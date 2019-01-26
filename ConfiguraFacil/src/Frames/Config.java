/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;
import Business.GestaoFabrica.ConfiguraFacil;


public class Config {

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     ConfiguraFacil cf=new ConfiguraFacil();
     LoginGUI l= new LoginGUI(cf);
     
     l.setVisible(true);
 
       
     

              
        
    }
    
}
