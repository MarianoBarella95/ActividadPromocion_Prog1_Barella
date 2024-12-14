package ACTIVIDADPROMOCION_PROG1_BARELLAMARIANO.Clases;

import javax.swing.JOptionPane;

public class Orco extends Jugador {
    
    
    /*
    * LA VENTAJA DEL ORCO ES QUE
    * SI EL DADO ES IGUAL A 6
    * SU ATAQUE ES DEL 40%
    */

    /*
     * MÉTODO CONSTRUCTOR
     */

    public Orco() {
        super();
    }
     
    /*
     * MÉTODO CARGAR ORCO
     */

    public void cargarOrco(int nJugador) {
        super.cargarJugador(nJugador, "Orco", id);
    }

    /*
     * MÉTODO MOSTRAR ORCO
     */

    public void mostrarOrco() {
        super.mostrarJugador();
    }

    /*
     * MÉTODO ATACAR ORCO
     */

    public void ataqueOrco(Monstruo monstruo, int dado) {
        if (dado == 6) {
            JOptionPane.showMessageDialog(null, "Infringiste -40 de daño al monstruo.");
            monstruo.recibirDaño(40);
        } else if (dado < 6) {
            JOptionPane.showMessageDialog(null, "Infringiste -20 de daño al monstruo.");
            monstruo.recibirDaño(20);
        } 
    }
}
