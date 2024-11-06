/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Tablero.Tablero1vs1;
import Vistas.FrmJuego;
import Vistas.FrmVistaSolicitud;
import javax.swing.JOptionPane;

/**
 *
 * @author Crisp
 */
public class Controlador1vs1 {

    Tablero1vs1 model;
    FrmJuego vista;

    public Controlador1vs1(Tablero1vs1 model, FrmJuego vista) {
        this.model = model;
        this.vista = vista;
    }

    public void iniciarJuego() {

        boolean nombresValidos = false;
        while (!nombresValidos) {
            FrmVistaSolicitud v = new FrmVistaSolicitud(null, true, vista);
            v.setVisible(true);

            // Verifica si el usuario ha cancelado
            model.jugadorNombre1 = v.getJugador1();
            model.jugadorNombre2 = v.getJugador2();

            if (model.jugadorNombre1 == null || model.jugadorNombre2 == null) {
                // Si se canceló, se sale del método
                vista.mostrarMansaje("Juego cancelado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                vista.dispose();
                return; // Salir del método, no continuar pidiendo nombres
            }

            // Validación de nombres
            if (model.jugadorNombre1.trim().isEmpty() || model.jugadorNombre2.trim().isEmpty()) {

                vista.mostrarMansaje("Por favor, ingresa los nombre de ambos jugadores", "Error", JOptionPane.ERROR_MESSAGE);
                model.reestablecerVariables();
            } else {
                // Si los nombres son válidos, salimos del bucle
                nombresValidos = true;
            }
        }

        // Determina quién inicia el juego
        int jugadorInicial = (int) (Math.random() * 2);
        if (jugadorInicial == 0) {
            vista.mostrarMansaje("Inicia el Jugador: " + model.jugadorNombre1
                    + "\nEl segundo jugador es: " + model.jugadorNombre2, "¡Inician las fichas negras!", JOptionPane.INFORMATION_MESSAGE);
            vista.setLblNombreJ1(model.jugadorNombre1);
            vista.setLblNombreJ2(model.jugadorNombre2);
            model.jugadorActual = model.ficha.getNegro();
        } else {
            vista.mostrarMansaje("Inicia el Jugador: " + model.jugadorNombre2
                    + "\nEl segundo jugador es: " + model.jugadorNombre1, "¡Inician las fichas negras!", JOptionPane.INFORMATION_MESSAGE);
            vista.setLblNombreJ1(model.jugadorNombre2);
            vista.setLblNombreJ2(model.jugadorNombre1);
            model.jugadorActual = model.ficha.getBlanco();
        }

        model.mostrarTabla();
        vista.getLblJugador1().setText("Jugador:");
        vista.getLblJugador2().setText("Jugador:");
        vista.getLblNombreFichasActuales1().setText("Fichas:");
        vista.getLblNombreFichasActuales2().setText("Fichas:");
        vista.getLblContador1().setText(String.valueOf("2"));
        vista.getLblContador2().setText(String.valueOf("2"));
        model.actualizarTurno();
        model.juegoEnProgreso = true;

    }

    public void reiniciarJuego() {

        if (!model.juegoEnProgreso) {
            vista.mostrarMansaje("¡No hay ninguna partida en progreso para reiniciar!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = vista.mostrarMensajeConfirmacion("¿Quieres jugar de nuevo?", "Reiniciar juego", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            // Reiniciar el estado del juego
            model.juegoEnProgreso = false;
            model.repaint();
            model.reestablecerVariables();
            iniciarJuego();
        }
    }

    public boolean rendirse() {
        // Obtiene los nombres de los jugadores
        String nombreJugadorActual = (model.jugadorActual == model.ficha.getNegro()) ? vista.getLblNombreJ1().getText() : vista.getLblNombreJ2().getText();
        // Pregunta de confirmación personalizada con el nombre del jugador
        int respuesta = vista.mostrarMensajeConfirmacion(nombreJugadorActual + ", ¿deseas rendirte?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {
            String ganador, perdedor;
            model.jugadorNombre1 = vista.getLblNombreJ1().getText();
            model.jugadorNombre2 = vista.getLblNombreJ2().getText();
            if (model.jugadorActual == model.ficha.getNegro()) {
                perdedor = "      " + model.jugadorNombre1 + ". te has rendido\n";
                model.ultimoGanador = model.jugadorNombre2;
                ganador = "\n\n" + model.jugadorNombre2 + " ¡HAS GANADO! ";
            } else {
                perdedor = "      " + model.jugadorNombre2 + ". te has rendido\n";
                model.ultimoGanador = model.jugadorNombre1;
                ganador = "\n\n  " + model.jugadorNombre1 + " ¡HAS GANADO ";
            }
            vista.mostrarMansaje(perdedor + ganador, "Juego Abandonado", JOptionPane.WARNING_MESSAGE);

            // Reinicia el estado del juego
            model.juegoEnProgreso = false;
            model.reestablecerVariables();
            model.tableroBorrado();
            return true;
        }
        return false;
    }

    public void mostrarGanador() {

        String mensaje;
        if (model.contadorJugador1 > model.contadorJugador2) {
            mensaje = "El ganador es: " + model.jugadorNombre1 + " con " + model.contadorJugador1 + " fichas.";
            model.ultimoGanador = model.jugadorNombre1;
        } else if (model.contadorJugador2 > model.contadorJugador1) {
            mensaje = "El ganador es: " + model.jugadorNombre2 + " con " + model.contadorJugador2 + " fichas.";
            model.ultimoGanador = model.jugadorNombre2;
        } else {
            mensaje = "Empate. Ambos jugadores tienen " + model.contadorJugador1 + " fichas.";
            model.ultimoGanador = "Empate";
        }
        vista.mostrarMansaje(mensaje, "Felicidades", JOptionPane.INFORMATION_MESSAGE);
        // Reiniciar variables y preguntar si quieren jugar de nuevo
        model.reestablecerVariables();
        model.tableroBorrado();
        int result = vista.mostrarMensajeConfirmacion("¿Quieres jugar de nuevo?", "Si deseas, pudes volver a jugar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            model.juegoEnProgreso = false;
            iniciarJuego();
        } else {
            model.juegoEnProgreso = false;
            vista.dispose();
        }
    }
}
