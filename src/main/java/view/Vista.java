package view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import enums.Category;
import enums.Status;
import model.Client;
import model.Product;
import model.RepoClient;
import model.RepoCopia;
import model.RepoProduct;
import model.Reservation;

public class Vista {

	RepoProduct RepoProducto = RepoProduct.getInstance();
	RepoClient rClient = RepoClient.getInstance();
	RepoCopia rCopia = RepoCopia.getInstance();
	Scanner teclado = new Scanner(System.in);

	private Vista() {
	}

	private static Vista vista;

	public static Vista getInstance() {
		if (vista == null) {
			vista = new Vista();
		}
		return vista;
	}

	public void showMainMenu() {
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out
				.println("|  _         _    _    ___     ____    _______    _____    _        _     _    ____      |");
		System.out
				.println("| |*|       |*|  |*|  |***|   |****|  |*******|  |*****|  |*|      |*|   |*|  |****|     |");
		System.out
				.println("|  |*|     |*|   |*|  |*  *|  |*|     |*|   |*|  |*|      |*|      |*|   |*|  |*   *|    |");
		System.out
				.println("|   |*|   |*|    |*|  |*   *| |****|  |*|   |*|  |*|      |*|      |*|   |*|  |***|      |");
		System.out
				.println("|    |*| |*|     |*|  |*  *|  |*|     |*|   |*|  |*|      |*|___   |*|___|*|  |*   *|    |");
		System.out
				.println("|      |**|      |*|  |***|   |****|  |*******|  |*****|  |*****|  |****** |  |****|     |");
		System.out
				.println("|                                                                                        |");
		System.out
				.println("|----------------------------------------------------------------------------------------|");
		System.out
				.println("                                                                                          ");
		System.out
				.println("                                                                                          ");
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out
				.println("|                                 1. Clientes                                            |");
		System.out
				.println("|                                 2. Productos                                           |");
		System.out
				.println("|                                 3. Salir                                               |");
		this.print("-----------------------------------------------------------------------------------------");
	}

	public void showMenuClient() {
		this.print("1. Anadir cliente");
		this.print("2. Eliminar cliente");
		this.print("3. Modificar cliente");
		this.print("4. Mostrar clientes");
		this.print("5. Buscar Cliente por ID");
		this.print("6. Reservas");
		this.print("7. Volver");
	}

	public void showMenuProduct() {
		this.print("1. Anadir producto");
		this.print("2. Eliminar producto");
		this.print("3. Modificar producto");
		this.print("4. Mostrar producto");
		this.print("5. Buscar Producto");
		this.print("6. Volver");
	}

	public void showMenuReservation() {
		this.print("1. Crear reserva");
		this.print("2. Eliminar reserva");
		this.print("3. Modificar reserva");
		this.print("4. Mostrar reservas");
		this.print("5. Buscar Reserva por id");
		this.print("5. Volver");
	}

	public void showMenuModifyClient() {
		this.print("1. Modificar nombre");
		this.print("2. Modificar telefono");
		this.print("3. Modificar direccion");
		this.print("4. Modificar edad");
		this.print("5. Volver");
	}

	public void showMenuModifyProduct() {
		this.print("1. Modificar nombre");
		this.print("2. Modificar descripcion");
		this.print("3. Modificar precio");
		this.print("4. Modificar categoria");
		this.print("5. Volver");
	}

	public void showMenuModifyReservation() {
		this.print("1. Modificar fecha de creacion");
		this.print("2. Modificar fecha final");
		this.print("3. Modificar estado de la reserva");
		this.print("4. Volver");
	}

	public void showCategoryMenu() {
		this.print("1. Peliculas");
		this.print("2. Juegos");
		this.print("3. Series");

	}
	public void showStatusMenu() {
		this.print("1. Entragado");
		this.print("2. Reservado");
		this.print("3. Expirado");

	}

