package principal;
import biblioteca.Artigo;
import biblioteca.Autor;
import biblioteca.Editor;
import biblioteca.Revista;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class TelaCadRevista extends javax.swing.JFrame {
    private Connection conexaoBanco;
    
    public TelaCadRevista() {
        initComponents();
        personalizacoes();
        popularComboBoxAutores();
    }
    
    public TelaCadRevista(Connection c) {
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
        ArrayList<Artigo> listaArtigos = Artigo.consultaListaArtigos(conexaoBanco);
        
        for (Editor _editor : listaEditores) {
            cbxEditor.addItem(_editor.getNome() + " - Codigo: '" + _editor.getCodigo() + "'");
        }

        DefaultListModel<String> model = new DefaultListModel<String>();
        for (Artigo _artigo : listaArtigos) {
            model.addElement(_artigo.getTitulo()+ " - Codigo: '" + _artigo.getCodigo() + "'");
        }  
        
        jlstArtigos.setModel(model);
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
        LabelArtigos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlstArtigos = new javax.swing.JList<>();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGB - Cadastramento de Revista");
        getContentPane().setLayout(null);

        PainelTopo.setBackground(new java.awt.Color(51, 102, 255));
        PainelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelTopo.setLayout(null);

        LabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Cadastramento de Revista");
        PainelTopo.add(LabelTitulo);
        LabelTitulo.setBounds(99, 21, 320, 22);

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

        LabelArtigos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelArtigos.setForeground(new java.awt.Color(255, 255, 255));
        LabelArtigos.setText("Artigos:");
        PainelConteudo.add(LabelArtigos);
        LabelArtigos.setBounds(50, 120, 50, 20);

        jScrollPane1.setViewportView(jlstArtigos);

        PainelConteudo.add(jScrollPane1);
        jScrollPane1.setBounds(110, 120, 320, 170);

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
        btnCadastrar.setBounds(200, 310, 100, 23);

        getContentPane().add(PainelConteudo);
        PainelConteudo.setBounds(0, 79, 490, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        int codigoEditorSelecionado = 0;

        List<String> listaArtigosSelecionados = jlstArtigos.getSelectedValuesList();
        ArrayList<Integer> listaCodigosArtigosSelecionados = new ArrayList<>();

        if (txtTitulo.getText().equals("")) {
            JOptionPane.showConfirmDialog(null, "Favor Informar o Título!");
        }

        if (cbxEditor.getSelectedIndex() != 0) {
            codigoEditorSelecionado = Integer.parseInt(cbxEditor.getSelectedItem().toString().split("'")[1]);
        } else{
            JOptionPane.showConfirmDialog(null, "Favor Selecionar um Editor!");
        }

        for(int i = 0; i < listaArtigosSelecionados.size(); i++){
            listaCodigosArtigosSelecionados.add(Integer.parseInt(listaArtigosSelecionados.get(i).split("'")[1]));
        }

        if (!(listaArtigosSelecionados.size() > 0)) {
            Object[] opcao = {"OK"};
            JOptionPane.showOptionDialog(null, "Favor Selecionar ao Menos um Artigo!", null, JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
        }

        Object[] opcao = {"Sim", "Não"};
        int n = JOptionPane.showOptionDialog(null,
            "Deseja incluir essa Revista?",
            null,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcao,
            opcao[0]);

        if (n == JOptionPane.YES_OPTION) {
            try {
                Revista novoRevista = new Revista();
                novoRevista.setCodigo(0);
                novoRevista.setTitulo(txtTitulo.getText());
                novoRevista.setEditor(new Editor().consultaUmEditor(conexaoBanco, codigoEditorSelecionado));
                
                ArrayList<Artigo> listaArtigosGravar = new ArrayList<>();
                for(int i = 0; i < listaCodigosArtigosSelecionados.size(); i++){
                    listaArtigosGravar.add(new Artigo().consultaUmArtigo(conexaoBanco, listaCodigosArtigosSelecionados.get(i)));
                }
                novoRevista.setArtigos(listaArtigosGravar);

                int codRevistaGravada = novoRevista.inclui(conexaoBanco);

                if(codRevistaGravada > 0){
                    txtTitulo.setText("");
                    cbxEditor.setSelectedIndex(0);
                    jlstArtigos.clearSelection();
                    JOptionPane.showMessageDialog(null, "Revista Gravada com Sucesso!");
                } else{
                    throw new Exception("Erro na gravação da Revista");
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee.getMessage(), "Revista", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(TelaCadRevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadRevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadRevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadRevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadRevista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelArtigos;
    private javax.swing.JLabel LabelEditor;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelTituloLivro;
    private javax.swing.JPanel PainelConteudo;
    private javax.swing.JPanel PainelTopo;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<String> cbxEditor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlstArtigos;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
