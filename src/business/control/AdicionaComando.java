package business.control;

import java.util.HashMap;

import javax.swing.JOptionPane;

import Exc.UserLoginException;
import business.model.Fabrica;
import business.model.FabricaUsuario;
import business.model.User;
import infra.Arquivo;
import infra.InfraException;

public class AdicionaComando implements ComandoIF {
	
	String senha;
	String login;
	int idade;
	int cpf;
	Fabrica f;
	protected static HashMap<String, User> catraca = new HashMap<>();
	
	public AdicionaComando(String login,String senha, int cpf , int idade) {
		this.login = login;
		this.senha = senha;
		this.cpf = cpf;
		this.idade= idade;
		f = new FabricaUsuario();
		try {
			catraca = Arquivo.load();
			
		}
		catch(InfraException ex) {
			catraca = new HashMap<>();
		}
		
	}
	@Override
	public MemCaretaker execute(MemCaretaker mem) throws Exception {
	
		if (login.length() > 24)
			throw new UserLoginException("Login excede 24 caracteres");

		else if (login.isEmpty())
			throw new UserLoginException("Login vazio");

		else if (login.matches(".*\\d.*"))
			throw new UserLoginException("Login não deve conter numeros");

		else if (senha.length() > 20)
			throw new UserLoginException("Senha excede 20 caracteres");

		else if (senha.length() < 8)
			throw new UserLoginException("Senha deve possuir mais de 8 caracteres");

		else if (!senha.matches(".*\\d.*") && !senha.matches(".*\\c.*"))
			throw new UserLoginException("Senha invalida");

		else if (contaNum(senha) < 2)
			throw new UserLoginException("Senha deve ter ao menos 2 numeros");
		HashMap<String, User> catraca2 = (HashMap<String, User>) catraca.clone();
		mem.AdicionarMemento(new MapaMemento(catraca2));
		//idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade: "));
		//cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite o cpf: "));
		
		User u = f.CriarUser();
		u.setCpf(cpf);
		System.out.println(cpf);
		System.out.println(idade);
		u.setIdade(idade);
		u.setLogin(login);
		u.setSenha(senha);
		catraca.put(login, u);

		try {
			Arquivo.save(catraca); // Salva arquivo
		} catch (InfraException ex) {
			catraca.remove(login); // se der erro, exclui login
			throw ex;
		}
		return mem;
		
	}
	
	public int contaNum(String senha) {
		int cont = 0;
		for (int i = 0; i < senha.length(); i++) {
			if (Character.isDigit(senha.charAt(i)))
				cont++;
		}
		return cont;
	}
	
	

}
