package biblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Assunto {

    private int codigo; 
    private String assunto;

    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int _codigo) {
        this.codigo = _codigo;
    }    
       
    public String getAssunto() {
        return assunto;
    }
    
    public void setAssunto(String _assunto) {
        assunto = _assunto;
    }
    
    public Assunto() {
    }

    public Assunto(int _codigo, String _assunto) {
        this.codigo = _codigo;
        this.assunto = _assunto;
    }    
    
    public int inclui(Connection _conn) throws SQLException {
        PreparedStatement ps = _conn.prepareStatement("INSERT INTO ASSUNTOS (DESCRICAO) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, assunto);
        ps.execute();
        
        ResultSet rs = ps.getGeneratedKeys();
        int generatedKey = 0;
        
        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }
        ps.close();

        return generatedKey;
    }
    
    public boolean altera(Connection _conn) throws SQLException {
        PreparedStatement ps = _conn.prepareStatement("UPDATE ASSUNTOS SET DESCRICAO = ? WHERE CODIGO = ?");
        ps.setString(1, assunto);
        ps.setInt(2, codigo);

        int n = ps.executeUpdate();
        ps.close();

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }    
    
    public boolean exclui(Connection _conn, int _codPesquisa) throws SQLException {
        PreparedStatement ps = _conn.prepareStatement("DELETE FROM ASSUNTOS WHERE CODIGO = ?");
        ps.setInt(1, _codPesquisa);

        int n = ps.executeUpdate();
        ps.close();

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }
 
     public Assunto consultaUmAssunto(Connection _conn, int _codPesquisa) throws SQLException {
        Assunto assunto = null;
        PreparedStatement ps = _conn.prepareStatement("SELECT * FROM ASSUNTOS WHERE CODIGO = ?");
        ps.setInt(1, _codPesquisa);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            assunto = new Assunto(rs.getInt("CODIGO"), rs.getString("DESCRICAO"));
        } else {
            throw new SQLException("Assunto não encontrado!!!");
        }
        ps.close();

        return assunto;
    }   
    
    public static ArrayList<Assunto> consultaListaAssuntos(Connection _conn) {
        ArrayList<Assunto> listaAssuntos = new ArrayList<>();
        try {
            PreparedStatement ps = _conn.prepareStatement("SELECT CODIGO, DESCRICAO FROM ASSUNTOS ORDER BY DESCRICAO", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                listaAssuntos.add(new Assunto(rs.getInt("CODIGO"), rs.getString("DESCRICAO")));
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Assunto", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaAssuntos;
    }    
 }