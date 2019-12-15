package principal;
import biblioteca.Assunto;
import biblioteca.Autor;
import biblioteca.Editor;
import biblioteca.Livro;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class TelaManLivro extends javax.swing.JFrame {
    private Connection conexaoBanco;
    private int codigoPesquisado;
    private Livro livroAtualizado;
    List<String> listaAutoresAtuaisSelecionados;
    
    public TelaManLivro() {
        initComponents();
        personalizacoes();
        popularComboBoxAutores();
    }
    
    public TelaManLivro(Connection c) {
        this.conexaoBanco = c;
        initComponents();
        personalizacoes();
        popularComboBoxAutores();
    }
    
    private void personalizacoes(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("book.png")));
        this.setSize(481, 635);
        this.setResizable(false);
        //Centralizar no meio da Tela, independente da resolucao e tamanho do monitor
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    private void popularComboBoxAutores(){
        ArrayList<Editor> listaEditores = Editor.consultaListaEditores(conexaoBanco);
        ArrayList<Assunto> listaAssunto = Assunto.consultaListaAssuntos(conexaoBanco);
        ArrayList<Autor> listaTodosOsAutores = Autor.consultaListaAutores(conexaoBanco);
        
        for (Editor _editor : listaEditores) {
            cbxEditor.addItem(_editor.getNome() + " - Codigo: '" + _editor.getCodigo() + "'");
        }
        
        for (Assunto _assunto: listaAssunto) {
            cbxAssunto.addItem(_assunto.getAssunto() + " - Codigo: '" + _assunto.getCodigo() + "'");
        }

        DefaultListModel<String> model = new DefaultListModel<String>();
        for (Autor _autor : listaTodosOsAutores) {
            model.addElement(_autor.getNome() + " " + _autor.getSobrenome() + " - Codigo: '" + _autor.getCodigo() + "'");
        }  
        jlstAutoresNovos.setModel(model);
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
        LabelCodigoLivro = new javax.swing.JLabel();
        txtCodigoLivro = new javax.swing.JTextField();
        LabeTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        LabelEditor = new javax.swing.JLabel();
        cbxEditor = new javax.swing.JComboBox<>();
        LabelAssunto = new javax.swing.JLabel();
        cbxAssunto = new javax.swing.JComboBox<>();
        LabelAutorAtual = new javax.swing.JLabel();
        LabelAtual = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlstAutoresAtuais = new javax.swing.JList<>();
        btnSalvarAlteracoes = new javax.swing.JButton();
        btnExcluirLivro = new javax.swing.JButton();
        LabelAutorNovo = new javax.swing.JLabel();
        LabelNovo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlstAutoresNovos = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGB - Manutenção de Livro");
        getContentPane().setLayout(null);

        PainelTopo.setBackground(new java.awt.Color(51, 102, 255));
        PainelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelTopo.setLayout(null);

        LabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Manutenção de Livro");
        PainelTopo.add(LabelTitulo);
        LabelTitulo.setBounds(150, 20, 189, 22);

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

        btnPesquisar.setBackground(new java.awt.Color(51, 153, 255));
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

        LabelCodigoLivro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelCodigoLivro.setForeground(new java.awt.Color(255, 255, 255));
        LabelCodigoLivro.setText("Código do Livro:");
        jPanelConteudo.add(LabelCodigoLivro);
        LabelCodigoLivro.setBounds(134, 124, 101, 15);

        txtCodigoLivro.setEnabled(false);
        txtCodigoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoLivroActionPerformed(evt);
            }
        });
        jPanelConteudo.add(txtCodigoLivro);
        txtCodigoLivro.setBounds(302, 124, 103, 20);

        LabeTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabeTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabeTitulo.setText("Título:");
        jPanelConteudo.add(LabeTitulo);
        LabeTitulo.setBounds(42, 171, 50, 15);

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });
        jPanelConteudo.add(txtTitulo);
        txtTitulo.setBounds(100, 170, 320, 20);

        LabelEditor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelEditor.setForeground(new java.awt.Color(255, 255, 255));
        LabelEditor.setText("Editor:");
        jPanelConteudo.add(LabelEditor);
        LabelEditor.setBounds(40, 210, 50, 20);

        cbxEditor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Editor" }));
        jPanelConteudo.add(cbxEditor);
        cbxEditor.setBounds(100, 210, 320, 20);

        LabelAssunto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelAssunto.setForeground(new java.awt.Color(255, 255, 255));
        LabelAssunto.setText("Assunto:");
        jPanelConteudo.add(LabelAssunto);
        LabelAssunto.setBounds(40, 250, 50, 20);

        cbxAssunto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Assunto" }));
        jPanelConteudo.add(cbxAssunto);
        cbxAssunto.setBounds(100, 250, 320, 20);

        LabelAutorAtual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelAutorAtual.setForeground(new java.awt.Color(255, 255, 255));
        LabelAutorAtual.setText("Autores");
        jPanelConteudo.add(LabelAutorAtual);
        LabelAutorAtual.setBounds(40, 290, 50, 20);

        LabelAtual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelAtual.setForeground(new java.awt.Color(255, 255, 255));
        LabelAtual.setText("Atuais:");
        jPanelConteudo.add(LabelAtual);
        LabelAtual.setBounds(40, 300, 50, 20);

        jlstAutoresAtuais.setEnabled(false);
        jScrollPane1.setViewportView(jlstAutoresAtuais);

        jPanelConteudo.add(jScrollPane1);
        jScrollPane1.setBounds(100, 290, 320, 50);

        btnSalvarAlteracoes.setBackground(new java.awt.Color(51, 153, 255));
        btnSalvarAlteracoes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalvarAlteracoes.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarAlteracoes.setText("Alterar");
        btnSalvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracoesActionPerformed(evt);
            }
        });
        jPanelConteudo.add(btnSalvarAlteracoes);
        btnSalvarAlteracoes.setBounds(150, 500, 80, 23);

        btnExcluirLivro.setBackground(new java.awt.Color(51, 153, 255));
        btnExcluirLivro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExcluirLivro.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirLivro.setText("Excluir");
        btnExcluirLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirLivroActionPerformed(evt);
            }
        });
        jPanelConteudo.add(btnExcluirLivro);
        btnExcluirLivro.setBounds(250, 500, 80, 23);

        LabelAutorNovo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelAutorNovo.setForeground(new java.awt.Color(255, 255, 255));
        LabelAutorNovo.setText("Autores");
        jPanelConteudo.add(LabelAutorNovo);
        LabelAutorNovo.setBounds(40, 360, 50, 20);

        LabelNovo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelNovo.setForeground(new java.awt.Color(255, 255, 255));
        LabelNovo.setText("Novos:");
        jPanelConteudo.add(LabelNovo);
        LabelNovo.setBounds(40, 370, 50, 20);

        jScrollPane2.setViewportView(jlstAutoresNovos);

        jPanelConteudo.add(jScrollPane2);
        jScrollPane2.setBounds(100, 360, 320, 120);

        getContentPane().add(jPanelConteudo);
        jPanelConteudo.setBounds(0, 70, 481, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try{
            if(txtCodigo.getText().equals("")){
                throw new Exception("Favor informar o código do Livro que deseja pesquisar!");
            } else{
                codigoPesquisado = Integer.parseInt(txtCodigo.getText());
                Livro livroPesquisado = new Livro().consultaUmLivro(conexaoBanco, codigoPesquisado);
                livroAtualizado = livroPesquisado;
                
                ArrayList<Autor> listaAutoresAtuais = livroPesquisado.getAutores();
                DefaultListModel<String> model = new DefaultListModel<>();
                for (Autor _autor : listaAutoresAtuais) {
                    model.addElement(_autor.getNome() + " " + _autor.getSobrenome() + " - Codigo: '" + _autor.getCodigo() + "'");
                }  
                jlstAutoresAtuais.setModel(model);
                
                txtCodigoLivro.setText(String.valueOf(livroPesquisado.getCodigo()));
                txtTitulo.setText(livroPesquisado.getTitulo());
                cbxEditor.setSelectedItem(livroPesquisado.getEditor().getNome() + " - Codigo: '" + livroPesquisado.getEditor().getCodigo() + "'");
                cbxAssunto.setSelectedItem(livroPesquisado.getAssunto().getAssunto() + " - Codigo: '" + livroPesquisado.getAssunto().getCodigo() + "'");
                ArrayList<String> autoresSelecionados = new ArrayList<>();
                
                
                for(int i = 0; i < livroPesquisado.getAutores().size(); i++){
                    autoresSelecionados.add(livroPesquisado.getAutores().get(i).getNome() + " " + livroPesquisado.getAutores().get(i).getSobrenome() + " - Codigo: '" + livroPesquisado.getAutores().get(i).getCodigo() + "'");
                }
                jlstAutoresAtuais.setSelectedValue(autoresSelecionados, rootPaneCheckingEnabled);
                listaAutoresAtuaisSelecionados = autoresSelecionados;
                
                txtCodigo.setText("");
                
            }
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(null, ee.getMessage(), "Autor", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtCodigoLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoLivroActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void btnSalvarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracoesActionPerformed
        if (txtCodigoLivro.getText().equals("") || txtTitulo.getText().equals("") || cbxEditor.getSelectedIndex() == 0 || cbxAssunto.getSelectedIndex() == 0) {
            Object[] opcao = {"OK"};
            JOptionPane.showOptionDialog(null, "Existe campo sem preenchimento!", null, JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
        }
        else{
            Object[] opcao = {"Sim", "Não"};
            int n = JOptionPane.showOptionDialog(null,
            "Deseja salvar as Alterações feitas?",
            null,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcao,
            opcao[0]);

            if (n == JOptionPane.YES_OPTION) {
                try {
                    List<String> listaAutoresNovosSelecionados = jlstAutoresNovos.getSelectedValuesList();
                    ArrayList<Integer> listaCodigosAutoresAtuaisSelecionados = new ArrayList<>();
                    ArrayList<Integer> listaCodigosAutoresNovosSelecionados = new ArrayList<>();
                    
                    livroAtualizado.setTitulo(txtTitulo.getText());
                    livroAtualizado.setEditor(new Editor().consultaUmEditor(conexaoBanco, Integer.parseInt(cbxEditor.getSelectedItem().toString().split("'")[1])));
                    livroAtualizado.setAssunto(new Assunto().consultaUmAssunto(conexaoBanco, Integer.parseInt(cbxAssunto.getSelectedItem().toString().split("'")[1])));
                                        
                    for(int i = 0; i < listaAutoresAtuaisSelecionados.size(); i++){
                        listaCodigosAutoresAtuaisSelecionados.add(Integer.parseInt(listaAutoresAtuaisSelecionados.get(i).split("'")[1]));
                    }  
                    
                    for(int i = 0; i < listaAutoresNovosSelecionados.size(); i++){
                        listaCodigosAutoresNovosSelecionados.add(Integer.parseInt(listaAutoresNovosSelecionados.get(i).split("'")[1]));
                    }
                    
                    if (!(listaCodigosAutoresNovosSelecionados.toString().replace("[", "").replace("]", "").equals(listaCodigosAutoresAtuaisSelecionados.toString().replace("[", "").replace("]", ""))) && listaCodigosAutoresNovosSelecionados.size() > 0) {
                        livroAtualizado.getAutores().clear();
                        livroAtualizado.getAutores().addAll(Autor.consultaListaAutoresPorCodigos(conexaoBanco, listaCodigosAutoresNovosSelecionados));
                    }
                    else{
                        livroAtualizado.getAutores().clear();
                    }
                    
                    livroAtualizado.altera(conexaoBanco);
                    
                    if (livroAtualizado.getAutores().size() > 0) {
                        livroAtualizado.excluiAuxiliar(conexaoBanco, livroAtualizado.getCodigo());
                        livroAtualizado.incluiAuxiliar(conexaoBanco, livroAtualizado.getCodigo(), livroAtualizado.getAutores());
                    }
                    
                    Object[] opcao2 = {"OK"};
                    JOptionPane.showOptionDialog(null, "Livro alterado com sucesso!", null, JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao2, opcao2[0]);
                    
                    txtCodigoLivro.setText("");
                    cbxEditor.setSelectedIndex(0);
                    cbxAssunto.setSelectedIndex(0);
                    jlstAutoresAtuais.removeAll();
                    jlstAutoresNovos.clearSelection();                  
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.getMessage(), "Livro", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSalvarAlteracoesActionPerformed

    private void btnExcluirLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirLivroActionPerformed
        Object[] opcao = {"Sim", "Não"};
        int n = JOptionPane.showOptionDialog(null,
            "Deseja excluir esse Livro?",
            null,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE,
            null,
            opcao,
            opcao[0]);

        if (n == JOptionPane.YES_OPTION) {
            try {
                if (txtCodigoLivro.getText().equals(""))
                {
                    throw new Exception("Existe campo sem preenchimento!");
                } else {
                    livroAtualizado.exclui(conexaoBanco, livroAtualizado.getCodigo());
                }
                
                Object[] opcao2 = {"OK"};
                JOptionPane.showOptionDialog(null, "Livro excluído com sucesso!", null, JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao2, opcao2[0]);
                txtCodigoLivro.setText("");
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee.getMessage(), "Livro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExcluirLivroActionPerformed

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
            java.util.logging.Logger.getLogger(TelaManLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaManLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaManLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaManLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaManLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabeTitulo;
    private javax.swing.JLabel LabelAssunto;
    private javax.swing.JLabel LabelAtual;
    private javax.swing.JLabel LabelAutorAtual;
    private javax.swing.JLabel LabelAutorNovo;
    private javax.swing.JLabel LabelCodigo;
    private javax.swing.JLabel LabelCodigoLivro;
    private javax.swing.JLabel LabelEditor;
    private javax.swing.JLabel LabelNovo;
    private javax.swing.JLabel LabelResultadoPesquisa;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel PainelTopo;
    private javax.swing.JButton btnExcluirLivro;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvarAlteracoes;
    private javax.swing.JComboBox<String> cbxAssunto;
    private javax.swing.JComboBox<String> cbxEditor;
    private javax.swing.JPanel jPanelConteudo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JList<String> jlstAutoresAtuais;
    private javax.swing.JList<String> jlstAutoresNovos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoLivro;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
