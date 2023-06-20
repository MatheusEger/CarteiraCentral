/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.telas;

import com.br.dao.CategoriaDao;
import com.br.entidades.Categoria;
import com.br.utils.Msg;

/**
 *
 * @author PC-Eger
 */
public class TelaCategoriaCadastro extends javax.swing.JDialog {

    private boolean inserir;
    private Categoria categoria;
    private TelaCategoria pai;

    public TelaCategoriaCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        categoria = new Categoria();
    }

    public TelaCategoriaCadastro(TelaCategoria parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pai = parent;
        categoria = new Categoria();
    }

    protected void preencheCampos(Categoria cat) {
        categoria = cat;
        txNomeCat.setText(categoria.getNomeCategoria());
        cbTipoCat.setSelectedItem(categoria.getTipoLancamento());

    }

    private Categoria getCategoria() {
        categoria.setTipoLancamento(cbTipoCat.getSelectedItem().toString());
        categoria.setNomeCategoria(txNomeCat.getText());
        return categoria;
    }

    private boolean vereficaCampos() {
        boolean verifica = false;
        String msg = "Campos obrigatorios!\n";
        if (txNomeCat.getText().trim().equals("") || txNomeCat.getText().isEmpty()) {
            verifica = true;
            msg += "Descrição: \n";
            txNomeCat.requestFocus();
        }
        if (verifica) {
            Msg.erro(this, msg);
        }
        return verifica;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txNomeCat = new javax.swing.JTextField();
        cbTipoCat = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro - Categoria");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/cancelar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/aceitar.png"))); // NOI18N
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        jLabel1.setText("Descrição:");

        jLabel2.setText("Tipo:");

        txNomeCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomeCatActionPerformed(evt);
            }
        });

        cbTipoCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Despesa", "Receita", "Transferencia" }));
        cbTipoCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoCatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txNomeCat, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipoCat, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txNomeCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbTipoCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txNomeCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomeCatActionPerformed

    private void cbTipoCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoCatActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!vereficaCampos()) {
            if (isInserir()) {
                new CategoriaDao().inserir(getCategoria());
                Msg.informacao(this, "Salvo com sucesso!");
                this.pai.atualizaTabela();
                this.dispose();
            } else {
                new CategoriaDao().alterar(getCategoria());
                Msg.informacao(this, "Alterado com sucesso!");
                this.pai.atualizaTabela();
                this.dispose();
            }
        }
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCategoriaCadastro.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCategoriaCadastro.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCategoriaCadastro.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCategoriaCadastro.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCategoriaCadastro dialog = new TelaCategoriaCadastro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbTipoCat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txNomeCat;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the inserir
     */
    public boolean isInserir() {
        return inserir;
    }

    /**
     * @param inserir the inserir to set
     */
    public void setInserir(boolean inserir) {
        this.inserir = inserir;
    }
}
