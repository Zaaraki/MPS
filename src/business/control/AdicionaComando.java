package business.control;

import java.util.HashMap;

import Exc.UserLoginException;
import business.model.User;
import infra.Arquivo;
import infra.InfraException;

public class AdicionaComando implements ComandoIF {
	
	String senha;
	String login;
	protected static HashMap<String, User> catraca = new HashMap<>();
	
	public AdicionaComando(String login,String senha) {
		this.login = login;
		this.senha = senha;
		try {
			catraca = Arquivo.load();
		}
		catch(InfraException ex) {
			catraca = null;
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
		User u = new User(login, senha);
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
