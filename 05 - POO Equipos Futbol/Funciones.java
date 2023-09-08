import java.util.Scanner;

public abstract class Funciones {

    // 1. crear jugador
    public static void crearJugador(Jugador[] array, String[] posiciones) {
        Scanner entradaInt = new Scanner(System.in);
        Scanner entradaLine = new Scanner(System.in);

        System.out.println(" +---------------------------------+");
        System.out.println(" |          CREAR JUGADOR          |");
        System.out.println(" +---------------------------------+");
        System.out.println("");
        System.out.println("  Número de documento:");
        int cedula = entradaInt.nextInt();

        if (documentoExiste(array, cedula)) {
            System.out.println("   - ¡El jugador ya existe! -");
        } else {
            System.out.println("  Nombres:");
            String nombres = entradaLine.nextLine();
            System.out.println("  Apellidos:");
            String apellidos = entradaLine.nextLine();
            System.out.println("  Seleccione la posición:");
            String posicion = seleccionarPosicion(posiciones);

            array[contadorArray(array)] = new Jugador(cedula, nombres, apellidos, posicion); 

            System.out.println("   - Jugador creado con exito -");
        }
    }

    public static void crearEquipo(Equipo[] equipos, Jugador[] jugadores, int opcMenu) {
        Scanner entradaInt = new Scanner(System.in);
        Scanner entradaLine = new Scanner(System.in);
        Jugador[] jugadoresEquipo = new Jugador[25];
        int opcCE = 0; // opcion Crear Equipo
        int contDisponibles = 0;
        int contContratados = 0;

        System.out.println(" +---------------------------------+");
        System.out.println(" |          CREAR EQUIPO           |");
        System.out.println(" +---------------------------------+");
        System.out.println("");
        System.out.println(" Nombre:");
        String nombre = entradaLine.nextLine();
        if (nombreDisponible(equipos, nombre)) {
            System.out.println(" Nombre del técnico:");
            String tecnico = entradaLine.nextLine();
            do {
                System.out.println(" +---------------------------------+");
                System.out.println(" | 1. ingresar jugador al equipo   |");
                System.out.println(" | 2. crear equipo                 |");
                System.out.println(" +---------------------------------+");
                System.out.print("  Seleccionar una opción: ");
                opcCE = entradaInt.nextInt();
                System.out.println("");

                if (opcCE == 1) {
                    for(int i = 0; i < jugadores.length; i++) {
                        if (jugadores[i] != null && jugadores[i].estado == true) {
                            contDisponibles++;
                        }
                    }
                    if (contDisponibles == contContratados) {
                        System.out.println("   - no hay jugadores para contratar -");
                    } else {
                        System.out.println("   Buscando jugadores disponibles...");
                        System.out.println("  Seleccione un jugador por número de documento: ");
                        jugadoresEquipo[contadorArray(jugadoresEquipo)] = seleccionarJugador(jugadores, opcMenu);
                        System.out.println("   - jugador contratado con éxito -\n");
                        contContratados++;
                    }
                } else if (opcCE == 2) {
                    equipos[contadorArray(equipos)] = new Equipo(nombre, tecnico, jugadoresEquipo);
                    System.out.println("   - equipo creado con éxito -\n");
                }
            } while (opcCE != 2);

        } else {
            System.out.println("    - el nombre del equipo ya existe, intente con otro -");
        }
    } 

