package business;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import Exc.MementoException;
import Exc.UserLoginException;
import Exc.UserPassException;
import business.control.ComandoIF;
import business.control.MemCaretaker;
import business.model.User;
import infra.Arquivo;
import infra.InfraException;

public class UserManager {

	protected static HashMap<String, User> catraca = new HashMap<>();
	MemCaretaker mem;
	
	public UserManager() {
		mem = new MemCaretaker();
	}

	public void add(String login, String senha) throws UserLoginException, UserPassException, InfraException {

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

		User u = new User(login, senha);

		catraca.put(login, u);

		try {
			Arquivo.save(catraca); // Salva arquivo
		} catch (InfraException ex) {
			catraca.remove(login); // se der erro, exclui login
			throw ex;
		}
	}

	public void del(String login) throws UserLoginException, UserPassException, InfraException {
		User temp;
		loginExiste(login);
		temp = catraca.remove(login);

		try {
			Arquivo.save(catraca); // Salva arquivo
		} catch (InfraException ex) {
			catraca.put(login, temp); // se der erro, recoloca na memoria
			throw ex;
		}
	}

	

	public void buscaUsuario(String login) {

		for (User cliente : catraca.values()) {

			if (cliente.getLogin().equals(login)) {
				// System.out.println(cliente);
				JOptionPane.showMessageDialog(null, cliente);
				break;

			}

		}

	}

	public void buscaTodosUsuarios() {

		for (User cliente : catraca.values()) {

			System.out.println(cliente);

		}

	}

	public void buscaContasDeUmUsuario(String cpf) {

		for (Entry<String, User> cliente : catraca.entrySet()) {

			if (cliente.getValue().getSenha().equals(cpf)) {

				System.out.println(cliente.getKey());

			}

		}


	}

	public void iniciaSistema() throws InfraException {
		catraca = Arquivo.load();
	}

	public int contaNum(String senha) {
		int cont = 0;
		for (int i = 0; i < senha.length(); i++) {
			if (Character.isDigit(senha.charAt(i)))
				cont++;
		}
		return cont;
	}

	protected static void loginExiste(String login) throws UserLoginException {
		if (!catraca.containsKey(login)) {
			throw new UserLoginException("Login inexistente");
		}
	}
	
	public void Invoker(ComandoIF c) throws Exception {
		
		
		try {
			mem = c.execute(mem);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void Undo() throws MementoException, InfraException {
		//catraca = mem.getUltimoEstadoSalvo().getMapa();
		
		try {
			catraca = Arquivo.loadMemento();
			Arquivo.save(catraca); // Salva arquivo
		} catch (InfraException ex) {
			throw ex;
		}
	}

}
