/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Business.GestaoFabrica.Componente;
import Business.GestaoFabrica.ConfiguraFacil;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author PC - Luis
 */
public class MotorGUI extends javax.swing.JFrame {

    private ConfiguraFacil configurafacil;
    
    public MotorGUI(ConfiguraFacil configurafacil) {
        initComponents();
        this.configurafacil = configurafacil;
         insertPreco();
         System.out.println(""+configurafacil.getConfiguracao().getPreco());
    }
    
    //Qual o motor selecionado
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
      Componente c1= this.configurafacil.getGestao_fabrica().getComponente("v8");
      Componente c2= this.configurafacil.getGestao_fabrica().getComponente("v12");
      Componente c3= this.configurafacil.getGestao_fabrica().getComponente("v16");
      jRadioButton1.setText(c1.getNome());
      jRadioButton2.setText(c2.getNome());
      jRadioButton3.setText(c3.getNome());
      jLabel4.setText(String.valueOf(c1.getPreco()));
      jLabel5.setText(String.valueOf(c2.getPreco()));
      jLabel6.setText(String.valueOf(c3.getPreco()));
   }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/v8.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/v12.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/v16.png"))); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("V8");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("V12");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("v16");

        jLabel4.setLabelFor(jRadioButton1);
        jLabel4.setText("preço");

        jLabel5.setLabelFor(jRadioButton2);
        jLabel5.setText("preço");

        jLabel6.setLabelFor(jRadioButton3);
        jLabel6.setText("preço");

        jButton1.setText("Continua");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jRadioButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jRadioButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jRadioButton3))
                        .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(120, 120, 120))))
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String comp = RadioButtonSelected();
        List<String> incompativeis= this.configurafacil.getComponenteIncompativeis(comp);
        List<String> obrigatorios= this.configurafacil.compObrigatorios(comp);
            if(obrigatorios.size()>1){
                DependenciasGUI aviso= new DependenciasGUI(this,true,this.configurafacil,obrigatorios);
                aviso.setVisible(true);
            }
            if(incompativeis.size()>1){
                IncompativelGUI aviso = new IncompativelGUI(this,true,this.configurafacil,incompativeis);
                aviso.setVisible(true);
            }
            else {this.configurafacil.adicionarComponente(comp);}

            dispose();

        Componentes_ObrigatoriosGUI menu = new Componentes_ObrigatoriosGUI(this.configurafacil);
        menu.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    // End of variables declaration//GEN-END:variables
}
