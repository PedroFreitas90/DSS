/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.GestaoFabrica;

import Business.GestaoFabrica.Componente;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Classe que contém a implementação da Configuração.
 *
 * @author Davide, Francisco, Maria, Pedro
 */
public class Configuracao {
    private int id;
    private Map<String,Componente> componentes;
    private double preco;
    private double orcamento;
    private double desconto;
    private Carro carro;
    
    /**
     * Construtor Vazio.
     */
    public Configuracao(){
        int id=-1;
        this.componentes = new HashMap<>();
        this.preco = 0;
        this.orcamento = 0;
        this.desconto = 0;
        this.carro = new Carro();
    }
    public Configuracao(Configuracao c){
        this.id=c.getId();
        this.componentes=c.getComponentes();
        this.preco=c.getPreco();
        this.orcamento=c.getOrcamento();
        this.desconto = c.getDesconto();
        this.carro=c.getCarro();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Insere uma componente ou substitui uma já existente.
     * @param c Componente (Componente) que se pretende inserir na Configuração.
     */
    public void adicionaComponente(Componente c){
        componentes.put(c.getNome(),c);
        this.preco += c.getPreco();
    }

    /**
     * Remove um componente da configuração.
     * @param c Componente (Componente) que se pretende remover.
     */
    public void removeComponente(String componente){
            Componente c = this.componentes.get(componente);
            componentes.remove(componente);
                 this.preco -= c.getPreco();
        }
      
    /**
     * poe o map de componentes vazio para ser escolhido um pacote
     **/ 
    public void InseriuPacote(){
        Map<String,Componente>  old= getComponentes(); 
        Map<String,Componente>  novo= new HashMap<>();
        for(Componente c : old.values()){
            if(c.isObrig())
                novo.put(c.getNome(), c);
        }
        this.setComponentes(novo);
    }
    
    /**
     * poe o map de componentes vazio para ser escolhido um pacote
     **/ 
    public void limpaOpcionais(){
        Map<String,Componente>  old= getComponentes();
        Map<String,Componente>  novo= new HashMap<>();
        for(Componente c : old.values()){
                if(c.isObrig())
                    novo.put(c.getNome(), c);
        }
        this.setComponentes(novo);
        
    }
    
    public boolean configEqualsPack(Pacote p){
        List<Componente> pacote = p.getListadeComponentes();
        int r=0;
        boolean b= false;
        for(Componente c : componentes.values())
             for(Componente cp: pacote)
                if(cp.equals(c))
                    r++;
        if(r == pacote.size()) 
            b = true;
        return b;
        
    }
    
  
    public void PackDesconto(Pacote p){
            double desconto= p.getDesconto();
            this.preco= this.preco-this.preco*desconto;
            System.out.println(""+this.preco);
                    }
   
 
    /**
     * Devolve a lista de componentes.
     * @return HashMap<String, Componente> Lista de componentes da configuração.
     */
    
    public Map<String,Componente> getComponentes(){
        Map<String,Componente> comp = new HashMap<>();
        for(Componente c : this.componentes.values())
                comp.put(c.getNome(), c.clone());
        return comp;
    }

    /**
     * Define a lista de componentes da configuração.
     * @param l Lista de componentes (Map<String, Componente>) da configuração.
     */
    public void setComponentes(Map<String, Componente> l) {
        this.componentes = new HashMap<>();
        for(Componente c: l.values())
            this.componentes.put(c.getNome(), c.clone());
    }

    /**
     * Devolve o carro da configuração.
     * @return Carro Carro da configuração.
     */
    public Carro getCarro() {
        return carro;
    }

    /**
     * Define o carro da configuração.
     * @param carro Carro (Carro) da configuração.
     */
    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    /**
     * Devolve o preço da Configuração
     * @return int Preço da configuração
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço da configuração.
     * @param preco Preço da configuração
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Configuracao clone(){
        return new Configuracao(this);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Configuracao other = (Configuracao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (Double.doubleToLongBits(this.orcamento) != Double.doubleToLongBits(other.orcamento)) {
            return false;
        }
        if (Double.doubleToLongBits(this.desconto) != Double.doubleToLongBits(other.desconto)) {
            return false;
        }
        if (!Objects.equals(this.componentes, other.componentes)) {
            return false;
        }
        if (!Objects.equals(this.carro, other.carro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Configuracao{" + "id=" + id + ", componentes=" + componentes + ", preco=" + preco + ", orcamento=" + orcamento + ", desconto=" + desconto + ", carro=" + carro + '}';
    }

    
  

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    /**
     * Identifica uma componente que está na configuracao
     * @param nome
     * @return 
     */
    
    public Componente IdentificaComponente(String nome){
        return this.componentes.get(nome);
        
    }

    public double precoConfig(){
        double x = this.carro.getPreco();
        for(Componente c : this.componentes.values())
               x+=c.getPreco();
        return x;
    }

    
   /**
    * Verifica se ha componentes obrigatporios e no caso de existir devolve-o
    * @param c
    * @return 
    */
     public List<String> descobreObrigatorio(String nome){
             List<String>componente = new ArrayList<>();
                componente.add(nome);// priemeiro elemento
                for(Componente comp : componentes.values()){
                       if(comp.isCompObrigatorio(nome))
                           componente.add(comp.getNome());     
                       }
       
        return componente;
    }
  
   /*
     O mesmo que anterior so que agora com incompativeis
     */
     public List<String> descobreIncompativel(String nome){
            List<String>componente = new ArrayList<>();
            componente.add(nome);// priemeiro elemento. elemento que se quer associar
              for(Map.Entry<String,Componente> entry : this.componentes.entrySet()){
                       if(entry.getValue().isIncompativel(nome))
                           componente.add(entry.getKey());    // componentes que sao incompativeis e que poderao ser eliminados 
                       }  
        System.out.println(componente.toString());
        return componente; 
    }
     

     
     public boolean verificaComponentesObrigatorios(){
         int x = 4 ; // numero de componentes obrigatorios
         if(this.carro.getNome().equals(""))
             return false;        
         for(Componente c : this.componentes.values())
                if(c.isObrig())
                    x--;
         return (x==0);
         
     }
    
     }
     
    

