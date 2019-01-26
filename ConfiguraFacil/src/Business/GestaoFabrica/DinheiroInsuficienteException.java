/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.GestaoFabrica;

/**
 *
 * @author mariadias
 */
public class DinheiroInsuficienteException extends Exception {

    /**
     * Creates a new instance of <code>DinheiroInsuficienteException</code>
     * without detail message.
     */
    public DinheiroInsuficienteException() {
    }

    /**
     * Constructs an instance of <code>DinheiroInsuficienteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public DinheiroInsuficienteException(String msg) {
        super(msg);
    }
}
