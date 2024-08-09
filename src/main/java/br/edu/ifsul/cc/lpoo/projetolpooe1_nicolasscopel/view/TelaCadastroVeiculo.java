/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.view;

import br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.model.Veiculo;
import br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.model.Proprietario;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolas Scopel
 */
public class TelaCadastroVeiculo extends javax.swing.JFrame {

    DefaultListModel<Veiculo> mascaraItemLista = new DefaultListModel<>();
    /**
     * Creates new form TelaCadastroVeiculo
     */
    public TelaCadastroVeiculo() {
        initComponents();
        
        lstVeiculos.clearSelection();
        lstVeiculos.setModel(mascaraItemLista);
        
        listarVeiculos();
    }
    
     private void listarVeiculos() {

        PersistenciaJPA jpa = new PersistenciaJPA();
        jpa.conexaoAberta();

        List<Veiculo> veiculos = jpa.getVeiculos();
        mascaraItemLista.clear();

        for (Veiculo veic : veiculos) {
            mascaraItemLista.addElement(veic);

        }
        lstVeiculos.setModel(mascaraItemLista);
        jpa.fecharConexao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscaNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstVeiculos = new javax.swing.JList<>();
        btnNovoVeiculo = new javax.swing.JButton();
        btnEditarVeiculo = new javax.swing.JButton();
        btnRemoverVeiculo = new javax.swing.JButton();
        btnCancelarVeiculo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("TELA CADASTRO VEÍCULO");

        jLabel2.setText("Pesquisar via Nome:");

        txtBuscaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaNomeKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("LISTA DE VEÍCULOS");

        jScrollPane1.setViewportView(lstVeiculos);

        btnNovoVeiculo.setText("Novo");
        btnNovoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoVeiculoActionPerformed(evt);
            }
        });

        btnEditarVeiculo.setText("Editar");
        btnEditarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVeiculoActionPerformed(evt);
            }
        });

        btnRemoverVeiculo.setText("Remover");
        btnRemoverVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverVeiculoActionPerformed(evt);
            }
        });

        btnCancelarVeiculo.setText("Cancelar");
        btnCancelarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVeiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnNovoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnEditarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnRemoverVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnCancelarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(txtBuscaNome))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoVeiculo)
                    .addComponent(btnEditarVeiculo)
                    .addComponent(btnRemoverVeiculo)
                    .addComponent(btnCancelarVeiculo))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVeiculoActionPerformed
       dispose();
    }//GEN-LAST:event_btnCancelarVeiculoActionPerformed

    private void txtBuscaNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaNomeKeyReleased
        // TODO add your handling code here:
        String textoBusca = txtBuscaNome.getText().trim();
        
        if(textoBusca.isEmpty()){
            //return;
        }
                
        PersistenciaJPA jpa = new PersistenciaJPA();
        jpa.conexaoAberta();

        List<Veiculo> veiculos = jpa.getVeiculos(textoBusca);
        mascaraItemLista.clear();

        for (Veiculo veic : veiculos) {
            mascaraItemLista.addElement(veic);

        }
        lstVeiculos.setModel(mascaraItemLista);
        jpa.fecharConexao();
    }//GEN-LAST:event_txtBuscaNomeKeyReleased

    private void btnNovoVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoVeiculoActionPerformed
        TelaNovoVeiculo novo = new TelaNovoVeiculo(this, true);
        novo.setVisible(true);
        
        listarVeiculos();
    }//GEN-LAST:event_btnNovoVeiculoActionPerformed

    private void btnRemoverVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverVeiculoActionPerformed
        
        // TODO add your handling code here:
        Veiculo veiculoSelecionado = lstVeiculos.getSelectedValue();
        PersistenciaJPA jpa = new PersistenciaJPA();
        
        if(veiculoSelecionado != null){
            int confirmPanel = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover o veiculo " + veiculoSelecionado + " ?");

        if (confirmPanel == JOptionPane.YES_OPTION) {

            try {

                jpa.conexaoAberta();
                jpa.remover(veiculoSelecionado);
                jpa.fecharConexao();
                listarVeiculos();
            } catch (Exception ex) {
                System.out.println("Erro ao remover veiculo selecionado!");

            } finally {
                jpa.fecharConexao();
            }

        }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Nenhum veiculo selecionado! ");
        }
    }//GEN-LAST:event_btnRemoverVeiculoActionPerformed

    private void btnEditarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVeiculoActionPerformed
        
        Veiculo veiculoSelecionado = lstVeiculos.getSelectedValue();
        
        if(veiculoSelecionado != null){
            
            TelaEditarVeiculo editado = new TelaEditarVeiculo(this, true);
            editado.setVeiculo(veiculoSelecionado);
            editado.setVisible(true);
            listarVeiculos();
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Nenhum Veiculo Selecionado");
            
        }
        
    }//GEN-LAST:event_btnEditarVeiculoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarVeiculo;
    private javax.swing.JButton btnEditarVeiculo;
    private javax.swing.JButton btnNovoVeiculo;
    private javax.swing.JButton btnRemoverVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Veiculo> lstVeiculos;
    private javax.swing.JTextField txtBuscaNome;
    // End of variables declaration//GEN-END:variables
}
