package business.control;

import java.util.HashMap;
import java.util.Map.Entry;

import business.model.User;
import infra.Arquivo;
import infra.InfraException;

public class BuscaContasComando implements ComandoIF {

	protected static HashMap<String, User> catraca = new HashMap<>();
	String cpf;
	
	public BuscaContasComando(String cpf) {
		
		this.cpf = cpf;
		try {
			catraca = Arquivo.load();
		}
		catch(InfraException ex) {
			
		}
	}

	@Override
	public MemCaretaker execute(MemCaretaker mem) throws Exception {
		for (Entry<String, User> cliente : catraca.entrySet()) {

			if (cliente.getValue().getSenha().equals(cpf)) {

				System.out.println(cliente.getKey());

			}
			
		}
		return mem;

	}

}
