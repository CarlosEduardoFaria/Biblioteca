package biblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Revista extends Publicacao {

    private ArrayList<Artigo> artigos;
    
    public ArrayList<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(ArrayList<Artigo> _artigos) {
        artigos = _artigos;
    }
    
    public Revista(){
    }
    
    public Revista(int _codigo, String _titulo, Editor _editor, ArrayList<Artigo> _artigos){
      super(_codigo, _titulo, _editor);
      this.artigos = _artigos;
    }    
    
    public int inclui(Connection _conn) throws SQLException {
        String sql = "INSERT INTO REVISTAS (DATA_INSERCAO) VALUES " + new java.sql.Date(new Date().getTime());
        PreparedStatement ps = _conn.prepareStatement("INSERT INTO REVISTAS (DATA_INSERCAO) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        Date dataAgora = new Date();
        ps.setDate(1, new java.sql.Date(dataAgora.getTime()));
        ps.execute();
        
        ResultSet rs = ps.getGeneratedKeys();
        int generatedKey = 0;
        
        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }
        ps.close();
        incluiAuxiliar(_conn, generatedKey, artigos);
                
        return generatedKey;
    }
    
    public void incluiAuxiliar(Connection _conn, int _codigoLivroGravado, ArrayList<Artigo> _artigos) throws SQLException {
        PreparedStatement ps = null;
        for (Artigo _artigo : _artigos) {
            ps = _conn.prepareStatement("INSERT INTO REVISTA_ARTIGOS (CODIGO_REVISTA, CODIGO_ARTIGO) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, _codigoLivroGravado);
            ps.setInt(2, _artigo.getCodigo());
            ps.execute();
        }
        if (ps != null) {
            ps.close();   
        }
    }  
 } 



