package biblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Publicacao {
    
    protected int codigo;
    protected String titulo;
    protected Editor editor;
    protected Date data;

    public Publicacao(){
    }
    
    public Publicacao(int _codigo, String _titulo, Editor _editor)
    {
      this.codigo = _codigo;
      this.titulo = _titulo;
      this.editor = _editor;
      this.data = new Date();
    }

    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int _codigo) {
        this.codigo = _codigo;
    }      
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String _titulo) {
        titulo = _titulo;
    }
    
    public Editor getEditor() {
        return editor;
    }
    
    public void setEditor(Editor _editor) {        
        editor = _editor;
    }
    
    public Date getData() {
        return data;
    }
    
    public void setData(Date _data) {        
        data = _data;
    }

    public int inclui(Connection _conn) throws SQLException {
        //String sqlteste = "INSERT INTO PUBLICACOES (TITULO, CODIGO_EDITOR, DATA) VALUES (" + titulo + ", " + editor.codigo + ", " + new java.sql.Date(new Date().getTime()) + ")";
        
        PreparedStatement ps = _conn.prepareStatement("INSERT INTO PUBLICACOES (TITULO, CODIGO_EDITOR, DATA) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, titulo);
        ps.setInt(2, editor.codigo);
        ps.setDate(3, new java.sql.Date(data.getTime()));
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
        PreparedStatement ps = _conn.prepareStatement("UPDATE PUBLICACOES SET CODIGO_EDITOR = ?, TITULO = ? WHERE CODIGO = ?");
        ps.setInt(1, editor.getCodigo());
        ps.setString(2, titulo);
        ps.setInt(3, codigo);

        int n = ps.executeUpdate();
        ps.close();

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean exclui(Connection _conn, int codPesquisa) throws SQLException {
        PreparedStatement ps = _conn.prepareStatement("DELETE FROM PUBLICACOES WHERE CODIGO = ?");
        ps.setInt(1, codPesquisa);

        int n = ps.executeUpdate();
        ps.close();     

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }    
 }

