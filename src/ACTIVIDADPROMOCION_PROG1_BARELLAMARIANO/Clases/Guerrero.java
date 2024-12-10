package ACTIVIDADPROMOCION_PROG1_BARELLAMARIANO.Clases;

import javax.swing.JOptionPane;

public class Guerrero extends Jugador {
    
    Arma arma;

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    /*
     * MÉTODO CONSTRUCTOR
     */

    public Guerrero() {
        super();
        this.arma = new Arma("Espada", 20);
    }    

    /*
     * MÉTODO CARGAR GUERRERO 
     */

    public void cargarGuerrero(int nJugador) {
        super.cargarJugador(nJugador, "Guerrero");

        String[] armas = {"Espada (Infringe +20 de daño)","Hacha (Infringe +30 de daño)","Palo (Infringe +10 de daño)"};
        
        int opciones = JOptionPane.showOptionDialog(null, "Elija un arma", "Elección de Arma", 0, 3, null, armas, armas[0]);

        // System.out.println("\nElija un arma: "+
        // "\n1. Espada (Infringe + 20 de daño)"+
        // "\n2. Hacha (Infringe + 30 de daño)"+
        // "\n3. Palo (Infringe + 10 de daño)");
        // int arma = Integer.parseInt(ext.nextLine());
        switch (opciones) {
            case 0:
                this.arma = new Arma("Espada", 20);
                break;
                case 1: 
                this.arma = new Arma("Hacha", 30);
                break;
            case 2:
                this.arma = new Arma("Palo", 10);
            default:
                break;
        }

    }

    /*
     * MÉTODO MOSTRAR GUERRERO
     */

    public void mostrarGuerrero() {
        super.mostrarJugador();

        String mensaje = String.format("\nArma: %s",this.arma);

        System.out.println(mensaje);
    }

    /*
     ? MÉTODO ATACAR GUERRERO
     */

    public void ataqueGuerrero(Monstruo monstruo) {

        int daño = arma.getDaño();

        // System.out.println("Infringiste -"+daño+" de daño al monstruo con "+arma.getNombre());
        JOptionPane.showMessageDialog(null, "Infringiste -"+daño+" de daño al monstruo con "+arma.getNombre(), "Ataque al Monstruo", 1);


        monstruo.recibirDaño(daño);
    }

}
