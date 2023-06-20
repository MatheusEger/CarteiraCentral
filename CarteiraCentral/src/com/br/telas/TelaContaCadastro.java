/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.telas;

import com.br.dao.ContaDao;
import com.br.entidades.Conta;
import com.br.utils.Msg;

/**
 *
 * @author PC-Eger
 */
public class TelaContaCadastro extends javax.swing.JDialog {

    private boolean inserir;
    private Conta conta;
    private TelaConta pai;

    public TelaContaCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        conta = new Conta();
    }

    public TelaContaCadastro(TelaConta parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pai = parent;
        conta = new Conta();
    }

    protected void preencheCampos(Conta cat) {
        conta = cat;
        txNomeCont.setText(conta.getNomeConta());
        txSaldoCont.setText(Double.toString(conta.getSaldoConta()));
     }

     private Conta getconta() {;;
        conta.setNomeConta(txNomeCont.getText());
        conta.setSaldoConta(Double.parseDouble(txSaldoCont.getText().replace(",", ".")));
        return conta;
    }
      
    private Conta getconta(double valorInicial) {
    conta.setNomeConta(txNomeCont.getText());
    conta.setSaldoConta(valorInicial);
    return conta;
}

    private boolean vereficaCampos() {
        boolean verifica = false;
        String msg = "Campos obrigatorios!\n";
        if (txNomeCont.getText().trim().equals("") || txNomeCont.getText().isEmpty()) {
            verifica = true;
            msg += "Descrição: \n";
            txNomeCont.requestFocus();
        }
        if (verifica) {
            Msg.erro(this, msg);
        }
        return verifica;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txNomeCont = new javax.swing.JTextField();
        txSaldoCont = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro - Conta");

        jLabel5.setText("Nome da conta: ");

        jLabel6.setText("Saldo inicial:");

        txNomeCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomeContActionPerformed(evt);
            }
        });

        txSaldoCont.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txSaldoCont.setText("0,00");
        txSaldoCont.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txSaldoContFocusGained(evt);
            }
        });
        txSaldoCont.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txSaldoContMouseClicked(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/cancelar.png"))); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/aceitar.png"))); // NOI18N
        jButton4.setText("Salvar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txNomeCont)
                            .addComponent(txSaldoCont, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txNomeCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txSaldoCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txNomeContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeContActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomeContActionPerformed

    private void txSaldoContFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txSaldoContFocusGained
        txSaldoCont.selectAll();
    }//GEN-LAST:event_txSaldoContFocusGained

    private void txSaldoContMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txSaldoContMouseClicked
        txSaldoCont.selectAll();
    }//GEN-LAST:event_txSaldoContMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         if (!vereficaCampos()) {
        if (isInserir()) {
            double valorInicial = Double.parseDouble(txSaldoCont.getText().replace(",", "."));
            new ContaDao().inserir(getconta(valorInicial));
            Msg.informacao(this, "Salvo com sucesso!");
            this.pai.atualizaTabela();
            this.dispose();
        } else {
            new ContaDao().alterar(getconta());
            Msg.informacao(this, "Alterado com sucesso!");
            this.pai.atualizaTabela();
            this.dispose();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaContaCadastro.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaContaCadastro.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaContaCadastro.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaContaCadastro.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaContaCadastro dialog = new TelaContaCadastro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txNomeCont;
    private javax.swing.JFormattedTextField txSaldoCont;
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
