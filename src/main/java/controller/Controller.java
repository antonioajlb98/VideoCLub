package controller;

import enums.Category;
import view.Vista;
import view.Utils;
import model.Client;
import model.Copia;
import model.Product;
import model.RepoClient;
import model.RepoProduct;
import model.RepoCopia;
import model.RepoReservation;
import model.Reservation;

public class Controller {

	RepoCopia rCopy = RepoCopia.getInstance();
	RepoProduct rProduct = RepoProduct.getInstance();
	RepoClient rClient = RepoClient.getInstance();
	RepoReservation rReserva = RepoReservation.getInstance();
	Product product;
	Copia copy;
	Client client = new Client();
	Reservation reserva;
	Vista v = Vista.getInstance();
	Utils u = Utils.getInstance();

	public void switchMain(int op) {
		switch (op) {
		case 1:
			v.showMenuClient();
			switchMenuCliente(v.opcMenu7());
			break;
		case 2:
			v.showMenuProduct();
			switchMenuProduct(v.opcMenu6());
			break;
		case 3:
			v.print("Gracias por utilizar nuestro software");
			break;
		}
	}

	private void switchMenuCliente(int op) {
		switch (op) {
		case 1:
			rClient.addClient(u.readClient());
			rClient.saveFile("cliente.xml");
			v.showMenuClient();
			switchMenuCliente(v.opcMenu7());
			break;
		case 2:
			Integer id6 = v.leeEntero("Introduce el ID del cliente");
			v.showObject("Cliente Borrado= " + rClient.removeClient(id6));
			rClient.saveFile("cliente.xml");
			v.showMenuClient();
			switchMenuCliente(v.opcMenu7());
			break;
		case 3:
			v.showMenuModifyClient();
			switchMenuModifyClient(v.opcMenu6());
			break;
		case 4:
			v.showClientList(rClient.getClientList());
			v.showMenuClient();
			switchMenuCliente(v.opcMenu7());
			break;
		case 5:
			Integer id = v.leeEntero("Introduce el ID del cliente");
			v.showObject(rClient.searchClient(id));
			v.showMenuClient();
			switchMenuCliente(v.opcMenu7());
			break;
		case 6:
			v.showMenuReservation();
			v.showMenuReservation();
			switchMenuReservation(v.opcMenu6());
			break;
		case 7:
			v.showMainMenu();
			switchMain(v.opcMenu3());
			break;
		}
	}

	private void switchMenuProduct(int op) {
		switch (op) {
		case 1:
			rProduct.addProduct(u.readProduct());
			rProduct.saveFile("producto.xml");
			v.showMenuProduct();
			switchMenuProduct(v.opcMenu6());
			break;
		case 2:
			Integer id = v.leeEntero("Introduzca la ID del producto");
			rProduct.removeProduct(id);
			rProduct.saveFile("producto.xml");
			v.showMenuProduct();
			switchMenuProduct(v.opcMenu6());
			break;
		case 3:
			v.showMenuModifyProduct();
			switchModifyProduct(v.opcMenu5());
			break;
		case 4:
			if (rProduct.isEmpty()) {
				v.print("No hay Productos para mostrar");
			}
			v.showProductList(rProduct.getProductList());
			v.showMenuProduct();
			switchMenuProduct(v.opcMenu6());
			break;
		case 5:
			Integer id2 = v.leeEntero("Introduce el ID del producto");
			v.showObject(rProduct.searchProduct(id2));
			break;
		case 6:
			v.showMainMenu();
			switchMain(v.opcMenu3());
			break;
		}
	}

	private void switchMenuModifyClient(int op) {
		switch (op) {
		case 1:
			Integer id = v.leeEntero("Introduzca el ID del cliente");
			searchKeyClienttoModify(id);
			String name = v.leeString("Introduzca el nuevo nombre");
			rClient.modifyName(id, name);
			rClient.saveFile("cliente.xml");
			v.showMenuModifyClient();
			switchMenuModifyClient(v.opcMenu6());
			break;
		case 2:
			Integer id2 = v.leeEntero("Introduzca el ID del cliente");
			searchKeyClienttoModify(id2);
			String telef = v.leeString("Introduzca el nuevo telefono");
			rClient.modifyPhone(id2, telef);
			rClient.saveFile("cliente.xml");
			v.showMenuModifyClient();
			switchMenuModifyClient(v.opcMenu6());
			break;
		case 3:
			Integer id4 = v.leeEntero("Introduzca el ID del cliente");
			searchKeyClienttoModify(id4);
			String dir = v.leeString("Introduzca la nueva direccion");
			rClient.modifyAddress(id4, dir);
			rClient.saveFile("cliente.xml");
			v.showMenuModifyClient();
			switchMenuModifyClient(v.opcMenu6());
			break;
		case 4:
			Integer id5 = v.leeEntero("Introduzca el ID del cliente");
			searchKeyClienttoModify(id5);
			Integer edad = v.leeEntero("Introduzca la edad");
			rClient.modifyAge(id5, edad);
			rClient.saveFile("cliente.xml");
			v.showMenuModifyClient();
			switchMenuModifyClient(v.opcMenu6());
			break;
		case 5:
			v.showMenuClient();
			switchMenuCliente(v.opcMenu6());
			break;
		}
	}

