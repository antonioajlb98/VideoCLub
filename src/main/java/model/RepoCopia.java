package model;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class RepoCopia implements Serializable{
	private static final long serialVersionUID = 1L;
	private HashMap<Integer,Copia> ListaCopias;
	
	private RepoCopia() {
		ListaCopias = new HashMap<Integer,Copia>();
	}
	private static RepoCopia RC;
	public static RepoCopia getInstance() {
		if(RC==null) {
			RC = new RepoCopia();
		}
		return RC;
	}
	public void addCopy(Copia c) {
		ListaCopias.put(c.getID(),c);
	}
	
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

	public void loadFile(String url) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(RepoCopia.class);
		    Unmarshaller um = contexto.createUnmarshaller();
		     
		    RepoCopia newRepoCopias = (RepoCopia)um.unmarshal( new File(url) );
		    ListaCopias=newRepoCopias.ListaCopias;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
