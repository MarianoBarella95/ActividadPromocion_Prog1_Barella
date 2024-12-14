package ACTIVIDADPROMOCION_PROG1_BARELLAMARIANO;

import ACTIVIDADPROMOCION_PROG1_BARELLAMARIANO.Clases.*;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.time.*;

public class demoRPG {
    private static int cantGanadores = 0;

    private static int getCantGanadores() {
        return cantGanadores;
    }

    private void setCantGanadores(int cantGanadores) {
        this.cantGanadores = cantGanadores;
    }

    public static void main(String[] args) throws Exception {

        ImageIcon iconoMenu = new ImageIcon("src/guerrero.jpeg");

        boolean conditionMenu = true;

        do {

            try {

                int cantJugadores = Integer
                        .parseInt(JOptionPane.showInputDialog("Antes de comenzar, ingrese la cantidad de jugadores: "));
                Jugador Jugadores[] = new Jugador[cantJugadores];

                boolean condition = true;

                do {

                    /*
                     * MUESTRA EL MENÚ PRINCIPAL
                     */

                    try {
                        String[] opciones = { "Comenzar Juego", "Listar Jugadores", "Mostrar Ganadores",
                                "Ver Ganador (Por menos intentos)", "Listar Jugadores por Raza",
                                "Ver Ganador (Por menos tiempo)", "Buscar Jugador por Id", "Salir del Juego" };

                        String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción",
                                "Menú de Opciones", 2, iconoMenu, opciones, opciones[0]);

                        switch (opcion) {
                            case "Comenzar Juego":
                                /*
                                 * COMIENZA EL JUEGO
                                 */
                                for (int i = 0; i < Jugadores.length; i++) {

                                    String[] razas = { "Guerrero", "Mago", "Orco" };

                                    int seleccion = JOptionPane.showOptionDialog(null, "Elija la raza del jugador",
                                            "Elección de raza", 0, 3, null, razas, razas[0]);

                                    switch (seleccion) {
                                        case 0:
                                            Guerrero j = new Guerrero();
                                            Monstruo monstruo = new Monstruo(100);
                                            Jugadores[i] = j;
                                            j.cargarGuerrero(i + 1);
                                            j.setId(i + 1);
                                            menuJuego();
                                            int saludJugador = Jugadores[i].getSalud();
                                            int intentosJugador = Jugadores[i].getIntentos();
                                            boolean bandera = true;
                                            Instant inicioGuerrero = Instant.now();

                                            while (bandera) {
                                                JOptionPane.showMessageDialog(null, "Se lanza el dado", "Dado", 1);

                                                int dado = tirarDado();
                                                JOptionPane.showMessageDialog(null, "El dado salió: " + dado, "Dado",
                                                        2);

                                                if (dado <= 3) {
                                                    saludJugador -= 20;
                                                    intentosJugador++;
                                                    JOptionPane.showMessageDialog(null,
                                                            "Te infringió -20 de daño.\nSalud "
                                                                    + Jugadores[i].getNombre()
                                                                    + ":" + saludJugador +
                                                                    "\nSalud Monstruo: " + monstruo.getSalud()
                                                                    + "\nIntentos: " + intentosJugador);
                                                } else if (dado > 3) {
                                                    j.ataqueGuerrero(monstruo);
                                                    intentosJugador++;
                                                    JOptionPane.showMessageDialog(null,
                                                            "\nSalud " + Jugadores[i].getNombre() + ":" + saludJugador
                                                                    + "\nIntentos: " + intentosJugador,
                                                            "Salud del Jugador", 1);
                                                }

                                                bandera = finalizarPartida(j, monstruo, bandera, saludJugador,
                                                        intentosJugador, cantGanadores);
                                                Instant finGuerrero = Instant.now();

                                                calcularTiempo(j, inicioGuerrero, finGuerrero);
                                            }
                                            break;
                                        /*
                                         * INGRESAR MAGO
                                         */
                                        case 1:
                                            Mago m = new Mago();
                                            Monstruo monstruo1 = new Monstruo(100);
                                            Jugadores[i] = m;
                                            m.cargarMago(i + 1);
                                            m.setId(i + 1);
                                            menuJuego();
                                            int saludJugadorMago = Jugadores[i].getSalud();
                                            int intentosJugadorMago = Jugadores[i].getIntentos();
                                            boolean bandera1 = true;
                                            Instant inicioMago = Instant.now();

                                            while (bandera1) {
                                                JOptionPane.showMessageDialog(null, "Se lanza el dado", "Dado", 1);

                                                int dado = tirarDado();
                                                JOptionPane.showMessageDialog(null, "El dado salió: " + dado, "Dado",
                                                        2);

                                                if (dado <= 3) {
                                                    System.out.println("Te infringió -20 de daño.");
                                                    saludJugadorMago -= 20;
                                                    intentosJugadorMago++;
                                                    JOptionPane.showMessageDialog(null,
                                                            "Te infringió -20 de daño.\nSalud "
                                                                    + Jugadores[i].getNombre()
                                                                    + ":" + saludJugadorMago +
                                                                    "\nSalud Monstruo: " + monstruo1.getSalud()
                                                                    + "\nIntentos: " + intentosJugadorMago);
                                                } else if (dado > 3) {
                                                    m.ataqueMago(monstruo1, dado);
                                                    intentosJugadorMago++;
                                                    JOptionPane.showMessageDialog(null,
                                                            "Salud " + Jugadores[i].getNombre() + ":" + saludJugadorMago
                                                                    + "\n Intentos: " + intentosJugadorMago,
                                                            "Salud del Jugador", 1);
                                                }

                                                bandera1 = finalizarPartida(m, monstruo1, bandera1,
                                                        saludJugadorMago,
                                                        intentosJugadorMago, cantGanadores);
                                                Instant finMago = Instant.now();
                                                calcularTiempo(m, inicioMago, finMago);

                                            }
                                            break;
                                        /*
                                         * INGRESAR ORCO
                                         */
                                        case 2:
                                            Orco o = new Orco();
                                            Monstruo monstruo2 = new Monstruo(100);
                                            Jugadores[i] = o;
                                            o.cargarOrco(i + 1);
                                            o.setId(i + 1);
                                            menuJuego();
                                            int saludJugadorOrco = Jugadores[i].getSalud();
                                            int intentosJugadorOrco = Jugadores[i].getIntentos();
                                            boolean bandera2 = true;
                                            Instant inicioOrco = Instant.now();

                                            while (bandera2) {

                                                JOptionPane.showMessageDialog(null, "Se lanza el dado", "Dado", 1);

                                                int dado = tirarDado();
                                                JOptionPane.showMessageDialog(null, "El dado salió: " + dado, "Dado",
                                                        2);

                                                if (dado <= 3) {
                                                    System.out.println("Te infringió -20 de daño.");
                                                    saludJugadorOrco -= 20;
                                                    intentosJugadorOrco++;
                                                    JOptionPane.showMessageDialog(null,
                                                            "Te infringió -20 de daño.\nSalud "
                                                                    + Jugadores[i].getNombre()
                                                                    + ":" + saludJugadorOrco +
                                                                    "\nSalud Monstruo: " + monstruo2.getSalud()
                                                                    + "\nIntentos: " + intentosJugadorOrco);
                                                } else if (dado > 3) {
                                                    o.ataqueOrco(monstruo2, dado);
                                                    intentosJugadorOrco++;
                                                    JOptionPane.showMessageDialog(null,
                                                            "Salud " + Jugadores[i].getNombre() + ":" + saludJugadorOrco
                                                                    + "\n Intentos: " + intentosJugadorOrco,
                                                            "Salud del Jugador", 1);
                                                }

                                                bandera2 = finalizarPartida(o, monstruo2, bandera2,
                                                        saludJugadorOrco,
                                                        intentosJugadorOrco, cantGanadores);
                                                Instant finOrco = Instant.now();
                                                calcularTiempo(o, inicioOrco, finOrco);
                                            }
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Ingrese una opción Válida",
                                                    "Error en el ingreso", 0);
                                            break;
                                    }

                                }
                                break;
                            case "Listar Jugadores":
                                /*
                                 * LISTAR JUGADORES
                                 */
                                listarJugadores(Jugadores);
                                break;
                            case "Mostrar Ganadores":
                                /*
                                 * MOSTRAR GANADORES
                                 */
                                mostrarGanadores(Jugadores, cantGanadores, cantJugadores);
                                break;
                            case "Ver Ganador (Por menos intentos)":
                                /*
                                 * MOSTRAR GANADOR POR INTENTOS
                                 */
                                try {
                                    if (cantJugadores == 0 || cantGanadores == 0) {
                                        JOptionPane.showMessageDialog(null, "No hay jugadores o ganadores para mostrar",
                                                "Error", 1);
                                    } else {
                                        ordenarGanadores(Jugadores, cantJugadores, cantGanadores);

                                        /*
                                         * LUEGO DE ORDENAR POR INTENTOS
                                         * REALIZA UNA BÚSQUEDA SECUENCIAL PARA ENCONTRAR
                                         * EL JUGADOR CON MENOS INTENTOS
                                         */

                                        for (int j = 0; j < Jugadores.length; j++) {
                                            if (Jugadores[j].getGano()) {
                                                JOptionPane.showMessageDialog(null,
                                                        "El jugador" + Jugadores[j].getNombre()
                                                                + " ganó " + " con " + Jugadores[j].getIntentos()
                                                                + " intentos.");
                                            }
                                            break;
                                        }
                                    }
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Ocurrió un error", "Error", 0);
                                }
                                break;
                            case "Listar Jugadores por Raza":
                                /*
                                 * LISTAR JUGADORES POR RAZA
                                 */
                                int nGuerrero = 0;
                                int nMago = 0;
                                int nOrco = 0;

                                for (Jugador jugador : Jugadores) {
                                    if (jugador instanceof Guerrero) {
                                        nGuerrero++;
                                    } else if (jugador instanceof Mago) {
                                        nMago++;
                                    } else if (jugador instanceof Orco) {
                                        nOrco++;
                                    }
                                }

                                String mensaje = String.format(
                                        "\nJugadores por Raza: \nGuerrero: %s\nMago: %s\nOrco: %s",
                                        nGuerrero, nMago, nOrco);
                                JOptionPane.showMessageDialog(null, mensaje, "Cantidad de Jugadores por Raza", 1);
                                break;
                            case "Ver Ganador (Por menos tiempo)":
                                if (cantJugadores == 0 || cantGanadores == 0) {
                                    JOptionPane.showMessageDialog(null, "No hay jugadores o ganadores para mostrar.",
                                            "Error", 1);
                                } else {
                                    ganadorTiempo(Jugadores, cantJugadores, cantGanadores);
                                    for (int j = 0; j < Jugadores.length; j++) {
                                        if (Jugadores[j].getGano()) {
                                            JOptionPane.showMessageDialog(null,
                                                    "El jugador " + Jugadores[j].getNombre() + " ganó con "
                                                            + Jugadores[j].getTiempoJuego() + " segundos.",
                                                    "Ganador por Tiempo", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        break;
                                    }
                                }
                                break;
                            case "Buscar Jugador por Id":
                                int nABuscar = Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "Ingrese el número a buscar", null, JOptionPane.QUESTION_MESSAGE));
                                buscarId(Jugadores, nABuscar, cantJugadores);
                                break;
                            case "Salir del Juego":
                                condition = false;
                                conditionMenu = false;
                                JOptionPane.showMessageDialog(null, "Gracias por jugar!", "Saludo Final",
                                        JOptionPane.PLAIN_MESSAGE);
                                break;
                            default:
                                break;
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("\n\t*************************");
                        System.out.println("\n\tIngrese un número entero.");
                        System.out.println("\n\t*************************");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n\t*************************");
                        System.out.println("\n\tIngrese un número entero.");
                        System.out.println("\n\t*************************");
                    }

                } while (condition);

            } catch (

            NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero.", "Ha ocurrido un error.", 1);
            }
        } while (conditionMenu);

    }

    /*
     * ***************************
     */
    /*
     * MÉTODOS DE LA CLASE MAIN
     */
    /*
     * ***************************
     */

    /*
     * MÉTODO TIRAR DADO
     */

    public static int tirarDado() {
        int n = (int) (Math.random() * 6 + 1);

        return n;
    }

    /*
     * MÉTODO MOSTRAR MENÚ JUEGO
     */

    public static void menuJuego() {

        String mensaje = "\nComienza el juego...\nEl jugador se despierta en un calabozo, una vez que abre la puerta debe enfrentarse a un monstruo para poder escapar.."
                +
                "\nTire un dado para ver si tiene suerte (Si saca más de 3 ataca al monstruo, si saca menos, el monstruo lo ataca a usted.)";

        JOptionPane.showMessageDialog(null, mensaje, "Comienzo del JUego", JOptionPane.INFORMATION_MESSAGE);
    }

    /*
     * MÉTODO FINALIZAR PARTIDA
     */

    public static boolean finalizarPartida(Jugador j, Monstruo monstruo, boolean bandera, int saludJugador,
            int intentosJugador, int cantGanadores) {

        if (saludJugador > 0 && monstruo.getSalud() <= 0) {
            j.setIntentos(intentosJugador);
            j.setGano(true);
            bandera = false;
            demoRPG.cantGanadores++;
            JOptionPane.showMessageDialog(null, "Has sobrevivido en " + intentosJugador
                    + " intentos, eres libre!\nCantidad de Ganadores: " + demoRPG.getCantGanadores());
        } else if (saludJugador <= 0 && monstruo.getSalud() > 0) {
            j.setIntentos(intentosJugador);
            j.setGano(false);
            bandera = false;
            JOptionPane.showMessageDialog(null, "El monstruo te ha derrotado en " + intentosJugador + " intentos.");
        }

        return bandera;

    }

    /*
     * MÉTODO LISTAR JUGADORES
     */

    public static void listarJugadores(Jugador[] Jugadores) {

        try {
            if (Jugadores.length == 0) {
                JOptionPane.showMessageDialog(null, "No hay jugadores para mostrar", "Error", 1);
            } else {
                for (int i = 0; i < Jugadores.length; i++) {
                    Jugadores[i].mostrarJugador();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay jugadores para mostrar!", "Error", 1);
        }

    }

    /*
     * MÉTODO MOSTRAR GANADORES
     */

    public static void mostrarGanadores(Jugador[] Jugadores, int cantGanadores, int cantJugadores) {

        try {
            if (cantGanadores == 0) {
                JOptionPane.showMessageDialog(null, "Todavía no hay ganadores", null, 1);
            } else {
                for (int i = 0; i < Jugadores.length; i++) {
                    if (Jugadores[i].getGano()) {
                        JOptionPane.showMessageDialog(null, "\n\tEl jugador " + Jugadores[i].getNombre() + " ganó en "
                                + Jugadores[i].getIntentos() + " intentos.", null, 1);
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Todavía no hay ganadores", "Error", 1);
        }

    }

    /*
     * MÉTODO MOSTRAR GANADOR
     * POR INTENTOS (BUBBLE SORT)
     */

    public static void ordenarGanadores(Jugador[] Jugadores, int cantJugadores, int cantGanadores) {

        try {

            boolean cambios = true;

            while (cambios) {
                cambios = false;
                for (int i = 0; i < Jugadores.length - 1; i++) {
                    if (Jugadores[i].getIntentos() > Jugadores[i + 1].getIntentos()) {
                        cambios = true;
                        Jugador Jugador = Jugadores[i];
                        Jugadores[i] = Jugadores[i + 1];
                        Jugadores[i + 1] = Jugador;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error!", "Error", 1);
        }

    }

    /*
     * CALCULAR TIEMPO DE JUEGO
     */

    public static void calcularTiempo(Jugador jugador, Instant inicio, Instant fin) {

        Duration duracion = Duration.between(inicio, fin);
        long segundos = duracion.getSeconds();
        jugador.setTiempoJuego(segundos);

    }

    /*
     * MOSTRAR GANADOR
     * POR TIEMPO (BUBBLE SORT)
     */

    public static void ganadorTiempo(Jugador[] Jugadores, int cantJugadores, int cantGanadores) {

        try {

            boolean cambios = true;

            while (cambios) {
                cambios = false;
                for (int i = 0; i < Jugadores.length - 1; i++) {
                    if (Jugadores[i].getTiempoJuego() > Jugadores[i + 1].getTiempoJuego()) {
                        cambios = true;
                        Jugador Jugador = Jugadores[i];
                        Jugadores[i] = Jugadores[i + 1];
                        Jugadores[i + 1] = Jugador;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error", null, 1);
        }

    }

    /*
     * BUSCAR JUGADOR POR ID
     * (BÚSQUEDA BINARIA)
     */

    public static void buscarId(Jugador[] Jugadores, int nABuscar, int cantJugadores) {

        try {
            /*
             * ORDENO POR LAS DUDAS LA LISTA
             * CON BUBBLE SORT
             */

            boolean cambios = true;

            while (cambios) {
                cambios = false;
                for (int i = 0; i < Jugadores.length - 1; i++) {
                    if (Jugadores[i].getId() > Jugadores[i + 1].getId()) {
                        cambios = true;
                        Jugador Jugador = Jugadores[i];
                        Jugadores[i] = Jugadores[i + 1];
                        Jugadores[i + 1] = Jugador;
                    }
                }
            }

            int min = 0;
            int max = Jugadores.length - 1;

            while (min <= max) {
                int mid = (min + max) / 2;
                int midN = Jugadores[mid].getId();

                if (nABuscar == midN) {
                    JOptionPane.showMessageDialog(null,
                            "El Jugador " + Jugadores[mid].getNombre() + " posee el Id " + Jugadores[mid].getId(), null,
                            1);
                    return;
                } else if (nABuscar < midN) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }

            JOptionPane.showMessageDialog(null, "El número ingresado no coincide con ningún Id", "Error", 1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay jugadores para mostrar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
