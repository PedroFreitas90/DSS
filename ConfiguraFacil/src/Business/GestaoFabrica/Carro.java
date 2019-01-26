package Business.GestaoFabrica;

public class Carro{
    int id;
    private String nome;
    private double preco;

    /**
     * Construtor vazio.
     */
    public Carro(){
        nome = "" ;
        id= 0 ;
        preco = 0;
    }

    /**
     * Construtor parametrizado.
     * @param n Nome(String) do carro.
     * @param t Tipo(int) do carro.
     * @param p Preço(Double) do carro.
     */
    public Carro(String n , int t, double p){
        nome = n ;
        id = t;
        preco = p;
    }

    /**
     * Construtor por cópia.
     * @param c Carro (Carro).
     */
    public Carro(Carro c){
        nome = c.getNome();
        id = c.getId();
        preco = c.getPreco();
    }

    /**
     * Devolve o nome do carro.
     * @return String.
     */
    public String getNome(){
        return nome;
    }

    /**
     * Devolve o tipo do carro.
     * @return int.
     */
    public int getId(){
        return id;
    }

    /**
     * Devolve o preço do carro.
     * @return double.
     */
    public double getPreco(){
        return preco;
    }

    /**
     * Define o nome do carro.
     * @param n Nome(String) do carro.
     */
    public void setNome(String n){
        nome = n;
    }

    /**
     * Define o tipo do carro.
     * @param t Tipo(int) do carro.
     */
    public void setId(int t){
        id = t;
    }

    /**
     * Define o preço do carro.
     * @param p Preço(double) do carro.
     */
    public void setPreco(double p){
        preco = p;
    }

    public boolean equals(Object o){
        if (this == o)
            return true;
        if((o == null) || ( this.getClass() != o.getClass() ) )
            return false;
        Carro c = (Carro) o;
        return nome.equals(c.getNome()) && id == c.getId() && preco == c.getPreco();
    }

    @Override
    public Carro clone(){
        return new Carro(this);
    }

    @Override
    public String toString(){
        return "Carro{" + "nome=" + nome + ", Id =" + id +", preço =" + preco + "}" ;
    }
}