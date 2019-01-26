/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.GestaoFuncionarios;

import Business.GestaoFuncionarios.Funcionario;
import Business.GestaoFuncionarios.FuncionarioExistenteException;
import Business.GestaoFuncionarios.FuncionarioInvalidoException;
import Data.FuncionarioDAO;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Maria, Francisco, Davide, Pedro
 */
public class GestaoFuncionarios {
    
   private FuncionarioDAO funcionarios;
   
     /**
     * Construtor vazio
     */
    public GestaoFuncionarios(){
      this.funcionarios=new FuncionarioDAO();
    }  
  
    public Map<String, Funcionario> getFuncionarios() {
        Map<String,Funcionario> novo= new HashMap<>();
        for(Map.Entry<String,Funcionario> entry: this.funcionarios.entrySet())
                novo.put(entry.getKey(),entry.getValue());
        return novo;
    }
    
 
    
    public void setFuncionarios(Map<String, Funcionario> funcionarios) {
        this.funcionarios.clear();
        for(Map.Entry<String,Funcionario> entry: this.funcionarios.entrySet())       
                this.funcionarios.put(entry.getKey(),entry.getValue());
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
        final GestaoFuncionarios other = (GestaoFuncionarios) obj;
        if (!Objects.equals(this.funcionarios, other.funcionarios)) {
            return false;
        }
        return true;
    }

    
    /**
     * Adiciona utilizador
     * @param u 
     */
    public void addUtilizador(String username, String password) throws FuncionarioExistenteException {
        boolean is = checkUsername(username);
        if(!is){
            Funcionario func = new Funcionario(username,password);
            funcionarios.put(func.getNome(), func);
        }
    }
    
    /**
     * Verifica se o funcionario é o gestor
     * @param user
     * @return 
     */
    public boolean checkGestor(Funcionario user){
        Funcionario gestor = new Funcionario("gestor","admin");
        return gestor.equals(user);
    }
    
      /**
     * Verifica se um utilizador está registado
     *
     * @param username
     * 
     * @param password
     * 
     * @return Funcionario
     */
     public Funcionario checkFuncionario(String username,String password)throws FuncionarioInvalidoException{
         Funcionario funcionario ;
         if( this.funcionarios.containsKey(username)){
             funcionario=this.funcionarios.get(username);
             if(funcionario.getPassword().equals(password)) return funcionario;
         }
         else throw new FuncionarioInvalidoException("Este nome nao existe!");
        return null;
     
     }
     /**
      * Verifica se o username ja foi utilizado
      * @param username
      * @return 
      */
     public boolean checkUsername(String username){
         for(Map.Entry<String,Funcionario> entry: this.funcionarios.entrySet())
                if(entry.getKey().equals(username))
                    return true;
        return false; 
     }
     
     

    
      
    
}