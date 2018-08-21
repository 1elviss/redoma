/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.IndicesClustered;

/**
 *
 * @author aldam
 */
public class Tela_Resumo extends javax.swing.JFrame {

    /**
     * Creates new form Tela_Resumo
     */
    public Tela_Resumo() {
        initComponents();
    }
    private Tela_Script telaScript;

    public Tela_Script getTelaScript() {
        return telaScript;
    }

    public void setTelaScript(Tela_Script telaScript) {
        this.telaScript = telaScript;
    }

    public void salvarEmTxt(String select) {
        Path caminho = Paths.get("C:/Users/PC/Desktop/Informações Sobre Indices.txt");
        //e necessario converter o string em bytes
        byte[] textoEmByte = select.getBytes();
        try {
            //gravando os dados no txt
            Files.write(caminho, textoEmByte);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public Connection pegarConexao() {
        return getTelaScript().conection;
    }

    //List<Object> lista ;
    public List<IndicesClustered> selecionarIndicesCusClustereds() {
        String sql = "SELECT distinct\n"
                + "clmns.column_id AS [ID],\n"
                + "clmns.name AS [Name],\n"
                + "ISNULL(baset.name, N'') AS [SystemType],\n"
                + "ik.type_desc\n"
                + "FROM information_schema.tables,\n"
                + "sys.tables AS tbl\n"
                + "INNER JOIN sys.all_columns AS clmns ON clmns.object_id=tbl.object_id\n"
                + "LEFT OUTER JOIN sys.types AS baset ON (baset.user_type_id = clmns.system_type_id and baset.user_type_id = baset.system_type_id) or ((baset.system_type_id = clmns.system_type_id) and (baset.user_type_id = clmns.user_type_id) and (baset.is_user_defined = 0) and (baset.is_assembly_type = 1)) \n"
                + "LEFT OUTER JOIN sys.indexes AS ik ON ik.object_id = clmns.object_id\n"
                + "LEFT OUTER JOIN sys.index_columns AS cik ON cik.index_id = ik.index_id and cik.column_id = clmns.column_id and cik.object_id = clmns.object_id and 0 = cik.is_included_column\n"
                + "WHERE table_type = 'base table' \n"
                + " and ik.type = 1\n"
                + " and baset.name in ('nchar','ntext','nvarchar','sql_variant','text','varbinary','varchar')\n"
                + "ORDER BY\n"
                + "[ID] ASC";

        //abrir conexao;
        Connection minhaConexao = getTelaScript().conection;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<IndicesClustered> listaResultSet = new ArrayList<>();

        try {
            //É preciso percorrer o PreparedStatement
            /*toda a consulta ta denro do do stmt que e a declaracao ja prepada
            (Prepared Stamtement)*/
            //Preparou tudo mas e preciso executar
            stmt = minhaConexao.prepareStatement(sql);
            //retorna um resultset o executeQuery()
            //valores retornados estao em rs
            rs = stmt.executeQuery();//query porque e consulta 
            //para percorrer o resultSet

            while (rs.next()) {//enquanto houver próximo;
                IndicesClustered inp = new IndicesClustered();

                inp.setNomeTabela(rs.getString("nomeTabela"));
                inp.setTipoDedadoVariante(rs.getString("dadosTipoVariantes"));
                inp.setIndecesCustered(rs.getString("indecesCustered"));

                listaResultSet.add(inp);
            }

        } catch (SQLException ex) {
            System.err.println("Erro :" + ex);
        } finally {
            try {
                minhaConexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(Tela_Resumo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaResultSet;
    }

    ///  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanelFuncao = new javax.swing.JPanel();
        jBtVoltar = new javax.swing.JButton();
        jBtConcluir = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtAjuda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneDadosSelecionados = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Resumo");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções Selecionadas"));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        jScrollBar1.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        jPanelFuncao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBtVoltar.setText("<< Voltar ");
        jBtVoltar.setPreferredSize(new java.awt.Dimension(100, 30));
        jBtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtVoltarActionPerformed(evt);
            }
        });
        jPanelFuncao.add(jBtVoltar);

        jBtConcluir.setText("Concluir");
        jBtConcluir.setPreferredSize(new java.awt.Dimension(100, 30));
        jBtConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConcluirActionPerformed(evt);
            }
        });
        jPanelFuncao.add(jBtConcluir);

        jBtCancelar.setText("Cancelar");
        jBtCancelar.setPreferredSize(new java.awt.Dimension(100, 30));
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });
        jPanelFuncao.add(jBtCancelar);

        jBtAjuda.setText("Ajuda");
        jBtAjuda.setPreferredSize(new java.awt.Dimension(100, 30));
        jBtAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAjudaActionPerformed(evt);
            }
        });
        jPanelFuncao.add(jBtAjuda);

        jTextPaneDadosSelecionados.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(jTextPaneDadosSelecionados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanelFuncao, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtVoltarActionPerformed
        this.getTelaScript().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtVoltarActionPerformed

    private void jBtConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConcluirActionPerformed

        salvarEmTxt("Aqui o texto que vai ser salvo, no caso o select");
    }//GEN-LAST:event_jBtConcluirActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja Realmente Sair ?");
        if (resposta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAjudaActionPerformed


    }//GEN-LAST:event_jBtAjudaActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Resumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Resumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Resumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Resumo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Resumo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAjuda;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtConcluir;
    private javax.swing.JButton jBtVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFuncao;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPaneDadosSelecionados;
    // End of variables declaration//GEN-END:variables
}
