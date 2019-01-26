/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

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
public class ComponenteDAO implements Map<String,Componente> {
    
    private Connection conn;

    
    @Override
    public int size() {
        int size = -1;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM Componente");
            if(rs.next())
                size = rs.getInt(1);
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public void decrementaStock(String key){
        try {
            int stock = 0;
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Componente WHERE Nome = ?");
            ps.setString(1,(String) key);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                stock = rs.getInt("Stock");
            
            stock = stock - 1;
            ps = conn.prepareStatement("UPDATE Componente SET Stock=? WHERE Nome = ?");
            ps.setString(1, Integer.toString(stock));
            ps.setString(2,(String) key);
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
    
    public void adicionarStock(String key, int quantidade){
        try {
            int stock = 0;
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Componente WHERE Nome = ?");
            ps.setString(1,(String) key);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                stock = rs.getInt("Stock");
            
            stock = stock + quantidade;
            ps = conn.prepareStatement("UPDATE Componente SET Stock=? WHERE Nome = ?");
            ps.setString(1, Integer.toString(stock));
            ps.setString(2,(String) key);
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
    public boolean containsKey(Object key) {
        boolean b = false;
        
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Componente WHERE Nome = ?");
            ps.setString(1,(String) key);
            ResultSet rs = ps.executeQuery();
            b = rs.next();   
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
        return b;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean b = false;
        
        if(value.getClass().getName().equals("Configuracao.Java.Componente")){
            Componente c = (Componente)value;
            String nome = c.getNome();
            Componente comp = this.get(nome);
            if(comp.equals(c)){
                b = true;
            }
        }
       return b;
    }


    @Override
    public void clear() {
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Componente");
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
    public Componente get(Object key) {
        Componente c = new Componente();
        
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Componente WHERE Nome = ?");
            ps.setString(1,(String) key);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c.setNome(rs.getString("Nome"));
                c.setPreco(rs.getDouble("Preco"));
                c.setStock(rs.getInt("Stock"));
                c.setObrig(rs.getBoolean("Obrigatorio"));
                List<String> incompativeis = new ArrayList<>();
                ps = conn.prepareStatement("SELECT * FROM Incompativeis WHERE Componente = ?");
                ps.setString(1,(String) key);
                ResultSet rs2 = ps.executeQuery();
                while(rs2.next()){
                    incompativeis.add(rs2.getString("Nome"));
                }
                c.setIncompativeis(incompativeis);
                
                List<String> dependentes = new ArrayList<>();
                ps = conn.prepareStatement("SELECT * FROM Dependentes WHERE Componente = ?");
                ps.setString(1,(String) key);
                ResultSet rs3 = ps.executeQuery();
                while(rs3.next()){
                    dependentes.add(rs3.getString("Nome"));
                }
                c.setObrigatorios(dependentes);
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
        return c;
    }


    @Override
    public Componente put(String key, Componente value) {
        Componente c;

        if(this.containsKey(key)){
            c = this.get(key);
        }
        else c = value;
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Componente WHERE Nome = ?");
            ps.setString(1,key);
            ps.executeUpdate();
            
            ps = conn.prepareStatement("INSERT INTO Componente (Nome,Obrigatorio,Preco,Stock) VALUES (?,?,?,?)");
            ps.setString(1,key);
            ps.setString(2,Boolean.toString(value.isObrig()));
            ps.setString(3,Double.toString(value.getPreco()));
            ps.setString(4,Integer.toString(value.getStock()));
            ps.executeUpdate();
            
            List<String> incompativeis = value.getIncompativeis();
            if(incompativeis!=null){
                for(String info : incompativeis){
                    ps = conn.prepareStatement("INSERT INTO Incompativeis (Nome,Componente) VALUES (?,?)");
                    ps.setString(1,info);
                    ps.setString(2,key);
                    ps.executeUpdate();
                }
            }
           
            List<String> dependentes = value.getObrigatorios();
            if(dependentes!=null){
                for(String info : dependentes){
                    ps = conn.prepareStatement("INSERT INTO Dependentes (Nome,Componente) VALUES (?,?)");
                    ps.setString(1,info);
                    ps.setString(2,key);
                    ps.executeUpdate();
                }
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
        return c;
    }

    @Override
    public Componente remove(Object key) {
        Componente c = this.get((String) key);
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Morador WHERE Nome = ?");
            ps.setString(1, (String) key);
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
        return c;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Componente> m) {
         for(Componente c : m.values()) {
            put(c.getNome(), c);
        }
    }

    @Override
    public Set<String> keySet() {
        Set<String> set = null;
        
        try{
            conn = Connect.connect();
            set = new HashSet<>();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Componente");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                set.add(rs.getString("Nome"));
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
    public Collection<Componente> values() {
        Set<Componente> set = new HashSet<>();
        Set<String> keys = new HashSet<>(this.keySet());
        for(String key : keys){
            set.add(this.get(key));
        }
        return set;
    }

    @Override
    public Set<Entry<String, Componente>> entrySet() {
        Set<String> keys = new HashSet<>(this.keySet());
        
        HashMap<String,Componente> map = new HashMap<>();
        for(String key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }
    
    
    
}
