package principal;
import biblioteca.Autor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class TelaManAutor extends javax.swing.JFrame {
    private Connection conexaoBanco;
    private int codigoPesquisado;
    
    public TelaManAutor() {
        initComponents();
        personalizacoes();
    }
    
    public TelaManAutor(Connection c) {
        this.conexaoBanco = c;
        initComponents();
        personalizacoes();
    }
    
    private void personalizacoes(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("book.png")));
        this.setSize(481, 396);
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
        jPanelConteudo = new javax.swing.JPanel();
        LabelCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        LabelResultadoPesquisa = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        LabelCodigoAutor = new javax.swing.JLabel();
        txtCodigoAutor = new javax.swing.JTextField();
        LabelNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        LabelSobrenome = new javax.swing.JLabel();
        txtSobrenome = new javax.swing.JTextField();
        btnSalvarAlteracoes = new javax.swing.JButton();
        btnExcluirAutor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGB - Manutenção de Autor");
        getContentPane().setLayout(null);

        PainelTopo.setBackground(new java.awt.Color(51, 102, 255));
        PainelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelTopo.setLayout(null);

        LabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Manutenção de Autor");
        PainelTopo.add(LabelTitulo);
        LabelTitulo.setBounds(140, 20, 195, 22);

        getContentPane().add(PainelTopo);
        PainelTopo.setBounds(0, 0, 481, 67);

        jPanelConteudo.setBackground(new java.awt.Color(204, 204, 204));
        jPanelConteudo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelConteudo.setLayout(null);

        LabelCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelCodigo.setForeground(new java.awt.Color(255, 255, 255));
        LabelCodigo.setText("Informe o Código:");
        jPanelConteudo.add(LabelCodigo);
        LabelCodigo.setBounds(42, 28, 112, 15);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanelConteudo.add(txtCodigo);
        txtCodigo.setBounds(180, 26, 157, 20);

        btnPesquisar.setBackground(new java.awt.Color(248, 148, 6));
        btnPesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jPanelConteudo.add(btnPesquisar);
        btnPesquisar.setBounds(355, 24, 100, 23);

        LabelResultadoPesquisa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelResultadoPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        LabelResultadoPesquisa.setText("Resultado da Pesquisa:");
        jPanelConteudo.add(LabelResultadoPesquisa);
        LabelResultadoPesquisa.setBounds(166, 75, 142, 15);
        jPanelConteudo.add(jSeparator2);
        jSeparator2.setBounds(0, 96, 481, 10);

        LabelCodigoAutor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelCodigoAutor.setForeground(new java.awt.Color(255, 255, 255));
        LabelCodigoAutor.setText("Código do Autor:");
        jPanelConteudo.add(LabelCodigoAutor);
        LabelCodigoAutor.setBounds(134, 124, 107, 15);

        txtCodigoAutor.setEnabled(false);
        txtCodigoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoAutorActionPerformed(evt);
            }
        });
        jPanelConteudo.add(txtCodigoAutor);
        txtCodigoAutor.setBounds(302, 124, 103, 20);

        LabelNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelNome.setForeground(new java.awt.Color(255, 255, 255));
        LabelNome.setText("Nome:");
        jPanelConteudo.add(LabelNome);
        LabelNome.setBounds(42, 171, 38, 15);

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanelConteudo.add(txtNome);
        txtNome.setBounds(134, 166, 320, 20);

        LabelSobrenome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelSobrenome.setForeground(new java.awt.Color(255, 255, 255));
        LabelSobrenome.setText("Sobrenome:");
        jPanelConteudo.add(LabelSobrenome);
        LabelSobrenome.setBounds(42, 213, 74, 15);

        txtSobrenome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSobrenomeActionPerformed(evt);
            }
        });
        jPanelConteudo.add(txtSobrenome);
        txtSobrenome.setBounds(134, 208, 312, 20);

        btnSalvarAlteracoes.setBackground(new java.awt.Color(248, 148, 6));
        btnSalvarAlteracoes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalvarAlteracoes.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarAlteracoes.setText("Alterar");
        btnSalvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracoesActionPerformed(evt);
            }
        });
        jPanelConteudo.add(btnSalvarAlteracoes);
        btnSalvarAlteracoes.setBounds(160, 260, 80, 23);

        btnExcluirAutor.setBackground(new java.awt.Color(248, 148, 6));
        btnExcluirAutor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcluirAutor.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirAutor.setText("Excluir");
        btnExcluirAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAutorActionPerformed(evt);
            }
        });
        jPanelConteudo.add(btnExcluirAutor);
        btnExcluirAutor.setBounds(270, 260, 80, 23);

        getContentPane().add(jPanelConteudo);
        jPanelConteudo.setBounds(0, 70, 481, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtSobrenomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSobrenomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSobrenomeActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try{
            if(txtCodigo.getText().equals("")){
                throw new Exception("Favor informar o código do Autor que deseja pesquisar!");
            } else{
                codigoPesquisado = Integer.parseInt(txtCodigo.getText());
                Autor autorPesquisado = new Autor();
                autorPesquisado = autorPesquisado.consultaUmAutor(conexaoBanco, codigoPesquisado);
                txtCodigoAutor.setText(String.valueOf(autorPesquisado.getCodigo()));
                txtNome.setText(autorPesquisado.getNome());
                txtSobrenome.setText(autorPesquisado.getSobrenome());
                txtCodigo.setText("");
            }
        } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee.getMessage(), "Autor", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAutorActionPerformed
        Object[] opcao = {"Sim", "Não"};
        int n = JOptionPane.showOptionDialog(null,
                "Deseja excluir esse Autor?",
                null,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE,
                null,
                opcao,
                opcao[0]);

        if (n == JOptionPane.YES_OPTION) {
            try {
                if (txtNome.getText().equals("") || txtSobrenome.getText().equals(""))
                {
                    throw new Exception("Existe campo sem preenchimento!");
                } else {
                    Autor autor = new Autor(codigoPesquisado, txtNome.getText(), txtSobrenome.getText());
                    boolean Ok = autor.exclui(conexaoBanco, codigoPesquisado);
                    if (!Ok) {
                        throw new Exception("Erro na exclusão do Autor");
                    } else {
                        JOptionPane.showMessageDialog(null, "Autor Excluído com Sucesso!");
                        codigoPesquisado = 0;
                        txtCodigo.setText("");
                        txtNome.setText("");
                        txtSobrenome.setText("");
                    }
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee.getMessage(), "Autor", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirAutorActionPerformed

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
                if (txtNome.getText().equals("") || txtSobrenome.getText().equals("")) {
                    throw new Exception("Existe campo sem preenchimento!");
                } else {
                    Autor autor = new Autor(codigoPesquisado, txtNome.getText(), txtSobrenome.getText());                   
                    boolean ok = autor.altera(conexaoBanco);
                    if (!ok) {
                        throw new Exception("Erro na alteração do Autor");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Autor Alterado com Sucesso!");
                    }
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee.getMessage(), "Autor", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSalvarAlteracoesActionPerformed

    private void txtCodigoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoAutorActionPerformed

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
            java.util.logging.Logger.getLogger(TelaManAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaManAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaManAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaManAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaManAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCodigo;
    private javax.swing.JLabel LabelCodigoAutor;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelResultadoPesquisa;
    private javax.swing.JLabel LabelSobrenome;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel PainelTopo;
    private javax.swing.JButton btnExcluirAutor;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvarAlteracoes;
    private javax.swing.JPanel jPanelConteudo;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoAutor;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSobrenome;
    // End of variables declaration//GEN-END:variables
}
