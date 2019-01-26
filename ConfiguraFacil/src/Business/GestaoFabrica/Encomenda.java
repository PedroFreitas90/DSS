package Business.GestaoFabrica;

import java.util.Objects;

/**
 * Classe que contém a implementação da Encomenda.
 *
 * @author Davide, Francisco, Maria, Pedro
 */

public class Encomenda{
    private int id;
    private Configuracao conf;
    private Cliente cl;
    private String estado;

    /**
     * Construtor vazio
     */
    public Encomenda (){
        id=0;
        conf = new Configuracao();
        cl = new Cliente();
        estado= "Em espera";
    }


    /**
     * Construtor parametrizado
     *@param cf Configuração(Configuracao) criada pelo funcionário.
     *@param  c Cliente(cliente) que pretende fazer a encomenda
     *@return  Encomenda criada.
     */
    public Encomenda(Configuracao cf, Cliente c){
        id = -1;
        conf = cf;
        cl = c;
        estado="Em espera";
    }
    
    public Encomenda (Encomenda e){
        id= e.getId();
        conf=e.getConf();
        cl=e.getCl();
        estado=e.getEstado();
    }
    
    /**
     * Devolve a configuração
     *@return  Configuracao
     */
    public Configuracao getConf() {
        return conf;
    }

    /**
     * Devolve o Cliente
     *@return  Cliente
     */
    public Cliente getCl() {
        return cl;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Define a configuração
     *@param conf Configuração(Configuracao ) criada pelo funcionário.
     */
    public void setConf(Configuracao conf) {
        this.conf = conf;
    }

    /**
     * Define o cliente
     *@param cl Cliente(cliente) que pretende fazer a encomenda.
     */
    public void setCl(Cliente cl) {
        this.cl = cl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        final Encomenda other = (Encomenda) obj;
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.conf, other.conf)) {
            return false;
        }
        if (!Objects.equals(this.cl, other.cl)) {
            return false;
        }
        return true;
    }
    
    public Encomenda clone(){
        return new Encomenda(this);
    }
}