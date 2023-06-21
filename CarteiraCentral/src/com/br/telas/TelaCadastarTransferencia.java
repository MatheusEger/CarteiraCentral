/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.telas;

import com.br.dao.CategoriaDao;
import com.br.dao.ContaDao;
import com.br.dao.MovimentacaoDao;
import com.br.entidades.Categoria;
import com.br.entidades.Conta;
import com.br.entidades.Movimentacao;
import com.br.utils.Msg;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author PC-Eger
 */
public class TelaCadastarTransferencia extends javax.swing.JDialog {

    private boolean inserir;
    private boolean despesa;
    private Movimentacao movimentacao;
    private TelaMovimentacao pai;
    private double valorTransferencia;
    private List<Categoria> listaCategoria = new ArrayList<>();
    private List<Conta> listaConta = new ArrayList<>();
    private List<Conta> listaCompletaConta;    

    public TelaCadastarTransferencia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        movimentacao = new Movimentacao();
        atualizaCombo();
        atualizarComboConta();;

    }

    public TelaCadastarTransferencia(TelaMovimentacao parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pai = parent;
        movimentacao = new Movimentacao();
        atualizaCombo();
        atualizarComboConta();
    }
    
    // Obtém o valor selecionado em cbSaiuConta

    
    protected  void atualizaCombo(){
        try {
            cbCategoria.removeAllItems();
            cbCategoria.addItem("<selecione>");
           
            listaCategoria = new CategoriaDao().getListaFiltro("Transferencia");
            
            for (Categoria c: listaCategoria) {
                cbCategoria.addItem(c.getNomeCategoria());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(this, "Erro ao atualizar combo categoria!"+e.getMessage());
        }
    }
    
    protected void atualizarComboConta() {
    try {
        cbEntrouConta.removeAllItems();
        cbEntrouConta.addItem("<--CONTAS-->");
        cbSaiuConta.removeAllItems();
        cbSaiuConta.addItem("<--CONTAS-->");

        listaConta = new ContaDao().getLista("");
        
        for (Conta c : listaConta) {
            cbSaiuConta.addItem(c.getNomeConta());
        }
        
        for (Conta c : listaConta) {
            cbEntrouConta.addItem(c.getNomeConta());
        }


    } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(this, "Erro ao atualizar combo Conta!"+e.getMessage());
        }
    }
    
    protected void preencheCampos(Movimentacao cat) {
        movimentacao = cat;
        txData.setDate(movimentacao.getDataMovi());
        txValorTransferencia.setText(movimentacao.getValorMovi()+"");
        txDescricao.setText(movimentacao.getDescricaoMovi());
     }
    
    protected void preencheCamposTransferencia(Movimentacao cat) {
        movimentacao = cat;
        txData.setDate(movimentacao.getDataMovi());
        txValorTransferencia.setText(movimentacao.getValorMovi()+"");
        txDescricao.setText(movimentacao.getDescricaoMovi());
     }

   

    private boolean verificaCampos() {
    boolean verifica = false;
    String msg = "Campos obrigatórios!\n";

    if (txValorTransferencia.getText().trim().equals("") || txValorTransferencia.getText().isEmpty()) {
    verifica = true;
    msg += "Valor\n";
    txValorTransferencia.requestFocus();
    } else {
        valorTransferencia = Double.parseDouble(txValorTransferencia.getText().replace(",", "."));
    }

    if (txValorTransferencia.getText().trim().equals("") || txValorTransferencia.getText().isEmpty()) {
        verifica = true;
        msg += "Valor\n";
        txValorTransferencia.requestFocus();
    }
    
    if (txData.getDate() == null) {
        verifica = true;
        msg += "Data\n";
        txData.requestFocus();
    }
    
    if (cbCategoria.getSelectedIndex() == 0) {
        verifica = true;
        msg += "Categoria\n";
        cbCategoria.requestFocus();
    }
    
    if (cbSaiuConta.getSelectedIndex() == 0) {
        verifica = true;
        msg += "Conta de origem\n";
        cbSaiuConta.requestFocus();
    }
    
    if (cbEntrouConta.getSelectedIndex() == 0) {
        verifica = true;
        msg += "Conta de destino\n";
        cbEntrouConta.requestFocus();
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
        txValorTransferencia = new javax.swing.JFormattedTextField();
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
        cbEntrouConta = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbSaiuConta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro - Despesa");

        jLabel2.setText("Valor");

        txValorTransferencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txValorTransferencia.setText("0,00");
        txValorTransferencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txValorTransferenciaFocusGained(evt);
            }
        });
        txValorTransferencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txValorTransferenciaMouseClicked(evt);
            }
        });
        txValorTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txValorTransferenciaActionPerformed(evt);
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
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Transfêrencia");

        jLabel4.setText("Descrição");

        txDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDescricaoActionPerformed(evt);
            }
        });

        jLabel5.setText("Data");

        jLabel6.setText("Saiu da conta");

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

        cbEntrouConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEntrouContaActionPerformed(evt);
            }
        });

        jLabel8.setText("Entrou na conta");

        cbSaiuConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSaiuContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txDescricao)
                                .addComponent(txValorTransferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txData, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSaiuConta, 0, 157, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(cbEntrouConta, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEntrouConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSaiuConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txValorTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txData, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txValorTransferenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txValorTransferenciaFocusGained
        txValorTransferencia.selectAll();
    }//GEN-LAST:event_txValorTransferenciaFocusGained

    private void txValorTransferenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txValorTransferenciaMouseClicked
        txValorTransferencia.selectAll();
    }//GEN-LAST:event_txValorTransferenciaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public Movimentacao getMovimentacaoOrigem() {
    Movimentacao movimentacao = new Movimentacao();
        movimentacao.setIdContaOrigem(listaConta.get(cbSaiuConta.getSelectedIndex()-1));
        movimentacao.setIdContaDestino(listaConta.get(cbEntrouConta.getSelectedIndex()-1));
        movimentacao.setTipoMovi("Transferencia");
        movimentacao.setIdCategoria(listaCategoria.get(cbCategoria.getSelectedIndex()-1));
        movimentacao.setValorMovi(Math.abs(Double.parseDouble(txValorTransferencia.getText().replace(",", ".")))); 
        movimentacao.setDataMovi(txData.getDate());
        movimentacao.setDescricaoMovi(txDescricao.getText());
    return movimentacao;
    
    }
   public Movimentacao getMovimentacaoDestino() {
    Movimentacao movimentacao = new Movimentacao();
        movimentacao.setIdContaOrigem(listaConta.get(cbEntrouConta.getSelectedIndex()-1));
        movimentacao.setIdContaDestino(listaConta.get(cbSaiuConta.getSelectedIndex()-1));
        movimentacao.setTipoMovi("Transferencia");
        movimentacao.setIdCategoria(listaCategoria.get(cbCategoria.getSelectedIndex()-1));
        movimentacao.setValorMovi(Double.parseDouble(txValorTransferencia.getText().replace(",", "."))* -1);
        movimentacao.setDataMovi(txData.getDate());
        movimentacao.setDescricaoMovi(txDescricao.getText());
    return movimentacao;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if (!verificaCampos()) {
         
        new MovimentacaoDao().inserir(getMovimentacaoOrigem());
        new MovimentacaoDao().inserir(getMovimentacaoDestino());

        Msg.informacao(this, "Salvo com sucesso!");
            this.dispose();
        } else {
            Msg.erro(this, "!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txValorTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txValorTransferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txValorTransferenciaActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void txDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDataActionPerformed

    private void cbEntrouContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEntrouContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEntrouContaActionPerformed

    private void txDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDescricaoActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_txDescricaoActionPerformed

    private void cbSaiuContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSaiuContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSaiuContaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastarTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastarTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);


        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastarTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);


        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastarTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastarTransferencia dialog = new TelaCadastarTransferencia(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbEntrouConta;
    private javax.swing.JComboBox<String> cbSaiuConta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker txData;
    private javax.swing.JTextField txDescricao;
    private javax.swing.JFormattedTextField txValorTransferencia;
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
