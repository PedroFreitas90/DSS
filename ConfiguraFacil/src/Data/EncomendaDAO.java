/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.GestaoFabrica.Carro;
import Business.GestaoFabrica.Encomenda;
import Business.GestaoFabrica.Configuracao;
import Business.GestaoFabrica.Cliente;
import Business.GestaoFabrica.Componente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariadias
 */
public class EncomendaDAO implements Map<Integer,Encomenda>{
    
    private Connection conn;
    
    @Override
    public int size() {
        int i = 0;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Encomenda");
            for (;rs.next();i++);
            
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean res = false;
        
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Encomenda WHERE ID_Encomenda = ?");
            ps.setString(1,Integer.toString((Integer) key));
            ResultSet rs = ps.executeQuery();
            res = rs.next();   
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(conn);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return res;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean res = false;
        
        if(value.getClass().getName().equals("Configuracao.Java.Encomenda")){
            Encomenda enc = (Encomenda)value;
            int user = enc.getId();
            Encomenda e = this.get(user);
            if(e.equals(enc)){
                res=true;
            }
        }
       return res;
    }
    
    
    
    @Override
    public void putAll(Map m) {
        throw new UnsupportedOperationException("Not supported."); 
    }

    @Override
    public void clear() {
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Encomenda");
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(conn);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
    }

    @Override
    public Set keySet() {
        Set<Integer> set = null;
        
        try{
            conn = Connect.connect();
            set = new HashSet<>();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Encomenda");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                set.add(rs.getInt("ID_Encomenda"));
            }   
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(conn);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return set;
    }

    @Override
    public Collection values() {
        Set<Encomenda> set = new HashSet<>();
        Set<Integer> keys = new HashSet<>(this.keySet());
        for(Integer key : keys){
            set.add(this.get(key));
        }
        return set;
    }


