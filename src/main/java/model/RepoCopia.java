package model;

import java.util.HashMap;

import view.Utils;

public class RepoCopia {
	private HashMap<Integer,Copia> ListaCopias;
	Utils u;
	public RepoCopia() {
		ListaCopias = new HashMap<Integer,Copia>();
	}
	public void addCopy(Copia c,Product p) {
		if(ListaCopias.containsKey(c.getId_copia())) {
			u.copyGenerator(p);
		}
		ListaCopias.put(c.getID(),c);
	}
}
