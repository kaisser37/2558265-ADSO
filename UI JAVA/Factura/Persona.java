public class Persona{

	private String cedula;
	private String nombres;
	private String direccion;

	public Persona(String cedula, String nombres, String direccion){
		this.cedula = cedula;
		this.nombres = nombres;
		this.direccion = direccion;
	}

	public String getCedula(){
		return cedula;
	}

	public String getNombres(){
		return nombres;
	}

	public String getDireccion(){
		return direccion;
	}

}
