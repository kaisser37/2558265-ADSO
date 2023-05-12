public class Persona {
    int cedula;
    String nombres;
    String apellidos;

    public Persona(String nombres, String apellidos, int cedula) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public int getCedula() {
	    return this.cedula;
	}

    public String getNombres(){
        return this.nombres;
    }

    public String getApellidos(){
        return this.apellidos;
    }

}






