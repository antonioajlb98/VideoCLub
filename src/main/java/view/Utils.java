package view;

import java.time.LocalDateTime;

import enums.Category;
import model.Client;
import model.Copia;
import model.Product;
import model.RepoClient;
import model.RepoCopia;
import model.RepoProduct;

public class Utils {
	Vista v = Vista.getInstance();
	Copia c = new Copia();
	RepoCopia rCopy = RepoCopia.getInstance();
	RepoProduct rProduct = RepoProduct.getInstance();
	RepoClient  rClient= RepoClient.getInstance();
	private Utils() {
	}
	private static Utils u;
	public static Utils getInstance() {
		if(u==null) {
			u = new Utils();
		}
		return u;
	}
	
	public Product readProduct() {
		String name,desc;
		Integer id,numcop;
		Float price;
		Category cat;
		name=v.leeString("Introduce el nombre del producto");
		desc=v.leeString("Introduce la descripcion del producto");
		id=v.leeEntero("Introduce la id del Producto");
		searchKeyProduct(id);
		price=v.leeFloat("Introduce el precio del producto");
		numcop=v.leeEntero("Introduce el numero de copias");
		cat=v.leeCategory("Introduce la Categoria");
		Product p= new Product(name,price,desc,id,numcop,cat);
		copyGenerator(p);
		return p;
	}
	public Client readClient() {
		String name,phone,address;
		Integer id,age;
		name=v.leeString("Introduce el nombre del Cliente");
		id=v.leeEntero("Introduce la id del Cliente");
		searchKeyClient(id);
		phone=v.leeString("Introduce el numero de telefono del Cliente");
		LocalDateTime time=LocalDateTime.now();
		address=v.leeString("Introduce la direccion del cliente");
		age=v.leeEntero("Introduce la edad del Cliente");
		
		Client c = new Client(id,name,phone,time,address,age);
		return c;
	}
	public Copia copyGenerator(Product p){
		int cont=0;
	while(cont<p.getNum_cop()) {
			Integer idcopy=c.idGenerator();
			Copia c = new Copia(p.getName(),p.getPrice(),p.getDescription(),p.getID(),p.getNum_cop(),p.getCategory(),idcopy);
			rCopy.addCopy(c);
			cont++;
	}
		return c;
	}
	public Integer searchKeyProduct(Integer id) {
		Integer newid;
		while(rProduct.Contains(id)) {
			v.print("Esta id ya esta asociada a otro producto");
			newid=v.leeEntero("Introduzca la id");
			id=newid;
		}
		return id;
	}
	public Integer searchKeyClient(Integer id) {
		Integer newid;
		while(rClient.Contains(id)) {
			if(rProduct.Contains(id)) {
				v.print("La id está disponible y se le ha asociado correctamente");
			}
			v.print("Esta id ya esta asociada a otro cliente\n");
			newid=v.leeEntero("Introduzca otra id");
			id=newid;
		}
		return id;
	}
	
}