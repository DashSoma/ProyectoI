/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author dashs
 */
public class JugadorBoot {
    
    private String nombre;
    private int color;
    public String jugador1;
    public int jugadorActual;

    public JugadorBoot() {
    }

    public JugadorBoot(String nombre, int color) {
        this.nombre = nombre;
        this.color = color;
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

    public int getJugadorActual() {
        return jugadorActual;
    }
    
}
