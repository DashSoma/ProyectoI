package ProyectoI.Bots;

import ProyectoI.Modelos.Ficha;
import ProyectoI.Modelos.Jugador;
import ProyectoI.Vistas.FrmJuego;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author daniTini
 */
public class Bot extends JPanel {

    public static final int tamaño = 12;
    private static final int vacio = 0;

    private int contadorJugador1 = 0;
    private int contadorJugador2 = 0;
    public boolean juegoEnProgreso = false;
    private int[][] tablero;
    public int filaSeleccionada;
    public int columnaSeleccionada;
    private String lblTurno;

    Ficha ficha = new Ficha();
    Jugador jugador = new Jugador();
    String jugador1 = jugador.getJugador1();
    String jugador2 = jugador.getJugador2();
    int jugadorActual = jugador.getJugadorActual();

    FrmJuego view;
    public String ultimoGanador = "";

    public Bot(FrmJuego view) {
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
                    actualizarTurno("");
                    repaint();

                    if (tablaLlena() || ambosJugadoresSinMovimientos()) {
                        mostrarGanador(jugador.getJugador1(), jugador.getJugador2());
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

        for (filaSeleccionada = 0; filaSeleccionada < tamaño; filaSeleccionada++) {
            for (columnaSeleccionada = 0; columnaSeleccionada < tamaño; columnaSeleccionada++) {
                g.setColor(new Color(9, 161, 24));
                g.fillRect(columnaSeleccionada * tamañoCelda, filaSeleccionada * tamañoCelda, tamañoCelda, tamañoCelda);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(columnaSeleccionada * tamañoCelda, filaSeleccionada * tamañoCelda, tamañoCelda, tamañoCelda);

                if (tablero[filaSeleccionada][columnaSeleccionada] == ficha.getNegro()) {
                    g.setColor(new Color(255, 255, 255));
                    g.fillOval(columnaSeleccionada * tamañoCelda, filaSeleccionada * tamañoCelda, tamañoCelda, tamañoCelda);
                } else if (tablero[filaSeleccionada][columnaSeleccionada] == ficha.getBlanco()) {
                    g.setColor(new Color(0, 0, 0));
                    g.fillOval(columnaSeleccionada * tamañoCelda, filaSeleccionada * tamañoCelda, tamañoCelda, tamañoCelda);
                }
            }
        }
        g.setColor(Color.BLACK);
        g.drawString("Jugador 1 (Negro): " + contadorJugador1, 10, 20);
        g.drawString("Jugador 2 (Blanco): " + contadorJugador2, 10, 40);
    }

    public int obtenerTamañoCelda() {
        return Math.min(getWidth(), getHeight()) / tamaño;
    }

    private void mostrarGanador(String jugador1, String jugador2) {
        int fichasJugador1 = 0;
        int fichasJugador2 = 0;

        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (tablero[i][j] == ficha.getNegro()) {
                    fichasJugador1++;
                } else if (tablero[i][j] == ficha.getBlanco()) {
                    fichasJugador2++;
                }
            }
        }

        String mensaje;
        if (fichasJugador1 > fichasJugador2) {
            mensaje = "Ganó " + jugador1 + " con " + fichasJugador1 + " fichas.";
            ultimoGanador = jugador1;
        } else if (fichasJugador2 > fichasJugador1) {
            mensaje = "Ganó " + jugador2 + " con " + fichasJugador2 + " fichas.";
            ultimoGanador = jugador2;
        } else {
            mensaje = "Empate. Ambos jugadores tienen " + fichasJugador1 + " fichas.";
            ultimoGanador = "Empate";
        }

        juegoEnProgreso = false;
        JOptionPane.showMessageDialog(view, mensaje);
        reestablecerVariables();
    }

    public boolean esMovimientoValido(int filaSeleccionada, int columnaSeleccionada) {
        if (tablero[filaSeleccionada][columnaSeleccionada] != vacio) {
            return false;
        }
        return puedeInvertir(filaSeleccionada, columnaSeleccionada, true);
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

    private void invertir(int fila, int columnaSeleccionada, int dFila, int dColumna) {
        int r = fila + dFila;
        int c = columnaSeleccionada + dColumna;
        while (tablero[r][c] != jugadorActual) {
            tablero[r][c] = jugadorActual;
            r += dFila;
            c += dColumna;
        }
    }

    public boolean hacerMovimiento(int filaSeleccionada, int columnaSeleccionada) {
        tablero[filaSeleccionada][columnaSeleccionada] = jugadorActual;
        puedeInvertir(filaSeleccionada, columnaSeleccionada, false);
        return false;
    }

    public void iniciarJuegobot() {
        jugadorActual = ficha.getNegro();
        tablero = new int[tamaño][tamaño];
        tablero[5][5] = ficha.getBlanco();
        tablero[5][6] = ficha.getNegro();
        tablero[6][5] = ficha.getNegro();
        tablero[6][6] = ficha.getBlanco();
        juegoEnProgreso = true;
        contadorJugador1 = 2;
        contadorJugador2 = 2;
        repaint();
        actualizarTurno("");
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

    public void tableroBorrado() {
        jugadorActual = ficha.getNegro();
        tablero = new int[tamaño][tamaño];
        repaint();
    }

    private void cambiarTurno() {
        if (jugadorActual == ficha.getNegro()) {
            jugadorActual = ficha.getBlanco();
        } else {
            jugadorActual = ficha.getNegro();
        }
    }

    private void realizarMovimientoBot() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(1000);
                int[] movimiento = obtenerMejorMovimiento();
                hacerMovimiento(movimiento[0], movimiento[1]);
                cambiarTurno();
                actualizarTurno("");
                return null;
            }

            @Override
            protected void done() {
                repaint();
                if (tablaLlena() || ambosJugadoresSinMovimientos()) {
                    mostrarGanador(jugador.getJugador1(), jugador.getJugador2());
                }
            }
        };
        worker.execute();
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

    public void reestablecerVariables() {
        contadorJugador1 = 0;
        contadorJugador2 = 0;
        juegoEnProgreso = false;
        tablero = new int[tamaño][tamaño];
        repaint();
    }

    public void actualizarTurno(String nuevoTurno) {
        String turnoActual = (jugadorActual == ficha.getNegro()) ? jugador1 : jugador2;
        if (!nuevoTurno.isEmpty()) {
            turnoActual = nuevoTurno;
        }
    }
}
