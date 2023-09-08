import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner entradaInt = new Scanner(System.in);
        Jugador[] jugadores = new Jugador[100];
        Equipo[] equipos = new Equipo[50];

        String[] posiciones = new String[4];
        posiciones[0] = "Portero";
        posiciones[1] = "Defensa";
        posiciones[2] = "Centrocampista";
        posiciones[3] = "Delantero";

        int opcMenu = 0;
        boolean mostrarMenu = true;

        do {
            System.out.println(" +---------------------------------------------------------------+");
            System.out.println(" |                  Federación de fútbol ADSO                    |");
            System.out.println(" +---------------------------------------------------------------+");
            System.out.println(" | 1. Crear jugador de fútbol                                    |");
            System.out.println(" | 2. Crear equipo de fútbol                                     |");
            System.out.println(" | 3. Cambiar jugador de equipo                                  |");
            System.out.println(" | 4. Ver Listado de Equipos de Futbol                           |");
            System.out.println(" | 5. Ver detalle de Equipos de Futbol                           |");
            System.out.println(" | 6. Registrar Partido                                          |");
            System.out.println(" | 7. Ver detalle de Partidos de Futbol                          |");
            System.out.println(" | 8. Ver listado de Partidos de Futbol realizados en un Estadio |");
            System.out.println(" +---------------------------------------------------------------+");
            System.out.print("  Seleccionar una opción: ");
            opcMenu = entradaInt.nextInt();
            System.out.println("");

            if (opcMenu == 1) {
                Funciones.crearJugador(jugadores, posiciones);
            } else if (opcMenu == 2) {
                Funciones.crearEquipo(equipos, jugadores, opcMenu);
            } else if (opcMenu == 3) {
                Funciones.cambiarJugadorEquipo(equipos, opcMenu);
            } else if (opcMenu == 4) {
                Funciones.verListadoEquipos(equipos);
            } else if (opcMenu == 5) {
                Funciones.verDetallesEquipo(equipos);
            } else if (opcMenu == 6) {
                
            } else if (opcMenu == 7) {
                
            } else if (opcMenu == 8) {
                System.out.println("   Saliendo...");
                mostrarMenu = false;
            } else {
                System.out.println("   ¡Opción inválida!\n");
            }

        } while (mostrarMenu);


    }
}