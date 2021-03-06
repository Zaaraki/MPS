package business.control;

import java.util.HashMap;

import Exc.UserLoginException;
import business.model.User;
import infra.Arquivo;
import infra.InfraException;

public class DeletaComando implements ComandoIF {
	
	String login;
	protected static HashMap<String, User> catraca = new HashMap<>();
	
	public DeletaComando(String login) {
		this.login = login;
		try {
			catraca = Arquivo.load();
		}
		catch(InfraException ex) {
			
		}
	}
	
	@Override
	public MemCaretaker execute(MemCaretaker mem) throws Exception {
		User temp;
		loginExiste(login);
		HashMap<String, User> catraca2 = (HashMap<String, User>) catraca.clone();
		mem.AdicionarMemento(new MapaMemento(catraca2));
		temp = catraca.remove(login);

		try {
			Arquivo.saveMem(catraca2);
			Arquivo.save(catraca); // Salva arquivo
		} catch (InfraException ex) {
			catraca.put(login, temp); // se der erro, recoloca na memoria
			throw ex;
		}
		return mem;

	}
	
	protected static void loginExiste(String login) throws UserLoginException {
		if (!catraca.containsKey(login)) {
			throw new UserLoginException("Login inexistente");
		}
	}

}
