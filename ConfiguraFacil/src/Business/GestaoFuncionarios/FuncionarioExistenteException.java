/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.GestaoFuncionarios;

/**
 *
 * @author mariadias
 */
public class FuncionarioExistenteException extends Exception {

    /**
     * Creates a new instance of <code>FuncionarioExistenteException</code>
     * without detail message.
     */
    public FuncionarioExistenteException() {
    }

    /**
     * Constructs an instance of <code>FuncionarioExistenteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public FuncionarioExistenteException(String msg) {
        super(msg);
    }
}
