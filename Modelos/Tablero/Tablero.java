package Modelos.Tablero;

import Modelos.Ficha;
import Modelos.Jugador;
import Vistas.FrmJuego;
import Vistas.FrmVistaSolicitud;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Chrisp
 */
public class Tablero extends JPanel {

    public static final int tamaño = 4;
    private static final int vacio = 0;
    private int contadorJugador1 = 0; // Para el jugador negro
    private int contadorJugador2 = 0; // Para el jugador blanco
    public boolean juegoEnProgreso = false;
    private int[][] tablero;
    public int filaSeleccionada;
    public int columnaSeleccionada;
    Ficha ficha = new Ficha();
    Jugador jugador = new Jugador();
    String jugadorNombre1 = jugador.getJugador1();
    String jugadorNombre2 = jugador.getJugador2();
    int jugadorActual = jugador.getJugadorActual();

    FrmJuego view;

    public String ultimoGanador = "";
    Clip clip;

    public Tablero(FrmJuego view) {
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
                    jugadorActual = (jugadorActual == ficha.getNegro()) ? ficha.getBlanco() : ficha.getNegro();
                    actualizarTurno();
                    MusicaJuego(true);
                    repaint();

                    if (tablaLlena() || ambosJugadoresSinMovimientos()) {
                        mostrarGanador();
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

    private void mostrarGanador() {

        String mensaje;
        if (contadorJugador1 > contadorJugador2) {
            mensaje = "Ganó " + jugadorNombre1 + " con " + contadorJugador1 + " fichas.";
            ultimoGanador = jugadorNombre1;
        } else if (contadorJugador2 > contadorJugador1) {
            mensaje = "Ganó " + jugadorNombre2 + " con " + contadorJugador2 + " fichas.";
            ultimoGanador = jugadorNombre2;
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
            iniciarJuego();
        } else {
            juegoEnProgreso = false;
            view.dispose();
        }
    }

    public boolean esMovimientoValido(int filaSeleccionada, int columnaSeleccionada) {
        if (tablero[filaSeleccionada][columnaSeleccionada] != vacio) {
            return false;
        }
        return puedeInvertir(filaSeleccionada, columnaSeleccionada, true);
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

    public void iniciarJuego() {
        if (juegoEnProgreso) {
            JOptionPane.showMessageDialog(view, "Partida en juego. Si deseas iniciar otra, haz clic en reiniciar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean nombresValidos = false;
        while (!nombresValidos) {
            FrmVistaSolicitud v = new FrmVistaSolicitud(null, true, view);
            v.setVisible(true);

            // Verifica si el usuario ha cancelado
            jugadorNombre1 = v.getJugador1();
            jugadorNombre2 = v.getJugador2();

            if (jugadorNombre1 == null || jugadorNombre2 == null) {
                // Si se canceló, se sale del método
                JOptionPane.showMessageDialog(view, "Juego cancelado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return; // Salir del método, no continuar pidiendo nombres
            }

            // Validación de nombres
            if (jugadorNombre1.trim().isEmpty() || jugadorNombre2.trim().isEmpty()) {
                JOptionPane.showMessageDialog(view, "Por favor, ingresa los nombres de ambos jugadores.", "Error", JOptionPane.ERROR_MESSAGE);
                reestablecerVariables();
            } else if (jugadorNombre1.length() > 10) {
                JOptionPane.showMessageDialog(view, "El nombre del Jugador 1 no puede tener más de 10 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                reestablecerVariables();
            } else if (jugadorNombre2.length() > 10) {
                JOptionPane.showMessageDialog(view, "El nombre del Jugador 2 no puede tener más de 10 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                reestablecerVariables();
            } else {
                // Si los nombres son válidos, salimos del bucle
                nombresValidos = true;
            }
        }

        // Determina quién inicia el juego
        int jugadorInicial = (int) (Math.random() * 2);
        if (jugadorInicial == 0) {
            JOptionPane.showMessageDialog(view, "Inicia el Jugador: " + jugadorNombre1
                    + "\nEl segundo jugador es: " + jugadorNombre2, "¡Inician las fichas negras!", JOptionPane.INFORMATION_MESSAGE);
            view.setLblNombreJ1(jugadorNombre1);
            view.setLblNombreJ2(jugadorNombre2);
            jugadorActual = ficha.getNegro();
        } else {
            JOptionPane.showMessageDialog(view, "Inicia el Jugador: " + jugadorNombre2
                    + "\nEl segundo jugador es: " + jugadorNombre1, "¡Inician las fichas negras!", JOptionPane.INFORMATION_MESSAGE);
            view.setLblNombreJ1(jugadorNombre2);
            view.setLblNombreJ2(jugadorNombre1);
            jugadorActual = ficha.getBlanco();
        }

        mostrarTabla();
        actualizarTurno();
        juegoEnProgreso = true;
    }

    public void reiniciarJuego() {

        if (!juegoEnProgreso) {
            JOptionPane.showMessageDialog(this, "¡No hay ninguna partida en progreso para reiniciar!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(view, "¿Quieres jugar de nuevo?", "Reiniciar juego", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            // Reiniciar el estado del juego
            juegoEnProgreso = false;
            repaint();
            reestablecerVariables();
            iniciarJuego();
        }
    }

    public boolean rendirse() {
        if (!juegoEnProgreso) {
            JOptionPane.showMessageDialog(null, "¡Esta opción solo está habilitada cuando una partida está en juego!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

        // Obtén los nombres de los jugadores
        String nombreJugadorActual = (jugadorActual == ficha.getNegro()) ? view.getLblNombreJ1().getText() : view.getLblNombreJ2().getText();

        // Pregunta de confirmación personalizada con el nombre del jugador
        int respuesta = JOptionPane.showConfirmDialog(null, nombreJugadorActual + ", ¿deseas rendirte?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            String ganador, perdedor;
            jugadorNombre1 = view.getLblNombreJ1().getText();
            jugadorNombre2 = view.getLblNombreJ2().getText();

            if (jugadorActual == ficha.getNegro()) {
                perdedor = "      " + jugadorNombre1 + ". te has rendido\n";
                ultimoGanador = jugadorNombre2;
                ganador = "\n\n" + jugadorNombre2 + " ¡HAS GANADO! ";
            } else {
                perdedor = "      " + jugadorNombre2 + ". te has rendido\n";
                ultimoGanador = jugadorNombre1;
                ganador = "\n\n  " + jugadorNombre1 + " ¡HAS GANADO ";
            }

            JOptionPane.showMessageDialog(null, perdedor + ganador, "Juego Abandonado", JOptionPane.WARNING_MESSAGE);

            // Reinicia el estado del juego
            juegoEnProgreso = false;
            reestablecerVariables();
            tableroBorrado();
            return true;
        }
        return false;
    }

    public void mostrarUltimoGanador() {
        String mensaje;
        if (!juegoEnProgreso && ultimoGanador.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡El juego sigue sin un ganador definido!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (!juegoEnProgreso) {
            if ("Empate".equals(ultimoGanador)) {
                mensaje = "El último resultado fue un empate.";
            } else {
                mensaje = "El último ganador es: " + ultimoGanador;
            }
            JOptionPane.showMessageDialog(this, mensaje, "Último Ganador", JOptionPane.INFORMATION_MESSAGE);
            if (contadorJugador1 > contadorJugador2) {
                mensaje = "Ganó " + jugadorNombre1 + " con " + contadorJugador1 + " fichas.";
                ultimoGanador = jugadorNombre1;
            } else if (contadorJugador2 > contadorJugador1) {
                mensaje = "Ganó " + jugadorNombre2 + " con " + contadorJugador2 + " fichas.";
                ultimoGanador = jugadorNombre2;
            } else {
                mensaje = "Empate. Ambos jugadores tienen " + contadorJugador1 + " fichas.";
                ultimoGanador = "Empate";
            }

            JOptionPane.showMessageDialog(view, mensaje);
            actualizarTurno();
            reestablecerVariables();
            tableroBorrado();
            int result = JOptionPane.showConfirmDialog(view, "¿Quieres jugar de nuevo?", "", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                juegoEnProgreso = false;
                iniciarJuego();
            } else {
                juegoEnProgreso = false;
                view.dispose();
            }
        }
    }

    public void MusicaJuego(boolean estado) {
        if (estado) {
            try {
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                    clip.close();
                    clip = null;
                } else {
                    java.net.URL resource = getClass().getResource("/musica/ComerFicha.wav");
                    if (resource == null) {
                        System.err.println("No se encontró el archivo de audio en la ruta especificada.");
                        return;
                    }
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(resource);
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }
        }
    }

}
