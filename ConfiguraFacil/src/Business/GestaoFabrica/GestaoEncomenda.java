/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.GestaoFabrica;

import Data.CarroDAO;
import Data.ComponenteDAO;
import Data.EncomendaDAO;
import Data.PacoteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author PC - Luis
 */
public class GestaoEncomenda {
    
    private EncomendaDAO encomendas;
    private CarroDAO carros;
    private ComponenteDAO comps; // Map<String,Componente>
    private PacoteDAO pacotes;
    
    
    GestaoEncomenda(){
        this.encomendas= new EncomendaDAO();
        this.carros =new CarroDAO();
        this.comps = new ComponenteDAO();
        this.pacotes = new PacoteDAO();
    } 
    
    public void setEstadoEnc(int id) throws SQLException{
        this.encomendas.setEstado(id);
    }
    
    public Map<Integer,Pacote> getPacotes(){
        Map<Integer,Pacote> pacote = new HashMap<>();
        for(Pacote p : this.pacotes.values())
               pacote.put(p.getId(),p.clone());
        return pacote;
    }
    
   public Map<Integer,String> consultarEnc(){
      Map<Integer,String> cps = new HashMap<>();
        Collection <Object> encs = encomendas.values();
        for(Object o: encs){
            Encomenda e = (Encomenda) o;
            cps.put(e.getId(),e.getEstado());
        }
        return cps;
}
    
    
    public Map<Integer, Encomenda> getEncomendas() {
        Map<Integer,Encomenda> cps = new HashMap<>();
        Collection encs = encomendas.values();
        for(Object o: encs){
            Encomenda e = (Encomenda) o;
            cps.put(e.getId(),e.clone());
        }
            
        return cps;
    }
    
    public Map<String,Componente > getComponentes() {
        Map<String,Componente> cps = new HashMap<>();
        Collection encs = comps.values();
        for(Object o: encs){
            Componente c  = (Componente) o;
            cps.put(c.getNome(),c.clone());
        }
            
        return cps;
    }
    
    
    

    public Carro getCarro(int key) {
        Carro c= this.carros.get(key);
            return c;
    }
    
    public Componente getComponente(String comp){
        Componente c= this.comps.get(comp);
        return c.clone();
    }
    public Pacote getPacote(int id){
        return this.pacotes.get(id);
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
        final GestaoEncomenda other = (GestaoEncomenda) obj;
        if (!Objects.equals(this.encomendas, other.encomendas)) {
            return false;
        }
        if (!Objects.equals(this.carros, other.carros)) {
            return false;
        }
        if (!Objects.equals(this.comps, other.comps)) {
            return false;
        }
        if (!Objects.equals(this.pacotes, other.pacotes)) {
            return false;
        }
        return true;
    }
        

    
    public Map<String,Integer> verStock(){
        Map<String,Integer> novo= new HashMap<>();
        for(Componente sc :this.comps.values()){
           int s= sc.getStock();
           String n=sc.getNome();
        novo.put(n,s);
        }
        return novo;
    }

    public void adicionaEncomenda(Configuracao c, String nome,int nif,int contacto){
        Cliente cliente= new Cliente(nome,nif,contacto);
        Encomenda encomenda = new Encomenda(c,cliente);
        int size = this.encomendas.size();
        encomenda.setId(size+1);
        this.encomendas.put(size+1,encomenda );
    }
   
    
   
          
    
    public Map<String,Componente> getComps() {
        Map<String,Componente> cps = new HashMap<>();
        comps.entrySet().stream().forEach(entry -> cps.put(entry.getKey(), entry.getValue().clone()));
        return cps;
    }
  
    /**
     * Define o hash das componentes
     *
     * @param cps
     */
 
    public void adicionarStock (String comp,int quantidade){
        this.comps.adicionarStock(comp,quantidade);      
    }
    
