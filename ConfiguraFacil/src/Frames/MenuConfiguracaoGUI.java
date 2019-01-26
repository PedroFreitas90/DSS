package Frames;

import Business.GestaoFabrica.Componente;
import Business.GestaoFabrica.ConfiguraFacil;
import Business.GestaoFabrica.Configuracao;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;


public class MenuConfiguracaoGUI extends javax.swing.JFrame {
    
    private ConfiguraFacil configurafacil;

    
    public MenuConfiguracaoGUI(ConfiguraFacil configurafacil) {
        initComponents();
        this.configurafacil=configurafacil;
        updateListaConfiguracao();
    }

    public void updateListaConfiguracao(){
        DefaultListModel model = new DefaultListModel();
        jList1.setModel(model);
        Configuracao config= this.configurafacil.getConfiguracao(); 
        int index =0, i; // a primeira linha da lista é 0 , para fugir á exceção que lança
        model.add(index++,config.getCarro().getNome()); 
        Map<String,Componente> componentes=this.configurafacil.getConfiguracao().getComponentes();
        int tamanho =componentes.size();
        for(Componente c :componentes.values()){
            model.add(index++,c.getNome());
        }
        System.out.println(""+ config.getPreco());
            
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        EscCarro = new javax.swing.JButton();
        CompObrigatorios = new javax.swing.JButton();
        Detalhes = new javax.swing.JButton();
        CompOpcionais = new javax.swing.JButton();
        Voltar = new javax.swing.JButton();
        RemoveComponente = new javax.swing.JButton();
        EscPacotes = new javax.swing.JButton();
        ConfigOtima = new javax.swing.JButton();
        Enviar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Menu Configuração");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ConfiguraFácil");

        EscCarro.setText("Carro");
        EscCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscCarroActionPerformed(evt);
            }
        });

        CompObrigatorios.setText("Componentes \nObrigatórios");
        CompObrigatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompObrigatoriosActionPerformed(evt);
            }
        });

        Detalhes.setText("Detalhes");
        Detalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetalhesActionPerformed(evt);
            }
        });

        CompOpcionais.setText("Componente Opcionais");
        CompOpcionais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompOpcionaisActionPerformed(evt);
            }
        });

        Voltar.setText("Volta");
        Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarActionPerformed(evt);
            }
        });

        RemoveComponente.setText("Remover Componente");
        RemoveComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveComponenteActionPerformed(evt);
            }
        });

        EscPacotes.setText("Pacotes");
        EscPacotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscPacotesActionPerformed(evt);
            }
        });

        ConfigOtima.setText("Configuração Ótina");
        ConfigOtima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigOtimaActionPerformed(evt);
            }
        });

        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(Voltar)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RemoveComponente)
                            .addComponent(Detalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EscCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(EscPacotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CompObrigatorios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(CompOpcionais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(82, 82, 82))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(ConfigOtima, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EscCarro)
                            .addComponent(CompObrigatorios))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Detalhes)
                            .addComponent(CompOpcionais))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RemoveComponente)
                            .addComponent(EscPacotes))
                        .addGap(34, 34, 34)
                        .addComponent(ConfigOtima))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Voltar)
                    .addComponent(Enviar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EscCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EscCarroActionPerformed
        dispose();
        EscolheCarroGUI escolhecarro = new EscolheCarroGUI(this.configurafacil);
        escolhecarro.setVisible(true);
    }//GEN-LAST:event_EscCarroActionPerformed

    private void CompObrigatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompObrigatoriosActionPerformed
        dispose();
        Componentes_ObrigatoriosGUI escolheobrigatorios = new Componentes_ObrigatoriosGUI(this.configurafacil);
        escolheobrigatorios.setVisible(true);
    }//GEN-LAST:event_CompObrigatoriosActionPerformed

    private void DetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetalhesActionPerformed
        // TODO add your handling code here:
        dispose();
        DetalhesGUI detalhes= new DetalhesGUI(this.configurafacil);
        detalhes.setVisible(true);
        
        
    }//GEN-LAST:event_DetalhesActionPerformed

    private void CompOpcionaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompOpcionaisActionPerformed
        // TODO add your handling code here:
        dispose();
        OpcionalGUI menu = new OpcionalGUI(this.configurafacil);
        menu.setVisible(true);
        
    }//GEN-LAST:event_CompOpcionaisActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        dispose();
        if(configurafacil.getGestao_funcionarios().checkGestor(this.configurafacil.getUtilizador())){
            MenuGestorGUI menu = new MenuGestorGUI(this.configurafacil);
            menu.setVisible(true);
        }
        else{
        MenuFuncionarioGUI menuFuncionario= new MenuFuncionarioGUI(this.configurafacil); // abre o menu do funcionario
        menuFuncionario.setVisible(true);
       }
    }//GEN-LAST:event_VoltarActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        if(this.configurafacil.getConfiguracao().verificaComponentesObrigatorios()){
        this.configurafacil.checkPacote();
        EnviarConfiguracao enviaconfiguracao= new EnviarConfiguracao(this,true,this.configurafacil);
        enviaconfiguracao.setVisible(true);
        dispose();
        }
        //}
        
    }//GEN-LAST:event_EnviarActionPerformed

    private void EscPacotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EscPacotesActionPerformed
        dispose();
        EscolhePacoteGUI pacote = new EscolhePacoteGUI(this,true,this.configurafacil);
        pacote.setVisible(true);
    }//GEN-LAST:event_EscPacotesActionPerformed

    private void RemoveComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveComponenteActionPerformed
        // TODO add your handling code here:
        dispose();
        RemoverComponente menu= new RemoverComponente(this.configurafacil);
        menu.setVisible(true);
    }//GEN-LAST:event_RemoveComponenteActionPerformed

    private void ConfigOtimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigOtimaActionPerformed
        dispose();
        Configuracao_OtimaGUI configotima = new Configuracao_OtimaGUI(this.configurafacil);
        configotima.setVisible(true);
    }//GEN-LAST:event_ConfigOtimaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CompObrigatorios;
    private javax.swing.JButton CompOpcionais;
    private javax.swing.JButton ConfigOtima;
    private javax.swing.JButton Detalhes;
    private javax.swing.JButton Enviar;
    private javax.swing.JButton EscCarro;
    private javax.swing.JButton EscPacotes;
    private javax.swing.JButton RemoveComponente;
    private javax.swing.JButton Voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}