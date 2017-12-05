package business.control;

import java.util.HashMap;

import javax.swing.JOptionPane;

import business.model.User;
import infra.Arquivo;
import infra.InfraException;

public class BuscaUsuarioComando implements ComandoIF {
	
	String user;
	protected static HashMap<String, User> catraca = new HashMap<>();
	
	public BuscaUsuarioComando(String user) {
		this.user = user;
		try {
			catraca = Arquivo.load();
		}
		catch(InfraException ex) {
			
		}
	}
	
	@Override
	public MemCaretaker execute(MemCaretaker mem) throws Exception {
		for (User cliente : catraca.values()) {

			if (cliente.getLogin().equals(user)) {
				System.out.println(cliente.toString());
				
				JOptionPane.showMessageDialog(null, cliente);
				break;

			}

		}
		return mem;

	}

}
