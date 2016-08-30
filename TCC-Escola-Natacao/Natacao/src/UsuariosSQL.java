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
    
    
    public void Salvar(clUsuarios usu) {
        Conectar();
        try {
            
            PreparedStatement pst = con.prepareStatement("INSERT INTO USUARIOS (LOGIN, SENHA, NOME, EMAIL) VALUES (?, ?, ?, ?)");
            pst.setString(1, usu.getLogin());
            pst.setString(2, usu.getSenha());
            pst.setString(3, usu.getNome());
            pst.setString(4, usu.getEmail());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!" + ex);
        }
        
        DesconectaDB();

    }
    
    public void PesuisaUsuario(JTable grid, String pesquisa) {
        Conectar();
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
//        executaSQL( "SELECT *       " +
//                    "FROM USUARIOS  " +
//                    "WHERE CODUSUARIO = " + (pesquisa)
//                    );
        executaSQL("SELECT *      " +
                   "FROM USUARIOS " +
                   "WHERE LOGIN LIKE '%" + (pesquisa) + "%'"
                    //"OR CODUSUARIO = '" + (pesquisa) + "'" 
                    );
                     
            try {
                    while (jTabela.getRowCount() > 0) {
                jTabela.removeRow(0);
            }
    
            while (resultado.next()) {
                jTabela.addRow(new Object[]{resultado.getObject("CODUSUARIO").toString(),
                                            resultado.getObject("LOGIN").toString(),
                                            resultado.getObject("SENHA").toString(),
                                            resultado.getObject("NOME").toString(),
                                            resultado.getObject("EMAIL").toString()});
            }

                } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado \n Pesquise por outro LOGIN!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            DesconectaDB();
    
    }
   
    
        public void PesquisarUsuario(JTable grid) {
        Conectar();
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
        executaSQL("SELECT * FROM USUARIOS ORDER BY CODUSUARIO");
        try {
            while (jTabela.getRowCount() > 0) {
                jTabela.removeRow(0);
            }
    
            while (resultado.next()) {
                jTabela.addRow(new Object[]{resultado.getObject("CODUSUARIO").toString(),
                                            resultado.getObject("LOGIN").toString(),
                                            resultado.getObject("SENHA").toString(),
                                            resultado.getObject("NOME").toString(),
                                            resultado.getObject("EMAIL").toString()});           
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        DesconectaDB();
    }
        
        public void EditarUsuario(clUsuarios usu) {
            Conectar();         
        try {
                PreparedStatement pst = con.prepareStatement("UPDATE USUARIOS SET LOGIN = ?, SENHA = ?, NOME = ?, EMAIL = ? WHERE CODUSUARIO = ?");
                pst.setString(1, usu.getLogin());
                pst.setString(2, usu.getSenha());
                pst.setString(3, usu.getNome());
                pst.setString(4, usu.getEmail());
                pst.setInt(5, usu.getID());
                pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!", "Erro", JOptionPane.ERROR_MESSAGE);

            }  
            DesconectaDB();
        }
        
        public void ExcluirUsuario(clUsuarios usu) {
            Conectar();
            try {
                PreparedStatement pst = con.prepareStatement("DELETE FROM USUARIOS WHERE CODUSUARIO =?");
                pst.setInt(1, usu.getID());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na exclusão dos dados!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
       
            DesconectaDB();
        }
        
        public void PesquisaUsuarioUnico(JTable grid, int ID) {
        Conectar();
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
        executaSQL("SELECT *      " +
                   "FROM USUARIOS " +
                   "WHERE CODUSUARIO = '" + (ID) + "'"           
                   //"WHERE LOGIN LIKE '%" + (pesquisa) + "%'" +
                   //"OR LOGIN = '" + (pesquisa) + "'"  
                   );
        try {
            while (jTabela.getRowCount() > 0) {
                jTabela.removeRow(0);
            }
    
            while (resultado.next()) {
                jTabela.addRow(new Object[]{resultado.getObject("CODUSUARIO").toString(),
                                            resultado.getObject("LOGIN").toString(),
                                            resultado.getObject("SENHA").toString(),
                                            resultado.getObject("NOME").toString(),
                                            resultado.getObject("EMAIL").toString()});                
            }                   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        DesconectaDB();
    }

}
