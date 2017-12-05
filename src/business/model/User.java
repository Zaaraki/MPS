package business.model;

import java.io.Serializable;

import business.control.EstadoIf;


public class User implements Serializable {
	
	
	protected EstadoIf estado;
	String login;
	String senha;
	int cpf;
	int idade;

	public User(String login, String senha, int cpf, int idade) {
		super();
		this.login = login;
		this.senha = senha;
		this.cpf = cpf;
		this.idade = idade;
		estado = null;
	}
	
	public User() {
		super();
	};
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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

	public void setSenha(String cpf) {
		this.senha = cpf;
	}
	public void setEstado(EstadoIf estado){
		this.estado = estado;
	}
	public EstadoIf getEstado(){
		return estado;
	}

	public User(String login, String senha) {

		this.login = login;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", senha=" + senha + ", cpf=" + cpf + ", idade=" + idade + "]";
	}

	

}
