package biblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Artigo extends Publicacao {

    private ArrayList<Autor> autores;
    private ArrayList<PalavraChave> palavrasChaves;
    private ArrayList<String> listapalavras;

    public Artigo(){
    }
    
    public Artigo(int _codigo, String _titulo, Editor _editor, ArrayList<Autor> _autores, ArrayList<PalavraChave> _palavrasChaves){
      super(_codigo, _titulo, _editor);
      this.autores = _autores;
      this.palavrasChaves = _palavrasChaves;
      
      listapalavras = new ArrayList<>();
      for(int i = 0; i < _palavrasChaves.size(); i++){
          listapalavras.add(_palavrasChaves.get(i).getPalavra());
      }
    }  

    public ArrayList<Autor> getAutores() {
        return autores;
    }
    public void setAutores(ArrayList<Autor> _autores) {
        autores = _autores;
    }
    
    public ArrayList<PalavraChave> getPalavrasChaves() {
        return palavrasChaves;
    }
    
    public void setPalavrasChave(ArrayList<PalavraChave> _palavrasChaves) {
        palavrasChaves = _palavrasChaves;
    }  
    
    public ArrayList<String> getListaPalavras(){
        return listapalavras;
    }
    
    public void setListaPalavras(ArrayList<String> _listapalavras){
        this.listapalavras = new ArrayList<>();
        this.listapalavras = _listapalavras;
    }
    
    public int inclui(Connection _conn) throws SQLException {
        //Grava um Nova Publicação e pega o ID (Codigo)
        int codigoPublicacaoGravada = super.inclui(_conn);

        //Grava o Livro usando a ID/Código da Publicação (Super) Gravada.
        PreparedStatement ps = _conn.prepareStatement("INSERT INTO ARTIGOS (CODIGO) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, codigoPublicacaoGravada);
        ps.execute();
        
        ResultSet rs = ps.getGeneratedKeys();
        int generatedKey = 0;
        
        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }
        ps.close();
        incluiAuxiliar(_conn, generatedKey, autores, listapalavras);

        return generatedKey;
    }   
    
    public void incluiAuxiliar(Connection _conn, int _codigoArtigoGravado, ArrayList<Autor> _autores, ArrayList<String> _palavrasChaves) throws SQLException {
        PreparedStatement ps = null;
        PalavraChave palavraChave = new PalavraChave();
        
        for (Autor _autor : _autores) {
            ps = _conn.prepareStatement("INSERT INTO ARTIGOS_AUTORES (CODIGO_AUTOR, CODIGO_ARTIGO) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, _autor.getCodigo());
            ps.setInt(2, _codigoArtigoGravado);
            ps.execute();
        }

        if (_palavrasChaves.size() > 0) {
            palavraChave.incluiLista(_conn, _codigoArtigoGravado, _palavrasChaves);
        }
        
        if (ps != null) {
            ps.close();   
        }
    }    

    public boolean altera(Connection _conn) throws SQLException {
        super.altera(_conn);
        
        
        PreparedStatement ps = _conn.prepareStatement("UPDATE LIVROS SET CODIGO_ASSUNTO = ? WHERE CODIGO = ?");
        ps.setInt(1, 1);
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
        excluiPalavrasChaves(_conn, codigo);
        PreparedStatement ps = _conn.prepareStatement("DELETE FROM ARTIGOS WHERE CODIGO = ?");
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
        PreparedStatement ps = _conn.prepareStatement("DELETE FROM ARTIGOS_AUTORES WHERE CODIGO_ARTIGO  = ?");
        ps.setInt(1, codPesquisa);

        int n = ps.executeUpdate();
        ps.close();        

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }   
    
    public boolean excluiPalavrasChaves(Connection _conn, int codPesquisa) throws SQLException {
        PreparedStatement ps = _conn.prepareStatement("DELETE FROM PALAVRAS_CHAVES WHERE CODIGO_ARTIGO  = ?");
        ps.setInt(1, codPesquisa);

        int n = ps.executeUpdate();
        ps.close();        

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    } 
    
    public Artigo consultaUmArtigo(Connection _conn, int codPesquisa) throws SQLException {
        ArrayList<Integer> codigosAutores = Autor.consultaListaCodigosAutoresPorCodigoArtigo(_conn, codPesquisa);
        Artigo artigo = null;
        PreparedStatement ps = _conn.prepareStatement("SELECT l.CODIGO, p.TITULO, p.CODIGO_EDITOR FROM ARTIGOS l LEFT JOIN PUBLICACOES p ON l.CODIGO = p.CODIGO WHERE l.CODIGO = ?");
 
        ps.setInt(1, codPesquisa);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next())
        {
            artigo = new Artigo(rs.getInt("CODIGO"), 
                              rs.getString("TITULO"), 
                              new Editor().consultaUmEditor(_conn, rs.getInt("CODIGO_EDITOR")),
                              Autor.consultaListaAutoresPorCodigos(_conn, codigosAutores),
                              PalavraChave.consultaListaPalavrasChavesPorCodigoArtigo(_conn, codPesquisa)
            );
        } else {
            throw new SQLException("Artigo não encontrado!!!");
        }
        ps.close();
        
        return artigo;
    }
    
    public static ArrayList<Artigo> consultaListaArtigos(Connection _conn) {
        ArrayList<Integer> codigosArtigos = null;
        ArrayList<Artigo> listaArtigos = new ArrayList<>();
        try {
            PreparedStatement ps = _conn.prepareStatement("SELECT l.CODIGO, p.TITULO, p.CODIGO_EDITOR FROM ARTIGOS l LEFT JOIN PUBLICACOES p ON l.CODIGO = p.CODIGO ORDER BY p.TITULO", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                codigosArtigos = new ArrayList<>();
                codigosArtigos = Autor.consultaListaCodigosAutoresPorCodigoArtigo(_conn, rs.getInt("CODIGO"));
                
                listaArtigos.add(new Artigo(rs.getInt("CODIGO"), 
                                rs.getString("TITULO"), 
                                new Editor().consultaUmEditor(_conn, rs.getInt("CODIGO_EDITOR")),
                                Autor.consultaListaAutoresPorCodigos(_conn, codigosArtigos),
                                PalavraChave.consultaListaPalavrasChavesPorCodigoArtigo(_conn, rs.getInt("CODIGO"))
                ));
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Livro", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaArtigos;
    }
    
//    public static ArrayList<Artigo> consultaListaArtigos(Connection _conn) {
//        ArrayList<Integer> codigosArtigos = null;
//        ArrayList<Artigo> listaArtigos = new ArrayList<>();
//        try {
//            PreparedStatement ps = _conn.prepareStatement("SELECT l.CODIGO, p.TITULO, p.CODIGO_EDITOR FROM ARTIGOS l LEFT JOIN PUBLICACOES p ON l.CODIGO = p.CODIGO ORDER BY p.TITULO", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next()) {
//                codigosArtigos = new ArrayList<>();
//                codigosArtigos = Autor.consultaListaCodigosAutoresPorCodigoArtigo(_conn, rs.getInt("CODIGO"));
//                
//                listaArtigos.add(new Artigo(rs.getInt("CODIGO"), 
//                                rs.getString("TITULO"), 
//                                new Editor().consultaUmEditor(_conn, rs.getInt("CODIGO_EDITOR")),
//                                Autor.consultaListaAutoresPorCodigos(_conn, codigosArtigos),
//                                PalavraChave.consultaListaPalavrasChavesPorCodigoArtigo(_conn, rs.getInt("CODIGO"))
//                ));
//            }
//            ps.close();
//            
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Livro", JOptionPane.ERROR_MESSAGE);
//        }
//        
//        return listaArtigos;
//    } 
    
    public static ArrayList<Artigo> consultaListaArtigosPorRevista(Connection _conn, int _codigoRevista) {
        ArrayList<Artigo> listaArtigos = new ArrayList<>();
//        try {
//            PreparedStatement ps = _conn.prepareStatement("SELECT l.CODIGO, p.TITULO, p.CODIGO_EDITOR FROM REVISTAS l LEFT JOIN PUBLICACOES p ON l.CODIGO = p.CODIGO ORDER BY p.TITULO", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ps.setInt(1, _codigoRevista);
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next()) {
//                ArrayList<Integer> listaCodigosAutores = new ArrayList<>();
//                listaCodigosAutores = consultaListaCodigosAutoresPorCodigoArtigo(_conn, rs.getInt("CODIGO"));
//                listaArtigos.add(new Artigo(rs.getInt("CODIGO"), 
//                                     rs.getString("TITULO"),
//                                     new Editor().consultaUmEditor(_conn, rs.getInt("CODIGO_EDITOR")),
//                                     Autor.consultaListaAutoresPorCodigos(_conn, consultaListaCodigosAutoresPorCodigoArtigo(_conn, rs.getInt("CODIGO")))),
//                                     PalavraChave.consultaListaPalavrasChavesPorCodigoArtigo(_conn, rs.getInt("CODIGO"))
//                ));
//            }
//            ps.close();
//            
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Artigo", JOptionPane.ERROR_MESSAGE);
//        }
        
        return listaArtigos;
    }    
 }



