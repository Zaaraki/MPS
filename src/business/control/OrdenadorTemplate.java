package business.control;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import business.model.User;

public abstract class OrdenadorTemplate {
	
	public abstract boolean Ordem(User a,User b);

	public HashMap<String, User> Ordenar(HashMap<String, User> mapa) {
		 // Sorting the list based on values
		List<Entry<String, User>> list = new LinkedList<Entry<String, User>>(mapa.entrySet());
       Collections.sort(list, new Comparator<Entry<String, User>>()
       {
           public int compare(Entry<String, User> o1,
                   Entry<String, User> o2)
           {
           	if(Ordem(o1.getValue(),o2.getValue()))
                   return -1;
           	else 
           		return 1;
                
           }
       });

       // Maintaining insertion order with the help of LinkedList
       HashMap<String, User> sortedMap = new LinkedHashMap<String, User>();
       for (Entry<String, User> entry : list)
       {
           sortedMap.put(entry.getKey(), entry.getValue());
       }

       return sortedMap;
   }

}
