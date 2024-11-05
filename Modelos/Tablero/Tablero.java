package Modelos.Tablero;

import Modelos.Ficha;
import Modelos.Jugador;
import Musica.Metodos.Musica;
import Vistas.FrmJuego;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Chrisp
 */
public class Tablero extends JPanel {

    public static final int tamaño = 4;
    private static final int vacio = 0;
    public int contadorJugador1 = 0; // Para el jugador negro
    public int contadorJugador2 = 0; // Para el jugador blanco
    public boolean juegoEnProgreso = false;
    private int[][] tablero;
    public int filaSeleccionada;
    public int columnaSeleccionada;
    Ficha ficha = new Ficha();
    Jugador jugador = new Jugador();
    ControladorTablero controller;
    Musica musica;
    String jugadorNombre1 = jugador.getJugador1();
    String jugadorNombre2 = jugador.getJugador2();
    int jugadorActual = jugador.getJugadorActual();

    FrmJuego view;

    public String ultimoGanador = "";

    public Tablero(FrmJuego view, Ficha ficha, Jugador jugador) {
        this.view = view;
        this.ficha = ficha;
        this.jugador = jugador;
        this.controller = new ControladorTablero(this, view);
        musica = new Musica();
        tablero = new int[tamaño][tamaño];
        jugadorActual = ficha.getNegro();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSeleccionada = e.getY() / obtenerTamañoCelda();
                columnaSeleccionada = e.getX() / obtenerTamañoCelda();
                if (esMovimientoValido(filaSeleccionada, columnaSeleccionada)) {
                    hacerMovimiento(filaSeleccionada, columnaSeleccionada);
                    jugadorActual = (jugadorActual == ficha.getNegro()) ? ficha.getBlanco() : ficha.getNegro();
                    musica.musicaJuego(true);
                    actualizarTurno();
                    repaint();

                    if (tablaLlena() || ambosJugadoresSinMovimientos()) {
                        controller.mostrarGanador();
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
                    g.setColor(new Color(0, 0, 0));
                    g.fillOval(columna * tamañoCelda, fila * tamañoCelda, tamañoCelda, tamañoCelda);
                } else if (tablero[fila][columna] == ficha.getBlanco()) {
                    g.setColor(new Color(255, 255, 255));
                    g.fillOval(columna * tamañoCelda, fila * tamañoCelda, tamañoCelda, tamañoCelda);
                }
            }
        }
    }

    public int obtenerTamañoCelda() {
        return Math.min(getWidth(), getHeight()) / tamaño;
    }

    public void mostrarTabla() {
        // Iniciar juego
        jugadorActual = ficha.getNegro();
        tablero = new int[tamaño][tamaño];
        // Colocar fichas iniciales
        tablero[1][1] = ficha.getBlanco();
        tablero[1][2] = ficha.getNegro();
        tablero[2][1] = ficha.getNegro();
        tablero[2][2] = ficha.getBlanco();
        repaint();
    }

    public boolean tablaLlena() {
        // Verificar si la matriz está llena
        for (filaSeleccionada = 0; filaSeleccionada < tamaño; filaSeleccionada++) {
            for (columnaSeleccionada = 0; columnaSeleccionada < tamaño; columnaSeleccionada++) {
                if (tablero[filaSeleccionada][columnaSeleccionada] == vacio) {
                    return false; // La matriz no está llena
                }
            }
        }
        return true;
    }

    public void tableroBorrado() {
        jugadorActual = ficha.getNegro();
        tablero = new int[tamaño][tamaño];
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
        //Vector con posibles direcciones 
        int[] direcciones = {-1, 0, 1};
        //Bucle que revisa el vector direcciones para determinar posibles movimientos 
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
        // Recalcula los contadores después de hacer el movimiento y las inversiones
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
        // Actualiza los contadores en la vista
        view.getLblContador1().setText(String.valueOf(contadorJugador1));
        view.getLblContador2().setText(String.valueOf(contadorJugador2));
    }

    private boolean ambosJugadoresSinMovimientos() {
        return !movimientosDisponibles(ficha.getNegro()) && !movimientosDisponibles(ficha.getBlanco());
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

    public void actualizarTurno() {
        if (view.getLblContTurno() != null) {
            JLabel lblCirculo = view.getLblCirculo();
            String nombreJugadorActual = (jugadorActual == ficha.getNegro()) ? jugadorNombre1 : jugadorNombre2;
            view.getLblContTurno().setText("Turno de: " + nombreJugadorActual);
            lblCirculo.setIcon(new ImageIcon(ClassLoader.getSystemResource(
                    jugadorActual == ficha.getNegro() ? "Iconos/circuloNegro.png" : "Iconos/circuloblanco.png")));
        }
    }

    public void reestablecerVariables() {
        view.getLblJugador1().setText("");
        view.getLblJugador2().setText("");
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
}
