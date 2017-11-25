package business.control;

import java.util.HashMap;

import business.model.User;
import infra.Arquivo;
import infra.InfraException;

public class BuscaTodosComando implements ComandoIF {

	protected static HashMap<String, User> catraca = new HashMap<>();
	
	public BuscaTodosComando() {
		try {
			catraca = Arquivo.load();
		}
		catch(InfraException ex) {
			
		}
	}
	@Override
	public MemCaretaker execute(MemCaretaker mem) throws Exception {
		for (User cliente : catraca.values()) {

			System.out.println(cliente);

		}
		return mem;

	}

}
