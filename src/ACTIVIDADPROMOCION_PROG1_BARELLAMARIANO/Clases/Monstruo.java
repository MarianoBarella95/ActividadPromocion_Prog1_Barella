package ACTIVIDADPROMOCION_PROG1_BARELLAMARIANO.Clases;

import javax.swing.JOptionPane;

public class Monstruo extends Jugador {
    int salud = 100;

    /*
     * GETTERS & SETTERS
     */

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    /*
     * MÉTODO CONSTRUCTOR
     */

    public Monstruo(int salud) {
        this.salud = salud;
    }

    /*
     * MÉTODO RECIBIR DAÑO
     */

    public void recibirDaño(int daño) {

        salud-=daño;
    
        if (salud <= 0) {
            JOptionPane.showMessageDialog(null, "El monstruo ha sido derrotado.", "Victoria!", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Salud Monstruo: "+salud, "Salud del Monstruo", 1);
        }
        
    }

}
