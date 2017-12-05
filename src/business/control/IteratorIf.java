package business.control;

import business.model.User;

public interface IteratorIf {
	
	void first();
	 
    void next();
 
    boolean isDone();
 
    User currentItem();
		
	}
	
	


