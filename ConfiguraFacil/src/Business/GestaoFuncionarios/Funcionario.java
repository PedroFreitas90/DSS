/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.GestaoFuncionarios;

import java.util.Objects;

/**
 *
 * @author PC - Luis
 */
public class Funcionario {
    private String nome;
    private String password;
    
    
    public Funcionario(String nome, String password){
        this.nome=nome;
        this.password=password;
    }

    public Funcionario(Funcionario u){
        this.nome=u.getNome();
        this.password=u.getPassword();
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   public Funcionario clone(){
       return new Funcionario(this);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Utilizador{" + "nome=" + nome + ", password=" + password + '}';
    }



}
