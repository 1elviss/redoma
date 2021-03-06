package view;

//import com.microsoft.sqlserver.jdbc.StringUtils;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.Arquivo;
import util.ConnectionFactory;

public class Tela_Resumo extends javax.swing.JFrame {

    private static List<Object> listacomlistaComTodosSelects;

    public Tela_Resumo() {
        initComponents();
    }

    public Tela_Resumo(List<Object> listacomlistaComTodosSelects) {
        this.listacomlistaComTodosSelects = listacomlistaComTodosSelects;
        initComponents();
    }

    private Tela_Script telaScript;

    public Tela_Script getTelaScript() {
        return telaScript;
    }

    public void setTelaScript(Tela_Script telaScript) {
        this.telaScript = telaScript;
    }

    public static List<Object> getListacomlistaComTodosSelects() {
        return listacomlistaComTodosSelects;
    }

    public static void setListacomlistaComTodosSelects(List<Object> listacomlistaComTodosSelects) {
        Tela_Resumo.listacomlistaComTodosSelects = listacomlistaComTodosSelects;
    }

    public void adicionarTudoNaTelaResumo() {

        List<String> listaTemporaria = BasesDinamicas.resumoOpcoes;    
        //usando o String Builder para formatar a impressao
        int contador = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : listaTemporaria) {
            sb.append(contador + "--> ");
            sb.append(s);//append = acrescentar;
            sb.append("\n");
            contador++;
        }
        //remover os espacos em branco
        String resumoDeTudo = sb.toString().trim();
        jTextPaneDadosSelecionados.setText(resumoDeTudo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        //para zerar as adicoes 
        this.getTelaScript().setListaComTodosSelects(new ArrayList<>());
        jTextPaneDadosSelecionados.setText("");
        //Zerando o resumoOpcoes porque pode ser que mude as opcoes
        BasesDinamicas.resumoOpcoes = new ArrayList<>();
        //adicionando novamente o nome do banco a lista de resumoOpcoes
        BasesDinamicas.resumoOpcoes.add("Nome(s) da Base(s) de Dados: " + getTelaScript().getNomeBanco());
        this.getTelaScript().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtVoltarActionPerformed

    private void jBtConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConcluirActionPerformed
        Arquivo novoArquivo = new Arquivo();
        novoArquivo.criarDiretorio();
        novoArquivo.criarArquivoTxt("Resultado");

        //salvando no arquivo resultado
        int count = 0;
        for (Object object : listacomlistaComTodosSelects) {
            novoArquivo.printWriter(novoArquivo.getArquivo(), listacomlistaComTodosSelects, count);
            count++;
        }
        //fechando a conexao aqui
        ConnectionFactory.close();
        //fechando o programa
        System.exit(0);
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
            java.util.logging.Logger.getLogger(Tela_Resumo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Resumo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Resumo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Resumo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
