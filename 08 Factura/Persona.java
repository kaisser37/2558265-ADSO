public class Persona {
    int documento;
    String nombres;
    String direccion;

    public Persona( int documento, String nombres, String direccion ){
        this.documento = documento;
        this.nombres = nombres;
        this.direccion = direccion;
    }

    public int getDocumento(){
        return this.documento;
    }

    public String getNombres(){
        return this.nombres;
    }

    public String getDireccion(){
        return this.direccion;
    }

    public void setDocumento(int documento){
        this.documento = documento;
    }

    public void setNombres(String nombres){
        this.nombres = nombres;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
}
