import java.util.Scanner;

public abstract class Funciones {

    public static void crearPersona(Persona[] array, int opcionMenu) {
		Scanner entradaNumero = new Scanner(System.in);
		Scanner entradaTexto = new Scanner(System.in);
        
		int contadorArray = 0;
		for(int i=0; i<array.length;i++){
			if(array[i]!=null){
				contadorArray++;
			}
		}

		System.out.println("+------------------------------+");
		System.out.println("|        Crear " + ((opcionMenu == 1? "cliente ": "vendedor")) + "        |");
		System.out.println("+------------------------------+");
		System.out.println("Registros actuales: " + contadorArray);
		System.out.println("Cédula: ");
		int cedula = entradaNumero.nextInt();

		boolean cedulaValida = true;
		for(int i = 0; i < contadorArray; i++) {
			if (array[i] != null && array[i].getCedula() == cedula) {
				cedulaValida = false;
				break;
			}
		}

		if (cedulaValida) {
			System.out.println("Nombre: ");
			String nombres = entradaTexto.nextLine();
			System.out.println("Apellidos: ");
			String apellidos = entradaTexto.nextLine();
			array[contadorArray] = new Persona(nombres, apellidos, cedula);
			System.out.println("\n");
			System.out.println("¡Persona registrada!");                    
		} else {
			System.out.println("La persona ya existe, intente de nuevo.");
		}
	}

	public static void imprimirListaPersonas(Persona [] array, int opcionMenu){
		System.out.println("+----------------------------------+");
		System.out.println("|        Lista de " + ((opcionMenu == 4? "clientes  ": "vendedores")) + "       |");
		System.out.println("+----------------------------------+");
		for(int i=0; i<array.length;i++){
			if(array[i]!=null){
				System.out.println( "  => "+array[i].getCedula()+" - "+array[i].getNombres()+" "+array[i].getApellidos() );
			}
		}
	}

    public static int getIndexPersona(Persona [] array){
		int contador = -1;
		for(int i=0; i<array.length;i++){
			if(array[i]!=null){
				contador++;
			}
		}
		return contador;
	}

	public static void crearFactura(Persona[] clientes, Persona[] vendedores, Producto[] productos, Factura[] facturas) {
		Scanner entradaNumero = new Scanner(System.in);		
		Scanner entradaTexto = new Scanner(System.in);
		System.out.println("+------------------------------+");
		System.out.println("|        Crear factura         |");
		System.out.println("+------------------------------+");
		System.out.println("Ingrese cédula del cliente: ");
		int cedulaCliente = entradaNumero.nextInt();
		System.out.println("Ingrese cedula del vendedor: ");
		int cedulaVendedor =  entradaNumero.nextInt();

		int opcionFactura = 0;
		int contRegistros = 0;
		float totalFactura = 0;
		ItemFactura[] registroProductos = new ItemFactura[100];

		do {
			System.out.println("  +---------------------------------+");
			System.out.println("  |    1. Registrar producto        |");
			System.out.println("  |    2. Generar factura           |");
			System.out.println("  +---------------------------------+");
			System.out.println(">>: ");
			opcionFactura = entradaNumero.nextInt();

			if (opcionFactura == 1) {
				// registrar producto
				verProductos(productos);
				System.out.println("Seleccionar producto: ");
				int selectProducto = entradaNumero.nextInt() - 1; //para seleccionar el index del arreglo de productos.
				System.out.println("Cantidad: ");
				int cantidad = entradaNumero.nextInt();
				float subtotal = productos[selectProducto].precio * cantidad;
				registroProductos[contRegistros] = new ItemFactura(productos[selectProducto], cantidad, subtotal);
				contRegistros++;
				totalFactura += subtotal;

			} else if (opcionFactura == 2) {
				// generar factura

				Persona clienteFactura = new Persona("", "", 0);
				for(int i = 0; i < clientes.length; i++) {
					if(clientes[i] != null && clientes[i].cedula == cedulaCliente) {
						clienteFactura = clientes[i];
						break;
					} else {
						clienteFactura = new Persona(null , null, 0);
					}
				}

				Persona vendedorFactura = new Persona("", "", 0);
				for(int i = 0; i < vendedores.length; i++) {
					if(vendedores[i] != null && vendedores[i].cedula == cedulaVendedor) {
						vendedorFactura = vendedores[i];
						break;
					} else {
						vendedorFactura = new Persona(null, null, 0);
					}
				}

				int contadorArray = 0;
				for(int i = 0; i < facturas.length; i++){
					if(facturas[i] != null){
					contadorArray++;
					}
				}

				facturas[contadorArray] = new Factura(clienteFactura, vendedorFactura, registroProductos, totalFactura);

				System.out.println("---Productos registrados---");
				facturas[contadorArray].verProductos(registroProductos);
				System.out.println("Total facturado: " + totalFactura);
				
			} else {
				System.out.println(" --- opción invalida ---");
			}

		} while (opcionFactura != 2);
	}

	public static void verProductos(Producto[] array) {
		System.out.println("--- Lista de productos---");
		for(int i = 0; i < array.length; i++) {
			System.out.println((i + 1)+ ". " + array[i].nombre);
		}

	}
/* 	- La lista de Facturas debe tener el siguiente formato:
			  FECHA => ID_FACTURA => VENDEDOR => CLIENTE => TOTAL */
	public static void imprimirListaFacturas(Factura[] array) {
		System.out.println("---Lista de facturas---");
		System.out.println("FECHA => ID_FACTURA => VENDEDOR => CLIENTE => TOTAL");
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null) {
				System.out.println(array[i].fecha + " => " + array[i].numeroFactura + " => " +  array[i].getNombresVendedor() + " => " + array[i].getNombresCliente() +  " => " + array[i].total);
			}
		}		

	}

	public static void verDetalleFactura(Factura[] arrayFactura) {
		Scanner entradaNumero = new Scanner(System.in);		
		Scanner entradaTexto = new Scanner(System.in);
		System.out.println("+------------------------------+");
		System.out.println("|        Detalle factura       |");
		System.out.println("+------------------------------+");
		System.out.println("Ingrese el id de la factura: ");
		int idFactura = entradaNumero.nextInt();

		boolean facturaExiste = false;
		int indexFactura = 0;
		for(int i = 0; i < arrayFactura.length; i++) {
			if(arrayFactura[i] != null && arrayFactura[i].numeroFactura == idFactura) {
				facturaExiste = true;
				indexFactura = i;
				break;
			}
		}

		if (facturaExiste) {
			System.out.println("Existe");
			System.out.println("+----------------------------+");
	        System.out.println("Fecha: " + arrayFactura[indexFactura].fecha);
        	System.out.println("Número de factura: " + idFactura);
			System.out.println("Cliente: " + arrayFactura[indexFactura].getNombresCliente());
			System.out.println("Vendedor: " + arrayFactura[indexFactura].getNombresVendedor());
			arrayFactura[indexFactura].verProductos(arrayFactura[indexFactura].arrayItems);
			System.out.println("Total: " + arrayFactura[indexFactura].total);


		} else {
			System.out.println("---La factura no existe---");
		}

	}
}
