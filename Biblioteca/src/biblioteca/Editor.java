package biblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;

public class Editor extends Agente {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String _nome) {
        this.nome = _nome;
    }

    public Editor() {
    }

    public Editor(int _codigo, String _nome) {
        super(_codigo);
        this.nome = _nome;
    }

    public int inclui(Connection _conn) throws SQLException {
        //Grava um Novo Agente e pega o ID (Codigo)
        int codigoAgenteGravado = super.inclui(_conn);

        //Grava o Autor usando a ID/Código do Agente (Super) Gravado.
        PreparedStatement ps = _conn.prepareStatement("INSERT INTO EDITORES (CODIGO, NOME) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, String.valueOf(codigoAgenteGravado));
        ps.setString(2, nome);

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
        PreparedStatement ps = _conn.prepareStatement("UPDATE EDITORES SET NOME = ? WHERE CODIGO = ?");
        ps.setString(1, nome);
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
        PreparedStatement ps = _conn.prepareStatement("DELETE FROM EDITORES WHERE CODIGO = ?");
        ps.setInt(1, _codPesquisa);

        int n = ps.executeUpdate();
        ps.close();
        //Deletar também o Agente SuperClasse
        super.exclui(_conn, _codPesquisa);

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    public Editor consultaUmEditor(Connection _conn, int _codPesquisa) throws SQLException {
        Editor editor = null;
        PreparedStatement ps = _conn.prepareStatement("SELECT * FROM EDITORES WHERE CODIGO = ?");
        ps.setInt(1, _codPesquisa);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            editor = new Editor(rs.getInt("CODIGO"), rs.getString("NOME"));
        } else {
            throw new SQLException("Editor não encontrado!!!");
        }
        ps.close();

        return editor;
    }

    public static ArrayList<Editor> consultaListaEditores(Connection _conn) {
        ArrayList<Editor> listaEditores = new ArrayList<>();
        try {
            PreparedStatement ps = _conn.prepareStatement("SELECT CODIGO, NOME FROM EDITORES ORDER BY NOME", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                listaEditores.add(new Editor(rs.getInt("CODIGO"), rs.getString("NOME")));
            }
            ps.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Editor", JOptionPane.ERROR_MESSAGE);
        }
        
        return listaEditores;
    }
}
