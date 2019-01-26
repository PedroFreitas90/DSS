/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.GestaoFabrica;

import Business.GestaoFuncionarios.GestaoFuncionarios;
import Business.GestaoFuncionarios.Funcionario;
import Business.GestaoFuncionarios.FuncionarioExistenteException;
import Business.GestaoFuncionarios.FuncionarioInvalidoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maria, Francisco, Davide, Pedro
 */
public class ConfiguraFacil {
    private Funcionario utilizador;
    private GestaoFuncionarios gestao_funcionarios;
    private GestaoEncomenda gestao_fabrica;
    private Configuracao configuracao;

 
    
    /**
     * Contrutor por omissão
     *
     * 
     */
    public ConfiguraFacil(){
        this.utilizador=null;
        this.gestao_funcionarios=new GestaoFuncionarios();
        this.gestao_fabrica= new GestaoEncomenda();
        this.configuracao= null;
    }

     /**
     * Função que faz o login de um utilizador
     *
     * @param username
     * 
     * @param password
     */
    public void login(String username, String password) throws FuncionarioInvalidoException{
        try {
            this.utilizador=gestao_funcionarios.checkFuncionario(username,password);
        } catch(Exception e){
            throw new FuncionarioInvalidoException(e.getMessage());
        }
    }
    
     /**
     * Função que faz o logout 
     *
     */
    public void logout() {
        this.utilizador=null;
    }
    
    
    public void registarFuncionario(String username ,String password) throws FuncionarioExistenteException {
        gestao_funcionarios.addUtilizador(username,password);
    }
    
    public void gerarConfiguracao(){
        this.configuracao= new Configuracao();
    }
    
    public void adicionarComponente(String componente){
        this.configuracao.adicionaComponente(this.gestao_fabrica.getComponente(componente));
      
    }
    
    public void configOPT(double orcamento) throws DinheiroInsuficienteException {
        List<Componente> opcionais = this.gestao_fabrica.getAllOpcionais();
        Componente maisbarato = null;
        List<Componente> obrigatorios = new ArrayList<Componente>();
        for(Componente c :opcionais){
            if(compObrigatorios(c.getNome()).size()>1){
               obrigatorios.add(c.clone());
            }
        }
        for(Componente c :obrigatorios){
            opcionais.remove(c);
        }
        for(Componente c : opcionais){
            if(maisbarato == null){
                maisbarato = c.clone();
                continue;
            }
            if(c.getPreco()<maisbarato.getPreco())
                maisbarato=c;
        }
        if(maisbarato.getPreco()>orcamento)
            throw new DinheiroInsuficienteException("quantia insuficiente");
        double money = orcamento;
        this.configuracao.limpaOpcionais();
        Collection <Pacote> coll = this.gestao_fabrica.getPacotes().values();
        List <Pacote> list = new ArrayList(coll);
        Pacote melhor=null;
        for(Pacote p : list){
            if(melhor == null){
                melhor = p;
                continue;
            }
            if(p.precoPorComp()<melhor.precoPorComp()){
              melhor=p.clone();
            }
            
        }
        double preco = melhor.getpreco();
        if(preco<=money){
          for(Componente c: melhor.getListadeComponentes()){
            this.configuracao.adicionaComponente(c.clone());
            opcionais.remove(c);
          }
            money-=preco;
        }
        boolean asmoney = true;
        boolean morecomps = true;
        
        while(asmoney && morecomps){
            if(opcionais.size()>0){
                for(Componente c : opcionais){
                    if(maisbarato == null){
                        maisbarato = c;
                        continue;
                    }
                    if(c.getPreco()<maisbarato.getPreco())
                        maisbarato=c.clone();
                }
                if(getComponenteIncompativeis(maisbarato.getNome()).size()>1){
                    opcionais.remove(maisbarato);
                    maisbarato=null;
                    continue;
                }
                if(maisbarato.getPreco()<=money){
                    this.configuracao.adicionaComponente(maisbarato.clone());
                    opcionais.remove(maisbarato);
                    money-=maisbarato.getPreco();
                    maisbarato=null;
                }else{
                    asmoney = false;
                }
            }else{
                morecomps = false;
            }
        }
    }
    
    public void escolherCarro(int key){
        Carro c= this.gestao_fabrica.getCarro(key);
        this.configuracao.setCarro(c);
    }
    
    public void escolherPacote(int id){
        this.configuracao.InseriuPacote();// se quiser escolher pacote comça a configuracao do 0
        Pacote p = this.gestao_fabrica.getPacote(id);
        for(Componente c: p.getListadeComponentes())
            this.configuracao.adicionaComponente(c);
    }
        
    
    public void encomendarConfiguracao(String nome,int nif, int contacto){
        int id = this.gestao_fabrica.getEncomendas().size();//id da configuracao;
        this.configuracao.setId(id+1);
         Configuracao c = this.configuracao.clone();
        this.gestao_fabrica.adicionaEncomenda(c,nome,nif,contacto);
    }
    
    public List<String> getComponenteIncompativeis(String nome){
            List<String>componente = new ArrayList<>();
            componente.add(nome);// priemeiro elemento. elemento que se quer associar
              for(Componente comp : this.configuracao.getComponentes().values()){
                       if(comp.isIncompativel(nome))
                           componente.add(comp.getNome());    // componentes que sao incompativeis e que poderao ser eliminados 
                       }  
        return componente; 
    }
    
    
    public List<String> compObrigatorios(String comp){
         List<String> compObrigatorios = new ArrayList<>();
         List<String> obrigatorios = new ArrayList<>();
         Map<String,Componente> compConfig = this.configuracao.getComponentes();
         Componente c = this.gestao_fabrica.getComponente(comp);
         if(c.existeObrigatorios()){
             compObrigatorios = c.getObrigatorios();
             for(String s: compObrigatorios){
                 if(!compConfig.containsKey(s))
                     obrigatorios.add(s);
             }
         }
         
         obrigatorios.add(comp);
           
             return obrigatorios;
         }
    
    public Map<Integer,String > consultarEncomendas(){
        Map<Integer,String> encomendas = this.gestao_fabrica.consultarEnc();
        return encomendas;
    }
    
    public Map<Integer, String> encomendasFaziveis() throws SQLException {
        Map<Integer, String> enc = this.gestao_fabrica.carrosFaziveis();
            return enc;
    }
    
    public void validaEncomenda(int id){
        this.gestao_fabrica.exportEncomenda(id);
    }
    
    public void adicionarStock(String comp,int quantidade){
        this.gestao_fabrica.adicionarStock(comp, quantidade);
    }
    
    public Map<String,Integer> verificarStock(){
       return this.gestao_fabrica.verStock();
    }
    
    public void removerComponente(String c){
        this.configuracao.removeComponente(c);
        
    }
    public void checkPacote(){// verifica se uma configuracao tem um pacote
        double x = this.configuracao.precoConfig();
        this.configuracao.setPreco(x);
        Map<Integer,Pacote> pacotes = this.gestao_fabrica.getPacotes();
        for(Pacote p : pacotes.values()){
            if(this.configuracao.configEqualsPack(p))
                this.configuracao.PackDesconto(p);
        }  
    }
    
    
    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public GestaoEncomenda getGestao_fabrica() {
        return gestao_fabrica;
    }
    
    
    
    public Funcionario getUtilizador(){
        return utilizador;
    }

    public GestaoFuncionarios getGestao_funcionarios() {
        return gestao_funcionarios;
    }

   
  

}