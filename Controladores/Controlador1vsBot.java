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
    FrmJuegoBot vista;

    public Controlador1vsBot(Tablero1vsBot model, FrmJuegoBot vista) {
        this.model = model;
        this.vista = vista;
    }

    public void iniciarJuegobot() {
        vista.mostrarMansaje("El juego ha comenzado \n\nInicias con las blancas", "¡Ha jugar!", JOptionPane.INFORMATION_MESSAGE);
        vista.setLblNombreJ1("Boot (Negro):");
        vista.setLblNombreJ2("Tú (Blanco):");
        vista.getLblContador1().setText(String.valueOf(model.contadorJugador1));
        vista.getLblContador2().setText(String.valueOf(model.contadorJugador2));
        vista.getLblJugador1().setText("Jugador:");
        vista.getLblJugador2().setText("Jugador:");
        vista.getLblNombreFichasActuales1().setText("Fichas Actuales:");
        vista.getLblNombreFichasActuales2().setText("Fichas Actuales:");
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
            // Reiniciar el estado del juego
            model.juegoEnProgreso = false;
            model.repaint();
            model.reestablecerVariables();
            iniciarJuegobot();
        }
    }

    public boolean rendirse() {

        // Obtén los nombres de los jugadores
        String nombreJugadorActual = "Estimado(a)";

        // Pregunta de confirmación personalizada con el nombre del jugador
        int respuesta = vista.mostrarMensajeConfirmacion(nombreJugadorActual + ", ¿deseas rendirte?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {

            vista.mostrarMansaje("""
                                                Te has rendido
                                                
                                                El bot te gano por deafult""", "Juego Abandonado", JOptionPane.WARNING_MESSAGE);

            // Reinicia el estado del juego
            model.juegoEnProgreso = false;
            model.reestablecerVariables();
            model.tableroBorrado();
            vista.dispose();
            return true;
        }
        return false;
    }

    public void mostrarGanador() {
        String mensaje, titulo = null;
        if (model.contadorJugador1 > model.contadorJugador2) {
            mensaje = "Ganaste con " + model.contadorJugador1 + " fichas.";
            model.ultimoGanador = model.jugadorNombreJugador;
            titulo = "¡Felicides!";
            model.musica.musicaGanador(true);
        } else if (model.contadorJugador2 > model.contadorJugador1) {
            mensaje = "El Bot te ha ganado con " + model.contadorJugador2 + " fichas.";
            model.ultimoGanador = model.jugadorNombreBot;
            titulo = "¡Suerte en la próxima!";
            model.musica.musicaPerdedor(true);
        } else {
            mensaje = "Empate. Ambos jugadores tienen " + model.contadorJugador1 + " fichas.";
            model.ultimoGanador = "Empate";
            model.musica.musicaEmpate(true);
        }

        vista.mostrarMansaje(mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);

        // Reiniciar variables y preguntar si quieren jugar de nuevo
        model.reestablecerVariables();
        model.tableroBorrado();
        int result = vista.mostrarMensajeConfirmacion("¡¿Quieres jugar de nuevo?", "Si deseas, puedes volver a jugar!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            model.juegoEnProgreso = false;
            model.musica.musicaGanador(false);
            model.musica.musicaPerdedor(false);
            model.musica.musicaEmpate(false);
            iniciarJuegobot();
        } else {
            model.juegoEnProgreso = false;
            vista.dispose();
        }
    }
}
