package ACTIVIDADPROMOCION_PROG1_BARELLAMARIANO.Clases;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Jugador {
    Scanner ext = new Scanner(System.in);


    protected String nombre; 
    protected int salud = 0;
    protected int id;
    protected int intentos = 0;
    protected String raza;
    protected Boolean gano;
    protected long tiempoJuego;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void cargarJugador(int nJugador, String raza, int id) {
        this.nombre = JOptionPane.showInputDialog("Ingresel el nombre del jugador "+nJugador);
        this.salud = 100;
        this.raza = raza;
        this.id = id;
    }

    /*
     * MÉTODO MOSTRAR JUGADOR
     */

    @Override
    public String toString() {
        return "nombre=" + nombre + ", salud=" + salud;
    }

    public void mostrarJugador() {
        String mensaje = String.format("\nId: %d\nNombre: %s\nIntentos: %d\n¿Ganó?: %s\nRaza: %s\nTiempo de Juego: %d segundos.",this.id, this.nombre, this.intentos, this.gano, this.raza, this.tiempoJuego);
        JOptionPane.showMessageDialog(null, mensaje, "Información del Jugador", 1);
    }
    
}
