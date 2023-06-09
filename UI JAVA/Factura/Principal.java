public class Principal{
	public static void main(String[] args) {
		
		Persona listaClientes [] = new Persona [100];
		Persona listaVendedores [] = new Persona [10];
		Producto listaProductos [] = new Producto [10];
		
		listaClientes[0] = new Persona("108800", "Oscar Loaiza", "Calle 20");
		listaClientes[1] = new Persona("108801", "Santiago Vergara", "Carrera 10");
		listaClientes[2] = new Persona("108802", "Alejandra Velasco", "Calle 26 bis");
		listaClientes[3] = new Persona("108803", "Maurico Mejia", "Calle 20");
		listaClientes[4] = new Persona("108804", "Mateo Hernandez", "Transversal 32");

		listaVendedores[0] = new Persona("109900", "Juan Castillo", "Calle 20");
		listaVendedores[1] = new Persona("109901", "Fernando Vergara", "Calle 19");
		listaVendedores[2] = new Persona("109902", "Alejandro Velez", "Calle 18");
		listaVendedores[3] = new Persona("109903", "Angelica Osorio", "Calle 17");
		listaVendedores[4] = new Persona("109904", "Andres Vigo", "Calle 16");

		listaProductos[0] = new Producto(100, "Leche", 3800);
		listaProductos[1] = new Producto(101, "Lomo Redondo 350gr", 30000);
		listaProductos[2] = new Producto(102, "Lomo Cuadrado 350gr", 30000);
		listaProductos[3] = new Producto(103, "Ducales", 7500);
		listaProductos[4] = new Producto(104, "Jabon REY", 5000);
		
		Facturador inicio = new Facturador(listaClientes, listaVendedores, listaProductos);

	}
}
