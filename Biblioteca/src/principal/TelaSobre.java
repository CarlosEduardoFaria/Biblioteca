package principal;
import java.awt.Dimension;
import java.awt.Toolkit;

public class TelaSobre extends javax.swing.JFrame {

    public TelaSobre() {
        initComponents();
        personalizacoes();
    }
    
    private void personalizacoes(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("book.png")));
        this.setSize(470, 350);
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
        LabelUniversidade = new javax.swing.JLabel();
        LabelMateria = new javax.swing.JLabel();
        LabelProfessor = new javax.swing.JLabel();
        LabelNomeProfessor = new javax.swing.JLabel();
        LabelAlunos = new javax.swing.JLabel();
        LabelAluno1 = new javax.swing.JLabel();
        LabelAluno2 = new javax.swing.JLabel();
        LabelAluno3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGB - Informações do Sistema");
        getContentPane().setLayout(null);

        PainelTopo.setBackground(new java.awt.Color(51, 102, 255));
        PainelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelTopo.setLayout(null);

        LabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Informações do Sistema");
        PainelTopo.add(LabelTitulo);
        LabelTitulo.setBounds(70, 20, 330, 22);

        getContentPane().add(PainelTopo);
        PainelTopo.setBounds(0, 0, 470, 80);

        PainelConteudo.setBackground(new java.awt.Color(204, 204, 204));
        PainelConteudo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelConteudo.setLayout(null);

        LabelUniversidade.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelUniversidade.setForeground(new java.awt.Color(255, 255, 255));
        LabelUniversidade.setText("Universidade Estácio de Sá - Unidade Praça XI");
        PainelConteudo.add(LabelUniversidade);
        LabelUniversidade.setBounds(30, 20, 420, 22);

        LabelMateria.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        LabelMateria.setForeground(new java.awt.Color(255, 255, 255));
        LabelMateria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelMateria.setText("Biblioteca - Programação 2");
        PainelConteudo.add(LabelMateria);
        LabelMateria.setBounds(60, 60, 340, 20);

        LabelProfessor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelProfessor.setForeground(new java.awt.Color(255, 255, 255));
        LabelProfessor.setText("Professor:");
        PainelConteudo.add(LabelProfessor);
        LabelProfessor.setBounds(30, 110, 80, 17);

        LabelNomeProfessor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelNomeProfessor.setForeground(new java.awt.Color(255, 255, 255));
        LabelNomeProfessor.setText("Henrique Tavares");
        PainelConteudo.add(LabelNomeProfessor);
        LabelNomeProfessor.setBounds(110, 110, 110, 15);

        LabelAlunos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelAlunos.setForeground(new java.awt.Color(255, 255, 255));
        LabelAlunos.setText("Alunos:");
        PainelConteudo.add(LabelAlunos);
        LabelAlunos.setBounds(30, 170, 52, 17);

        LabelAluno1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelAluno1.setForeground(new java.awt.Color(255, 255, 255));
        LabelAluno1.setText("Jefferson da Silva Pinheiro - 201609030222");
        PainelConteudo.add(LabelAluno1);
        LabelAluno1.setBounds(90, 190, 290, 15);

        LabelAluno2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelAluno2.setForeground(new java.awt.Color(255, 255, 255));
        LabelAluno2.setText("Thiago Santos Soares - 201509206833");
        PainelConteudo.add(LabelAluno2);
        LabelAluno2.setBounds(90, 210, 290, 15);

        LabelAluno3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelAluno3.setForeground(new java.awt.Color(255, 255, 255));
        LabelAluno3.setText("Carlos Eduardo Peçanha Faria - 201407014323");
        PainelConteudo.add(LabelAluno3);
        LabelAluno3.setBounds(90, 170, 290, 15);

        getContentPane().add(PainelConteudo);
        PainelConteudo.setBounds(0, 80, 470, 250);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSobre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAluno1;
    private javax.swing.JLabel LabelAluno2;
    private javax.swing.JLabel LabelAluno3;
    private javax.swing.JLabel LabelAlunos;
    private javax.swing.JLabel LabelMateria;
    private javax.swing.JLabel LabelNomeProfessor;
    private javax.swing.JLabel LabelProfessor;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelUniversidade;
    private javax.swing.JPanel PainelConteudo;
    private javax.swing.JPanel PainelTopo;
    // End of variables declaration//GEN-END:variables
}
