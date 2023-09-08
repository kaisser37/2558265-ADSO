public class Jugador {
    int cedula;
    String nombres;
    String apellidos;
    String posicion;
    boolean estado = true;

    public Jugador(int cedula, String nombres, String apellidos, String posicion) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.posicion = posicion;
    }

}