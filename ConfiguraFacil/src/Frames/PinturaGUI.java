/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Business.GestaoFabrica.Componente;
import Business.GestaoFabrica.ConfiguraFacil;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author PC - Luis
 */
public class PinturaGUI extends javax.swing.JFrame {
    
    private ConfiguraFacil configurafacil;

    /**
     * Creates new form Pintura
     */
    public PinturaGUI(ConfiguraFacil c) {
        initComponents();
        this.configurafacil = c;
        insertPreco();
    }
    
    /*
    public PinturaGUI(java.awt.Frame parent, boolean modal, String cor) {
         super(parent, modal);
        initComponents();
        selecionarRadioButton(cor);  
    }*/
    
        

  public String RadioButtonSelected(){
        String componente="";
         Enumeration elements = buttonGroup1.getElements();
     while (elements.hasMoreElements()) {
        JRadioButton button = (JRadioButton)elements.nextElement();
        if (button.isSelected()) {
             if(buttonGroup1.getSelection().equals(button.getModel()))
                    componente= button.getText();
             return componente;
      }
        
    }
     return componente;
    }
   public void insertPreco(){
       List<Componente> pintura = this.configurafacil.getGestao_fabrica().getPinturas();
       Preto.setText(pintura.get(0).getNome());
       Marron.setText(pintura.get(1).getNome());
       Cinzento.setText(pintura.get(2).getNome());
       Azul.setText(pintura.get(3).getNome());
       Branco.setText(pintura.get(4).getNome());
       Crayon.setText(pintura.get(5).getNome());
       Vermelho.setText(pintura.get(6).getNome());
       Preto_Mate.setText(pintura.get(7).getNome());
   }
  
   
   
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Preto = new javax.swing.JRadioButton();
        Marron = new javax.swing.JRadioButton();
        Branco = new javax.swing.JRadioButton();
        Azul = new javax.swing.JRadioButton();
        Vermelho = new javax.swing.JRadioButton();
        Crayon = new javax.swing.JRadioButton();
        Cinzento = new javax.swing.JRadioButton();
        Preto_Mate = new javax.swing.JRadioButton();
        Continua = new javax.swing.JButton();

        setTitle("Escolhe Pintura");

        buttonGroup1.add(Preto);
        Preto.setSelected(true);
        Preto.setText("Preto");

        buttonGroup1.add(Marron);
        Marron.setText("Marron");

        buttonGroup1.add(Branco);
        Branco.setText("Branco");

        buttonGroup1.add(Azul);
        Azul.setText("Azul");

        buttonGroup1.add(Vermelho);
        Vermelho.setText("Vermelho");

        buttonGroup1.add(Crayon);
        Crayon.setText("Crayon");

        buttonGroup1.add(Cinzento);
        Cinzento.setText("Cinzento");
        Cinzento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CinzentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(Preto_Mate);
        Preto_Mate.setText("Preto Mate");

        Continua.setText("Continuar");
        Continua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Branco)
                            .addComponent(Vermelho)
                            .addComponent(Preto)
                            .addComponent(Cinzento))
                        .addGap(277, 277, 277)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Azul)
                            .addComponent(Marron)
                            .addComponent(Crayon)
                            .addComponent(Preto_Mate)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(Continua)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Preto)
                    .addComponent(Marron))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cinzento)
                    .addComponent(Azul))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Branco)
                    .addComponent(Crayon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Vermelho)
                    .addComponent(Preto_Mate))
                .addGap(18, 18, 18)
                .addComponent(Continua)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CinzentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CinzentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CinzentoActionPerformed

    private void ContinuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuaActionPerformed
       String comp = RadioButtonSelected();
        List<String> incompativeis= this.configurafacil.getComponenteIncompativeis(comp);
        List<String> obrigatorios= this.configurafacil.compObrigatorios(comp);
            if(obrigatorios.size()!=1){
                DependenciasGUI aviso= new DependenciasGUI(this,true,this.configurafacil,obrigatorios);
                aviso.setVisible(true);
            }
            if(incompativeis.size()!=1){
                IncompativelGUI aviso = new IncompativelGUI(this,true,this.configurafacil,incompativeis);
                aviso.setVisible(true);
            }
            else {this.configurafacil.adicionarComponente(comp);}

            dispose();

        Componentes_ObrigatoriosGUI componenteObrigatorio = new Componentes_ObrigatoriosGUI(this.configurafacil);
        componenteObrigatorio.setVisible(true);
    }//GEN-LAST:event_ContinuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Azul;
    private javax.swing.JRadioButton Branco;
    private javax.swing.JRadioButton Cinzento;
    private javax.swing.JButton Continua;
    private javax.swing.JRadioButton Crayon;
    private javax.swing.JRadioButton Marron;
    private javax.swing.JRadioButton Preto;
    private javax.swing.JRadioButton Preto_Mate;
    private javax.swing.JRadioButton Vermelho;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables
}
