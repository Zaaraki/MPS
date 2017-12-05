package business.control;

import business.model.User;

public class OrdenadorNome extends OrdenadorTemplate {

	public  boolean Ordem(User a,User b) {
		if(a.getLogin().compareTo(b.getLogin())== -1)
			return true;
		else
			return false;
	};


}
