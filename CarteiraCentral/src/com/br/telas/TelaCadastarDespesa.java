/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.telas;

import com.br.dao.CartaodecreditoDao;
import com.br.dao.CategoriaDao;
import com.br.dao.ContaDao;
import com.br.dao.MovimentacaoDao;
import com.br.entidades.Cartaodecredito;
import com.br.entidades.Categoria;
import com.br.entidades.Conta;
import com.br.entidades.Movimentacao;
import com.br.utils.Msg;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC-Eger
 */
public class TelaCadastarDespesa extends javax.swing.JDialog {

    private boolean inserir;
    private boolean despesa;
    private Movimentacao movimentacao;
    private TelaMovimentacao pai;
    private List<Categoria> listaCategoria = new ArrayList<>();
    private List<Conta> listaConta = new ArrayList<>();
    private List<Cartaodecredito> listaCartao = new ArrayList<>();
    

    public TelaCadastarDespesa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        movimentacao = new Movimentacao();
        atualizaCombo();
        atualizarComboConta();
    }

    public TelaCadastarDespesa(TelaMovimentacao parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pai = parent;
        movimentacao = new Movimentacao();
        atualizaCombo();
        atualizarComboConta();
    }
    
    protected  void atualizaCombo(){
        try {
            cbCategoria.removeAllItems();
            cbCategoria.addItem("<selecione>");
            if(isDespesa()){
                listaCategoria = new CategoriaDao().getListaFiltro("Despesa");

            }else{
                listaCategoria = new CategoriaDao().getListaFiltro("Receita");

            }
            for(Categoria c: listaCategoria){
                cbCategoria.addItem(c.getNomeCategoria());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(this, "Erro ao atualizar combo categoria!"+e.getMessage());
        }
    }
    
    protected void atualizarComboConta() {
    try {
        cbContaCartao.removeAllItems();
        cbContaCartao.addItem("<--CONTAS-->");
        listaConta = new ContaDao().getLista("");
        for (Conta c : listaConta) {
            cbContaCartao.addItem(c.getNomeConta());
        }

//        cbContaCartao.addItem("<--CARTÕES-->");
//        listaCartao = new CartaodecreditoDao().getLista("");
//        for (Cartaodecredito c : listaCartao) {
//            cbContaCartao.addItem(c.getNomeCartao());
//        }
    } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(this, "Erro ao atualizar combo Conta!"+e.getMessage());
        }
    }


    protected void preencheCampos(Movimentacao cat) {
        movimentacao = cat;
        
        txData.setDate(movimentacao.getDataMovi());
        txValorDespesa.setText(movimentacao.getValorMovi()+"");
        txDescricao.setText(movimentacao.getDescricaoMovi());
     }

   private Movimentacao getMovimentacaoDespesa() {
    
        movimentacao.setIdContaDestino(null);
        movimentacao.setIdContaDestino(listaConta.get(cbContaCartao.getSelectedIndex()-1));
        movimentacao.setTipoMovi("Despesa");
        movimentacao.setIdCategoria(listaCategoria.get(cbCategoria.getSelectedIndex()-1));
        movimentacao.setValorMovi(Math.abs(Double.parseDouble(txValorDespesa.getText().replace(",", "."))) * -1); 
        movimentacao.setDataMovi(txData.getDate());
        movimentacao.setDescricaoMovi(txDescricao.getText());

        return movimentacao;
    }

    private boolean verificaCampos() {
    boolean verifica = false;
    String msg = "Campos obrigatórios!\n";

    if (txDescricao.getText().trim().equals("") || txDescricao.getText().isEmpty()) {
        verifica = true;
        msg += "Descrição\n";
        txDescricao.requestFocus();
    }

    if (txValorDespesa.getText().trim().equals("") || txValorDespesa.getText().isEmpty()) {
        verifica = true;
        msg += "Valor\n";
        txValorDespesa.requestFocus();
    }
    
    if (txData.getDate() == null) {
        verifica = true;
        msg += "Data\n";
        txData.requestFocus();
    }
    
    if (cbContaCartao.getSelectedIndex() == 0) {
        verifica = true;
        msg += "Conta\n";
        cbContaCartao.requestFocus();
    }

    if (cbCategoria.getSelectedIndex() == 0) {
        verifica = true;
        msg += "Categoria\n";
        cbCategoria.requestFocus();
    }
    
    if (verifica) {
        Msg.erro(this, msg);
    }

    return verifica;
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txValorDespesa = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        txData = new org.jdesktop.swingx.JXDatePicker();
        cbContaCartao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro - Despesa");

        jLabel2.setText("Valor");

        txValorDespesa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txValorDespesa.setText("0,00");
        txValorDespesa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txValorDespesaFocusGained(evt);
            }
        });
        txValorDespesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txValorDespesaMouseClicked(evt);
            }
        });
        txValorDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txValorDespesaActionPerformed(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Despesa");

        jLabel4.setText("Descrição");

        txDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDescricaoActionPerformed(evt);
            }
        });

        jLabel5.setText("Data");

        jLabel6.setText("Conta");

        jLabel7.setText("Categoria");

        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        txData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDataActionPerformed(evt);
            }
        });

        cbContaCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbContaCartaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txDescricao)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(180, 180, 180)
                                .addComponent(jLabel5))
                            .addComponent(jLabel6))
                        .addGap(0, 114, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txValorDespesa)
                            .addComponent(cbContaCartao, 0, 157, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txValorDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbContaCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txValorDespesaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txValorDespesaFocusGained
        txValorDespesa.selectAll();
    }//GEN-LAST:event_txValorDespesaFocusGained

    private void txValorDespesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txValorDespesaMouseClicked
        txValorDespesa.selectAll();
    }//GEN-LAST:event_txValorDespesaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!verificaCampos()) {
//         if (isInserir()) {
                new MovimentacaoDao().inserir(getMovimentacaoDespesa());
                Msg.informacao(this, "Salvo com sucesso!");
//                this.pai.atualizaTabela();
                this.dispose();
//         {
//                new MovimentacaoDao().alterar(getMovimentacaoDespesa());
//                Msg.informacao(this, "Alterado com sucesso!");
////                this.pai.atualizaTabela();
//                this.dispose();
//            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void txValorDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txValorDespesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txValorDespesaActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void txDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDataActionPerformed

    private void cbContaCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbContaCartaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbContaCartaoActionPerformed

    private void txDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDescricaoActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_txDescricaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
}
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastarDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastarDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastarDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastarDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastarDespesa dialog = new TelaCadastarDespesa(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbContaCartao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker txData;
    private javax.swing.JTextField txDescricao;
    private javax.swing.JFormattedTextField txValorDespesa;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the inserir
     */
   

    /**
     * @return the despesa
     */
    public boolean isDespesa() {
        return despesa;
    }

    /**
     * @param despesa the despesa to set
     */
    public void setDespesa(boolean despesa) {
        this.despesa = despesa;
    }

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
