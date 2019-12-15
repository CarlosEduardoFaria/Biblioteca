package biblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Livro extends Publicacao {

    private Assunto assunto;
    private ArrayList<Autor> autores;

    public Livro(){
    }
    
    public Livro(int _codigo, String _titulo, Editor _editor, Assunto _assunto, ArrayList<Autor> _autores) {
        super(_codigo, _titulo, _editor);
        this.assunto = _assunto;
        this.autores = _autores;
    }    

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto _assunto) {
        assunto = _assunto;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> _autores) {
        autores = _autores;
    }
    
    public int inclui(Connection _conn) throws SQLException {
        //Grava um Nova Publicação e pega o ID (Codigo)
        int codigoPublicacaoGravada = super.inclui(_conn);

        //Grava o Livro usando a ID/Código da Publicação (Super) Gravada.
        PreparedStatement ps = _conn.prepareStatement("INSERT INTO LIVROS (CODIGO, CODIGO_ASSUNTO) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, codigoPublicacaoGravada);
        ps.setInt(2, assunto.getCodigo());
        ps.execute();
        
        ResultSet rs = ps.getGeneratedKeys();
        int generatedKey = 0;
        
        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }
        ps.close();

        return generatedKey;
    }  

    public void incluiAuxiliar(Connection _conn, int _codigoLivroGravado, ArrayList<Autor> _autores) throws SQLException {
        PreparedStatement ps = null;
        for (Autor _autor : _autores) {
            ps = _conn.prepareStatement("INSERT INTO LIVROS_AUTORES (CODIGO_AUTOR, CODIGO_LIVRO) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, _autor.getCodigo());
            ps.setInt(2, _codigoLivroGravado);
            ps.execute();
        }
        if (ps != null) {
            ps.close();   
        }
    }
    
    public boolean altera(Connection _conn) throws SQLException {
        super.altera(_conn);
        
        PreparedStatement ps = _conn.prepareStatement("UPDATE LIVROS SET CODIGO_ASSUNTO = ? WHERE CODIGO = ?");
        ps.setInt(1, assunto.getCodigo());
        ps.setInt(2, codigo);

        int n = ps.executeUpdate();
        ps.close();

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }  
    
    public boolean exclui(Connection _conn, int codPesquisa) throws SQLException {
        excluiAuxiliar(_conn, codigo);
        PreparedStatement ps = _conn.prepareStatement("DELETE FROM LIVROS WHERE CODIGO = ?");
        ps.setInt(1, codPesquisa);

        int n = ps.executeUpdate();
        ps.close();
        //Deletar também o Agente SuperClasse
        super.exclui(_conn, codPesquisa);        

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    } 
    
    public boolean excluiAuxiliar(Connection _conn, int codPesquisa) throws SQLException {
        PreparedStatement ps = _conn.prepareStatement("DELETE FROM LIVROS_AUTORES WHERE CODIGO_LIVRO  = ?");
        ps.setInt(1, codPesquisa);

        int n = ps.executeUpdate();
        ps.close();        

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }        

    public Livro consultaUmLivro(Connection _conn, int codPesquisa) throws SQLException {
        ArrayList<Integer> codigosAutores = Autor.consultaListaCodigosAutoresPorCodigoLivro(_conn, codPesquisa);
        Livro livro = null;
        PreparedStatement ps = _conn.prepareStatement("SELECT l.CODIGO, l.CODIGO_ASSUNTO, p.TITULO, p.CODIGO_EDITOR FROM LIVROS l LEFT JOIN PUBLICACOES p ON l.CODIGO = p.CODIGO WHERE l.CODIGO = ?");
 
        ps.setInt(1, codPesquisa);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next())
        {
            livro = new Livro(rs.getInt("CODIGO"), 
                              rs.getString("TITULO"), 
                              new Editor().consultaUmEditor(_conn, rs.getInt("CODIGO_EDITOR")),
                              new Assunto().consultaUmAssunto(_conn, rs.getInt("CODIGO_ASSUNTO")),
                              Autor.consultaListaAutoresPorCodigos(_conn, codigosAutores));
        } else {
            throw new SQLException("Livro não encontrado!!!");
        }
        ps.close();
        
        return livro;
    }
    
    public static ArrayList<Livro> consultaListaLivros(Connection _conn) {
        ArrayList<Integer> codigosAutores = null;
        ArrayList<Livro> listaLivros = new ArrayList<>();
        try {
            PreparedStatement ps = _conn.prepareStatement("SELECT l.CODIGO, p.TITULO, l.CODIGO_ASSUNTO, p.CODIGO_EDITOR FROM LIVROS l LEFT JOIN PUBLICACOES p ON l.CODIGO = p.CODIGO ORDER BY p.TITULO", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                codigosAutores = new ArrayList<>();
                codigosAutores = Autor.consultaListaCodigosAutoresPorCodigoLivro(_conn, rs.getInt("CODIGO"));
                
                listaLivros.add(new Livro(rs.getInt("CODIGO"), 
                                rs.getString("TITULO"), 
                                new Editor().consultaUmEditor(_conn, rs.getInt("CODIGO_EDITOR")),
                                new Assunto().consultaUmAssunto(_conn, rs.getInt("CODIGO_ASSUNTO")),
                                Autor.consultaListaAutoresPorCodigos(_conn, codigosAutores)));
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Livro", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaLivros;
    }
    
    public static ArrayList<Editor> consultaListaEditoresDoLivro(Connection _conn, int _codigoLivro) {
        ArrayList<Editor> listaEditores = new ArrayList<>();
        try {
            PreparedStatement ps = _conn.prepareStatement("SELECT * FROM LIVROS_AUTORES WHERE c = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, _codigoLivro);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                listaEditores.add(new Editor(rs.getInt("CODIGO"), rs.getString("NOME")));
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Livro", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaEditores;
    }    
}
