/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Tablero.Tablero1vsBot;
import Vistas.FrmJuegoBot;
import javax.swing.JOptionPane;

/**
 *
 * @author Crisp
 */
public class Controlador1vsBot {

    Tablero1vsBot model;
    public FrmJuegoBot vista;

    public Controlador1vsBot(Tablero1vsBot model, FrmJuegoBot vista) {
        this.model = model;
        this.vista = vista;
    }

    public void iniciarJuegobot() {
        vista.mostrarMansaje("El juego ha comenzado \n\nInicias con las negras", "¡Ha jugar!", JOptionPane.INFORMATION_MESSAGE);
        vista.setLblNombreJ1("Bot(Blanco)");
        vista.setLblNombreJ2("Tú(Negro)");
        vista.getLblContador1().setText(String.valueOf(model.contadorJugador1));
        vista.getLblContador2().setText(String.valueOf(model.contadorJugador2));
        vista.getLblJugador1().setText("Jugador:");
        vista.getLblJugador2().setText("Jugador:");
        vista.getLblNombreFichasActuales1().setText("Fichas:");
        vista.getLblNombreFichasActuales2().setText("Fichas:");
        vista.getLblContador1().setText(String.valueOf("2"));
        vista.getLblContador2().setText(String.valueOf("2"));
        model.mostrarTabla();
        model.actualizarTurno();
        model.juegoEnProgreso = true;

    }

    public void reiniciar() {

        int result = vista.mostrarMensajeConfirmacion("¿Quieres jugar de nuevo?", "Reiniciar juego",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {

            model.juegoEnProgreso = false;
            model.repaint();
            model.reestablecerVariables();
            iniciarJuegobot();
        }
    }

    public boolean rendirse() {

        String nombreJugadorActual = "Estimado(a)";

        int respuesta = vista.mostrarMensajeConfirmacion(nombreJugadorActual + ", ¿deseas rendirte?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {

            vista.mostrarMansaje("""
                                                Te has rendido
                                                
                                                El bot te gano por deafult""", "Juego Abandonado", JOptionPane.WARNING_MESSAGE);

            model.juegoEnProgreso = false;
            model.reestablecerVariables();
            model.tableroBorrado();
            vista.dispose();
            return true;
        }
        return false;
    }

    public void mostrarGanador() {
        String mensaje = null, titulo = null;
        if (model.contadorJugador1 > model.contadorJugador2) {
            mensaje = "Ganaste con " + model.contadorJugador1 + " fichas.";
            model.ultimoGanador = model.jugadorNombreJugador;
            titulo = "¡Felicides!";

        } else if (model.contadorJugador1 == model.contadorJugador2) {
            mensaje = "Empate. Ambos jugadores tienen " + model.contadorJugador1 + " fichas.";
            model.ultimoGanador = "Empate";
            model.musica.musicaEmpate(true);
        } 
        
        if (model.contadorJugador2 > model.contadorJugador1) {
            mensaje = "El Bot te ha ganado con " + model.contadorJugador2 + " fichas.";
            model.ultimoGanador = model.jugadorNombreBot;
            titulo = "¡Suerte en la próxima!";
            model.musica.musicaPerdedor(true);
        }else{
        model.musica.musicaGanador(true);
        }

        vista.mostrarMansaje(mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);

        model.reestablecerVariables();
        model.tableroBorrado();
        int result = vista.mostrarMensajeConfirmacion("¡¿Quieres jugar de nuevo?", "Si deseas, puedes volver a jugar!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            model.juegoEnProgreso = false;
            iniciarJuegobot();
        } else {
            model.juegoEnProgreso = false;
            vista.dispose();
        }
    }
}
