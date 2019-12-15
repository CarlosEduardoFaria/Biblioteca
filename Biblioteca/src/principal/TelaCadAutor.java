package principal;
import biblioteca.Autor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class TelaCadAutor extends javax.swing.JFrame {
    private Connection conexaoBanco;

    public TelaCadAutor() {
        initComponents();
        personalizacoes();
    }
    
    public TelaCadAutor(Connection c) {
        this.conexaoBanco = c;
        initComponents();
        personalizacoes();
    }
    
    private void personalizacoes(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("book.png")));
        this.setSize(490, 290);
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
        LabelNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        LabelSobrenome = new javax.swing.JLabel();
        txtSobrenome = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGB - Cadastramento de Autor");
        getContentPane().setLayout(null);

        PainelTopo.setBackground(new java.awt.Color(51, 102, 255));
        PainelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelTopo.setLayout(null);

        LabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Cadastramento de Autor");
        PainelTopo.add(LabelTitulo);
        LabelTitulo.setBounds(150, 20, 220, 22);

        getContentPane().add(PainelTopo);
        PainelTopo.setBounds(0, 0, 490, 80);

        PainelConteudo.setBackground(new java.awt.Color(204, 204, 204));
        PainelConteudo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelConteudo.setLayout(null);

        LabelNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelNome.setForeground(new java.awt.Color(255, 255, 255));
        LabelNome.setText("Nome:");
        PainelConteudo.add(LabelNome);
        LabelNome.setBounds(56, 45, 35, 14);
        PainelConteudo.add(txtNome);
        txtNome.setBounds(141, 42, 290, 20);

        LabelSobrenome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LabelSobrenome.setForeground(new java.awt.Color(255, 255, 255));
        LabelSobrenome.setText("Sobrenome:");
        PainelConteudo.add(LabelSobrenome);
        LabelSobrenome.setBounds(56, 86, 80, 14);
        PainelConteudo.add(txtSobrenome);
        txtSobrenome.setBounds(140, 80, 290, 20);

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
        btnCadastrar.setBounds(190, 130, 100, 23);

        getContentPane().add(PainelConteudo);
        PainelConteudo.setBounds(0, 79, 490, 210);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Object[] opcao = {"Sim", "Não"};
        int n = JOptionPane.showOptionDialog(null,
                "Deseja incluir esse Autor?",
                null,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcao,
                opcao[0]);

        if (n == JOptionPane.YES_OPTION) {
            try {
                if (txtSobrenome.getText().equals("") || txtSobrenome.getText().equals("")) {
                    throw new Exception("Existe(m) campo(s) sem preenchimento!");
                } else {
                    Autor novoAutor = new Autor(0, txtNome.getText(), txtSobrenome.getText());
                    int ok = novoAutor.inclui(conexaoBanco);
                    if(ok > 0){
                        txtNome.setText("");
                        txtSobrenome.setText("");
                        JOptionPane.showMessageDialog(null, "Autor Gravado com Sucesso!");
                    }
                    else{
                        throw new Exception("Erro na gravação do Autor");
                    }
                }
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, ee.getMessage(), "Autor", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(TelaCadAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelSobrenome;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel PainelConteudo;
    private javax.swing.JPanel PainelTopo;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSobrenome;
    // End of variables declaration//GEN-END:variables
}
