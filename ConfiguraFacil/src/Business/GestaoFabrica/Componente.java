/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.GestaoFabrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mariadias
 */
public class Componente {
    private String nome;
    private boolean obrig;
    private double preco;
    private List<String> incompativeis;
    private List<String> obrigatorios;
    private int stock;

    /**
     * Construtor vazio.
     */
    public Componente(){
        obrig = false;
        nome="";
        preco=0;
        incompativeis = new ArrayList<>();
        obrigatorios = new ArrayList<>();
        stock = 0;
    }
    /**
     * Construtor parametrizado.
     * @param tipo Tipo(int) do componente
     * @param d Nome(String) do componente.
     * @param p Preço(double) do componente.
     * @param inc Lista(<Componente>) dos componentes incompatíveis a este.
     * @param ob Lista(<Componente>) dos componentes obrigatórios a este.
     * @param s Stock(Integer) do componente.
     */
    public Componente(String d,boolean obg, double p, ArrayList<String> inc, ArrayList<String> ob, int s){
        this.obrig=obg;
        this.nome = d;
        this.preco = p;
        setIncompativeis(inc);
        setObrigatorios(ob);
        this.stock = s;
    }

    /**
     * Construtor por cópia.
     * @param c Componente(Componente) .
     */
    public Componente(Componente c){
        this.obrig=c.isObrig();
        this.nome = c.getNome();
        this.preco = c.getPreco();
        this.incompativeis = c.getIncompativeis();
        this.obrigatorios = c.getObrigatorios();
        this.stock = c.getStock();
    }

    
    /**
     * Devolve o nome do componente.
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do componente.
     * @param nome Nome(String) do componente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve o preço do componente.
     * @return double
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do componente.
     * @param preco Preço(double) do componente.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Devolve o Stock existente do componente.
     * @return int
     */
    public int getStock() {
        return stock;
    }

    /**
     * Define o Stock de um componente.
     * @param stock Valor(Integer) do stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isObrig() {
        return obrig;
    }

    public void setObrig(boolean b){
        this.obrig = b;
    }

    /**
     * Adiciona Stack a um componente.
     * @param s Stock(Integer) a adicionar.
     */
    public void addStock(int s){
        this.stock += s;
    }

    /**
     * Devolve a Lista dos componentes incompatíveis.
     * @return ArrayList<Componente>
     */
    public List<String> getIncompativeis() {
        List<String> novo= new ArrayList<String>();
        for(String c: incompativeis)
                novo.add(c);
        return novo;
    }

    /**
     * Define a lista dos componentes incompatíveis.
     * @param i Lista (List<Componente>) dos componentes incompatíveis
     */
    
    public void setIncompativeis(List<String> i) {
        this.incompativeis=new ArrayList<>();
         for(String c: i)
            this.incompativeis.add(c);
    }

    /**
     * Adiciona um componente à lista dos incompatíveis.
     * @param c Componente(Componente) incompatível.
     */
    public void addInc(String nome){
        this.incompativeis.add(nome);
    }

    /**
     * Devolve a lista dos componentes obrigatórios.
     * @return ArrayList<Componente>
     */
    public List<String> getObrigatorios() {
        List<String> novo= new ArrayList<String>();
        for(String c: obrigatorios)
                novo.add(c);
        return novo;
    }

    /**
     * Define a lista dos componentes obrigatórios.
     * @param o Lista (List<Componente>) dos componentes obrigatórios.
     */
    public void setObrigatorios(List<String> o) {
        this.obrigatorios=new ArrayList<>();
        for(String c: o)
            this.obrigatorios.add(c);
    }

    /**
     * Adiciona um componente à lista de componentes obrigatórios.
     * @param c Componente(Componente) a adicionar à lista dos obrigatórios.
     */
    public void addObr(String nome){
        this.obrigatorios.add(nome);
    }

    protected Componente clone() {
        return new Componente(this);
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
        final Componente other = (Componente) obj;
        if (this.obrig != other.obrig) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.incompativeis, other.incompativeis)) {
            return false;
        }
        if (!Objects.equals(this.obrigatorios, other.obrigatorios)) {
            return false;
        }
        return true;
    }

   

    
    
    /*
    Verifica se existe componentes obrigatorios.
    */
    public boolean existeObrigatorios(){
        boolean existe= false;
        if(this.obrigatorios.size()!=0)
            existe=true;
    return existe;
    }
    
    /**
     * Funçao que diz se um componente é componente obrigatorio de outro
     */
    public boolean isCompObrigatorio(String nome){
           List<String> obrigatorios =  this.getObrigatorios();// listas de obrigatorios do componente
           for(String c : obrigatorios){
               if(c.equals(nome))
                   return true;
           }
           return false;
    }
    
    /**
     * Funçao que Verifica se um componente é incompativel com outro
     * @param nome
     * @return 
     */
      public boolean isIncompativel(String nome){
           List<String> obrigatorios =  this.getIncompativeis();
           for(String c : obrigatorios){
               if(c.equals(nome))
                   return true;
           }
           return false;
    }
    
      public void decrementaStock(){
          this.stock-=1;
      }
}

