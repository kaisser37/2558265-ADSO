public class Main{
	public static void main(String[] args) {
		
		Persona Clientes [] = new Persona [10];
		Persona Vendedores [] = new Persona [10];
		Producto Productos [] = new Producto [10];
		
		Clientes[0] = new Persona("108800", "Oscar Loaiza", "Calle 20");
		Clientes[1] = new Persona("108801", "Santiago Vergara", "Carrera 10");
		Clientes[2] = new Persona("108802", "Alejandra Velasco", "Calle 26 bis");
		Clientes[3] = new Persona("108803", "Maurico Mejia", "Calle 20");
		Clientes[4] = new Persona("108804", "Mateo Hernandez", "Transversal 32");

		Vendedores[0] = new Persona("109900", "Juan Castillo", "Calle 20");
		Vendedores[1] = new Persona("109901", "Fernando Vergara", "Calle 19");
		Vendedores[2] = new Persona("109902", "Alejandro Velez", "Calle 18");
		Vendedores[3] = new Persona("109903", "Angelica Osorio", "Calle 17");
		Vendedores[4] = new Persona("109904", "Leidy Perez", "Calle 16");

		Productos[0] = new Producto(100, "Leche", 3800);
		Productos[1] = new Producto(101, "Lomo Redondo 350gr", 30000);
		Productos[2] = new Producto(102, "Lomo Cuadrado 350gr", 30000);
		Productos[3] = new Producto(103, "Ducales", 7500);
		Productos[4] = new Producto(104, "Jabon REY", 5000);
		
		Factura ventana = new Factura(Clientes, Vendedores, Productos);

	}
}
