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

public class Controller{
	Copia copia;
	RepoCopia RepoCopia;
	Vista vista = new Vista();
	Utils u = new Utils();
	RepoClient RepoCliente = RepoClient.getInstance();
	Client client = new Client();
	Product product;
	RepoProduct RepoProducto = RepoProduct.getInstance();
	Reservation reserva;
	RepoReservation RepoReserva = RepoReservation.getInstance();
	
	
	private void switchMain(int op) {
		switch (op) {
		case 1: vista.showMenuClient();
				switchMenuCliente(vista.opcMenu7());
				break;
		case 2: vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu6());
				break;
		case 3: vista.print("Gracias por utilizar nuestro software");
				break;
		}
	}
	
	private void switchMenuCliente(int op) {
		switch (op) {
		case 1: RepoCliente.addClient(u.readClient());
				RepoCliente.saveFile("cliente.xml");	
				vista.showMenuClient();
				switchMenuCliente(vista.opcMenu7());
				break;
		case 2: Integer id6 = vista.leeEntero("Introduce el ID del cliente");
				RepoCliente.removeClient(id6);
				RepoCliente.saveFile("cliente.xml");
				vista.showMenuClient();
				switchMenuCliente(vista.opcMenu7());
				break;
		case 3: vista.showMenuModifyClient();
				switchMenuModifyClient(vista.opcMenu6());
				break;
		case 4: vista.showClientList(RepoCliente.getClientList());
				vista.showMenuClient();
				switchMenuCliente(vista.opcMenu7());
				break;
		case 5: Integer id = vista.leeEntero("Introduce el ID del cliente");
				vista.showObject(RepoCliente.searchClient(id));
				vista.showMenuClient();
				switchMenuCliente(vista.opcMenu7());
				break;
		case 6: vista.showMenuReservation();
				vista.showMenuReservation();
				switchMenuReservation(vista.opcMenu6());
				break;
		case 7: vista.showMainMenu();
				switchMain(vista.opcMenu3());
				break;
		}
	}
	
	private void switchMenuProduct(int op) {
		switch (op) {
		case 1: RepoProducto.addProduct(u.readProduct());
				RepoProducto.saveFile("producto.xml");
				vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu6());
				break;
		case 2: 
				RepoProducto.saveFile("producto.xml");
				vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu6());
				break;
		case 3: vista.showMenuModifyProduct();
				switchModifyProduct(vista.opcMenu5());
				break;
		case 4: vista.showProductList(RepoProducto.getProductList());
				vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu6());
				break;
		case 5: Integer id2 = vista.leeEntero("Introduce el ID del producto");
				RepoProducto.searchProduct(id2);
				break;
		case 6: vista.showMainMenu();
				switchMain(vista.opcMenu3());
				break;
		}
	}
	
	private void switchMenuModifyClient(int op) {
		switch (op) {
		case 1: Integer id = vista.leeEntero("Introduzca el ID del cliente");
				String name=vista.leeString("Introduzca el nuevo nombre");
				RepoCliente.modifyName(id, name);
				RepoCliente.saveFile("cliente.xml");
				vista.showMenuModifyClient();
				switchMenuModifyClient(vista.opcMenu6());
				break;
		case 2: Integer id2 = vista.leeEntero("Introduzca el ID del cliente");
				String telef=vista.leeString("Introduzca el nuevo telefono");
				RepoCliente.modifyPhone(id2, telef);
				RepoCliente.saveFile("cliente.xml");
				vista.showMenuModifyClient();
				switchMenuModifyClient(vista.opcMenu6());
				break;
		case 3: Integer id3 = vista.leeEntero("Introduzca el ID del cliente");
				String fecha=vista.leeString("Introduzca la fecha de alta");
				RepoCliente.modifyTime(id3, fecha);
				RepoCliente.saveFile("cliente.xml");
				vista.showMenuModifyClient();
				switchMenuModifyClient(vista.opcMenu6());
				break;
		case 4: Integer id4 = vista.leeEntero("Introduzca el ID del cliente");
				String dir = vista.leeString("Introduzca la nueva direccion");
				RepoCliente.modifyAddress(id4, dir);
				RepoCliente.saveFile("cliente.xml");
				vista.showMenuModifyClient();
				switchMenuModifyClient(vista.opcMenu6());
				break;
		case 5: Integer id5 = vista.leeEntero("Introduzca el ID del cliente");
				Integer edad = vista.leeEntero("Introduzca la edad");
				RepoCliente.modifyAge(id5, edad);
				RepoCliente.saveFile("cliente.xml");
				vista.showMenuModifyClient();
				switchMenuModifyClient(vista.opcMenu6());
				break;
		case 6: vista.showMenuClient();
				switchMenuCliente(vista.opcMenu6());
				break;
		}
	}
	
	private void switchModifyProduct(int op) {
		switch (op) {
		case 1: Integer id6 = vista.leeEntero("Introduzca el ID del producto");
				String name2 = vista.leeString("Introduzca el nombre del producto");
				RepoProducto.modifyName(id6, name2);
				RepoProducto.saveFile("producto.xml");
				vista.showMenuModifyProduct();
				switchModifyProduct(vista.opcMenu5());
				break;
		case 2: Integer id7 = vista.leeEntero("Introduzca el ID del producto");
				String desc2 = vista.leeString("Introduzca la descripcion del producto");
				RepoProducto.modifyDesc(id7, desc2);
				RepoProducto.saveFile("producto.xml");
				vista.showMenuModifyProduct();
				switchModifyProduct(vista.opcMenu5());
				break;
		case 3: Integer id8 = vista.leeEntero("Introduzca el ID del producto");
				Integer precio2 = vista.leeEntero("Introduzca el precio del producto");
				RepoProducto.modifyPrize(id8, precio2);
				RepoProducto.saveFile("producto.xml");
				vista.showMenuModifyProduct();
				switchModifyProduct(vista.opcMenu5());
				break;
		case 4: Integer id9 = vista.leeEntero("Introduzca el ID del producto");
				Category cate2 = vista.leeCategory("Introduzca la nueva categoria");
				RepoProducto.modifyCategory(id9, cate2);
				RepoProducto.saveFile("producto.xml");
				vista.showMenuModifyProduct();
				switchModifyProduct(vista.opcMenu5());
				break;
		case 5: vista.showMenuProduct();
				switchMenuProduct(vista.opcMenu5());
				break;
		}
	}
	
	private void switchMenuReservation(int op) {
		switch (op) {
		case 1: 
				RepoReserva.saveFile("reserva.xml");
				vista.showMenuReservation();
				switchMenuReservation(vista.opcMenu6());
				break;
		case 2:
				RepoReserva.saveFile("reserva.xml");
				break;
		case 3: vista.showMenuModifyReservation();
				switchMenuModifyReservation(vista.opcMenu4());
				break;
		case 4:
				break;
		case 5:
				break;
		case 6: vista.showMenuClient();
				switchMenuCliente(vista.opcMenu7());
				break;
		}
	}
	
	private void switchMenuModifyReservation(int op) {
		switch (op) {
		case 1:
				RepoReserva.saveFile("reserva.xml");
				vista.showMenuModifyReservation();
				switchMenuModifyReservation(vista.opcMenu4());
				break;
		case 2:
				RepoReserva.saveFile("reserva.xml");
				vista.showMenuModifyReservation();
				switchMenuModifyReservation(vista.opcMenu4());
				break;
		case 3:
				RepoReserva.saveFile("reserva.xml");
				vista.showMenuModifyReservation();
				switchMenuModifyReservation(vista.opcMenu4());
				break;
		case 4: vista.showMenuReservation();
				switchMenuReservation(vista.opcMenu6());
				break;
		}
	}
	
	
	
	public void run() {
		vista.showMainMenu();
		Integer opc2 = vista.leeEntero("Introduzca la opcion");
		switchMain(opc2);
		
	}
	
	
}