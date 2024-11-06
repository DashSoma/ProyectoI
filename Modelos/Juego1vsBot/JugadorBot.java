/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.Juego1vsBot;

/**
 *
 * @author dashs
 */
public class JugadorBot {

    private String nombre;
    private int color;
    public String jugador = "   Tú";
    public String jugadorBot = "   Bot";
    public int jugadorActual;

    public JugadorBot() {
    }

    public JugadorBot(String nombre, int color) {
        this.nombre = nombre;
        this.color = color;
    }

    public JugadorBot(String jugador, String jugadorBot) {
        this.jugador = jugador;
        this.jugadorBot = jugadorBot;
    }

    public String getNombre() {
        return nombre;
    }

    public int getColor() {
        return color;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getJugadorBot() {
        return jugadorBot;
    }

    public void setJugadorBot(String jugadorBot) {
        this.jugadorBot = jugadorBot;
    }

    public int getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(int jugadorActual) {
        this.jugadorActual = jugadorActual;
    }
}
