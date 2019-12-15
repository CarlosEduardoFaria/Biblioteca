package biblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Agente {

    protected int codigo;

    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int _codigo) {
        this.codigo = _codigo;
    }    
        
    public Agente() {
    }

    public Agente(int _codigo) {
        this.codigo = _codigo;
    }

    public int inclui(Connection _conn) throws SQLException {
        PreparedStatement ps = _conn.prepareStatement("INSERT INTO AGENTES (DATA_INSERCAO) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        Date dataAgora = new Date();
        ps.setDate(1, new java.sql.Date(dataAgora.getTime()));
        ps.execute();
        
        ResultSet rs = ps.getGeneratedKeys();
        int generatedKey = 0;
        
        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }
        ps.close();
        
        return generatedKey;
    }
    
    public boolean exclui(Connection _conn, int _codPesquisa) throws SQLException {
        PreparedStatement ps = _conn.prepareStatement("DELETE FROM AGENTES WHERE CODIGO = ?");
        ps.setInt(1, _codPesquisa);

        int n = ps.executeUpdate();
        ps.close();

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }    
}