	private void switchModifyProduct(int op) {
		switch (op) {
		case 1:
			Integer id6 = v.leeEntero("Introduzca el ID del producto");
			searchKeyProduct(id6);
			String name2 = v.leeString("Introduzca el nombre del producto");
			rProduct.modifyName(id6, name2);
			rProduct.saveFile("producto.xml");
			v.showMenuModifyProduct();
			switchModifyProduct(v.opcMenu5());
			break;
		case 2:
			Integer id7 = v.leeEntero("Introduzca el ID del producto");
			searchKeyProduct(id7);
			String desc2 = v.leeString("Introduzca la descripcion del producto");
			rProduct.modifyDesc(id7, desc2);
			rProduct.saveFile("producto.xml");
			v.showMenuModifyProduct();
			switchModifyProduct(v.opcMenu5());
			break;
		case 3:
			Integer id8 = v.leeEntero("Introduzca el ID del producto");
			searchKeyProduct(id8);
			Integer precio2 = v.leeEntero("Introduzca el precio del producto");
			rProduct.modifyPrize(id8, precio2);
			rProduct.saveFile("producto.xml");
			v.showMenuModifyProduct();
			switchModifyProduct(v.opcMenu5());
			break;
		case 4:
			Integer id9 = v.leeEntero("Introduzca el ID del producto");
			searchKeyProduct(id9);
			Category cate2 = v.leeCategory("Introduzca la nueva categoria");
			rProduct.modifyCategory(id9, cate2);
			rProduct.saveFile("producto.xml");
			v.showMenuModifyProduct();
			switchModifyProduct(v.opcMenu5());
			break;
		case 5:
			v.showMenuProduct();
			switchMenuProduct(v.opcMenu5());
			break;
		}
	}

	private void switchMenuReservation(int op) {
		switch (op) {
		case 1:
			rReserva.saveFile("reserva.xml");
			v.showMenuReservation();
			switchMenuReservation(v.opcMenu6());
			break;
		case 2:
			rReserva.saveFile("reserva.xml");
			break;
		case 3:
			v.showMenuModifyReservation();
			switchMenuModifyReservation(v.opcMenu4());
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			v.showMenuClient();
			switchMenuCliente(v.opcMenu7());
			break;
		}
	}

	private void switchMenuModifyReservation(int op) {
		switch (op) {
		case 1:
			rReserva.saveFile("reserva.xml");
			v.showMenuModifyReservation();
			switchMenuModifyReservation(v.opcMenu4());
			break;
		case 2:
			rReserva.saveFile("reserva.xml");
			v.showMenuModifyReservation();
			switchMenuModifyReservation(v.opcMenu4());
			break;
		case 3:
			rReserva.saveFile("reserva.xml");
			v.showMenuModifyReservation();
			switchMenuModifyReservation(v.opcMenu4());
			break;
		case 4:
			v.showMenuReservation();
			switchMenuReservation(v.opcMenu6());
			break;
		}
	}

	public Integer searchKeyProduct(Integer id) {
		Integer newid;
		while (rProduct.Contains(id)) {
			v.print("Esta id ya esta asociada a otro producto");
			newid = v.leeEntero("Introduzca la id");
			id = newid;
		}
		return id;
	}

	public Integer searchKeyClient(Integer id) {
		Integer newid;
		while (rClient.Contains(id)) {
			if (rProduct.Contains(id)) {
				v.print("La id está disponible y se le ha asociado correctamente");
			}
			v.print("Esta id ya esta asociada a otro cliente\n");
			newid = v.leeEntero("Introduzca otra id");
			id = newid;
		}
		return id;
	}

	public Integer searchKeyClienttoModify(Integer id) {
		int cont = 0;
		Integer newid;
		
		while (!rClient.Contains(id)) {
			cont++;
			v.print("Esta id no esta asociada a ningun cliente");
			newid = v.leeEntero("Introduzca otra id");
			id = newid;
			if (cont==3) {
				System.out.println("Has agotado tus intentos volveras al Programa Principal en 3 segundos");
				esperar(3);
				v.showMainMenu();
				switchMain(v.opcMenu3());
			}
		}
		return id;
	}

	public void run() {
		v.showMainMenu();
		switchMain(v.opcMenu3());

	}

	public static void esperar(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}