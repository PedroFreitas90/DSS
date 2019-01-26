package Business.GestaoFabrica;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que contém a implementação do Pacote.
 *
 * @author Davide, Francisco, Maria, Pedro
 */
public class Pacote{
    private String nome;
    private int id;
    private float desconto;
    private List<Componente> ListadeComponentes;

    /**
     * Construtor vazio
     */
    public Pacote(){
        nome="";
        id=-1;
        desconto = 0;
        ListadeComponentes = new ArrayList<Componente>();
    }

    /**
     * Construtor parametrizado
     * @param n Nome(String) do pacote.
     * @param i Id(int) do pacote.
     * @param d Desconto(float) do pacote.
     * @param lc Lista de Componentes(ArrayList<Componente>) que fazem parte do pacote.
     */
    public Pacote(String n, int i, float d , List<Componente> lc){
        nome = n;
        id = i;
        desconto=d;
        ListadeComponentes = new ArrayList<Componente>();
        for(Componente c: lc)
            ListadeComponentes.add(c);
    }
    
    public Pacote(Pacote p){
        nome=p.getNome();
        id=p.getId();
        desconto=p.getDesconto();
        ListadeComponentes =p.getListadeComponentes();
    }

    /**
     * Devolve o nome do pacote.
     * @return String nome do pacote.
     */
    public String getNome(){
        return nome;
    }

    /**
     * Devolve o Id do pacote.
     * @return int Id do pacote.
     */
    public int getId(){
        return id;
    }

    /**
     * Devolve o valor do desconto (em formato decimal da percentagem).
     * @return float Desconto do pacote.
     */
    public float getDesconto(){
        return desconto;
    }
    
    public double precoPorComp(){
        double somapreco=0;
        double num=0;
        for(Componente c : this.ListadeComponentes){
            somapreco += c.getPreco()*(1 - this.desconto);
            num++;
        }
        return somapreco/num;
    }
    
    public double getpreco(){
        double somapreco=0;
        for(Componente c : this.ListadeComponentes){
            somapreco += c.getPreco()*(1 - this.desconto);
        }
        return somapreco;
    }
    
    /**
     * Devolve a lista de todos os componentes do pacote.
     * @return ArrayList<Componente> Lista com todos os componentes do pacote.
     */
    public List<Componente> getListadeComponentes(){
        ArrayList<Componente> lc = new ArrayList<>();
        for(Componente c: ListadeComponentes)
            lc.add(c.clone());
        return lc;
    }

    /**
     * Define o nome do pacote
     * @param n Nome(String) do pacote.
     */
    public void setNome(String n){
        this.nome = n;
    }

    /**
     * Define o Id do pacote.
     * @param i Id(int) do pacote.
     */
    public void setId(int i){
        id = i;
    }

    /**
     * Define o desconto do pacote (em formato decimal da percentagem).
     * @param x Desconto(float) do pacote.
     */
    public void setDesconto(float x){
        if(x >=0 && x <=1)
            desconto = x;
        else desconto = 0;
    }

    /**
     * Define a lista de componentes do pacote.
     * @param lc Lista dos componentes(ArrayList<Componente>) que fazem parte do pacote.
     */
    public void setListadeComponentes(List<Componente> lc){
        ListadeComponentes = new ArrayList<Componente>();
        for(Componente c: lc)
            ListadeComponentes.add(c);   
    }

    /**
     * Insere uma componente no pacote.
     * @param c Componente a inserir na lista de componentes do pacote
     */
    private void insereComponente(Componente c){
        ListadeComponentes.add(c);
    }

    /**
     * Remove um componente do pacote.
     * @param c Componente a remover da lista de componentes.
     */
    private void removeComponente(Componente c){
        ListadeComponentes.remove(c);
    }
    
   public Pacote clone(){
           return new Pacote(this);
}
}