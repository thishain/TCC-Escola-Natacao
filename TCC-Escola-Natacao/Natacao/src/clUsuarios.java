
import javax.swing.JTable;


/**
 * 
 * @author Thiago C. da Silva
 */
public class clUsuarios {
    
    private int ID;
    private String login;
    private String senha;
    private String email;
    private String nome;
    private String pesquisa;
   

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String Senha) {
        this.senha = Senha;
    }
      
    public String getEmail() {
        return email;
    }
      
    public void setEmail(String Email) {
        this.email = Email;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String Nome) {
        this.nome = Nome;
    }
    
    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String Pesquisa) {
        this.pesquisa = Pesquisa;
    }
    
    public void PesuisaUsuarios(int ID) {
        UsuariosSQL objSQL = new UsuariosSQL();
        objSQL.PesuisaUsuario(this, ID);
    }
    
    public void PesquisaUsuarios(JTable grid) {
        UsuariosSQL objSQL = new UsuariosSQL();
        objSQL.PesquisarUsuario(grid);
    }
    
    public void Salvar() {
        UsuariosSQL objSQL = new UsuariosSQL();
        objSQL.Salvar(this);
    }
    

    
}
