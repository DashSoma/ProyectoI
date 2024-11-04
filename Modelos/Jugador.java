/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoI.Modelos;

/**
 *
 * @author Crisp
 */
public class Jugador {

    private String nombre;
    private int color;
    public String jugador1;
    public String jugador2;
    public int jugadorActual;
    public String ultimoGanador;

    public Jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getColor() {
        return color;
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public int getJugadorActual() {
        return jugadorActual;
    }

    public Jugador(String nombre, int color) {
        this.nombre = nombre;
        this.color = color;
    }
}
