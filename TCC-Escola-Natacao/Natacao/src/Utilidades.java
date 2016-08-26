
import Conexao.Conexao;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiago
 */
public class Utilidades {
        
        
        public void fecharForm()
        {
        String message = "Deseja realmente fehcar o programa?";
        String title = "Confirmação";
        //Exibe caixa de dialogo (veja figura) solicitando confirmação ou não. 
        //Se o usuário clicar em "Sim" retorna 0 pra variavel reply, se informado não retorna 1
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {                      
                System.exit(0);              
            }
            else
            {

            }
        
        }
        
    
}
