package model;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RepoClient")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoClient implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private static RepoClient _instance;
	
	HashMap <Integer, Client> clientlist;
	
	private RepoClient() {
		clientlist= new HashMap <Integer, Client>();
	}
	
	public static RepoClient getInstance() {
		if (_instance==null) {
			_instance=new RepoClient();
		}
		return _instance;
	}
	
	public void showClientList(){
		for(Integer key:clientlist.keySet()) {
			System.out.println("ID: " +key+ "Value: " +clientlist.get(key));
		}
	}
	
	public void modifyName(Integer ID, String Name) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setName(Name);
		}
	}
	
	public void modifyPhone(Integer ID, String Phone) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setPhone(Phone);;
		}
	}
	
	public void modifyTime(Integer ID, String Time) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setTime(Time);
		}
	}
	
	public void modifyAddress(Integer ID, String Address) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setAddress(Address);
		}
	}
	
	public void modifyAge(Integer ID, Integer Age) {
		if(this.clientlist.containsKey(ID)) {
			clientlist.get(ID).setAge(Age);
		}
	}
	
	public Client searchClient(Integer ID) {
		return(this.clientlist.get(ID));
	}

	public boolean addClient(Client c) {
		Client aux= (Client) c;
		boolean added=false;
		if(!this.clientlist.containsKey(aux.getID())) {
			this.clientlist.put(aux.getID(), aux);
			added=true;
		}
		return added;
	}
	
	public boolean removeClient(Integer ID) {
		boolean removed=false;
		if(this.clientlist.containsKey(ID)) {
			this.clientlist.remove(ID);
			removed=true;
		}
		return removed; 
	}
	public HashMap<Integer, Client> getClientList(){
		return clientlist;
	}

	public void saveFile(String url) {
		JAXBContext contexto; 
		try {
			contexto = JAXBContext.newInstance(RepoClient.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(_instance, new File(url));
		
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void loadFile(String url) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(RepoClient.class);
		    Unmarshaller um = contexto.createUnmarshaller();
		     
		    RepoClient newRepoClient = (RepoClient) um.unmarshal( new File(url) );
		    clientlist=newRepoClient.clientlist;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}