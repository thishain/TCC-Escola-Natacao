package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * 
 * @author Thiago C. da Silva
 */
public class Conexao {
    
    public ResultSet resultado;
    public Connection con;
    public Statement stm;
    
    public void Conectar() {
    try {
        
        Class.forName("org.firebirdsql.jdbc.FBDriver");
        
        con = DriverManager.getConnection("jdbc:firebirdsql://127.0.0.1:3051/"
                + "C:\\dbe\\ESCOLANATACAO.fdb?lc_ctype=WIN1252","SYSDBA","masterkey");   
        stm = con.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao banco!" + ex.getMessage());
        }   
    }
    
    public void executaSQL(String Sql) {
        try { 
            stm = con.createStatement(resultado.TYPE_SCROLL_INSENSITIVE, resultado.CONCUR_READ_ONLY);
            resultado = stm.executeQuery(Sql);
            
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar SQL!" + ex.getMessage());
        }
    }
    
    public void DesconectaDB() {
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "Desconectado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao! \n" + ex.getMessage());
        }
        
    }
    
    
    
}

