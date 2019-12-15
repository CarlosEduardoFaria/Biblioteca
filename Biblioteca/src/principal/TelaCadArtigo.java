package principal;
import biblioteca.Artigo;
import biblioteca.Autor;
import biblioteca.Editor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class TelaCadArtigo extends javax.swing.JFrame {
    private Connection conexaoBanco;

    public TelaCadArtigo() {
        initComponents();
        personalizacoes();
        popularComboBoxAutores();
    }
    
    public TelaCadArtigo(Connection c) {
        this.conexaoBanco = c;
        initComponents();
        personalizacoes();
        popularComboBoxAutores();
    }
    
    private void personalizacoes(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("book.png")));
        this.setSize(488, 468);
        this.setResizable(false);
        //Centralizar no meio da Tela, independente da resolucao e tamanho do monitor
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    private void popularComboBoxAutores(){
        ArrayList<Editor> listaEditores = Editor.consultaListaEditores(conexaoBanco);
        ArrayList<Autor> listaAutores = Autor.consultaListaAutores(conexaoBanco);
        
        for (Editor _editor : listaEditores) {
            cbxEditor.addItem(_editor.getNome() + " - Codigo: '" + _editor.getCodigo() + "'");
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
        LabelAutor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlstAutores = new javax.swing.JList<>();
        LabelTextoPalavraChave = new javax.swing.JLabel();
        LabelPalavra = new javax.swing.JLabel();
        LabelChave = new javax.swing.JLabel();
        txtPalavrasChaves = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGB - Cadastramento de Artigo");
        getContentPane().setLayout(null);

        PainelTopo.setBackground(new java.awt.Color(51, 153, 255));
        PainelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelTopo.setLayout(null);

        LabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Cadastramento de Artigo");
        PainelTopo.add(LabelTitulo);
        LabelTitulo.setBounds(99, 21, 310, 22);

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

        LabelAutor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelAutor.setForeground(new java.awt.Color(255, 255, 255));
        LabelAutor.setText("Autores:");
        PainelConteudo.add(LabelAutor);
        LabelAutor.setBounds(50, 120, 50, 20);

        jScrollPane1.setViewportView(jlstAutores);

        PainelConteudo.add(jScrollPane1);
        jScrollPane1.setBounds(110, 120, 320, 90);

        LabelTextoPalavraChave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelTextoPalavraChave.setForeground(new java.awt.Color(255, 255, 255));
        LabelTextoPalavraChave.setText("Digite as palavras chaves separadas por vírgula!");
        PainelConteudo.add(LabelTextoPalavraChave);
        LabelTextoPalavraChave.setBounds(120, 230, 300, 14);

        LabelPalavra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelPalavra.setForeground(new java.awt.Color(255, 255, 255));
        LabelPalavra.setText("Palavras");
        PainelConteudo.add(LabelPalavra);
        LabelPalavra.setBounds(50, 250, 50, 20);

        LabelChave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelChave.setForeground(new java.awt.Color(255, 255, 255));
        LabelChave.setText("Chaves:");
        PainelConteudo.add(LabelChave);
        LabelChave.setBounds(50, 260, 50, 20);

        txtPalavrasChaves.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPalavrasChaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPalavrasChavesActionPerformed(evt);
            }
        });
        PainelConteudo.add(txtPalavrasChaves);
        txtPalavrasChaves.setBounds(110, 250, 320, 50);

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
        btnCadastrar.setBounds(200, 320, 100, 23);

        getContentPane().add(PainelConteudo);
        PainelConteudo.setBounds(0, 79, 490, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        int codigoEditorSelecionado = 0;
        ArrayList<String> listaPalavrasChaves = null;
        
        if (txtPalavrasChaves.getText().split(",").length > 0) {
            listaPalavrasChaves = new ArrayList<>();
            
            for(int i = 0; i < txtPalavrasChaves.getText().split(",").length; i++){
                listaPalavrasChaves.add(txtPalavrasChaves.getText().split(",")[i]);
            }   
        }
        else{
            JOptionPane.showConfirmDialog(null, "Favor Informar ao menos UMA palavra chave!"); 
        }
        
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
        
        for(int i = 0; i < listaAutoresSelecionados.size(); i++){
            listaCodigosAutoresSelecionados.add(Integer.parseInt(listaAutoresSelecionados.get(i).split("'")[1]));
        }   
        
        if (!(listaAutoresSelecionados.size() > 0)) {
            Object[] opcao = {"OK"};
            JOptionPane.showOptionDialog(null, "Favor Selecionar ao Menos um Autor!", null, JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
        }       

        Object[] opcao = {"Sim", "Não"};
        int n = JOptionPane.showOptionDialog(null,
            "Deseja incluir esse Artigo?",
            null,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcao,
            opcao[0]);

        if (n == JOptionPane.YES_OPTION) {
            try { 
                Artigo novoArtigo = new Artigo();
                novoArtigo.setCodigo(0);
                novoArtigo.setTitulo(txtTitulo.getText());
                novoArtigo.setEditor(new Editor().consultaUmEditor(conexaoBanco, codigoEditorSelecionado));
                novoArtigo.setAutores(Autor.consultaListaAutoresPorCodigos(conexaoBanco, listaCodigosAutoresSelecionados));
                novoArtigo.setListaPalavras(listaPalavrasChaves);
                novoArtigo.setData(new Date());
                
                int codLivroGravado = novoArtigo.inclui(conexaoBanco);
                
                if(codLivroGravado > 0){
                    txtTitulo.setText("");
                    cbxEditor.setSelectedIndex(0);
                    jlstAutores.clearSelection();
                    txtPalavrasChaves.setText("");
                    JOptionPane.showMessageDialog(null, "Artigo Gravado com Sucesso!");
                } else{
                    throw new Exception("Erro na gravação do Artigo");
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee.getMessage(), "Livro", JOptionPane.ERROR_MESSAGE);
            }
        }         
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtPalavrasChavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPalavrasChavesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPalavrasChavesActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadArtigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadArtigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadArtigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadArtigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadArtigo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAutor;
    private javax.swing.JLabel LabelChave;
    private javax.swing.JLabel LabelEditor;
    private javax.swing.JLabel LabelPalavra;
    private javax.swing.JLabel LabelTextoPalavraChave;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelTituloLivro;
    private javax.swing.JPanel PainelConteudo;
    private javax.swing.JPanel PainelTopo;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<String> cbxEditor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlstAutores;
    private javax.swing.JTextField txtPalavrasChaves;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
