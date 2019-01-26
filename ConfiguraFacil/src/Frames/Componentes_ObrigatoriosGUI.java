/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Business.GestaoFabrica.ConfiguraFacil;




/**
 *
 * @author PC - Luis
 */
public class Componentes_ObrigatoriosGUI extends javax.swing.JFrame {
   
    private ConfiguraFacil configurafacil;

   
    public  Componentes_ObrigatoriosGUI(ConfiguraFacil c) {
        initComponents();
        this.configurafacil = c;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pinturaButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        MotorButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        PneusButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JantesButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        VoltarButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        pinturaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pintura.png"))); // NOI18N
        pinturaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinturaButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Pintura");

        MotorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gear_icon-icons.com_70125.png"))); // NOI18N
        MotorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MotorButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Motor");

        PneusButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pneu.png"))); // NOI18N
        PneusButton.setRolloverEnabled(false);
        PneusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PneusButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Pneus");

        JantesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/jante-icone.png"))); // NOI18N
        JantesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JantesButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Jantes");

        VoltarButton.setText("Voltar");
        VoltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("ConfiguraFácil");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PneusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pinturaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MotorButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JantesButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(109, 109, 109))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(101, 101, 101))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(270, 270, 270))
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(VoltarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pinturaButton)
                    .addComponent(MotorButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JantesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PneusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VoltarButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarButtonActionPerformed
        dispose();
        MenuConfiguracaoGUI menuConfiguracao = new MenuConfiguracaoGUI(this.configurafacil);
        menuConfiguracao.setVisible(true);
    }//GEN-LAST:event_VoltarButtonActionPerformed

    private void pinturaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinturaButtonActionPerformed
        dispose();
        PinturaGUI menupintura = new PinturaGUI(this.configurafacil);
        menupintura.setVisible(true);
     
    }//GEN-LAST:event_pinturaButtonActionPerformed
   
    private void MotorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MotorButtonActionPerformed
        dispose();
        MotorGUI menumotor = new MotorGUI(this.configurafacil);
        menumotor.setVisible(true);
    }//GEN-LAST:event_MotorButtonActionPerformed
   
    
    private void PneusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PneusButtonActionPerformed
        dispose();
        PneusGUI menupneus = new PneusGUI(this.configurafacil);
        menupneus.setVisible(true);
    }//GEN-LAST:event_PneusButtonActionPerformed

    private void JantesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JantesButtonActionPerformed
        dispose();
        JantesGUI menujantes = new JantesGUI(this.configurafacil);
        menujantes.setVisible(true);
    }//GEN-LAST:event_JantesButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JantesButton;
    private javax.swing.JButton MotorButton;
    private javax.swing.JButton PneusButton;
    private javax.swing.JButton VoltarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton pinturaButton;
    // End of variables declaration//GEN-END:variables
}
