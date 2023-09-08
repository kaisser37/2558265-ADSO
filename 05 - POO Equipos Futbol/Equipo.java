public class Equipo {
    int codEquipo;
    static int nextCodEquipo = 100;
    String nombre;
    String tecnico;
    Jugador[] jugadoresEquipo;

    public Equipo(String nombre, String tecnico, Jugador[] jugadoresEquipo) {
        this.codEquipo = nextCodEquipo;
        nextCodEquipo++;
        this.nombre = nombre;
        this.jugadoresEquipo = jugadoresEquipo;

    }

    public void verJugadoresEquipo() {
        for(int i = 0; i < this.jugadoresEquipo.length; i++) {
            if (this.jugadoresEquipo[i] != null) {
                System.out.println("   + " + this.jugadoresEquipo[i].cedula + " || " + this.jugadoresEquipo[i].nombres + " - " + this.jugadoresEquipo[i].posicion);
            }
        }
    }


}

