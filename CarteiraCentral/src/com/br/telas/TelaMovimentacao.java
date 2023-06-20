/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.telas;

import com.br.dao.MovimentacaoDao;
import com.br.entidades.Conta;
import com.br.entidades.Movimentacao;
import com.br.utils.Msg;
import com.br.utils.Range;
import com.br.utils.Utils;
import java.time.YearMonth;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC-Eger
 */
public class TelaMovimentacao extends javax.swing.JDialog {

    private List<Movimentacao> lista = new ArrayList<>();
    
    private double SaldoTotal = 0;

    public TelaMovimentacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Utils.maximizar(this);
        atualizaTabela();

    }
    
  protected void atualizaTabela() {
        
    try {
        DefaultTableModel model = (DefaultTableModel) tabelaMovimentacao.getModel();
        model.setNumRows(0);
        
        lista = new MovimentacaoDao().getListaData(txPesquisaCat.getText(),txDataInicial.getDate(),txDataFinal.getDate());
               
        double despesa = 0;
        double receita = 0;
        
        for (Movimentacao c : lista) {
            if(c.getIdCategoria().getTipoLancamento().equals("Despesa")){
                 despesa += c.getValorMovi();
            }else{
                receita += c.getValorMovi();
            }
            model.addRow(new Object[]{
                c.getIdMovimentacao(),
                c.getIdContaOrigem() != null ? c.getIdContaOrigem().getNomeConta() : null,
                c.getIdContaDestino().getNomeConta(),
                c.getTipoMovi(),
                c.getIdCategoria().getTipoLancamento(),
//                Utils.converterDouble(c.getValorMovi()),
                c.getValorMovi(),
                Utils.converterData(c.getDataMovi()),
                c.getDescricaoMovi(),
            });
        }
//        setSaldoTotal(receita-despesa);
//        txSaldo.setText(String.valueOf(getSaldoTotal()));
        
    } catch (Exception e) {
        e.printStackTrace();
        Msg.erro(this, "Erro ao atualizar a tabela\nErro:" + e.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMovimentacao = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txPesquisaCat = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txDataInicial = new org.jdesktop.swingx.JXDatePicker();
        txDataFinal = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Movimentação");

        tabelaMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cõdigo", "Conta Origem", "Conta Destino", "Tipo ", "Categoria", "Valor", "Data", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaMovimentacao);
        if (tabelaMovimentacao.getColumnModel().getColumnCount() > 0) {
            tabelaMovimentacao.getColumnModel().getColumn(0).setResizable(false);
            tabelaMovimentacao.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/despesa.png"))); // NOI18N
        jButton7.setText("Inserir Despesa");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/receita.png"))); // NOI18N
        jButton8.setText("Inserir Receita");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/alterar.png"))); // NOI18N
        jButton6.setText("Alterar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/excluir.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/sair.png"))); // NOI18N
        jButton4.setText("Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Pesquisar");

        txPesquisaCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPesquisaCatActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/pesquisar.png"))); // NOI18N
        jButton5.setText("Pesquisar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Data inicial:");

        txDataInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDataInicialActionPerformed(evt);
            }
        });

        jLabel4.setText("Data final:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txPesquisaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton5)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txPesquisaCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jLabel3)
                    .addComponent(txDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        atualizaTabela();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txPesquisaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPesquisaCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPesquisaCatActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
             if(tabelaMovimentacao.getSelectedRow()>=0){
             if(Msg.confirmar(this, "Deseja realmente excluir esse registro?")){
             new MovimentacaoDao().excluir(lista.get(tabelaMovimentacao.getSelectedRow()));
             Msg.informacao(this, "Excluido com sucesso!");
             atualizaTabela();
                 }
            }else{
             Msg.alert(this, "Selecione uma registro!");
         }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    if (tabelaMovimentacao.getSelectedRow() > -1) {
        if (lista.get(tabelaMovimentacao.getSelectedRow()).getIdCategoria().getTipoLancamento().equals("Despesa")) {
            TelaCadastarDespesa a = new TelaCadastarDespesa(this, true);
            a.setDespesa(true);
            a.atualizaCombo();
            a.preencheCampos(lista.get(tabelaMovimentacao.getSelectedRow()));
            a.setVisible(true);
        } else if (lista.get(tabelaMovimentacao.getSelectedRow()).getIdCategoria().getTipoLancamento().equals("Receita")) {
            TelaCadastarReceita b = new TelaCadastarReceita(this, true);
            b.setDespesa(false);
            b.atualizaCombo();
            b.preencheCampos(lista.get(tabelaMovimentacao.getSelectedRow()));
            b.setVisible(true);
        } else {
            TelaCadastarTransferencia c = new TelaCadastarTransferencia(this, true);
            c.setDespesa(false);
            c.atualizaCombo();
            c.preencheCampos(lista.get(tabelaMovimentacao.getSelectedRow()));
            c.setVisible(true);
        }
        atualizaTabela();
    }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        TelaCadastarDespesa t = new TelaCadastarDespesa(this, true);
        t.setDespesa(true); 
        t.atualizaCombo();
        t.setVisible(true);
        atualizaTabela();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        TelaCadastarReceita t = new  TelaCadastarReceita(this, true);
        t.setDespesa(false);
        t.atualizaCombo();
        t.setVisible(true);;
        atualizaTabela();

    }//GEN-LAST:event_jButton8ActionPerformed

    private void txDataInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDataInicialActionPerformed
         txDataInicial.getDate();
    }//GEN-LAST:event_txDataInicialActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaMovimentacao dialog = new TelaMovimentacao(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaMovimentacao;
    private org.jdesktop.swingx.JXDatePicker txDataFinal;
    private org.jdesktop.swingx.JXDatePicker txDataInicial;
    private javax.swing.JTextField txPesquisaCat;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the SaldoTotal
     */
    public double getSaldoTotal() {
        return SaldoTotal;
    }

    /**
     * @param SaldoTotal the SaldoTotal to set
     */
    public void setSaldoTotal(double SaldoTotal) {
        this.SaldoTotal = SaldoTotal;
    }
}
