package business.control;

import java.util.ArrayList;
import Exc.MementoException;

public class MemCaretaker {

	protected ArrayList<MapaMemento> mapas;
	
	public MemCaretaker() {
		mapas = new ArrayList<MapaMemento>();
	}
		
	
	
	public void AdicionarMemento(MapaMemento m) {
		mapas.add(m);
	}
	
	public MapaMemento getUltimoEstadoSalvo() throws MementoException {
        if (mapas.size() <= 0) {
            throw new MementoException();
        }
        MapaMemento estadoSalvo = mapas.get(mapas.size() - 1);
        mapas.remove(mapas.size() - 1);
        return estadoSalvo;
    }

}
