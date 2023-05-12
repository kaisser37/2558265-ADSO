import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner entradaNumero = new Scanner(System.in);
    Scanner entradaTexto = new Scanner(System.in);
    Persona[] clientes = new Persona[100];
    Persona[] vendedores = new Persona[100];
	Factura[] facturas = new Factura[100];


	Producto[] productos = new Producto[10];
	productos[0] = new Producto("Jabón en polvo", 10000);
    productos[1] = new Producto("Detergente líquido", 12000);
    productos[2] = new Producto("Desinfectante en aerosol", 8000);
    productos[3] = new Producto("Esponjas", 3500);
    productos[4] = new Producto("Limpia vidrios", 7000);
    productos[5] = new Producto("Toallas de papel", 6500);
    productos[6] = new Producto("Limpiador multiuso", 12000);
    productos[7] = new Producto("Trapos de limpieza", 5000);
    productos[8] = new Producto("Guantes de goma", 5000);
    productos[9] = new Producto("Removedor de manchas", 9000);

    int opcionMenu = 0;

    do {
		System.out.println("\n");
		System.out.println("  +--------------------------------+");
		System.out.println("  |        Menú principal          |");
		System.out.println("  +--------------------------------+");
		System.out.println("  |    1. Crear cliente            |");
		System.out.println("  |    2. Crear vendedor           |");
		System.out.println("  |    3. Crear factura            |");
		System.out.println("  |    4. Ver clientes             |");
		System.out.println("  |    5. Ver vendedores           |");
		System.out.println("  |    6. Ver facturas             |");
		System.out.println("  |    7. Ver detalle de factura   |");
		System.out.println("  |    8. Salir                    |");
		System.out.println("  +--------------------------------+");

		System.out.print("Ingrese una opción: ");
		opcionMenu = entradaNumero.nextInt();
		System.out.println("\n");

		if (opcionMenu == 1) {
			Funciones.crearPersona(clientes, opcionMenu);
		} else if (opcionMenu == 2) {
			Funciones.crearPersona(vendedores, opcionMenu);
		} else if (opcionMenu == 3) {
			Funciones.crearFactura(clientes, vendedores, productos, facturas);
		} else if (opcionMenu == 4) {
			Funciones.imprimirListaPersonas(clientes, opcionMenu);
		} else if (opcionMenu == 5) {
			Funciones.imprimirListaPersonas(vendedores, opcionMenu);
		} else if (opcionMenu == 6) {
			Funciones.imprimirListaFacturas(facturas);
		} else {
			System.out.println(" --- opción invalida ---");
		}
    } while (opcionMenu != 8);

    System.out.println("\n");
    System.out.println("Saliendo...");
    System.out.println("Fin del programa");
  }
}
