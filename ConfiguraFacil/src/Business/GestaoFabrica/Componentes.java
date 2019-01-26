package Business.GestaoFabrica;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Componentes {
    private Map<String,Componente> comps; 
    private Map<Integer,Pacote> pacotes;

    /**
     * Construtor vazio
     */
    public Componentes() {
        this.comps = new HashMap<>();
        this.pacotes = new HashMap<>();
    }
    
    
    public Pacote getPacote(int id){
            return this.pacotes.get(id);
    }
    public Map<Integer,Pacote> getPacotes(){
        Map<Integer,Pacote> pacote = new HashMap<>();
        for(Pacote p : this.pacotes.values())
               pacote.put(p.getId(),p.clone());
        return pacote;
    }
    
    

    @Override
    public String toString() {
        return "Componentes{" + "comps=" + comps + '}';
    }
    
    
    

    /**
     * Construtor parametrizado
     *
     * @param cps
     */
    /*
    public Componentes(HashMap<Integer, ArrayList<Componente>> cps) {
        comps = new HashMap<Integer, ArrayList<Componente>>();
        cps.entrySet().stream().forEach(entry -> comps.put(entry.getKey(), entry.getValue()));
    }

    /**
     * Contrutor por cópia
     *
     * @param cps
     */
    /*
    public Componentes(Componentes cps) {
        comps = cps.getComps();
    }

    /**
     * Devolve o Map com todas as componentes
     */
   
    public Map<String,Componente> getComps() {
        Map<String,Componente> cps = new HashMap<>();
        comps.entrySet().stream().forEach(entry -> cps.put(entry.getKey(), entry.getValue()));
        return cps;
    }
    
    public Componente getComponente(String nome ){
           Componente c = this.comps.get(nome);
           return c.clone();
    }

    /**
     * Define o hash das componentes
     *
     * @param cps
     */
 
    public void atualizaStock (String comp,int quantidade){
             Componente c= this.comps.get(comp);       
                 c.addStock(quantidade);
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
        
        

    
}

