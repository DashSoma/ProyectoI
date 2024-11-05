/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.Tablero;

import Modelos.Juego1vs1.Ficha;
import Modelos.Juego1vsBot.FichaBoot;
import Modelos.Juego1vs1.Jugador;
import Modelos.Juego1vsBot.JugadorBoot;
import Musica.Musica;
import Vistas.FrmJuegoBoot;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author DaniTini
 */
public class Tablero1vsBot extends JPanel {

    public static final int tamaño = 4;
    private static final int vacio = 0;

    private int contadorJugador1 = 0;
    private int contadorJugador2 = 0;
    public boolean juegoEnProgreso = false;
    private int[][] tablero;
    public int filaSeleccionada;
    public int columnaSeleccionada;

    FichaBoot ficha = new FichaBoot();
    JugadorBoot jugador = new JugadorBoot();
    String jugadorNombreJugador = jugador.getJugador();
    String jugadorNombreBot = jugador.getJugadorBot();
    int jugadorActual = jugador.getJugadorActual();

    FrmJuegoBoot view;
    public String ultimoGanador = "";

    public Tablero1vsBot(FrmJuegoBoot view) {
        this.view = view;
        tablero = new int[tamaño][tamaño];
        jugadorActual = ficha.getNegro();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSeleccionada = e.getY() / obtenerTamañoCelda();
                columnaSeleccionada = e.getX() / obtenerTamañoCelda();
                if (esMovimientoValido(filaSeleccionada, columnaSeleccionada)) {
                    hacerMovimiento(filaSeleccionada, columnaSeleccionada);
                    cambiarTurno();
                    actualizarTurno();
                    repaint();
                    if (tablaLlena() || ambosJugadoresSinMovimientos()) {
                        mostrarGanador();
                    } else {
                        if (jugadorActual == ficha.getBlanco()) {
                            realizarMovimientoBot();
                        }
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int tamañoCelda = obtenerTamañoCelda();
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                g.setColor(new Color(9, 161, 24));
                g.fillRect(columna * tamañoCelda, fila * tamañoCelda, tamañoCelda, tamañoCelda);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(columna * tamañoCelda, fila * tamañoCelda, tamañoCelda, tamañoCelda);

                if (tablero[fila][columna] == ficha.getNegro()) {
                    g.setColor(new Color(255, 255, 255));
                    g.fillOval(columna * tamañoCelda, fila * tamañoCelda, tamañoCelda, tamañoCelda);
                } else if (tablero[fila][columna] == ficha.getBlanco()) {
                    g.setColor(new Color(0, 0, 0));
                    g.fillOval(columna * tamañoCelda, fila * tamañoCelda, tamañoCelda, tamañoCelda);
                }
            }
        }
    }

    public int obtenerTamañoCelda() {
        return Math.min(getWidth(), getHeight()) / tamaño;
    }

    public boolean tablaLlena() {
        for (filaSeleccionada = 0; filaSeleccionada < tamaño; filaSeleccionada++) {
            for (columnaSeleccionada = 0; columnaSeleccionada < tamaño; columnaSeleccionada++) {
                if (tablero[filaSeleccionada][columnaSeleccionada] == vacio) {
                    return false;
                }
            }
        }
        return false;
    }

    public void mostrarTabla() {
        jugadorActual = ficha.getNegro();
        tablero = new int[tamaño][tamaño];
        tablero[1][1] = ficha.getBlanco();
        tablero[1][2] = ficha.getNegro();
        tablero[2][1] = ficha.getNegro();
        tablero[2][2] = ficha.getBlanco();
        repaint();
    }

    public void tableroBorrado() {
        jugadorActual = ficha.getNegro();
        tablero = new int[tamaño][tamaño];
        repaint();
    }

    public void reestablecerVariables() {
        contadorJugador1 = 0;
        contadorJugador2 = 0;
        juegoEnProgreso = false;
        repaint();
    }

    private void invertir(int fila, int columnaSeleccionada, int dFila, int dColumna) {
        int r = fila + dFila;
        int c = columnaSeleccionada + dColumna;
        while (tablero[r][c] != jugadorActual) {
            tablero[r][c] = jugadorActual;
            r += dFila;
            c += dColumna;
        }
    }

    private boolean puedeInvertir(int filaSeleccionada, int columnaSeleccionada, boolean movimientoActual) {
        boolean puedeInvertir = false;
        int[] direcciones = {-1, 0, 1};
        for (int dFila : direcciones) {
            for (int dColumna : direcciones) {
                if (dFila == 0 && dColumna == 0) {
                    continue;
                }
                int r = filaSeleccionada + dFila;
                int c = columnaSeleccionada + dColumna;
                boolean encontroFichaOponente = false;
                while (r >= 0 && r < tamaño && c >= 0 && c < tamaño) {
                    if (tablero[r][c] == vacio) {
                        break;
                    }
                    if (tablero[r][c] == jugadorActual) {
                        if (encontroFichaOponente) {
                            if (movimientoActual) {
                                invertir(filaSeleccionada, columnaSeleccionada, dFila, dColumna);
                            }
                            puedeInvertir = true;
                        }
                        break;
                    }
                    encontroFichaOponente = true;
                    r += dFila;
                    c += dColumna;
                }
            }
        }
        return puedeInvertir;
    }

