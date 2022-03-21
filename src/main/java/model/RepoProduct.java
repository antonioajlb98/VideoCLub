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

	public HashMap<Integer, Product> getProductList() {
		return productList;
	}

	public static RepoProduct getInstance() {
		if (_instance == null) {
			_instance = new RepoProduct();
		}
		return _instance;
	}
	/**
	 * Metodo para añadir un producto a la lista
	 * @param p producto que queremos meter en la lista
	 * @return devuelve true si lo ha añadido bien o false si no
	 */
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
	/**
	 * Metodo para borrar un producto de la lista de productos
	 * @param id del producto que queremos borrar
	 */
	public void removeProduct(Integer id) {
		if (productList.containsKey(id)) {
			productList.remove(id);
		}
	}
	/**
	 * Metodo para mdificar el nombre de un producto 
	 * @param ID del producto al cual le queremos cambiar el nombre
	 * @param name nueva nombre del producto
	 */
	public void modifyName(Integer ID, String name) {
		if (productList.containsKey(ID)) {
			productList.get(ID).setName(name);
		}
	}	
	/**
	 * Metodo para pmodificar la descripcion de un producto
	 * @param ID del producto al cual le queremos modificar la descripcion 
	 * @param desc nueva descripcion del producto
	 */
	public void modifyDesc(Integer ID, String desc) {
		if (productList.containsKey(ID)) {
			productList.get(ID).setDescription(desc);
		}
	}
	 /**
	  * Metodo para modificar el precio de un producto
	  * @param ID del producto al cual le queremos camnbiar el precio
	  * @param prize nuevo precio que va a tener en producto
	  */
	public void modifyPrize(Integer ID, float prize) {
		if (productList.containsKey(ID)) {
			productList.get(ID).setPrice(prize);
		}
	}
	/**
	 * Metodo para guardar los productos en un xml
	 * @param url Archivo donde se van a guardar dichas productos.
	 */
	public void saveFile(String url) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(RepoProduct.class);
			Marshaller m = ((JAXBContext) contexto).createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			m.marshal(_instance, new File(url));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para cargar la Lista de productos de un xml
	 * @param url el archivo del que queremos cargar la Lista de Productos
	 */
	public void loadFile(String url) {
		JAXBContext contexto;

		try {
			contexto = JAXBContext.newInstance(RepoProduct.class);
			Unmarshaller um = contexto.createUnmarshaller();
			RepoProduct newRepoProduct = (RepoProduct) um.unmarshal(new File(url));
			productList = newRepoProduct.productList;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para modificar la categoria de un producto
	 * @param ID para saber de que producto queremos cambiar la categoria pasado como parametro
	 * @param category la nueva categoria pasada como parametro
	 */
	public void modifyCategory(Integer ID, Category category) {
		productList.get(ID).setCategory(category);
	}
	
	/**
	 * Metodo para buscar un producto por su id
	 * @param id del producto que queremos buscar pasada como parametro
	 * @return devuelve el producto si lo ha encontrado
	 */
	public Product searchProduct(Integer id) {
		return productList.get(id);
	}
	
	/**
	 * Metodo para comprobar si una id esta ya en nuestra lista de productos
	 * @param id que queremos comprobar si esta dentro
	 * @return devuelve true si esta en la lista o false si no esta en la lista
	 */
	public boolean Contains(Integer id) {
		return productList.containsKey(id);
	}
	/**
	 * Metodo que nos dice si la Lista de productos está vacía
	 * @return devuelve true si la lista está vacia o false si no lo está
	 */
	public boolean isEmpty() {
		return productList.isEmpty();
	}

}