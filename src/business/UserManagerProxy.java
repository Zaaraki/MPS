package business;

import javax.swing.JOptionPane;

import Exc.UserLoginException;
import Exc.UserPassException;
import infra.InfraException;

public class UserManagerProxy extends UserManager {
	
	String User,Senha;
	
	public UserManagerProxy(){
		super();
	}
	
	private boolean temPermissaoDeAcesso() {
        return User == "admin" && Senha == "admin123";
    }
	
	public void del(String login) throws UserLoginException, UserPassException, InfraException{
		if(temPermissaoDeAcesso()) {
			super.del(login);
		}
		else {
			JOptionPane.showMessageDialog(null,"Você não é Administrador!");
		}
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}
	
}
