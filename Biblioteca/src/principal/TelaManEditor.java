package principal;
import biblioteca.Editor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class TelaManEditor extends javax.swing.JFrame {
    private Connection conexaoBanco;
    private int codigoPesquisado;
    
    public TelaManEditor() {
        initComponents();
        personalizacoes();
    }
    
    public TelaManEditor(Connection c) {
        this.conexaoBanco = c;
        initComponents();
        personalizacoes();
    }
    
    private void personalizacoes(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("book.png")));
        this.setSize(491, 320);
        this.setResizable(false);
        //Centralizar no meio da Tela, independente da resolucao e tamanho do monitor
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelTopo = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        PainelConteudo = new javax.swing.JPanel();
        LabelCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        LabelResultadoPesquisa = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        LabelNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSalvarAlteracoes = new javax.swing.JButton();
        btnExcluirEditor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGB - Manutenção de Editor");
        getContentPane().setLayout(null);

        PainelTopo.setBackground(new java.awt.Color(51, 102, 255));
        PainelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelTopo.setLayout(null);

        LabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Manutenção de Editor");
        PainelTopo.add(LabelTitulo);
        LabelTitulo.setBounds(160, 20, 198, 22);

        getContentPane().add(PainelTopo);
        PainelTopo.setBounds(0, 0, 491, 70);

        PainelConteudo.setBackground(new java.awt.Color(204, 204, 204));
        PainelConteudo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelConteudo.setLayout(null);

        LabelCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        LabelCodigo.setText("Informe o Código:");
        PainelConteudo.add(LabelCodigo);
        LabelCodigo.setBounds(59, 28, 112, 15);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        PainelConteudo.add(txtCodigo);
        txtCodigo.setBounds(197, 26, 150, 20);

        btnPesquisar.setBackground(new java.awt.Color(51, 153, 255));
        btnPesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        PainelConteudo.add(btnPesquisar);
        btnPesquisar.setBounds(362, 24, 100, 23);

        LabelResultadoPesquisa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelResultadoPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        LabelResultadoPesquisa.setText("Resultado da Pesquisa:");
        PainelConteudo.add(LabelResultadoPesquisa);
        LabelResultadoPesquisa.setBounds(175, 75, 142, 15);
        PainelConteudo.add(jSeparator2);
        jSeparator2.setBounds(0, 96, 491, 10);

        LabelNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelNome.setForeground(new java.awt.Color(255, 255, 255));
        LabelNome.setText("Nome:");
        PainelConteudo.add(LabelNome);
        LabelNome.setBounds(59, 126, 38, 15);

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        PainelConteudo.add(txtNome);
        txtNome.setBounds(115, 124, 348, 20);

        btnSalvarAlteracoes.setBackground(new java.awt.Color(51, 153, 255));
        btnSalvarAlteracoes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalvarAlteracoes.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarAlteracoes.setText("Alterar");
        btnSalvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracoesActionPerformed(evt);
            }
        });
        PainelConteudo.add(btnSalvarAlteracoes);
        btnSalvarAlteracoes.setBounds(143, 177, 100, 23);

        btnExcluirEditor.setBackground(new java.awt.Color(51, 153, 255));
        btnExcluirEditor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcluirEditor.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirEditor.setText("Excluir");
        btnExcluirEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirEditorActionPerformed(evt);
            }
        });
        PainelConteudo.add(btnExcluirEditor);
        btnExcluirEditor.setBounds(291, 177, 100, 23);

        getContentPane().add(PainelConteudo);
        PainelConteudo.setBounds(0, 70, 491, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try{
            if(txtCodigo.getText().equals("")){
                throw new Exception("Favor informar o código do Editor que deseja pesquisar!");
            } else{
                codigoPesquisado = Integer.parseInt(txtCodigo.getText());
                Editor editorPesquisado = new Editor();
                editorPesquisado = editorPesquisado.consultaUmEditor(conexaoBanco, codigoPesquisado);
                txtNome.setText(editorPesquisado.getNome());
                txtCodigo.setText("");
            }
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(null, ee.getMessage(), "Editor", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnSalvarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracoesActionPerformed
        Object[] opcao = {"Sim", "Não"};
        int n = JOptionPane.showOptionDialog(null,
            "Deseja salvar as Alterações feitas?",
            null,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null, //referente ao icone
            opcao, //op�oes
            opcao[0]); //bot�o padr�o

        if (n == JOptionPane.YES_OPTION) {
            try {
                if (txtNome.getText().equals("")) {
                    throw new Exception("Existe campo sem preenchimento!");
                } else {
                    Editor editor = new Editor(codigoPesquisado, txtNome.getText());
                    boolean ok = editor.altera(conexaoBanco);
                    if (!ok) {
                        throw new Exception("Erro na alteração do Editor");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Editor Alterado com Sucesso!");
                    }
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee.getMessage(), "Editor", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSalvarAlteracoesActionPerformed

    private void btnExcluirEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirEditorActionPerformed
        Object[] opcao = {"Sim", "Não"};
        int n = JOptionPane.showOptionDialog(null,
            "Deseja excluir esse Editor?",
            null,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE,
            null,
            opcao,
            opcao[0]);

        if (n == JOptionPane.YES_OPTION) {
            try {
                if (txtNome.getText().equals(""))
                {
                    throw new Exception("Existe campo sem preenchimento!");
                } else {
                    Editor editor = new Editor(codigoPesquisado, txtNome.getText());
                    boolean Ok = editor.exclui(conexaoBanco, codigoPesquisado);
                    if (!Ok) {
                        throw new Exception("Erro na exclusão do Editor");
                    } else {
                        JOptionPane.showMessageDialog(null, "Editor Excluído com Sucesso!");
                        codigoPesquisado = 0;
                        txtCodigo.setText("");
                        txtNome.setText("");
                    }
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee.getMessage(), "Editor", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirEditorActionPerformed

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
            java.util.logging.Logger.getLogger(TelaManEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaManEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaManEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaManEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaManEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCodigo;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelResultadoPesquisa;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel PainelConteudo;
    private javax.swing.JPanel PainelTopo;
    private javax.swing.JButton btnExcluirEditor;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvarAlteracoes;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
