package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class RepoCopia implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Copia> ListaCopias;

	private RepoCopia() {
		ListaCopias = new ArrayList<Copia>();
	}

	private static RepoCopia RC;
	
	public static RepoCopia getInstance() {
		if (RC == null) {
			RC = new RepoCopia();
		}
		return RC;
	}
	/**
	 * Metodo que añade una copia al hashmap de copias
	 * @param c La copia que queremos que añada a la lista
	 */
	public void addCopy(Copia c) {
		ListaCopias.add(c);
	}
	
	/**
	 * Metodo para devolver un ArrayList
	 * @return El ArrayList que devolvemos en este caso la lista de copias
	 */
	public ArrayList<Copia> getListaCopias() {
		return ListaCopias;
	}
	/**
	 * Metodo para guardar las copias en un xml
	 * @param url Archivo donde se van a guardar dichas copias.
	 */
	public void saveFile(String url) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(RepoClient.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			m.marshal(RC, new File(url));

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Metodo para borrar una copia de la lista de copias
	 * @param c Copia que queremos borrar.
	 */
	public void removeCopy(Copia c) {
		ListaCopias.remove(c);
	}
	
	/**
	 * Metodo que nos devuelve una copia por su id
	 * @param id el id al que pertenece la copia que queremos coger
	 * @return La copia a la que pertenece la id que le pasamos como parametro
	 */
	public Copia getCopy(Integer id) {
		Copia aux = new Copia();
		for(Copia c : ListaCopias) {
			if(c.getId_copia()==id) {
			aux=c;
			return aux;
			}
		}
		return aux;
			
		}
	/**
	 * Metodo para cargar la Lista de copias de un xml
	 * @param url el archivo del que queremos cargar la Lista de Copias
	 */
	public void loadFile(String url) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(RepoCopia.class);
			Unmarshaller um = contexto.createUnmarshaller();

			RepoCopia newRepoCopias = (RepoCopia) um.unmarshal(new File(url));
			ListaCopias = newRepoCopias.ListaCopias;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