    public boolean esMovimientoValido(int filaSeleccionada, int columnaSeleccionada) {
        if (tablero[filaSeleccionada][columnaSeleccionada] != vacio) {
            return false;
        }
        return puedeInvertir(filaSeleccionada, columnaSeleccionada, true);
    }

    public boolean hacerMovimiento(int filaSeleccionada, int columnaSeleccionada) {
        tablero[filaSeleccionada][columnaSeleccionada] = jugadorActual;
        puedeInvertir(filaSeleccionada, columnaSeleccionada, false);
        actualizarContadores();
        return true;
    }

    private void actualizarContadores() {
        // Reiniciamos los contadores antes de contar
        contadorJugador1 = 0;
        contadorJugador2 = 0;
        // Recorre el tablero y cuenta las fichas de cada color
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                if (tablero[fila][columna] == ficha.getNegro()) {
                    contadorJugador1++;
                } else if (tablero[fila][columna] == ficha.getBlanco()) {
                    contadorJugador2++;
                }
            }
        }
        view.getLblContador1().setText(String.valueOf(contadorJugador1));
        view.getLblContador2().setText(String.valueOf(contadorJugador2));
    }

    private boolean movimientosDisponibles(int jugador) {
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                if (tablero[fila][columna] == vacio && puedeInvertir(fila, columna, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ambosJugadoresSinMovimientos() {
        return !movimientosDisponibles(ficha.getNegro()) && !movimientosDisponibles(ficha.getBlanco());
    }

    public void actualizarTurno() {
        if (view.getLblContTurno() != null) {
            JLabel lblCirculo = view.getLblCirculo();
            String nombreJugadorActual = (jugadorActual == ficha.getNegro()) ? jugadorNombreJugador : jugadorNombreBot;
            view.getLblContTurno().setText("Turno de: " + nombreJugadorActual);
            lblCirculo.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                    jugadorActual == ficha.getNegro() ? "Iconos/circuloBlanco.png" : "Iconos/circuloNegro.png")));
        }
    }

    private void cambiarTurno() {
        if (jugadorActual == ficha.getNegro()) {
            jugadorActual = ficha.getBlanco();
        } else {
            jugadorActual = ficha.getNegro();
        }
    }

    private int[] obtenerMejorMovimiento() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (esMovimientoValido(i, j)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private void realizarMovimientoBot() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(1000);
                int[] movimiento = obtenerMejorMovimiento();
                hacerMovimiento(movimiento[0], movimiento[1]);
                cambiarTurno();
                actualizarTurno();
                return null;
            }

            @Override
            protected void done() {
                repaint();
                if (tablaLlena() || ambosJugadoresSinMovimientos()) {
                    mostrarGanador();
                }
            }
        };
        worker.execute();

    }

    public void iniciarJuegobot() {
        JOptionPane.showMessageDialog(null, "El juego ha comenzado \n\nInicias con las blancas", "¡Ha jugar!", JOptionPane.INFORMATION_MESSAGE);
        view.setLblNombreJ1("Boot (Negro):");
        view.setLblNombreJ2("Tú (Blanco):");
        view.getLblContador1().setText(String.valueOf(contadorJugador1));
        view.getLblContador2().setText(String.valueOf(contadorJugador2));
        contadorJugador1 = 2;
        contadorJugador2 = 2;
        mostrarTabla();
        actualizarTurno();
        juegoEnProgreso = true;

    }

    public void reiniciar() {

        int result = JOptionPane.showConfirmDialog(null, "¿Quieres jugar de nuevo?", "Reiniciar juego",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            // Reiniciar el estado del juego
            juegoEnProgreso = false;
            repaint();
            reestablecerVariables();
            iniciarJuegobot();
        }
    }

    public boolean rendirse() {

        // Obtén los nombres de los jugadores
        String nombreJugadorActual = "Estimado(a)";

        // Pregunta de confirmación personalizada con el nombre del jugador
        int respuesta = JOptionPane.showConfirmDialog(null, nombreJugadorActual + ", ¿deseas rendirte?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (respuesta == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(view, """
                                                Te has rendido
                                                
                                                El bot te gano por deafult""", "Juego Abandonado", JOptionPane.WARNING_MESSAGE);

            // Reinicia el estado del juego
            juegoEnProgreso = false;
            reestablecerVariables();
            tableroBorrado();
            view.dispose();
            return true;
        }
        return false;
    }

    private void mostrarGanador() {
        String mensaje;
        if (contadorJugador1 > contadorJugador2) {
            mensaje = "Ganaste con " + contadorJugador1 + " fichas.";
            ultimoGanador = jugadorNombreJugador;
        } else if (contadorJugador2 > contadorJugador1) {
            mensaje = "Ganó " + jugadorNombreBot + " con " + contadorJugador2 + " fichas.";
            ultimoGanador = jugadorNombreBot;
        } else {
            mensaje = "Empate. Ambos jugadores tienen " + contadorJugador1 + " fichas.";
            ultimoGanador = "Empate";
        }

        JOptionPane.showMessageDialog(view, mensaje);

        // Reiniciar variables y preguntar si quieren jugar de nuevo
        reestablecerVariables();
        tableroBorrado();
        int result = JOptionPane.showConfirmDialog(view, "¿Quieres jugar de nuevo?", "", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            juegoEnProgreso = false;
            iniciarJuegobot();
        } else {
            juegoEnProgreso = false;
            view.dispose();
        }
    }
}
