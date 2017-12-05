package business.control;



import business.model.User;

public class OrdenadorIdade extends OrdenadorTemplate {

	public  boolean Ordem(User a,User b) {
		if(a.getIdade()<b.getIdade())
			return true;
		else
			return false;
	};


	
	}


