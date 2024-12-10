package ACTIVIDADPROMOCION_PROG1_BARELLAMARIANO.Clases;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Jugador {
    Scanner ext = new Scanner(System.in);


    String nombre; 
    int salud = 0;
    int intentos = 0;
    String raza;
    Boolean gano;
    long tiempoJuego;

    /*
     * GETTERS & SETTERS
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public boolean getGano() {
        return gano;
    }

    public void setGano(boolean gano) {
        this.gano = gano;
    }

    public long getTiempoJuego() {
        return tiempoJuego;
    }

    public void setTiempoJuego(long tiempoJuego) {
        this.tiempoJuego = tiempoJuego;
    }

    /*
     * MÉTODO CONSTRUCTOR
     */
    
    public Jugador() {
        this.nombre = "";
        this.salud = 70;

    }

    /*
     * MÉTODO CARGAR JUGADOR 
     */

    public void cargarJugador(int nJugador, String raza) {
        // System.out.println("Ingrese el nombre del jugador "+nJugador+":");
        // this.nombre = ext.nextLine();
        this.nombre = JOptionPane.showInputDialog("Ingresel el nombre del jugador "+nJugador);
        this.salud = 100;
        this.raza = raza;
    }

    /*
     * MÉTODO MOSTRAR JUGADOR
     */

    @Override
    public String toString() {
        return "nombre=" + nombre + ", salud=" + salud;
    }

    public void mostrarJugador() {
        String mensaje = String.format("\nNombre: %s\nIntentos: %d\n¿Ganó?: %s\nRaza: %s\nTiempo de Juego: %d segundos.", this.nombre, this.intentos, this.gano, this.raza, this.tiempoJuego);
        // System.out.println(mensaje);
        JOptionPane.showMessageDialog(null, mensaje, "Información del Jugador", 0);
    }
    
}
