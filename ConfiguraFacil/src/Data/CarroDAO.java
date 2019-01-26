/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.GestaoFabrica.Carro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



/**
 *
 * @author mariadias
 */
public class CarroDAO implements Map<Integer,Carro> {
    
    private Connection conn;
 

    @Override
    public int size() {
        int i = 0;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT nome FROM Carro");
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
        boolean b = false;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            String sql = "SELECT nome FROM Carro WHERE ID_Carro='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            b = rs.next();
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
        return b;
    }

    
    @Override
    public boolean containsValue(Object value) {
        boolean b = false;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            Carro c = (Carro) value;
            String sql = "SELECT * FROM Carro WHERE ID_Carro='"+c.getId()+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                if(rs.getInt("ID_Carro")==c.getId() && rs.getString("Nome").equals(c.getNome()) && rs.getInt("Preco")==c.getPreco())
                    b = true;
            }
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
        return b;
    }

    @Override
    public Carro get(Object key) {
        Carro c = new Carro();
        
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Carro WHERE ID_Carro= ?");
            ps.setString(1,Integer.toString((Integer) key));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt("ID_Carro"));
                c.setNome(rs.getString("Nome"));
                c.setPreco(rs.getDouble("Preco"));
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
    public Carro put(Integer key, Carro value) {
        Carro c = null;
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Carro WHERE ID_Carro='"+key+"'");
            String sql = "INSERT INTO Carro VALUES ('"+key+"','"+value.getNome()+"',";
            sql += value.getPreco()+")";
            int i  = stm.executeUpdate(sql);
            c = new Carro(value.getNome(),value.getId(),value.getPreco());
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
        return c;
    }

    @Override
    public Carro remove(Object key) {
        Integer k = (Integer) key;
        Carro c = this.get(k);
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            String sql = "DELETE '"+key+"' FROM Carro";
            int i  = stm.executeUpdate(sql);
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
        return c;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Carro> m) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void clear() {
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Carro");
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> col = new HashSet<>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT Nome FROM Carro");
            for (;rs.next();) {
                col.add(rs.getInt(1));
            }
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
        return col;
    }

    @Override
    public Collection<Carro> values() {
        Collection<Carro> col = new HashSet<Carro>();
        try {
            conn = Connect.connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Carro");
            for (;rs.next();) {
                col.add(new Carro(rs.getString(1),rs.getInt(2),rs.getDouble(3)));
            }
            
        }catch(SQLException e){
            throw new NullPointerException(e.getMessage());
        }finally {
            Connect.close(conn);
        }
        return col;
    }

    @Override
    public Set<Entry<Integer, Carro>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
}
