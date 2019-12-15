package biblioteca;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class Autor extends Agente {

    private String nome;
    private String sobrenome;

    public String getNome() {
        return nome;
    }

    public void setNome(String _nome) {
        this.nome = _nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String _sobrenome) {
        this.sobrenome = _sobrenome;
    }

    public Autor() {
    }

    public Autor(int _codigo, String _nome, String _sobrenome) {
        super(_codigo);
        this.nome = _nome;
        this.sobrenome = _sobrenome;
    }

    public int inclui(Connection _conn) throws SQLException {
        //Grava um Novo Agente e pega o ID (Codigo)
        int codigoAgenteGravado = super.inclui(_conn);

        //Grava o Autor usando a ID/Código do Agente (Super) Gravado.
        PreparedStatement ps = _conn.prepareStatement("INSERT INTO AUTORES (CODIGO, NOME, SOBRENOME) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, String.valueOf(codigoAgenteGravado));
        ps.setString(2, nome);
        ps.setString(3, sobrenome);
        
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        int generatedKey = 0;
        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }
        ps.close();
        
        return generatedKey;
    }

    public boolean altera(Connection _conn) throws SQLException {
        PreparedStatement ps = _conn.prepareStatement("UPDATE AUTORES SET NOME = ?, SOBRENOME = ? WHERE CODIGO = ?");
        ps.setString(1, nome);
        ps.setString(2, sobrenome);
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
        PreparedStatement ps = _conn.prepareStatement("DELETE FROM AUTORES WHERE CODIGO = ?");
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

    public Autor consultaUmAutor(Connection _conn, int codPesquisa) throws SQLException {
        Autor autor = null;
        PreparedStatement ps = _conn.prepareStatement("SELECT * FROM AUTORES WHERE CODIGO = ?");
        ps.setInt(1, codPesquisa);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            autor = new Autor(rs.getInt("CODIGO"), rs.getString("NOME"), rs.getString("SOBRENOME"));
        } else {
            throw new SQLException("Autor não encontrado!!!");
        }
        ps.close();

        return autor;
    }

    public static ArrayList<Autor> consultaListaAutores(Connection _conn) {
        ArrayList<Autor> listaAutores = new ArrayList<>();
        try {
            PreparedStatement ps = _conn.prepareStatement("SELECT CODIGO, NOME, SOBRENOME FROM AUTORES ORDER BY NOME", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                listaAutores.add(new Autor(rs.getInt("CODIGO"), rs.getString("NOME"), rs.getString("SOBRENOME")));
            }
            ps.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Autor", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaAutores;
    }
    
    public static ArrayList<Integer> consultaListaCodigosAutoresPorCodigoLivro(Connection _conn, int _codigoLivro){
        ArrayList<Integer> listaCodigoAutores = new ArrayList<>();
        try {
            PreparedStatement ps = _conn.prepareStatement("SELECT CODIGO, CODIGO_AUTOR, CODIGO_LIVRO FROM LIVROS_AUTORES WHERE CODIGO_LIVRO = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, _codigoLivro);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                listaCodigoAutores.add(rs.getInt("CODIGO_AUTOR"));
            }
            ps.close();            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Autor", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaCodigoAutores;
    }
    
    public static ArrayList<Integer> consultaListaCodigosAutoresPorCodigoArtigo(Connection _conn, int _codigoArtigo){
        ArrayList<Integer> listaCodigoAutores = new ArrayList<>();
        try {
            PreparedStatement ps = _conn.prepareStatement("SELECT CODIGO, CODIGO_AUTOR, CODIGO_ARTIGO FROM ARTIGOS_AUTORES WHERE CODIGO_ARTIGO = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setInt(1, _codigoArtigo);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                listaCodigoAutores.add(rs.getInt("CODIGO_AUTOR"));
            }
            ps.close();            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Autor", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaCodigoAutores;
    }    
    
    public static ArrayList<Autor> consultaListaAutoresPorCodigos(Connection _conn, ArrayList<Integer> _codigosAutores) {
        ArrayList<Autor> listaAutores = new ArrayList<>();
        try {
            String sql = "SELECT CODIGO, NOME, SOBRENOME FROM AUTORES WHERE CODIGO IN (" +  _codigosAutores.toString().replace("[", "").replace("]", "") +  ") ORDER BY NOME";
            PreparedStatement ps = _conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                listaAutores.add(new Autor(rs.getInt("CODIGO"), rs.getString("NOME"), rs.getString("SOBRENOME")));
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Editor", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaAutores;
    }    
}
