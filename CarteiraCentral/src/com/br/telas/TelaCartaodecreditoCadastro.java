/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.telas;

import com.br.dao.CartaodecreditoDao;
import com.br.entidades.Cartaodecredito;
import com.br.utils.Msg;

/**
 *
 * @author PC-Eger
 */
public class TelaCartaodecreditoCadastro extends javax.swing.JDialog {

    private boolean inserir;
    private Cartaodecredito cartaodecredito;
    private TelaCartaodecredito pai;

    public TelaCartaodecreditoCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cartaodecredito = new Cartaodecredito();
    }

    public TelaCartaodecreditoCadastro(TelaCartaodecredito parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pai = parent;
        cartaodecredito = new Cartaodecredito();
    }

    protected void preencheCampos(Cartaodecredito cat) {
        cartaodecredito = cat;
        txNomeCartao.setText(cartaodecredito.getNomeCartao());
        txLimite.setText(Double.toString(cartaodecredito.getLimiteCartao()));
        txDIaF.setText(Integer.toString(cartaodecredito.getDataFechamento()));
        txDiaV.setText(Integer.toString(cartaodecredito.getDataVencimento()));

     }

      private Cartaodecredito getCartaodecredito() {;;
        cartaodecredito.setNomeCartao(txNomeCartao.getText());
        cartaodecredito.setLimiteCartao(Double.parseDouble(txLimite.getText().replace(",", ".")));
        cartaodecredito.setDataFechamento(Integer.parseInt(txDIaF.getText()));
        cartaodecredito.setDataVencimento(Integer.parseInt(txDiaV.getText()));
        return cartaodecredito;
    }

    private boolean vereficaCampos() {
        boolean verifica = false;
        String msg = "Campos obrigatorios!\n";
        if (txNomeCartao.getText().trim().equals("") || txNomeCartao.getText().isEmpty()) {
            verifica = true;
            msg += "Descrição: \n";
            txNomeCartao.requestFocus();
        }
        if (verifica) {
            Msg.erro(this, msg);
        }
        return verifica;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txDIaF = new javax.swing.JTextField();
        txDiaV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txNomeCartao = new javax.swing.JTextField();
        txLimite = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro - Cartáo de Credito");

        jLabel1.setText("Nome do cartáo de credito:");

        jLabel2.setText("Limite do cartäo:");

        txNomeCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomeCartaoActionPerformed(evt);
            }
        });

        txLimite.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txLimite.setText("0,00");
        txLimite.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txLimiteFocusGained(evt);
            }
        });
        txLimite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txLimiteMouseClicked(evt);
            }
        });
        txLimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txLimiteActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha dia:");

        jLabel4.setText("Vence dia:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txDIaF, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txDiaV, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txNomeCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNomeCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txDiaV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txDIaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txNomeCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeCartaoActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_txNomeCartaoActionPerformed

    private void txLimiteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txLimiteFocusGained
        txLimite.selectAll();
    }//GEN-LAST:event_txLimiteFocusGained

    private void txLimiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txLimiteMouseClicked
        txLimite.selectAll();
    }//GEN-LAST:event_txLimiteMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!vereficaCampos()) {
            if (isInserir()) {
                new CartaodecreditoDao().inserir(getCartaodecredito());
                Msg.informacao(this, "Salvo com sucesso!");
                this.pai.atualizaTabela();
                this.dispose();
            } else {
                new CartaodecreditoDao().alterar(getCartaodecredito());
                Msg.informacao(this, "Alterado com sucesso!");
                this.pai.atualizaTabela();
                this.dispose();
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txLimiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txLimiteActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCartaodecreditoCadastro.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCartaodecreditoCadastro.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCartaodecreditoCadastro.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCartaodecreditoCadastro.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCartaodecreditoCadastro dialog = new TelaCartaodecreditoCadastro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txDIaF;
    private javax.swing.JTextField txDiaV;
    private javax.swing.JFormattedTextField txLimite;
    private javax.swing.JTextField txNomeCartao;
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
