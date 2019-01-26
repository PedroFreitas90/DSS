/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.GestaoFabrica.Componente;
import Business.GestaoFabrica.Configuracao;
import java.sql.Connection;
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

/**
 *
 * @author mariadias
 */
public class ConfiguracaoDAO implements Map<String,Componente>{
    
    private Connection conn;
    private int idconf; //id da configuracao em causa

    @Override
    public int size() {
        int size = -1;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM Componente_Configuracao WHERE Configuracao_ID='"+this.idconf+"'");
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

    @Override
    public boolean containsKey(Object key) {
        boolean b = false;
        
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Componente_Configuracao WHERE Componente_Nome = ? AND Configuracao_ID = ?");
            ps.setString(1,(String) key);
            ps.setString(2,Integer.toString(this.idconf));
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
            String s = c.getNome();
            Componente comp = this.get(s);
            if(comp.equals(c))
                b = true;
            }
        return b;
    }

    @Override
    public Componente get(Object key) {
        Componente c = new Componente();
        
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Componente_Configuracao WHERE Componente_Nome = ? AND Configuracao_ID = ?");
            ps.setString(1,(String) key);
            ps.setString(2, Integer.toString(this.idconf));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c.setNome(rs.getString("Nome"));
                c.setObrig(rs.getBoolean("Obrigatorio"));
                c.setPreco(rs.getDouble("Preco"));
                c.setStock(rs.getInt("Stock"));
                
                List<String> incompativeis = new ArrayList();
                ps = conn.prepareStatement("SELECT * FROM Incompativeis WHERE Componente = ?");
                ps.setString(1,(String) key);
                rs = ps.executeQuery();
                while(rs.next()){
                    incompativeis.add(rs.getString("Nome"));
                }
                c.setIncompativeis(incompativeis);
                
                List<String> dependentes = new ArrayList();
                ps = conn.prepareStatement("SELECT * FROM Dependentes WHERE Componente = ?");
                ps.setString(1,(String) key);
                rs = ps.executeQuery();
                while(rs.next()){
                    dependentes.add(rs.getString("Nome"));
                }
                c.setObrigatorios(dependentes);
            }
            else c = null;
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
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Componente_Configuracao WHERE Componente_Nome = ? AND Configuracao_ID = ?");
            ps.setString(1,(String) key);
            ps.setString(2,Integer.toString(this.idconf));
            ps.executeUpdate();
            
            ps = conn.prepareStatement("INSERT INTO Componente_Configuracao (Componente_Nome,Configuracao_ID) VALUES (?,?)");
            ps.setString(1,key);
            ps.setString(2,Integer.toString(this.idconf));
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
    public Componente remove(Object key) {
        Componente c = this.get((String) key);
        try{
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Componente_Configuracao WHERE Componente_Nome = ?");
            stm.setString(1, (String) key);
            stm.executeUpdate();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            Connect.close(conn);
        }
        return c;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Componente> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        try{
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM Componente_Configuracao");
            stm.executeUpdate();
        }
        catch(Exception e){
            throw new NullPointerException(e.getMessage()); 
        }
        finally{
            Connect.close(conn);
        }
    }

    @Override
    public Set<String> keySet() {
        Set<String> set = null;
        
        try{
            conn = Connect.connect();
            set = new HashSet<>();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Componente_Configuracao WHERE Configuracao_ID = ?");
            ps.setString(1,Integer.toString(this.idconf));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                set.add(rs.getString("Componente_Nome"));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
    
    public Map<String,Componente> getComponentes(){
        Map<String,Componente> comp = new HashMap<>();
        return comp; 
    }
    
}
