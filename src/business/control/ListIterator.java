package business.control;

import java.util.HashMap;

import business.model.User;
import infra.Arquivo;
import infra.InfraException;

public class ListIterator implements IteratorIf {
	protected static HashMap<String, User> catraca = new HashMap<>();
	protected int contador;

	public ListIterator() {
		try {
			this.catraca = Arquivo.load();
			contador = 0;

		} catch (InfraException ex) {
			catraca = null;
		}

	}

	public void first() {
		contador = 0;

	}

	public void next() {
		contador++;
	}

	public boolean isDone() {
		return contador == catraca.size();
	}

	public User currentItem() {
		int i = 0;
		for (User cliente : catraca.values()) {
			if (contador == i) {
				return cliente;

			}
			i++;
		}
		return null;

	}

}
