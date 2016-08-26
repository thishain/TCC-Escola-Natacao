/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * 
 * @author Thiago C. da Silva
 */
public class Conexao {
    
    public ResultSet resultado;
    public Connection con = null;
    public Statement stm = null;
    
    public Conexao() {
    try {
        
        Class.forName("org.firebirdsql.jdbc.FBDriver");
        
        con = DriverManager.getConnection("jdbc:firebirdsql://127.0.0.1/"
                + "C:/ESCOLANATACAO.fdb?lc_ctype=WIN1252","SYSDBA","masterkey");
        stm = con.createStatement();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getStackTrace(), "Não foi possivel conectar ao banco!"
                , JOptionPane.ERROR_MESSAGE);
    }   
    }
    
}

