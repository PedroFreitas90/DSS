package Frames;

import Business.GestaoFabrica.Componente;
import Business.GestaoFabrica.ConfiguraFacil;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JRadioButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC - Luis
 */
public class JantesGUI extends javax.swing.JFrame {

    private ConfiguraFacil configurafacil;
    
    public JantesGUI(ConfiguraFacil configurafacil) {
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
      Componente c1= this.configurafacil.getGestao_fabrica().getComponente("Modelo1");
      Componente c2= this.configurafacil.getGestao_fabrica().getComponente("Modelo2");
      Componente c3= this.configurafacil.getGestao_fabrica().getComponente("Modelo3");
      Jante1.setText(c1.getNome());
      jante2.setText(c2.getNome());
      Jante3.setText(c3.getNome());
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
        Jante1 = new javax.swing.JRadioButton();
        jante2 = new javax.swing.JRadioButton();
        Jante3 = new javax.swing.JRadioButton();
        Continua = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Jantes");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/22polegadas.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/jante2.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/jante3.png"))); // NOI18N

        buttonGroup1.add(Jante1);
        Jante1.setSelected(true);
        Jante1.setText("Modelo 1");

        buttonGroup1.add(jante2);
        jante2.setText("Modelo 2");

        buttonGroup1.add(Jante3);
        Jante3.setText("Modelo3");

        Continua.setText("Continuar");
        Continua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuaActionPerformed(evt);
            }
        });

        jLabel4.setText("Preço");

        jLabel5.setText("Preço");

        jLabel6.setText("Preço");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(Jante1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel3)
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jante2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Jante3)
                        .addGap(76, 76, 76))))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel4)
                .addGap(184, 184, 184)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Continua)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(89, 89, 89))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jante1)
                    .addComponent(jante2)
                    .addComponent(Jante3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(27, 27, 27)
                .addComponent(Continua)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

      Componentes_ObrigatoriosGUI menu = new Componentes_ObrigatoriosGUI(this.configurafacil);
        menu.setVisible(true);
    }//GEN-LAST:event_ContinuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Continua;
    private javax.swing.JRadioButton Jante1;
    private javax.swing.JRadioButton Jante3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jante2;
    // End of variables declaration//GEN-END:variables
}
