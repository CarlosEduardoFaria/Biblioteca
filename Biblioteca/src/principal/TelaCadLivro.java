package principal;
import biblioteca.Assunto;
import biblioteca.Autor;
import biblioteca.Editor;
import biblioteca.Livro;
import java.awt.Dimension;
import java.util.List;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class TelaCadLivro extends javax.swing.JFrame {
    private Connection conexaoBanco;

    public TelaCadLivro() {
        initComponents();
        personalizacoes();
        popularComboBoxAutores();
    }
    
    public TelaCadLivro(Connection c) {
        this.conexaoBanco = c;
        initComponents();
        personalizacoes();
        popularComboBoxAutores();
    }
    
    private void personalizacoes(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("book.png")));
        this.setSize(488, 458);
        this.setResizable(false);
        //Centralizar no meio da Tela, independente da resolucao e tamanho do monitor
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    private void popularComboBoxAutores(){
        ArrayList<Editor> listaEditores = Editor.consultaListaEditores(conexaoBanco);
        ArrayList<Assunto> listaAssunto = Assunto.consultaListaAssuntos(conexaoBanco);
        ArrayList<Autor> listaAutores = Autor.consultaListaAutores(conexaoBanco);
        
        for (Editor _editor : listaEditores) {
            cbxEditor.addItem(_editor.getNome() + " - Codigo: '" + _editor.getCodigo() + "'");
        }
        
        for (Assunto _assunto: listaAssunto) {
            cbxAssunto.addItem(_assunto.getAssunto() + " - Codigo: '" + _assunto.getCodigo() + "'");
        }

        DefaultListModel<String> model = new DefaultListModel<String>();
        for (Autor _autor : listaAutores) {
            model.addElement(_autor.getNome() + " " + _autor.getSobrenome() + " - Codigo: '" + _autor.getCodigo() + "'");
        }  
        
        jlstAutores.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelTopo = new javax.swing.JPanel();
        LabelTitulo = new javax.swing.JLabel();
        PainelConteudo = new javax.swing.JPanel();
        LabelTituloLivro = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        LabelEditor = new javax.swing.JLabel();
        cbxEditor = new javax.swing.JComboBox<>();
        LabelAssunto = new javax.swing.JLabel();
        cbxAssunto = new javax.swing.JComboBox<>();
        LabelAutor = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlstAutores = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGB - Cadastramento de Livro");
        getContentPane().setLayout(null);

        PainelTopo.setBackground(new java.awt.Color(51, 102, 255));
        PainelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelTopo.setLayout(null);

        LabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Cadastramento de Livro");
        PainelTopo.add(LabelTitulo);
        LabelTitulo.setBounds(150, 20, 214, 22);

        getContentPane().add(PainelTopo);
        PainelTopo.setBounds(0, 0, 490, 80);

        PainelConteudo.setBackground(new java.awt.Color(204, 204, 204));
        PainelConteudo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelConteudo.setLayout(null);

        LabelTituloLivro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelTituloLivro.setForeground(new java.awt.Color(255, 255, 255));
        LabelTituloLivro.setText("Título:");
        PainelConteudo.add(LabelTituloLivro);
        LabelTituloLivro.setBounds(50, 50, 35, 14);
        PainelConteudo.add(txtTitulo);
        txtTitulo.setBounds(111, 42, 320, 20);

        LabelEditor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelEditor.setForeground(new java.awt.Color(255, 255, 255));
        LabelEditor.setText("Editor:");
        PainelConteudo.add(LabelEditor);
        LabelEditor.setBounds(50, 80, 50, 20);

        cbxEditor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Editor" }));
        PainelConteudo.add(cbxEditor);
        cbxEditor.setBounds(110, 80, 320, 20);

        LabelAssunto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelAssunto.setForeground(new java.awt.Color(255, 255, 255));
        LabelAssunto.setText("Assunto:");
        PainelConteudo.add(LabelAssunto);
        LabelAssunto.setBounds(50, 120, 50, 20);

        cbxAssunto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Assunto" }));
        PainelConteudo.add(cbxAssunto);
        cbxAssunto.setBounds(110, 120, 320, 20);

        LabelAutor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelAutor.setForeground(new java.awt.Color(255, 255, 255));
        LabelAutor.setText("Autores:");
        PainelConteudo.add(LabelAutor);
        LabelAutor.setBounds(50, 160, 50, 20);

        btnCadastrar.setBackground(new java.awt.Color(51, 153, 255));
        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        PainelConteudo.add(btnCadastrar);
        btnCadastrar.setBounds(200, 300, 100, 23);

        jScrollPane1.setViewportView(jlstAutores);

        PainelConteudo.add(jScrollPane1);
        jScrollPane1.setBounds(110, 160, 320, 120);

        getContentPane().add(PainelConteudo);
        PainelConteudo.setBounds(0, 79, 490, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        int codigoEditorSelecionado = 0;
        int codigoAssuntoSelecionado = 0;

        List<String> listaAutoresSelecionados = jlstAutores.getSelectedValuesList();
        ArrayList<Integer> listaCodigosAutoresSelecionados = new ArrayList<>();
       
        if (txtTitulo.getText().equals("")) {
            JOptionPane.showConfirmDialog(null, "Favor Informar o Título!"); 
        }
        
        if (cbxEditor.getSelectedIndex() != 0) {
            codigoEditorSelecionado = Integer.parseInt(cbxEditor.getSelectedItem().toString().split("'")[1]);
        } else{
            JOptionPane.showConfirmDialog(null, "Favor Selecionar um Editor!");
        }
        
        if (cbxAssunto.getSelectedIndex() != 0) {
            codigoAssuntoSelecionado = Integer.parseInt(cbxAssunto.getSelectedItem().toString().split("'")[1]);
        } else{
            JOptionPane.showConfirmDialog(null, "Favor Selecionar um Assunto!");
        }         
        
        for(int i = 0; i < listaAutoresSelecionados.size(); i++){
            listaCodigosAutoresSelecionados.add(Integer.parseInt(listaAutoresSelecionados.get(i).split("'")[1]));
        }        
        
        if (!(listaAutoresSelecionados.size() > 0)) {
            Object[] opcao = {"OK"};
            JOptionPane.showOptionDialog(null, "Favor Selecionar ao Menos um Autor!", null, JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
        }
        
        Object[] opcao = {"Sim", "Não"};
        int n = JOptionPane.showOptionDialog(null,
            "Deseja incluir esse Livro?",
            null,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcao,
            opcao[0]);

        if (n == JOptionPane.YES_OPTION) {
            try {
                Editor editorSelecionado = new Editor();
                editorSelecionado = editorSelecionado.consultaUmEditor(conexaoBanco, codigoEditorSelecionado);
                
                Assunto assuntoSelecionado = new Assunto();
                assuntoSelecionado = assuntoSelecionado.consultaUmAssunto(conexaoBanco, codigoAssuntoSelecionado);
                
                ArrayList<Autor> listaAutores = Autor.consultaListaAutoresPorCodigos(conexaoBanco, listaCodigosAutoresSelecionados);
                
                Livro novoLivro = new Livro(0, txtTitulo.getText(), editorSelecionado, assuntoSelecionado, listaAutores);
                int codLivroGravado = novoLivro.inclui(conexaoBanco);
                if(codLivroGravado > 0){
                    novoLivro.incluiAuxiliar(conexaoBanco, codLivroGravado, listaAutores);
                    txtTitulo.setText("");
                    cbxEditor.setSelectedIndex(0);
                    cbxAssunto.setSelectedIndex(0);
                    jlstAutores.clearSelection();
                    JOptionPane.showMessageDialog(null, "Livro Gravado com Sucesso!");
                } else{
                    throw new Exception("Erro na gravação do Livro");
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee.getMessage(), "Livro", JOptionPane.ERROR_MESSAGE);
            }
        }       
    }//GEN-LAST:event_btnCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAssunto;
    private javax.swing.JLabel LabelAutor;
    private javax.swing.JLabel LabelEditor;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelTituloLivro;
    private javax.swing.JPanel PainelConteudo;
    private javax.swing.JPanel PainelTopo;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<String> cbxAssunto;
    private javax.swing.JComboBox<String> cbxEditor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlstAutores;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

}
