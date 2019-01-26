/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.GestaoFuncionarios;

/**
 *
 * @author Maria, Francisco, Davide, Pedro
 */
public class FuncionarioInvalidoException extends Exception {

    /**
     * Exceção caso a key nao exista no map de Funcionaarios
     * @param msg the detail message.
     */
    public FuncionarioInvalidoException(String msg) {
        super(msg);
    }
}