    public static void cambiarJugadorEquipo(Equipo[] equipos, int opcMenu) {
        Scanner entradaInt = new Scanner(System.in);
        boolean equipoExiste = false;
        int indexEquipo = 0;
        System.out.println(" +---------------------------------+");
        System.out.println(" |    CAMBIAR JUGADOR DE EQUIPO    |");
        System.out.println(" +---------------------------------+");
        System.out.println("");
        int contEquipos = 0;
        for(int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                System.out.println("    + " + equipos[i].codEquipo + " || " + equipos[i].nombre);
                contEquipos++;
            }
        }
        if (contEquipos == 0) {
            System.out.println("    - no hay equipos registrados por el momento -");
        } else {
            System.out.println("   Seleccione el código de equipo del jugador a cambiar:");
            int codigo = entradaInt.nextInt();
            for(int i = 0; i < equipos.length; i++) {
                if (equipos[i] != null && equipos[i].codEquipo == codigo) {
                    equipoExiste = true;
                    indexEquipo = i;
                    break;
                }
            }
            if (!equipoExiste) {
                System.out.println("    - el equipo no existe -");
            } else {
                System.out.println("   Seleccione el jugador a cambiar:");
                equipos[indexEquipo].verJugadoresEquipo();
                Jugador jugadorCambio = seleccionarJugador(equipos[indexEquipo].jugadoresEquipo, opcMenu);
                System.out.println("   Seleccione el equipo nuevo");
                for(int i = 0; i < equipos.length; i++) {
                    if (equipos[i] != null && equipos[i].codEquipo != codigo) {
                        System.out.println("    + " + equipos[i].codEquipo + " || " + equipos[i].nombre);
                    }
                }
                // asignando jugadorCambio en nuevo equipo
                int codEquipoNuevo = entradaInt.nextInt();
                for(int i = 0; i < equipos.length; i++) {
                    if (equipos[i] != null && equipos[i].codEquipo == codEquipoNuevo) {
                        equipos[i].jugadoresEquipo[contadorArray(equipos[i].jugadoresEquipo)] = jugadorCambio;
                        break;
                    }
                }
                // eliminando el jugador del equipo antiguo
                for(int i = 0; i < equipos[indexEquipo].jugadoresEquipo.length; i++) {
                    if (equipos[indexEquipo].jugadoresEquipo[i] != null && equipos[indexEquipo].jugadoresEquipo[i].cedula == jugadorCambio.cedula) {
                    equipos[indexEquipo].jugadoresEquipo[i] = null;
                    for(int j = i; j < equipos[indexEquipo].jugadoresEquipo.length - 1; j++) {
                        Jugador temporal = equipos[indexEquipo].jugadoresEquipo[i];
                        equipos[indexEquipo].jugadoresEquipo[i] = equipos[indexEquipo].jugadoresEquipo[j+1];
                        equipos[indexEquipo].jugadoresEquipo[j+1] = temporal;    
                    }
                    break;
                    }
                }
                System.out.println("    - jugador asignado con exito -");
            }

        }

    }

    public static void verListadoEquipos(Equipo[] equipos) {
        int contEquipos = 0;
        System.out.println(" +---------------------------------+");
        System.out.println(" |         LISTA DE EQUIPOS        |");
        System.out.println(" +---------------------------------+");
        System.out.println("");
        for(int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                System.out.println("   > Cod: "+ equipos[i].codEquipo + " || " + equipos[i].nombre);
                contEquipos++;
            }
        }
        if (contEquipos == 0) {
            System.out.println("    - noy hay equipos registrados por el momento -");
        }
    }

    public static void verDetallesEquipo(Equipo[] equipos) {
        Scanner entradaInt = new Scanner(System.in);
        System.out.println(" +---------------------------------+");
        System.out.println(" |       DETALLES DE EQUIPOS       |");
        System.out.println(" +---------------------------------+");
        System.out.println("");
        System.out.println("   Seleccione el equipo:");
        int contEquipos = 0;
        for(int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                System.out.println("    + " + equipos[i].codEquipo + " || " + equipos[i].nombre);
                contEquipos++;
            }
        }
        if (contEquipos == 0) {
            System.out.println("    - no hay equipos registrados por el momento -");
        } else {
            System.out.println("   Seleccione el código del equipo:");
            int codigo = entradaInt.nextInt();
            for(int i = 0; i < equipos.length; i++) {
                if (equipos[i] != null && equipos[i].codEquipo == codigo) {
                    System.out.println("    > Nombre: " + equipos[i].nombre);
                    System.out.println("    > Técnico: " + equipos[i].tecnico);
                    System.out.println("    > Jugadores:");
                    equipos[i].verJugadoresEquipo();
                    break;
                }
            }
        }

    }

    public static int contadorArray(Object[] array) {
        int contadorArray = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] != null) {
				contadorArray++;
			}
		}
        return contadorArray;
    }

    public static boolean nombreDisponible(Object[] array, String nombre) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i] instanceof Equipo && ((Equipo) array[i]).nombre.equalsIgnoreCase(nombre)) {
                return false;
            }
        }
        return true;
    }


    public static boolean documentoExiste(Object[] array, int cedula) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i] instanceof Jugador && ((Jugador) array[i]).cedula == cedula) {
                return true;
            }
        }
        return false;
    }


   /*  public static boolean documentoExiste(Object[] array, int cedula) {
        for(int i = 0; i < array.length; i++ ) {
            if (array[i] != null && array[i].cedula == cedula) {
                return true;
                break;
            }
        }

    } */

    public static String seleccionarPosicion(String[] array) {
        Scanner entradaLine = new Scanner(System.in);
        boolean posIncorrecta = true;
        String pos;

        do {
            for(int i = 0; i < array.length; i++) {
                System.out.println("    + " + array[i]);
            }
            pos = entradaLine.nextLine();
            // verificando si la posicion es correcta
            for(int i = 0; i < array.length; i++) {
                if (array[i].equalsIgnoreCase(pos)) {
                    posIncorrecta = false;
                    break;
                }
            }
            if (posIncorrecta) {
                System.out.println("");
                System.out.println("    - la posición no es correcta -");
                System.out.println("");
            }

        } while (posIncorrecta);
        return pos;        
    }

    public static Jugador seleccionarJugador(Jugador[] array, int opcMenu) {
        Scanner entradaInt = new Scanner(System.in);
        boolean selIncorrecta = true;
        int indexJugador = 0;
        Jugador nuevoJugador = null;
        do {
            for(int i = 0; i < array.length; i++) {
                if (array[i] != null && array[i].estado == (opcMenu == 2)? true: false) {
                    System.out.println("    + " + array[i].cedula + " || " + array[i].nombres + " || " + array[i].posicion);
                }
            }

            int cedulaJugador = entradaInt.nextInt();
            // verificando si la posicion es correcta
            for(int i = 0; i < array.length; i++) {
                if (array[i] != null && array[i].cedula == cedulaJugador) {
                    selIncorrecta = false;
                    array[i].estado = false;
                    indexJugador = i;
                    break;
                }
            }

            if (selIncorrecta) {
                System.out.println("");
                System.out.println("    - la selección no es correcta -");
                System.out.println("");
            }
        } while (selIncorrecta);

        nuevoJugador = new Jugador(array[indexJugador].cedula, array[indexJugador].nombres, array[indexJugador].apellidos, array[indexJugador].posicion);
        return nuevoJugador;        
    }

}