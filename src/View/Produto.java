/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.*;
import View.*;
import Controller.ClienteB;
import Controller.ClienteB.Limpar;
import Controller.ClienteB;
import Controller.ProdutoB;
import Model.ClienteA;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Produto extends javax.swing.JFrame {

    /**
     * Creates new form Tela
     */
   public void Listar(){
    ProdutoB dao = new ProdutoB();
    List<ProdutoA>lista = dao.listar();
    DefaultTableModel dados = (DefaultTableModel) tabela_produto.getModel();
    dados.setNumRows(0);
    for(ProdutoA u : lista ){
    dados.addRow(new Object[]{
    u.getIdproduto(),
    u.getNome(),
    u.getDescricao(),
    u.getCategoria(),
    u.getPreco(),
    u.getQuantidade(),
    
  });
    }
    }  
public Produto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        txt_categoria = new javax.swing.JTextField();
        btn_pesquisar = new javax.swing.JButton();
        btn_novo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_ver = new javax.swing.JButton();
        btn_atualizar = new javax.swing.JButton();
        btn_remover = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_preco = new javax.swing.JTextField();
        txt_quantidade = new javax.swing.JTextField();
        txt_descricao = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_produto = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 255, 0));

        jLabel1.setBackground(new java.awt.Color(153, 0, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUTO");

        btn_voltar.setBackground(new java.awt.Color(102, 102, 102));
        btn_voltar.setText("VOLTAR");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_voltar))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
                .addGap(110, 110, 110))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btn_voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("CÓDIGO:");

        jLabel3.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("NOME:");

        jLabel5.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("CATEGORIA");

        txt_codigo.setEditable(false);

        txt_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_categoriaActionPerformed(evt);
            }
        });

        btn_pesquisar.setBackground(new java.awt.Color(0, 255, 0));
        btn_pesquisar.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btn_pesquisar.setText("PESQUISAR");
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });

        btn_novo.setBackground(new java.awt.Color(0, 255, 51));
        btn_novo.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btn_novo.setText("NOVO");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_guardar.setBackground(new java.awt.Color(0, 255, 51));
        btn_guardar.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btn_guardar.setText("GUARDAR");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_ver.setBackground(new java.awt.Color(0, 255, 51));
        btn_ver.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btn_ver.setText("VER");
        btn_ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verActionPerformed(evt);
            }
        });

        btn_atualizar.setBackground(new java.awt.Color(0, 255, 51));
        btn_atualizar.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btn_atualizar.setText("ATUALIZAR");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });

        btn_remover.setBackground(new java.awt.Color(0, 255, 51));
        btn_remover.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btn_remover.setText("REMOVER");
        btn_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel6.setText("DESCRIÇÃO");

        jLabel7.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel7.setText("PREÇO");

        jLabel8.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel8.setText("QTD.ESTOQUE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(txt_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_pesquisar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_quantidade)))
                        .addGap(141, 141, 141))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(btn_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btn_atualizar)
                        .addGap(38, 38, 38)
                        .addComponent(btn_remover)
                        .addContainerGap(80, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_pesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_novo)
                    .addComponent(btn_guardar)
                    .addComponent(btn_ver)
                    .addComponent(btn_atualizar)
                    .addComponent(btn_remover))
                .addContainerGap())
        );

        tabela_produto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabela_produto.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        tabela_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME", "DESCRIÇÃO", "CATEGORIA", "PREÇO", "QUANTIDADE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_produtoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabela_produto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(827, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
        // TODO add your handling code here:
        ProdutoA obj = new ProdutoA(); 
         obj.setIdproduto(Integer.valueOf(txt_codigo.getText()));
         ProdutoB produtob= new ProdutoB();
         produtob.Remover(obj);
         ProdutoB.Limpar limp = produtob.new Limpar();
        limp.LimparTela(jPanel2);
    
    }//GEN-LAST:event_btn_removerActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
     ProdutoA obj = new ProdutoA(); 
   obj.setNome(txt_nome.getText());
   obj.setDescricao(txt_descricao.getText());
   obj.setCategoria(txt_categoria.getText());
   obj.setPreco(txt_preco.getText());
   obj.setQuantidade(txt_quantidade.getText());
   
   ProdutoB dao = new ProdutoB();
   dao.Guardar(obj);
   ProdutoB produtob = new ProdutoB();
       ProdutoB.Limpar limp = produtob.new Limpar();
        limp.LimparTela(jPanel2);

    }//GEN-LAST:event_btn_guardarActionPerformed
 
    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        // TODO add your handling code here:
       String nome =txt_nome.getText();
        ProdutoA obj = new ProdutoA();
        ProdutoB dao = new ProdutoB();

        if (dao == null) {
            dao = new ProdutoB();
        }
        obj = dao.Pesquisa(nome);
        
        if(obj.getNome()!=null && !nome.trim().isEmpty()){

            txt_codigo.setText(String.valueOf(obj.getIdproduto()));
            txt_nome.setText(obj.getNome());
            txt_descricao.setText(obj.getDescricao());
            txt_categoria.setText(obj.getCategoria());
            txt_preco.setText(obj.getPreco());
            txt_quantidade.setText(obj.getQuantidade());
            

        }else{
            JOptionPane.showMessageDialog(null,"Produto não encontrado");
            JOptionPane.showMessageDialog(null, "Por favor, insira um nome para pesquisar");
        }
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        // TODO add your handling code here:
         ProdutoB cadastro = new ProdutoB();
        ProdutoB.Limpar limp = cadastro.new Limpar();
        limp.LimparTela(jPanel2);


    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verActionPerformed
        // TODO add your handling code here:
        try{
        
        Listar(); 
        }catch (Exception e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,"Erro ao ver a listar de dados:"+ e.getMessage()); 
        }
       
    }//GEN-LAST:event_btn_verActionPerformed

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        // TODO add your handling code here:
       ProdutoA obj = new  ProdutoA(); 
   obj.setNome(txt_nome.getText());
   obj.setDescricao(txt_descricao.getText());
   obj.setCategoria(txt_categoria.getText());
   obj.setPreco(txt_preco.getText());
   obj.setQuantidade(txt_quantidade.getText());
   obj.setIdproduto(Integer.valueOf(txt_codigo.getText()));
   
    ProdutoB dao = new  ProdutoB();
   dao.Atualizar(obj);
    ProdutoB produtob= new  ProdutoB();
         ProdutoB.Limpar limp =  produtob.new Limpar();
        limp.LimparTela(jPanel2);
   
    }//GEN-LAST:event_btn_atualizarActionPerformed

    private void tabela_produtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_produtoMouseClicked
        // TODO add your handling code here:
        
        int selecttedRow = tabela_produto.getSelectedRow();
        btn_atualizar.setEnabled(true);
        btn_remover.setEnabled(true);
        
        if(selecttedRow != -1){
        String codigo = tabela_produto.getValueAt(selecttedRow, 0).toString();
        String nome = tabela_produto.getValueAt(selecttedRow, 1).toString();
        String descricao = tabela_produto.getValueAt(selecttedRow, 2).toString();
        String categoria = tabela_produto.getValueAt(selecttedRow, 3).toString();
      String preco = tabela_produto.getValueAt(selecttedRow, 4).toString();
        String quantidade = tabela_produto.getValueAt(selecttedRow, 5).toString();
        
        txt_nome.setText(nome);
        txt_codigo.setText(codigo);
        txt_descricao.setText(descricao);
        txt_categoria.setText(categoria);
        txt_preco.setText(preco);
        txt_quantidade.setText(quantidade);
        
        
        }
     //  btn_guardar.setEnabled(false); 
    }//GEN-LAST:event_tabela_produtoMouseClicked

    private void txt_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_categoriaActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        // TODO add your handling code here:
        TelaPrincipal c = new TelaPrincipal();
        c.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

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
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_pesquisar;
    private javax.swing.JButton btn_remover;
    private javax.swing.JButton btn_ver;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabela_produto;
    private javax.swing.JTextField txt_categoria;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_preco;
    private javax.swing.JTextField txt_quantidade;
    // End of variables declaration//GEN-END:variables

    
}
