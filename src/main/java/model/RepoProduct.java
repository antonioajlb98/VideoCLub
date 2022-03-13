package model;

import java.io.File;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import enums.Category;


@XmlRootElement(name = "RepoProduct")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoProduct {
	private HashMap<Integer, Product> productList;
	private static RepoProduct _instance;
	
	private RepoProduct() {
		productList = new HashMap<Integer, Product>();
	}

	public HashMap<Integer,Product> getProductList() {
		return productList;
	}

	public static RepoProduct getInstance() {
		if (_instance == null) {
			_instance = new RepoProduct();
		}
		return _instance;
	}

	public boolean addProduct(Product p) {
		boolean added = false;
		if (p != null) {
			if (!productList.containsKey(p.getID())) {
				productList.put(p.getID(), p);
				added = true;
			}
		}
		return added;
	}

	public boolean removeProduct(Product p) {
		boolean removed = false;
		if (p != null) {
			if (productList.containsKey(p.getID())) {
				productList.remove(p.getID());
				removed = true;
			}
		}
		return removed;
	}

	public void modifyName(Integer ID, String name) {
		if (productList.containsKey(ID)) {
			productList.get(ID).setName(name);
		}
	}

	public void modifyDesc(Integer ID, String desc) {
		if (productList.containsKey(ID)) {
			productList.get(ID).setDescription(desc);
		}
	}

	public void modifyPrize(Integer ID, float prize) {
		if (productList.containsKey(ID)) {
			productList.get(ID).setPrice(prize);
		}
	}

	public void saveFile(String url) {
		JAXBContext contexto;
		try {
			contexto =JAXBContext.newInstance(RepoProduct.class);
			Marshaller m = ((JAXBContext) contexto).createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			m.marshal(_instance, new File(url));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void loadFile(String url) {
		JAXBContext contexto;

		try {
			contexto = JAXBContext.newInstance(RepoProduct.class);
			Unmarshaller um = contexto.createUnmarshaller();
			RepoProduct newClub = (RepoProduct) um.unmarshal(new File(url));
			productList = newClub.productList;
			;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void modifyCategory(Integer ID, Category category) {
		productList.get(ID).setCategory(category);
	}
	public Product searchProduct(Integer id) {
		return productList.get(id);
	}

}