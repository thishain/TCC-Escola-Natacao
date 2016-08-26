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
    
    public void Conexao() {
    try {
        
        Class.forName("org.firebirdsql.jdbc.FBDriver");
        
        con = DriverManager.getConnection("jdbc:firebirdsql://127.0.0.1/"
                + "C:\\Users\\Thiago\\Desktop\\Polivalente\\Java 3S - Billy\\TCC-Escola-Natacao\\TCC-Escola-Natacao\\Natacao\\ESCOLANATACAO.fdb?lc_ctype=WIN1252","SYSDBA","masterkey");   
        stm = con.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao banco!" + ex.getMessage());
        }   
    }
    
    public void executaSQL(String sql) {
        try {
            //Faz a pesquisa no banco e diferencia maiusculas de minusculas.
            stm = con.createStatement();
            resultado = stm.executeQuery(sql);
        } catch (SQLException ex) {
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

