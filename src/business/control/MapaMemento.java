package business.control;

import java.util.HashMap;

import business.model.User;

public class MapaMemento {

	protected HashMap<String, User> estadoMapa;
	
	public MapaMemento(HashMap<String, User> m) {
		estadoMapa = m;
	}
	
	public HashMap<String, User> getMapa(){
		return estadoMapa;
	}

}