    public Map<Integer,String> carrosFaziveis() throws SQLException{
        Map<Integer,String> novo = new HashMap<>();
        Collection<Encomenda> listaEncomendas = this.encomendas.values();//lista de encomendas
        
        for(Encomenda e : listaEncomendas){
            String estado = e.getEstado();
            if(!estado.equals("Em execução")){
                int r =0;
            Map<String,Componente> config =e.getConf().getComponentes();// configuracao
            for(Componente comconfig : config.values()){// componentes da configuracao
                Componente c = this.comps.get(comconfig.getNome());// ir buscar á fabrica o componente que esta na configuracao
                if(c.getStock()!=0){
                    r++;
                }
            }
            if (r==config.size()){
                novo.put(e.getId(),e.getCl().getNome());
                    
                }
            }
        }
        return novo;
    }
   
     
    public void decrementaStock(Map<String,Componente> config){
            for(Componente comp : config.values()){
                if(this.comps.containsKey(comp.getNome())){
                    this.comps.decrementaStock(comp.getNome());
                }
            }   
    } 
    
    
    public List<Componente> getPinturas(){
        List<Componente> pinturas = new ArrayList<>();
      Componente c1= getComponente("Preto");
      Componente c2= getComponente("Marron");
      Componente c3= getComponente("Cinzento");
      Componente c4= getComponente("Azul");
      Componente c5= getComponente("Branco");
      Componente c6= getComponente("Crayon");
      Componente c7= getComponente("Vermelho");
      Componente c8= getComponente("Preto Mate");
      pinturas.add(c1);
      pinturas.add(c2);
      pinturas.add(c3);
      pinturas.add(c4);
      pinturas.add(c5);
      pinturas.add(c6);
      pinturas.add(c7);
      pinturas.add(c8);
      return pinturas;
    }
    
    
    
    public List<Componente> getPneus(){
          List<Componente> pneus = new ArrayList<>();
          Componente c1= getComponente("Pireli");
          Componente c2= getComponente("Michelin");
          Componente c3= getComponente("Continental");
          pneus.add(c1);
          pneus.add(c2);
          pneus.add(c3);
          return pneus;
    }
    
    public List<Componente> getLuzes(){
          List<Componente> luzes = new ArrayList<>();
          Componente c1= getComponente("luzesLED");
          Componente c2= getComponente("luzesNeon");
          Componente c3= getComponente("luzesHalogenas");
          Componente c4= getComponente("luzesFluorescentes");
          luzes.add(c1);
          luzes.add(c2);
          luzes.add(c3);
          luzes.add(c4);
          return luzes;
    }
    
    public List<Componente> getParachoques(){
        List<Componente> parachoques = new ArrayList<>();
          Componente c1= getComponente("parachoques1");
          Componente c2= getComponente("parachoques2");
          Componente c3= getComponente("parachoques3");
          Componente c4= getComponente("parachoques4");
          parachoques.add(c1);
          parachoques.add(c2);
          parachoques.add(c3);
          parachoques.add(c4);
          return parachoques;
    }
    
    public List<Componente> getOpcionais(){
        List<Componente> opcionais = new ArrayList<>();
        Componente c1= getComponente("acoplamento");
        Componente c2= getComponente("alarme");
        Componente c3= getComponente("camara traseira");
        Componente c4= getComponente("Hi Fi");
        Componente c5= getComponente("caixa automatica");
        Componente c6= getComponente("gps");
        Componente c7= getComponente("ar condicionado");
        Componente c8= getComponente("pack fumador");
        opcionais.add(c1);
        opcionais.add(c2);
        opcionais.add(c3);
        opcionais.add(c4);
        opcionais.add(c5);
        opcionais.add(c6);
        opcionais.add(c7);
        opcionais.add(c8);
        return opcionais;    
    }
    
    
    public List<Componente> getAllOpcionais(){
        Collection<Componente> col = this.comps.values();
        List<Componente> coll = new ArrayList<Componente>();
        for(Componente c : this.comps.values()){
            coll.add(c.clone());
        }
        List<Componente> opcionais = coll.stream().filter(a->!a.isObrig()).collect(Collectors.toList());
        return opcionais;
        
    }
   
    public void exportEncomenda(int id){
        Encomenda e = this.encomendas.get(id);
        this.encomendas.setEstado(id);
            Configuracao config= e.getConf();
        Map<String,Componente> componentes = config.getComponentes();
        decrementaStock(componentes);
    }
    
 }