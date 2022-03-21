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
		//rProduct.loadFile("producto.xml");
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
			searchKeyClienttoModify(id6);
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
			if (rClient.isEmpty()) {
				v.print("No hay Clientes para mostrar");
			}
			v.showClientList(rClient.getClientList());
			v.showMenuClient();
			switchMenuCliente(v.opcMenu7());
			break;
		case 5:
			Integer id = v.leeEntero("Introduce el ID del cliente");
			searchKeyClienttoModify(id);
			v.showObject(rClient.searchClient(id));
			v.showMenuClient();
			switchMenuCliente(v.opcMenu7());
			break;
		case 6:
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
			searchKeyProducttoModify(id);
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
			searchKeyProducttoModify(id2);
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
			searchKeyProducttoModify(id6);
			String name2 = v.leeString("Introduzca el nombre del producto");
			rProduct.modifyName(id6, name2);
			rProduct.saveFile("producto.xml");
			v.showMenuModifyProduct();
			switchModifyProduct(v.opcMenu5());
			break;
		case 2:
			Integer id7 = v.leeEntero("Introduzca el ID del producto");
			searchKeyProducttoModify(id7);
			String desc2 = v.leeString("Introduzca la descripcion del producto");
			rProduct.modifyDesc(id7, desc2);
			rProduct.saveFile("producto.xml");
			v.showMenuModifyProduct();
			switchModifyProduct(v.opcMenu5());
			break;
		case 3:
			Integer id8 = v.leeEntero("Introduzca el ID del producto");
			searchKeyProducttoModify(id8);
			Integer precio2 = v.leeEntero("Introduzca el precio del producto");
			rProduct.modifyPrize(id8, precio2);
			rProduct.saveFile("producto.xml");
			v.showMenuModifyProduct();
			switchModifyProduct(v.opcMenu5());
			break;
		case 4:
			Integer id9 = v.leeEntero("Introduzca el ID del producto");
			searchKeyProducttoModify(id9);
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
			this.newReserva();
			rReserva.saveFile("reserva.xml");
			v.showMenuReservation();
			switchMenuReservation(v.opcMenu6());

			break;
		case 2:
			u.removeReserva();
			rReserva.saveFile("reserva.xml");
			v.showMenuReservation();
			switchMenuReservation(v.opcMenu6());
			break;
		case 3:
			v.showMenuModifyReservation();
			switchMenuModifyReservation(v.opcMenu4());
			break;
		case 4:
			if (rReserva.isEmpty()) {
				v.print("No hay Reservas para mostrar");
			}
			v.showReservaList(rReserva.getReservations());
			v.showMenuModifyReservation();
			switchMenuModifyReservation(v.opcMenu4());
			break;
		case 5:
			Integer id = v.leeEntero("Introduce el id de la Reserva a buscar");
			searchKeyRerservationtoModify(id);
			rReserva.searchReservation(id);
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
			v.showMenuModifyReservation();
			switchMenuModifyReservation(v.opcMenu4());
			rReserva.saveFile("reserva.xml");
			break;
		case 3:
			v.showMenuModifyReservation();
			switchMenuModifyReservation(v.opcMenu4());
			rReserva.saveFile("reserva.xml");
			break;
		case 4:
			v.showMenuReservation();
			switchMenuReservation(v.opcMenu6());
			break;
		}
	}


	public Integer searchKeyClienttoModify(Integer id) {
		int cont = 0;
		Integer newid;

		while (!rClient.Contains(id)) {
			cont++;
			v.print("Esta id no esta asociada a ningun cliente");
			newid = v.leeEntero("Introduzca otra id");
			id = newid;
			if (cont == 3) {
				System.out.println("Has agotado tus intentos volveras al Programa Principal en 3 segundos");
				esperar(3);
				v.showMainMenu();
				switchMain(v.opcMenu3());
			}
		}
		return id;
	}

	public Integer searchKeyProducttoModify(Integer id) {
		int cont = 0;
		Integer newid;

		while (!rProduct.Contains(id)) {
			cont++;
			v.print("Esta id no esta asociada a ningun producto");
			newid = v.leeEntero("Introduzca otra id");
			id = newid;
			if (cont == 3) {
				System.out.println("Has agotado tus intentos volveras al Programa Principal en 3 segundos");
				esperar(3);
				v.showMainMenu();
				switchMain(v.opcMenu3());
			}
		}
		return id;
	}

	public Integer searchKeyRerservationtoModify(Integer id) {
		int cont = 0;
		Integer newid;

		while (!rReserva.Contains(id)) {
			cont++;
			v.print("Esta id no esta asociada a ninguna reserva");
			newid = v.leeEntero("Introduzca otra id");
			id = newid;
			if (cont == 3) {
				System.out.println("Has agotado tus intentos volveras al Programa Principal en 3 segundos");
				esperar(3);
				v.showMainMenu();
				switchMain(v.opcMenu3());
			}
		}
		return id;
	}

	public void newReserva() {
		v.showClientList(rClient.getClientList());
		Integer id_cliente = v.leeEntero("Introduzca la id del cliente que quiere hacer la reserva\n");
		searchKeyClienttoModify(id_cliente);
		v.showProductList(rProduct.getProductList());
		Integer id_producto = v.leeEntero("Introduzca la id del producto que quiere hacer la reserva\n");
		searchKeyProducttoModify(id_producto);
		v.showCopyList(id_producto);
		Integer id_copia = v.leeEntero("Introduzca la id de la copia que quiere reservar\n");
		v.showObject(rCopy.getCopy(id_copia));
		u.readReservation(rClient.getClient(id_cliente), rCopy.getCopy(id_copia));
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