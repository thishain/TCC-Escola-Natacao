import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Thiago C. da Silva
 */
public class UsuariosSQL extends Conexao{
    
        Conexao conex = new Conexao();
        clUsuarios usu = new clUsuarios();
    
     public void Salvar(clUsuarios usu) {
        conex.Conexao();   
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO USUARIOS (LOGIN, SENHA, NOME, EMAIL) VALUES (?, ?, ?, ?)");
            pst.setString(1, usu.getLogin());
            pst.setString(2, usu.getSenha());
            pst.setString(3, usu.getNome());
            pst.setString(4, usu.getEmail());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!" + ex);
        }

    }
    
    public void PesuisaUsuario(clUsuarios usu, int id) {
            try {
                //conex.executaSQL("SELECT * FROM USUARIOS WHERE LOGIN LIKE '%" + usu.getPesquisa() + "%'");
                //conex.executaSQL("SELECT * FROM USUARIOS");
                resultado = stm.executeQuery(
                    "SELECT *         " +
                    "FROM USUARIOS    " +
                    "WHERE CODUSUARIO = " + String.valueOf(id)
                    );

            if (resultado.next()) {
            usu.setID(Integer.parseInt(resultado.getObject("CODUSUARIO").toString()));
            usu.setLogin(resultado.getObject("LOGIN").toString());
            usu.setSenha(resultado.getObject("SENHA").toString());
            usu.setNome(resultado.getObject("NOME").toString());
            usu.setEmail(resultado.getObject("EMAIL").toString());
            }
            
            else 
            {
                JOptionPane.showMessageDialog(null, "ERRO DO CARALHO!");
            }
 
            stm.close(); 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
   
    
       
    }
    
     public void PesquisarUsuario(JTable grid) {
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
        try {
            while (jTabela.getRowCount() > 0) {
                jTabela.removeRow(0);
            }
            conex.resultado = stm.executeQuery("SELECT * FROM USUARIOS");
            
            while (conex.resultado.next()) {
                jTabela.addRow(new Object[]{conex.resultado.getObject("CODUSUARIO").toString(),
                                            conex.resultado.getObject("NOME").toString(),
                                            conex.resultado.getObject("LOGIN").toString(),
                                            conex.resultado.getObject("SENHA").toString(),
                                            conex.resultado.getObject("EMAIL").toString()});
            }
            
            conex.stm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuários!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
