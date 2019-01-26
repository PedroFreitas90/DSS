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
import javax.swing.JRadioButton;

/**
 *
 * @author PC - Luis
 */
public class PneusGUI extends javax.swing.JFrame {
    
    private ConfiguraFacil configurafacil;
    

    /**
     * Creates new form Pneus
     */
    public PneusGUI(ConfiguraFacil configurafacil) {
        initComponents();
        this.configurafacil = configurafacil;
        insertPreco();
    }

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
       List<Componente> pneus = this.configurafacil.getGestao_fabrica().getPneus();
       Pireli.setText(pneus.get(0).getNome());
       Michelin.setText(pneus.get(1).getNome());
       Continental.setText(pneus.get(2).getNome());
       precoPireli.setText(String.valueOf(pneus.get(0).getPreco()));
       precoMichelin.setText(String.valueOf(pneus.get(1).getPreco()));
       precoContinental.setText(String.valueOf(pneus.get(2).getPreco()));
     }
       
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        Jlabel2 = new javax.swing.JLabel();
        Pireli = new javax.swing.JRadioButton();
        Michelin = new javax.swing.JRadioButton();
        Continental = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        Continuar = new javax.swing.JButton();
        precoPireli = new javax.swing.JLabel();
        precoMichelin = new javax.swing.JLabel();
        precoContinental = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pneus");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pireli.png"))); // NOI18N

        Jlabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/latitude-cross.png"))); // NOI18N

        buttonGroup1.add(Pireli);
        Pireli.setSelected(true);
        Pireli.setText("Pireli");

        buttonGroup1.add(Michelin);
        Michelin.setText("Michelin");

        buttonGroup1.add(Continental);
        Continental.setText("Continental");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/continental.png"))); // NOI18N

        Continuar.setText("Continuar");
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });

        precoPireli.setText("preço");

        precoMichelin.setText("preço");

        precoContinental.setText("preço");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(precoPireli)
                            .addComponent(Pireli))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Michelin)
                        .addGap(118, 118, 118))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jlabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(precoMichelin)
                                .addComponent(Continuar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Continental)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(precoContinental)
                        .addGap(121, 121, 121))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Jlabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pireli)
                    .addComponent(Michelin)
                    .addComponent(Continental))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(precoPireli)
                    .addComponent(precoMichelin)
                    .addComponent(precoContinental))
                .addGap(34, 34, 34)
                .addComponent(Continuar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        String comp = RadioButtonSelected();
        List<String> incompativeis= this.configurafacil.getConfiguracao().descobreIncompativel(comp);
        Componente c= this.configurafacil.getGestao_fabrica().getComponente(comp);
            if(c.existeObrigatorios()){
                List<String> idNome = c.getObrigatorios();
                idNome.add(comp);//ultimo elemento da lista é que sem pretende adicionoar
                DependenciasGUI aviso= new DependenciasGUI(this,true,this.configurafacil,idNome);
                aviso.setVisible(true);
            }
            if(incompativeis.size()!=1){
                IncompativelGUI aviso = new IncompativelGUI(this,true,this.configurafacil,incompativeis);
                aviso.setVisible(true);
            }
            else {this.configurafacil.adicionarComponente(comp);}

            dispose();

       Componentes_ObrigatoriosGUI menu = new Componentes_ObrigatoriosGUI(this.configurafacil);
        menu.setVisible(true);

    }//GEN-LAST:event_ContinuarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Continental;
    private javax.swing.JButton Continuar;
    private javax.swing.JLabel Jlabel2;
    private javax.swing.JRadioButton Michelin;
    private javax.swing.JRadioButton Pireli;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel precoContinental;
    private javax.swing.JLabel precoMichelin;
    private javax.swing.JLabel precoPireli;
    // End of variables declaration//GEN-END:variables
}
