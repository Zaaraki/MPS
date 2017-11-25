package business.model;

import java.io.Serializable;

public class User implements Serializable {

	String login;
	String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String cpf) {
		this.senha = cpf;
	}

	public User(String login, String senha) {

		this.login = login;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", senha=" + senha + "]";
	}

}
