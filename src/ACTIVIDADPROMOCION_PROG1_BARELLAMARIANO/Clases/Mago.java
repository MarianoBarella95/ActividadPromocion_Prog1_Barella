package ACTIVIDADPROMOCION_PROG1_BARELLAMARIANO.Clases;

import javax.swing.JOptionPane;

public class Mago extends Jugador {

    Arma arma;

    /*
     * MÉTODO CONSTRUCTOR
     */

    public Mago() {
        super();
        this.arma = new Arma("Rayo Azul", 30);
    }

    /*
     * MÉTOO CARGAR MAGO
     */

    public void cargarMago(int nJugador) {
        super.cargarJugador(nJugador, "Mago", id);

        String[] armas = {"Rayo Azul (Infringe +30 de daño pero debe sacar +4)", "Rayo Verde (Infringe +20 de daño)"};

        int opciones = JOptionPane.showOptionDialog(null, "Elija un hechizo", "Elección de Hechizo", 0, 3, null, armas, armas[0]);

        switch (opciones) {
            case 0:
                this.arma = new Arma("Rayo Azul", 30);
                break;
            case 1: 
                this.arma = new Arma("Rayo Verde", 20);
                break;
            default:
                break;
        }
    }

    /*
     * MÉTODO MOSTRAR MAGO
     */

    public void mostrarMago() {
        super.mostrarJugador();

        String mensaje = String.format("Arma: %s", this.arma);

        System.out.println(mensaje);
    }

    /*
     ? MÉTODO ATACAR MAGO
     */

    public void ataqueMago(Monstruo monstruo, int dado) {

        int daño = this.arma.getDaño();

        if (dado > 4 && arma.getNombre() == "Rayo Azul") {
            JOptionPane.showMessageDialog(null, "Infringiste -"+daño+" de daño al monstruo con "+arma.getNombre());
            monstruo.recibirDaño(daño);
        } else if (dado <= 4 && arma.getNombre() == "Rayo Azul") {
            JOptionPane.showMessageDialog(null, "No infringiste daño.");
        } else if (arma.getNombre() == "Rayo Verde") {
            JOptionPane.showMessageDialog(null, "Infringiste -"+daño+" de daño al monstruo con "+arma.getNombre());
            monstruo.recibirDaño(daño);
        }
    }

}
