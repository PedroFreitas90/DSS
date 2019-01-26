/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


import Business.GestaoFabrica.Componente;
import Business.GestaoFabrica.Pacote;
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
public class PacoteDAO implements Map<Integer,Pacote> {

    private Connection conn;

    
    @Override
    public int size() {
        int size = -1;

        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM Pacote");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                size = rs.getInt(1);
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean res = false;
        
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Pacote WHERE ID_Pacote = ?");
            ps.setString(1,(String) key);
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
        
        if(value.getClass().getName().equals("Configuracao.Java.Pacote")){
            Pacote p = (Pacote)value;
            int user = p.getId();
            Pacote pac = this.get(user);
            if(pac.equals(p)){
                res=true;
            }
        }
       return res;
    }

    @Override
    public Pacote get(Object key) {
        Pacote p = new Pacote();
        
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Pacote WHERE ID_Pacote = ?");
            ps.setString(1,Integer.toString((Integer) key));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setId(rs.getInt("ID_Pacote"));
                p.setNome(rs.getString("Nome"));
                p.setDesconto(rs.getFloat("Desconto"));
                
                List<Componente> componentes = new ArrayList<>();
                ps = conn.prepareStatement("SELECT * FROM Pacote_Componente WHERE Pacote_ID = ?");
                ps.setString(1,Integer.toString((Integer) key));
                rs = ps.executeQuery();
                while(rs.next()){
                    String idcomp = rs.getString("Componente_Nome");
                    ps = conn.prepareStatement("SELECT * FROM Componente WHERE Nome = ?");
                    ps.setString(1,idcomp);
                    ResultSet rs2 = ps.executeQuery();
                    Componente c = new Componente();
                    if(rs2.next()){
                        c.setNome(rs2.getString("Nome"));
                        c.setObrig(rs2.getBoolean("Obrigatorio"));
                        c.setPreco(rs2.getDouble("Preco"));
                        c.setStock(rs2.getInt("Stock"));
                        List<String> incompativeis = new ArrayList();
                        ps = conn.prepareStatement("SELECT * FROM Incompativeis WHERE Componente = ?");
                        ps.setString(1, idcomp);
                        ResultSet rs3 = ps.executeQuery();
                        while(rs3.next()){
                            incompativeis.add(rs3.getString("Nome"));
                        }
                        c.setIncompativeis(incompativeis);

                        List<String> dependentes = new ArrayList();
                        ps = conn.prepareStatement("SELECT * FROM Dependentes WHERE Componente = ?");
                        ps.setString(1,idcomp);
                        ResultSet rs4 = ps.executeQuery();
                        while(rs4.next()){
                            dependentes.add(rs4.getString("Nome"));
                        }
                        c.setObrigatorios(dependentes); 
                    }
                    componentes.add(c);
                }
                p.setListadeComponentes(componentes);
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
        return p;
    }

    @Override
    public Pacote put(Integer key, Pacote value) {
        Pacote p = null;
        
        if(this.containsKey(key))
            p = this.get(key);
        else p = value;
        
        try {
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Pacote WHERE ID_Pacote = ?");
            ps.setString(1,Integer.toString(key));
            ps.executeUpdate();
            
            ps = conn.prepareStatement("INSERT INTO Pacote (ID_Pacote,Nome,Desconto) VALUES (?,?,?)");
            ps.setString(1,Integer.toString(key));
            ps.setString(2,value.getNome());
            ps.setString(3,Double.toString(value.getDesconto()));
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
        return p;
    }
    

    @Override
    public Pacote remove(Object key) {
        Pacote p = this.get((String) key);
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Pacote where ID_Pacote = ?");
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
        return p;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Pacote> m) {
        throw new NullPointerException("Not implemented!");
    }

    @Override
    public void clear() {
        try{
            conn = Connect.connect();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Pacote");
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
    public Set<Integer> keySet() {
        Set<Integer> set = null;
        
        try{
            conn = Connect.connect();
            set = new HashSet<>();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Pacote");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                set.add(rs.getInt("ID_Pacote"));
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
    public Collection<Pacote> values() {
        Set<Pacote> set = new HashSet<>();
        Set<Integer> keys = new HashSet<>(this.keySet());
        for(Integer key : keys){
            set.add(this.get(key));
        }
        return set;
    }

    @Override
    public Set<Entry<Integer, Pacote>> entrySet() {
        Set<Integer> keys = new HashSet<>(this.keySet());
        
        HashMap<Integer,Pacote> map = new HashMap<>();
        for(Integer key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }
    
}
