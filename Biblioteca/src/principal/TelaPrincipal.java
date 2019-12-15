package principal;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;

public class TelaPrincipal extends javax.swing.JFrame {
    
    Connection conexaoBanco;
    
    public TelaPrincipal() {
        initComponents();
        personalizacoes();
        conexaoBanco = criaConexaoBanco();
    }   
    
    private void personalizacoes(){
        adicionarIcone();
        adicionarCorDeFundo();
        maximizarForm();
    }
    
    private void adicionarIcone(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("book.png")));
    }  
    
    private void adicionarCorDeFundo(){
        this.getContentPane().setBackground(new Color(0,0,0));
    } 

    private void maximizarForm(){
        this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
    } 
    
    private Connection criaConexaoBanco() {
        Connection connection = null;
        String url = "jdbc:derby://localhost:1527/Biblioteca";
        String usuario = "henrique";
        String senha = "guest";
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException cnfex) {
            System.err.println(
                    "Failed to load JDBC/ODBC driver.");
            cnfex.printStackTrace();
            System.exit(1);
        } catch (SQLException sqlex) {
            System.err.println("Unable to connect");
            sqlex.printStackTrace();
            System.exit(1);
        }
        return connection;
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarraDeMenu = new javax.swing.JMenuBar();
        MenuArquivo = new javax.swing.JMenu();
        SubMenuSair = new javax.swing.JMenuItem();
        MenuAutor = new javax.swing.JMenu();
        SubMenuCadastroAutor = new javax.swing.JMenuItem();
        SubMenuPesquisarAutor = new javax.swing.JMenuItem();
        SubMenuManutencaoAutor = new javax.swing.JMenuItem();
        MenuEditor = new javax.swing.JMenu();
        SubMenuCadastroEditor = new javax.swing.JMenuItem();
        SubMenuPesquisarEditor = new javax.swing.JMenuItem();
        SubMenuManutencaoEditor = new javax.swing.JMenuItem();
        MenuAssunto = new javax.swing.JMenu();
        SubMenuCadastroAssunto = new javax.swing.JMenuItem();
        SubMenuPesquisarAssunto = new javax.swing.JMenuItem();
        SubMenuManutencaoAssunto = new javax.swing.JMenuItem();
        MenuLivro = new javax.swing.JMenu();
        SubMenuCadastroLivro = new javax.swing.JMenuItem();
        SubMenuPesquisarLivro = new javax.swing.JMenuItem();
        SubMenuManutencaoLivro = new javax.swing.JMenuItem();
        MenuArtigo = new javax.swing.JMenu();
        SubMenuCadastroArtigo = new javax.swing.JMenuItem();
        SubMenuPesquisarArtigo = new javax.swing.JMenuItem();
        SubMenuManutencaoArtigo = new javax.swing.JMenuItem();
        MenuRevista = new javax.swing.JMenu();
        SubMenuCadastroRevista = new javax.swing.JMenuItem();
        SubMenuPesquisarRevista = new javax.swing.JMenuItem();
        SubMenuManutencaoRevista = new javax.swing.JMenuItem();
        MenuSobre = new javax.swing.JMenu();
        SubMenuInformacoes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGB - Sistema de Gestão Bibliotecária");
        setBackground(new java.awt.Color(204, 204, 204));

        BarraDeMenu.setBackground(new java.awt.Color(248, 148, 6));
        BarraDeMenu.setForeground(new java.awt.Color(255, 255, 255));
        BarraDeMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        MenuArquivo.setBackground(new java.awt.Color(248, 148, 6));
        MenuArquivo.setForeground(new java.awt.Color(255, 255, 255));
        MenuArquivo.setText("Arquivo");

        SubMenuSair.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuSair.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuSair.setText("Sair");
        SubMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuSairActionPerformed(evt);
            }
        });
        MenuArquivo.add(SubMenuSair);

        BarraDeMenu.add(MenuArquivo);
        MenuArquivo.getAccessibleContext().setAccessibleDescription("");

        MenuAutor.setBackground(new java.awt.Color(248, 148, 6));
        MenuAutor.setForeground(new java.awt.Color(255, 255, 255));
        MenuAutor.setText("Autor");

        SubMenuCadastroAutor.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuCadastroAutor.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuCadastroAutor.setText("Cadastro");
        SubMenuCadastroAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuCadastroAutorActionPerformed(evt);
            }
        });
        MenuAutor.add(SubMenuCadastroAutor);

        SubMenuPesquisarAutor.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuPesquisarAutor.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuPesquisarAutor.setText("Pesquisar");
        SubMenuPesquisarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuPesquisarAutorActionPerformed(evt);
            }
        });
        MenuAutor.add(SubMenuPesquisarAutor);

        SubMenuManutencaoAutor.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuManutencaoAutor.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuManutencaoAutor.setText("Manutencão");
        SubMenuManutencaoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuManutencaoAutorActionPerformed(evt);
            }
        });
        MenuAutor.add(SubMenuManutencaoAutor);

        BarraDeMenu.add(MenuAutor);

        MenuEditor.setBackground(new java.awt.Color(248, 148, 6));
        MenuEditor.setForeground(new java.awt.Color(255, 255, 255));
        MenuEditor.setText("Editor");

        SubMenuCadastroEditor.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuCadastroEditor.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuCadastroEditor.setText("Cadastro");
        SubMenuCadastroEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuCadastroEditorActionPerformed(evt);
            }
        });
        MenuEditor.add(SubMenuCadastroEditor);

        SubMenuPesquisarEditor.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuPesquisarEditor.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuPesquisarEditor.setText("Pesquisar");
        SubMenuPesquisarEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuPesquisarEditorActionPerformed(evt);
            }
        });
        MenuEditor.add(SubMenuPesquisarEditor);

        SubMenuManutencaoEditor.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuManutencaoEditor.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuManutencaoEditor.setText("Manutencão");
        SubMenuManutencaoEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuManutencaoEditorActionPerformed(evt);
            }
        });
        MenuEditor.add(SubMenuManutencaoEditor);

        BarraDeMenu.add(MenuEditor);

        MenuAssunto.setBackground(new java.awt.Color(248, 148, 6));
        MenuAssunto.setForeground(new java.awt.Color(255, 255, 255));
        MenuAssunto.setText("Assunto");

        SubMenuCadastroAssunto.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuCadastroAssunto.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuCadastroAssunto.setText("Cadastro");
        SubMenuCadastroAssunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuCadastroAssuntoActionPerformed(evt);
            }
        });
        MenuAssunto.add(SubMenuCadastroAssunto);

        SubMenuPesquisarAssunto.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuPesquisarAssunto.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuPesquisarAssunto.setText("Pesquisar");
        SubMenuPesquisarAssunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuPesquisarAssuntoActionPerformed(evt);
            }
        });
        MenuAssunto.add(SubMenuPesquisarAssunto);

        SubMenuManutencaoAssunto.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuManutencaoAssunto.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuManutencaoAssunto.setText("Manutencão");
        SubMenuManutencaoAssunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuManutencaoAssuntoActionPerformed(evt);
            }
        });
        MenuAssunto.add(SubMenuManutencaoAssunto);

        BarraDeMenu.add(MenuAssunto);

        MenuLivro.setBackground(new java.awt.Color(248, 148, 6));
        MenuLivro.setForeground(new java.awt.Color(255, 255, 255));
        MenuLivro.setText("Livro");

        SubMenuCadastroLivro.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuCadastroLivro.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuCadastroLivro.setText("Cadastro");
        SubMenuCadastroLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuCadastroLivroActionPerformed(evt);
            }
        });
        MenuLivro.add(SubMenuCadastroLivro);

        SubMenuPesquisarLivro.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuPesquisarLivro.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuPesquisarLivro.setText("Pesquisar");
        SubMenuPesquisarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuPesquisarLivroActionPerformed(evt);
            }
        });
        MenuLivro.add(SubMenuPesquisarLivro);

        SubMenuManutencaoLivro.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuManutencaoLivro.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuManutencaoLivro.setText("Manutencão");
        SubMenuManutencaoLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuManutencaoLivroActionPerformed(evt);
            }
        });
        MenuLivro.add(SubMenuManutencaoLivro);

        BarraDeMenu.add(MenuLivro);

        MenuArtigo.setBackground(new java.awt.Color(248, 148, 6));
        MenuArtigo.setForeground(new java.awt.Color(255, 255, 255));
        MenuArtigo.setText("Artigo");

        SubMenuCadastroArtigo.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuCadastroArtigo.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuCadastroArtigo.setText("Cadastro");
        SubMenuCadastroArtigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuCadastroArtigoActionPerformed(evt);
            }
        });
        MenuArtigo.add(SubMenuCadastroArtigo);

        SubMenuPesquisarArtigo.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuPesquisarArtigo.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuPesquisarArtigo.setText("Pesquisar");
        SubMenuPesquisarArtigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuPesquisarArtigoActionPerformed(evt);
            }
        });
        MenuArtigo.add(SubMenuPesquisarArtigo);

        SubMenuManutencaoArtigo.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuManutencaoArtigo.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuManutencaoArtigo.setText("Manutencão");
        SubMenuManutencaoArtigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuManutencaoArtigoActionPerformed(evt);
            }
        });
        MenuArtigo.add(SubMenuManutencaoArtigo);

        BarraDeMenu.add(MenuArtigo);

        MenuRevista.setBackground(new java.awt.Color(248, 148, 6));
        MenuRevista.setForeground(new java.awt.Color(255, 255, 255));
        MenuRevista.setText("Revista");

        SubMenuCadastroRevista.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuCadastroRevista.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuCadastroRevista.setText("Cadastro");
        SubMenuCadastroRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuCadastroRevistaActionPerformed(evt);
            }
        });
        MenuRevista.add(SubMenuCadastroRevista);

        SubMenuPesquisarRevista.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuPesquisarRevista.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuPesquisarRevista.setText("Pesquisar");
        SubMenuPesquisarRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuPesquisarRevistaActionPerformed(evt);
            }
        });
        MenuRevista.add(SubMenuPesquisarRevista);

        SubMenuManutencaoRevista.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuManutencaoRevista.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuManutencaoRevista.setText("Manutencão");
        SubMenuManutencaoRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuManutencaoRevistaActionPerformed(evt);
            }
        });
        MenuRevista.add(SubMenuManutencaoRevista);

        BarraDeMenu.add(MenuRevista);

        MenuSobre.setBackground(new java.awt.Color(248, 148, 6));
        MenuSobre.setForeground(new java.awt.Color(255, 255, 255));
        MenuSobre.setText("Sobre");

        SubMenuInformacoes.setBackground(new java.awt.Color(248, 148, 6));
        SubMenuInformacoes.setForeground(new java.awt.Color(255, 255, 255));
        SubMenuInformacoes.setText("Informações");
        SubMenuInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubMenuInformacoesActionPerformed(evt);
            }
        });
        MenuSobre.add(SubMenuInformacoes);

        BarraDeMenu.add(MenuSobre);

        setJMenuBar(BarraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubMenuInformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuInformacoesActionPerformed
        TelaSobre telaSobre = new TelaSobre();
        telaSobre.setVisible(true);
    }//GEN-LAST:event_SubMenuInformacoesActionPerformed

    private void SubMenuCadastroAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuCadastroAutorActionPerformed
        TelaCadAutor telaCadastroAutor = new TelaCadAutor(conexaoBanco);
        telaCadastroAutor.setVisible(true);
    }//GEN-LAST:event_SubMenuCadastroAutorActionPerformed

    private void SubMenuCadastroEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuCadastroEditorActionPerformed
        TelaCadEditor telaCadastroEditor = new TelaCadEditor(conexaoBanco);
        telaCadastroEditor.setVisible(true);
    }//GEN-LAST:event_SubMenuCadastroEditorActionPerformed

    private void SubMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SubMenuSairActionPerformed

    private void SubMenuManutencaoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuManutencaoAutorActionPerformed
        TelaManAutor telaManutencaoAutor = new TelaManAutor(conexaoBanco);
        telaManutencaoAutor.setVisible(true);
    }//GEN-LAST:event_SubMenuManutencaoAutorActionPerformed

    private void SubMenuManutencaoEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuManutencaoEditorActionPerformed
        TelaManEditor telaManutencaoEditor = new TelaManEditor(conexaoBanco);
        telaManutencaoEditor.setVisible(true);
    }//GEN-LAST:event_SubMenuManutencaoEditorActionPerformed

    private void SubMenuPesquisarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuPesquisarAutorActionPerformed
        TelaListAutores telaListarAutores = new TelaListAutores(conexaoBanco);
        telaListarAutores.setVisible(true);
    }//GEN-LAST:event_SubMenuPesquisarAutorActionPerformed

    private void SubMenuPesquisarEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuPesquisarEditorActionPerformed
        TelaListEditores telaListarEditores = new TelaListEditores(conexaoBanco);
        telaListarEditores.setVisible(true);
    }//GEN-LAST:event_SubMenuPesquisarEditorActionPerformed

    private void SubMenuCadastroAssuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuCadastroAssuntoActionPerformed
        TelaCadAssunto telaCadastroAssunto = new TelaCadAssunto(conexaoBanco);
        telaCadastroAssunto.setVisible(true);
    }//GEN-LAST:event_SubMenuCadastroAssuntoActionPerformed

    private void SubMenuPesquisarAssuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuPesquisarAssuntoActionPerformed
        TelaListAssuntos telaListarAssuntos = new TelaListAssuntos(conexaoBanco);
        telaListarAssuntos.setVisible(true);
    }//GEN-LAST:event_SubMenuPesquisarAssuntoActionPerformed

    private void SubMenuManutencaoAssuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuManutencaoAssuntoActionPerformed
        TelaManAssunto telaManutencaoAssunto = new TelaManAssunto(conexaoBanco);
        telaManutencaoAssunto.setVisible(true);
    }//GEN-LAST:event_SubMenuManutencaoAssuntoActionPerformed

    private void SubMenuCadastroLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuCadastroLivroActionPerformed
        TelaCadLivro telaCadastroLivro = new TelaCadLivro(conexaoBanco);
        telaCadastroLivro.setVisible(true);
    }//GEN-LAST:event_SubMenuCadastroLivroActionPerformed

    private void SubMenuPesquisarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuPesquisarLivroActionPerformed
        TelaListLivros telaListarLivros = new TelaListLivros(conexaoBanco);
        telaListarLivros.setVisible(true);
    }//GEN-LAST:event_SubMenuPesquisarLivroActionPerformed

    private void SubMenuManutencaoLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuManutencaoLivroActionPerformed
        TelaManLivro telaManutencaoLivro = new TelaManLivro(conexaoBanco);
        telaManutencaoLivro.setVisible(true);
    }//GEN-LAST:event_SubMenuManutencaoLivroActionPerformed

    private void SubMenuCadastroArtigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuCadastroArtigoActionPerformed
        TelaCadArtigo telaCadastroArtigo = new TelaCadArtigo(conexaoBanco);
        telaCadastroArtigo.setVisible(true);
    }//GEN-LAST:event_SubMenuCadastroArtigoActionPerformed

    private void SubMenuPesquisarArtigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuPesquisarArtigoActionPerformed
        TelaListArtigos telaListarArtigos = new TelaListArtigos(conexaoBanco);
        telaListarArtigos.setVisible(true);
    }//GEN-LAST:event_SubMenuPesquisarArtigoActionPerformed

    private void SubMenuManutencaoArtigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuManutencaoArtigoActionPerformed
        TelaManArtigo telaManutencaoArtigo = new TelaManArtigo(conexaoBanco);
        telaManutencaoArtigo.setVisible(true);
    }//GEN-LAST:event_SubMenuManutencaoArtigoActionPerformed

    private void SubMenuCadastroRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuCadastroRevistaActionPerformed
        TelaCadRevista telaCadastroRevista = new TelaCadRevista(conexaoBanco);
        telaCadastroRevista.setVisible(true);
    }//GEN-LAST:event_SubMenuCadastroRevistaActionPerformed

    private void SubMenuPesquisarRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuPesquisarRevistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubMenuPesquisarRevistaActionPerformed

    private void SubMenuManutencaoRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubMenuManutencaoRevistaActionPerformed
    }//GEN-LAST:event_SubMenuManutencaoRevistaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraDeMenu;
    private javax.swing.JMenu MenuArquivo;
    private javax.swing.JMenu MenuArtigo;
    private javax.swing.JMenu MenuAssunto;
    private javax.swing.JMenu MenuAutor;
    private javax.swing.JMenu MenuEditor;
    private javax.swing.JMenu MenuLivro;
    private javax.swing.JMenu MenuRevista;
    private javax.swing.JMenu MenuSobre;
    private javax.swing.JMenuItem SubMenuCadastroArtigo;
    private javax.swing.JMenuItem SubMenuCadastroAssunto;
    private javax.swing.JMenuItem SubMenuCadastroAutor;
    private javax.swing.JMenuItem SubMenuCadastroEditor;
    private javax.swing.JMenuItem SubMenuCadastroLivro;
    private javax.swing.JMenuItem SubMenuCadastroRevista;
    private javax.swing.JMenuItem SubMenuInformacoes;
    private javax.swing.JMenuItem SubMenuManutencaoArtigo;
    private javax.swing.JMenuItem SubMenuManutencaoAssunto;
    private javax.swing.JMenuItem SubMenuManutencaoAutor;
    private javax.swing.JMenuItem SubMenuManutencaoEditor;
    private javax.swing.JMenuItem SubMenuManutencaoLivro;
    private javax.swing.JMenuItem SubMenuManutencaoRevista;
    private javax.swing.JMenuItem SubMenuPesquisarArtigo;
    private javax.swing.JMenuItem SubMenuPesquisarAssunto;
    private javax.swing.JMenuItem SubMenuPesquisarAutor;
    private javax.swing.JMenuItem SubMenuPesquisarEditor;
    private javax.swing.JMenuItem SubMenuPesquisarLivro;
    private javax.swing.JMenuItem SubMenuPesquisarRevista;
    private javax.swing.JMenuItem SubMenuSair;
    // End of variables declaration//GEN-END:variables
}