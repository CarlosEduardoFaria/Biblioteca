package principal;
import biblioteca.Assunto;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TelaListAssuntos extends javax.swing.JFrame {
    private Connection conexaoBanco;
    
    public TelaListAssuntos() {
        initComponents();
    }
    
    public TelaListAssuntos(Connection c) {
        this.conexaoBanco = c;
        initComponents();
        personalizacoes();
    }
    
    private void personalizacoes(){
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("book.png")));
        this.setSize(610, 460);
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
        btnListarAssuntos = new javax.swing.JButton();
        LabelResultadoPesquisa = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        dtAssuntos = new javax.swing.JTable();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGB - Listagem de Assuntos");
        getContentPane().setLayout(null);

        PainelTopo.setBackground(new java.awt.Color(51, 102, 255));
        PainelTopo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PainelTopo.setLayout(null);

        LabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Listagem de Assuntos");
        PainelTopo.add(LabelTitulo);
        LabelTitulo.setBounds(160, 20, 293, 22);

        getContentPane().add(PainelTopo);
        PainelTopo.setBounds(0, 0, 610, 70);

        jPanelConteudo.setBackground(new java.awt.Color(204, 204, 204));
        jPanelConteudo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelConteudo.setLayout(null);

        btnListarAssuntos.setBackground(new java.awt.Color(51, 153, 255));
        btnListarAssuntos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnListarAssuntos.setForeground(new java.awt.Color(255, 255, 255));
        btnListarAssuntos.setText("Listar Todos");
        btnListarAssuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAssuntosActionPerformed(evt);
            }
        });
        jPanelConteudo.add(btnListarAssuntos);
        btnListarAssuntos.setBounds(240, 20, 120, 23);

        LabelResultadoPesquisa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LabelResultadoPesquisa.setForeground(new java.awt.Color(255, 255, 255));
        LabelResultadoPesquisa.setText("Resultado da Pesquisa:");
        jPanelConteudo.add(LabelResultadoPesquisa);
        LabelResultadoPesquisa.setBounds(230, 70, 142, 15);
        jPanelConteudo.add(jSeparator2);
        jSeparator2.setBounds(0, 86, 610, 20);

        dtAssuntos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Assunto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dtAssuntos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(dtAssuntos);

        jPanelConteudo.add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 570, 210);

        btnAlterar.setBackground(new java.awt.Color(248, 148, 6));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("Realizar Manutenção");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanelConteudo.add(btnAlterar);
        btnAlterar.setBounds(220, 320, 170, 23);

        getContentPane().add(jPanelConteudo);
        jPanelConteudo.setBounds(0, 70, 610, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarAssuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarAssuntosActionPerformed
        try{
            dtAssuntos.removeAll();
            ArrayList<Assunto> listaAutores = Assunto.consultaListaAssuntos(conexaoBanco);
            for(int i = 0; i < listaAutores.size(); i++){
                dtAssuntos.setValueAt(listaAutores.get(i).getCodigo(), i, 0);
                dtAssuntos.setValueAt(listaAutores.get(i).getAssunto(), i, 1);
            }
        } catch(Exception ee){
            JOptionPane.showMessageDialog(null, ee.getMessage(), "Editor", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnListarAssuntosActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        TelaManAssunto telaManutencaoAssunto = new TelaManAssunto(conexaoBanco);
        telaManutencaoAssunto.setVisible(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaListAssuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListAssuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListAssuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListAssuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListAssuntos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelResultadoPesquisa;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JPanel PainelTopo;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnListarAssuntos;
    private javax.swing.JTable dtAssuntos;
    private javax.swing.JPanel jPanelConteudo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
