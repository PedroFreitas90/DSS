/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.GestaoFuncionarios.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariadias
 */
public class FuncionarioDAO implements Map<String,Funcionario> {
    
    private Connection conn;

    
    public void clear () {
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Funcionario");
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
    }
    
    public boolean containsKey(Object key) throws NullPointerException {
        boolean b = false;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            String sql = "SELECT Username FROM Funcionario WHERE Username='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            b = rs.next();
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
        return b;
    }
    
    public boolean containsValue(Object value) {
        boolean b = false;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            Funcionario f = (Funcionario) value;
            String sql = "SELECT Username FROM Funcionario WHERE Username='"+f.getNome()+"' AND password ='"+f.getPassword()+"'";
            ResultSet rs = stm.executeQuery(sql);
            b = rs.next();
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
        return b;
    }
    
    public Set<Map.Entry<String,Funcionario>> entrySet() {
        Set<String> keys = new HashSet<>(this.keySet());
        
        Map<String,Funcionario> map = new HashMap<>();
        for(String key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }
    
    public boolean equals(Object o) {
        throw new NullPointerException("not implemented!");
    }
    
    public Funcionario get(Object key) {
        Funcionario f = null;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Funcionario WHERE Username='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) 
                f = new Funcionario(rs.getString(1),rs.getString(2));
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            try{
                Connect.close(conn);
            }
            catch(Exception e){
                 System.out.printf(e.getMessage());
            }
        }
        return f;
    }
    
  
        
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public Set<String> keySet() {
        Set<String> col = null;
        try {
            conn = Connect.connect();
            col = new HashSet<>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Username FROM Funcionario");
            for (;rs.next();) {
                col.add(rs.getString("Username"));
            }
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
        return col;
    }
    
    public Funcionario put(String key, Funcionario value) {
        Funcionario f = null;
        
        if(this.containsKey(key))
            f = this.get(key);
        else f = value;
        
        try {
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Funcionario WHERE Username = ?");
            ps.setString(1,key);
            ps.executeUpdate();
            
            ps = conn.prepareStatement("INSERT INTO Funcionario (Username,Password) VALUES (?,?)");
            ps.setString(1,key);
            ps.setString(2,value.getPassword());
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
        return f;
    }
           
    
    public Funcionario remove(Object key) {
        Funcionario f = this.get(key);
        try {
            conn = Connect.connect();
            PreparedStatement stm = conn.prepareStatement("DELETE FROM Funcionario WHERE Username = ?");
            stm.setString(1,(String)key);
            stm.executeUpdate();
        } catch(SQLException e){
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
        return f;
    }
    
    
    public int size() {
        int size = -1;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM Funcionario");
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
    
    
    public Collection<Funcionario> values() {
        Collection<Funcionario> col = new HashSet<>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Funcionario");
            for (;rs.next();) {
                col.add(new Funcionario(rs.getString(1),rs.getString(2)));
            }
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
        return col;
    }

    
    public Boolean login(String nome, String pass) throws SQLException {
        boolean correto = false;
        try{
            conn = Connect.connect();
            Statement s = conn.createStatement();
            String sql = "SELECT password FROM Funcionario WHERE Username='" + nome + "'";
            ResultSet res = s.executeQuery(sql);
            if (res.next())
                if (res.getString(1).equals(pass))
                    correto = true;
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }        
        return correto;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Funcionario> m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