    @Override
    public Set entrySet() {
        Set<Integer> keys = new HashSet<>(this.keySet());
        
        HashMap<Integer,Encomenda> map = new HashMap<>();
        for(Integer key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }
    
    public void setEstado(Integer key){
        try {
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("UPDATE Encomenda SET Estado='Em execução' WHERE ID_Encomenda = ?");
            ps.setString(1,Integer.toString(key));
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(conn);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
    }
    
    
    @Override
    public Encomenda put(Integer key, Encomenda value) {
        Encomenda enc = null;
        
        if(this.containsKey(key))
            enc = this.get(key);
        else enc = value;
        
        try {
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Encomenda WHERE ID_Encomenda = ?");
            ps.setString(1,Integer.toString(key));
            ps.executeUpdate();
            
            Configuracao c = value.getConf();
            int idconf = c.getId();
            ps = conn.prepareStatement("INSERT INTO Configuracao (ID_Configuracao,Preco,Carro_ID_Carro) VALUES (?,?,?)");
            ps.setString(1, Integer.toString(idconf));
            ps.setString(2, Double.toString(c.getPreco()));
            ps.setString(3, Integer.toString(c.getCarro().getId()));
            ps.executeUpdate(); 
            
            ps = conn.prepareStatement("INSERT INTO Encomenda (ID_Encomenda,Cliente_NIF,Cliente_Nome,Cliente_Contato,Estado,Configuracao_ID) VALUES (?,?,?,?,?,?)");
            ps.setString(1,Integer.toString(key));
            ps.setString(2,Integer.toString(value.getCl().getNif()));
            ps.setString(3,value.getCl().getNome());
            ps.setString(4,Integer.toString(value.getCl().getContacto()));
            ps.setString(5,value.getEstado());
            ps.setString(6,Integer.toString(c.getId()));
            ps.executeUpdate();  
            
            Set<String> comp = c.getComponentes().keySet();
            for(String s: comp){
                ps = conn.prepareStatement("INSERT INTO Componente_Configuracao (Componente_Nome,Configuracao_ID) VALUES (?,?)");
                ps.setString(1,s);
                ps.setString(2,Integer.toString(idconf));
                ps.executeUpdate(); 
            }  
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(conn);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return enc;
    }
    
    /*
    private int id;
    private Map<String,Componente> componentes;
    private double preco;
    private double orcamento;
    private double desconto;
    private Carro carro;
    */

    public Configuracao getConf(Object key){
        Configuracao c = new Configuracao();
        int idconf = 0, idcarro = 0;
        String nome, idcomp = null;
        double preco = 0;
        Carro carro = null;
        Componente componente = null;
        Map<String,Componente> componentes = new HashMap<>();
        ArrayList<String> incompativeis = new ArrayList<>();
        ArrayList<String> dependentes = new ArrayList<>();
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT Configuracao_ID FROM Encomenda WHERE ID_Encomenda = ?");
            ps.setString(1,Integer.toString((Integer) key));
            ResultSet rs1 = ps.executeQuery();
            if(rs1.next()){
                idconf = rs1.getInt("Configuracao_ID");
            }
            
            ps = conn.prepareStatement("SELECT Componente_Nome FROM Componente_Configuracao WHERE ID_Configuracao = ?");
            ps.setString(1,Integer.toString(idconf));
            ResultSet rs2 = ps.executeQuery();
            while(rs2.next()){
                idcomp = rs2.getString("Componente_Nome");
                ps = conn.prepareStatement("SELECT * FROM Componente WHERE Nome = ?");
                ps.setString(1,(String) idcomp);
                ResultSet rs3 = ps.executeQuery();
                if(rs3.next()){
                    componente = new Componente(rs3.getString("Nome"),rs3.getBoolean("Obrigatorio"),rs3.getDouble("Preco"),null,null,rs3.getInt("Stock"));
                    ps = conn.prepareStatement("SELECT * FROM Incompativeis WHERE Componente = ?");
                    ps.setString(1,(String) idcomp);
                    ResultSet rs4 = ps.executeQuery();
                    while(rs4.next()){
                        incompativeis.add(rs4.getString("Nome"));
                    }
                    componente.setIncompativeis(incompativeis);

                    ps = conn.prepareStatement("SELECT * FROM Dependentes WHERE Componente = ?");
                    ps.setString(1,(String) idcomp);
                    ResultSet rs5 = ps.executeQuery();
                    while(rs5.next()){
                        dependentes.add(rs5.getString("Nome"));
                    }
                    componente.setObrigatorios(dependentes);
                }
                componentes.put(idcomp, componente);
            }
            
            ps = conn.prepareStatement("SELECT * FROM Configuracao WHERE ID_Configuracao = ?");
            ps.setString(1,Integer.toString(idconf));
            ResultSet rs6 = ps.executeQuery();
            if(rs6.next()){
                idcarro = rs6.getInt("Carro_ID_Carro");
                preco = rs6.getDouble("Preco");
                ps = conn.prepareStatement("SELECT * FROM Carro WHERE ID_Carro = ?");
                ps.setString(1,Integer.toString(idcarro));
                ResultSet rs7 = ps.executeQuery();
                if(rs7.next()){
                    carro = new Carro(rs7.getString("Nome"),idcarro,rs7.getDouble("Preco"));
                }
            }
            
            c.setCarro(carro);
            c.setComponentes(componentes);
            c.setId(idconf);
            c.setPreco(preco);
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
               Connect.close(conn);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        System.out.println(c.toString()+"falhou");
        return c;
    }
    
    @Override
    public Encomenda get(Object key) { 
        Encomenda enc = new Encomenda();
        Configuracao conf = null;
        Carro carro = null;
        Componente comp = null;
        Map<String,Componente> comps = new HashMap<>();
        ArrayList<String> incompativeis = new ArrayList<>();
        ArrayList<String> dependentes = new ArrayList<>();
        int idconf, idcarro;
        String idcomp;
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Encomenda WHERE ID_Encomenda = ?");
            ps.setString(1,Integer.toString((Integer) key));
            ResultSet rs1 = ps.executeQuery();
            if(rs1.next()){
                enc.setId(rs1.getInt("ID_Encomenda"));
                enc.setEstado(rs1.getString("Estado"));
                Cliente c = new Cliente(rs1.getString("Cliente_Nome"),rs1.getInt("Cliente_NIF"),rs1.getInt("Cliente_Contato"));
                enc.setCl(c);
                idconf = rs1.getInt("Configuracao_ID");
                ps = conn.prepareStatement("SELECT * FROM Configuracao WHERE ID_Configuracao = ?");
                ps.setString(1, Integer.toString(idconf));
                ResultSet rs2 = ps.executeQuery();
                if(rs2.next()){
                    conf = new Configuracao();
                    conf.setId(idconf);
                    conf.setPreco(rs2.getDouble("Preco"));
                    idcarro = rs2.getInt("Carro_ID_Carro");
                    ps = conn.prepareStatement("SELECT * FROM Carro WHERE ID_Carro = ?");
                    ps.setString(1, Integer.toString(idcarro));
                    ResultSet rs3 = ps.executeQuery();
                    if(rs3.next())
                        carro = new Carro(rs3.getString("Nome"),idcarro,rs3.getDouble("Preco"));
                    conf.setCarro(carro);
                    ps = conn.prepareStatement("SELECT * FROM Componente_Configuracao WHERE Configuracao_ID = ?");
                    
                    ps.setString(1, Integer.toString(idconf));
                    ResultSet rs4 = ps.executeQuery();
                    while(rs4.next()){
                        idcomp = rs4.getString("Componente_Nome");
                        System.out.println("COmponente "+idcomp);
                        ps = conn.prepareStatement("SELECT * FROM Componente WHERE Nome = ?");
                        ps.setString(1, idcomp);
                        ResultSet rs5 = ps.executeQuery();
                        if(rs5.next()){
                            comp = new Componente(rs5.getString("Nome"),rs5.getBoolean("Obrigatorio"),rs5.getDouble("Preco"),incompativeis,dependentes,rs5.getInt("Stock"));
                            ps = conn.prepareStatement("SELECT * FROM Incompativeis WHERE Componente = ?");
                            ps.setString(1,(String) idcomp);
                            ResultSet rs6 = ps.executeQuery();
                            while(rs6.next()){
                                incompativeis.add(rs6.getString("Nome"));
                            }
                            comp.setIncompativeis(incompativeis);

                            ps = conn.prepareStatement("SELECT * FROM Dependentes WHERE Componente = ?");
                            ps.setString(1,(String) idcomp);
                            ResultSet rs7 = ps.executeQuery();
                            while(rs7.next()){
                                dependentes.add(rs7.getString("Nome"));
                            }
                            comp.setObrigatorios(dependentes);
                        }
                        comps.put(idcomp,comp);
                    }
                    conf.setComponentes(comps);
                }
            }
            enc.setConf(conf);
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
               Connect.close(conn);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return enc;
    }

    @Override
    public Encomenda remove(Object key) {
        Encomenda enc = this.get((Integer) key);
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Encomenda where ID_Encomenda = ?");
            ps.setInt(1, (Integer) key);
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(conn);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return enc;
    }
    
}
