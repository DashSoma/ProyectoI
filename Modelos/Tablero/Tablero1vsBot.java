/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.Tablero;

import Controladores.Controlador1vsBot;
import Modelos.Juego1vs1.Ficha;
import Modelos.Juego1vsBot.FichaBot;
import Modelos.Juego1vs1.Jugador;
import Modelos.Juego1vsBot.JugadorBot;
import Musica.Musica;
import Vistas.FrmJuegoBot;
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

    private static final int tamaño = 4;
    private static final int vacio = 0;

    public int contadorJugador1 = 0;
    public int contadorJugador2 = 0;
    public boolean juegoEnProgreso = false;
    private int[][] tablero;
    public int filaSeleccionada;
    public int columnaSeleccionada;
    public Musica musica;
    public FichaBot ficha = new FichaBot();
    public JugadorBot jugador = new JugadorBot();
    Controlador1vsBot controlador;
    public String jugadorNombreJugador = jugador.getJugador();
    public String jugadorNombreBot = jugador.getJugadorBot();
    public int jugadorActual = jugador.getJugadorActual();

    FrmJuegoBot view;
    public String ultimoGanador = "";

    public Tablero1vsBot(FrmJuegoBot view, Musica musica) {
        this.view = view;
        this.musica = musica;
        controlador = new Controlador1vsBot(this, view);
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
                    musica.musicaJuego(true);
                    actualizarTurno();
                    repaint();
                    if (tablaLlena() || ambosJugadoresSinMovimientos()) {
                        controlador.mostrarGanador();
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

    public boolean TablaLlena(int fila, int columna) {//Directa
        if (fila == tamaño) {
            return true;
        }
        if (tablero[fila][columna] == vacio) {
            return false;
        }
        int nuevaFila = columna == tamaño - 1 ? fila + 1 : fila;
        int nuevaColumna = (columna + 1) % tamaño;
        return TablaLlena(nuevaFila, nuevaColumna);
    }

    public boolean tablaLlena() {
        return TablaLlena(0, 0);
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
        view.getLblJugador1().setText("");
        view.getLblJugador2().setText("");
        view.getLblNombreFichasActuales1().setText("");
        view.getLblNombreFichasActuales2().setText("");
        view.setLblNombreJ1("");
        view.setLblNombreJ2("");
        view.setLblContador1("");
        view.setLblContador2("");
        view.setLblContTurno("");
        view.getLblCirculo().setIcon(null);
        contadorJugador1 = 0;
        contadorJugador2 = 0;
        repaint();
    }

    private void invertir(int fila, int columnaSeleccionada, int dFila, int dColumna) {//Drirecta 
        int r = fila + dFila;
        int c = columnaSeleccionada + dColumna;

        if (r < 0 || r >= tamaño || c < 0 || c >= tamaño || tablero[r][c] == jugadorActual) {
            return;
        }

        tablero[r][c] = jugadorActual;

        invertir(r, c, dFila, dColumna);
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
                musica.musicaJuego(true);
                cambiarTurno();
                actualizarTurno();
                return null;
            }

            @Override
            protected void done() {
                repaint();
                if (tablaLlena() || ambosJugadoresSinMovimientos()) {
                    controlador.mostrarGanador();
                }
            }
        };
        worker.execute();

    }
}
