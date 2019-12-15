package biblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PalavraChave {
    private int codigo;
    private int codigoArtigo;
    private String palavra;
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int _codigo) {
        this.codigoArtigo = _codigo;
    }  
    
    public int getCodigoArtigo() {
        return codigo;
    }
    
    public void setCodigoArtigo(int _codigoArtigo) {
        this.codigoArtigo = _codigoArtigo;
    }     
       
    public String getPalavra() {
        return palavra;
    }
    
    public void setPalavra(String _palavra) {
        palavra = _palavra;
    }
    
    public PalavraChave() {
    }

    public PalavraChave(int _codigo, int _codigoArtigo, String _palavra) {
        this.codigo = _codigo;
        this.codigoArtigo = _codigoArtigo;
        this.palavra = _palavra;
    }    
    
    public int inclui(Connection _conn) throws SQLException {
        PreparedStatement ps = _conn.prepareStatement("INSERT INTO PALAVRAS_CHAVES (PALAVRA) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, palavra);
        ps.execute();
        
        ResultSet rs = ps.getGeneratedKeys();
        int generatedKey = 0;
        
        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }
        ps.close();
        
        return generatedKey;
    }
    
    public void incluiLista(Connection _conn, int codigoArtigoGravado, ArrayList<String> palavrasChaves) throws SQLException {
        String palavras = "";
        
        for (String palavrasChave : palavrasChaves) {
            if (palavrasChave == palavrasChaves.get(0)) {
                palavras += "(" + codigoArtigoGravado + ", '" + palavrasChave + "')";
            }else {
                palavras += ", (" + codigoArtigoGravado + ", '" + palavrasChave + "')";
            }
        }
        
        String sql = "INSERT INTO PALAVRAS_CHAVES (CODIGO_ARTIGO, PALAVRA) VALUES " + palavras;
        PreparedStatement ps = _conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.execute();
        ps.close();
    }    
    
    public boolean altera(Connection _conn) throws SQLException {
        PreparedStatement ps = _conn.prepareStatement("UPDATE PALAVRAS_CHAVES SET PALAVRA = ? WHERE CODIGO = ?");
        ps.setString(1, palavra);
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
        PreparedStatement ps = _conn.prepareStatement("DELETE FROM PALAVRAS_CHAVES WHERE CODIGO = ?");
        ps.setInt(1, _codPesquisa);

        int n = ps.executeUpdate();
        ps.close();

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }
 
     public PalavraChave consultaUmaPalavraChave(Connection _conn, int _codPesquisa) throws SQLException {
        PalavraChave palavraChave = null;
        PreparedStatement ps = _conn.prepareStatement("SELECT * FROM PALAVRAS_CHAVES WHERE CODIGO = ?");
        ps.setInt(1, _codPesquisa);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            palavraChave = new PalavraChave(rs.getInt("CODIGO"), rs.getInt("CODIGO_ARTIGO"), rs.getString("PALAVRA"));
        } else {
            throw new SQLException("Palavra Chave não encontrado!!!");
        }
        ps.close();

        return palavraChave;
    }   
    
    public static ArrayList<PalavraChave> consultaListaPalavrasChaves(Connection _conn) {
        ArrayList<PalavraChave> listaPalavrasChaves = new ArrayList<>();
        try {
            PreparedStatement ps = _conn.prepareStatement("SELECT CODIGO, CODIGO_ARTIGO, PALAVRA FROM PALAVRAS_CHAVES ORDER BY PALAVRA", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                listaPalavrasChaves.add(new PalavraChave(rs.getInt("CODIGO"), rs.getInt("CODIGO_ARTIGO"), rs.getString("PALAVRA")));
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Palavra Chave", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaPalavrasChaves;
    }   
    
    public static ArrayList<PalavraChave> consultaListaPalavrasChavesPorCodigoArtigo(Connection _conn, int codigoArtigo) {
        ArrayList<PalavraChave> listaPalavrasChaves = new ArrayList<>();
        try {
            PreparedStatement ps = _conn.prepareStatement("SELECT CODIGO, CODIGO_ARTIGO, PALAVRA FROM PALAVRAS_CHAVES WHERE CODIGO_ARTIGO = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, codigoArtigo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                listaPalavrasChaves.add(new PalavraChave(rs.getInt("CODIGO"), rs.getInt("CODIGO_ARTIGO"), rs.getString("PALAVRA")));
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Palavra Chave", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaPalavrasChaves;
    }      
} 