	public void showClientList(HashMap<Integer, Client> c) {
		for (Integer key : c.keySet()) {
			vista.showObject(c.get(key));
		}
	}
	public void showCopyList(Integer id) {
		rCopia.CopyByIdProduct(id);
	}

	public Integer leeEntero(String frase) {
		boolean valid = false;
		Integer numero = -1;
		do {
			try {
				System.out.println(frase);
				numero = teclado.nextInt();
				valid = true;
			} catch (InputMismatchException ex) {
				System.out.println("Error. Vuelve a introducir un valor");
				teclado.next();
			}
		} while (!valid);
		return numero;
	}

	public Float leeFloat(String frase) {
		boolean valid = false;
		Float numero = 1.f;
		do {
			try {
				System.out.println(frase);
				numero = teclado.nextFloat();
				valid = true;
			} catch (InputMismatchException ex) {
				System.out.println("Error. Vuelve a introducir un valor");
				teclado.next();
			}
		} while (!valid);
		return numero;
	}

	public String leeString(String frase) {
		String f = "";
		System.out.println(frase);
		f = teclado.next();
		return f;
	}

	public void print(String s) {
		System.out.println(s);
	}

	public Integer opcMenu3() {
		boolean valid = false;
		Integer opcion = 0;
		do {
			valid = false;
			opcion = leeEntero("Introduzca una opcion");
			if (opcion < 1 || opcion > 3) {
				System.out.println("Debe insertar un valor valido");
				valid = true;
			}
		} while (valid);
		return opcion;
	}

	public Integer opcMenu6() {
		boolean valid = false;
		Integer opcion = 0;
		do {
			valid=false;
			opcion = leeEntero("Introduzca una opcion");
			if (opcion < 1 || opcion > 6) {
				System.out.println("Debe insertar un valor valido");
				valid = true;
			}
		} while (valid);
		return opcion;
	}

	public Integer opcMenu5() {
		boolean valid = false;
		Integer opcion = 0;
		do {
			valid=false;
			opcion = leeEntero("Introduzca una opcion");
			if (opcion < 1 || opcion > 5) {
				System.out.println("Debe insertar un valor valido");
				valid = true;
			}
		} while (valid);
		return opcion;
	}

	public Integer opcMenu4() {
		boolean valid = false;
		Integer opcion = 0;
		do {
			valid=false;
			opcion = leeEntero("Introduzca una opcion");
			if (opcion < 1 || opcion > 4) {
				System.out.println("Debe insertar un valor valido");
				valid = true;
			}
		} while (valid);
		return opcion;
	}

	public Integer opcMenu7() {
		boolean valid = false;
		Integer opcion = 0;
		do {
			valid=false;
			opcion = leeEntero("Introduzca una opcion");
			if (opcion < 1 || opcion > 7) {
				System.out.println("Debe insertar un valor valido");
				valid = true;
			}
		} while (valid);
		return opcion;
	}

	public void showProductList(HashMap<Integer, Product> Lista) {
		for (Integer key : Lista.keySet()) {
			this.showObject(Lista.get(key));
		}
		
	}
	public void showReservaList(HashMap<Integer, Reservation> Lista) {
		for (Integer key : Lista.keySet()) {
			this.showObject(Lista.get(key));
		}
	}

	public void showObject(Object o) {
		System.out.println(o);
	}

	public Category leeCategory(String f) {
		this.print(f);
		showCategoryMenu();
		int opc = opcMenu3();
		switch (opc) {
		case 1:
			return Category.PELICULAS;
		case 2:
			return Category.JUEGOS;
		case 3:
			return Category.SERIES;
		default:
			return Category.PELICULAS;
		}
	}
	public Status leeStatus(String f) {
		this.print(f);
		showStatusMenu();
		int opc = opcMenu3();
		switch (opc) {
		case 1:
			return Status.ENTREGADO;
		case 2:
			return Status.RESERVADO;
		case 3:
			return Status.EXPIRADO;
		default:
			return Status.ENTREGADO;
		}
	}

}