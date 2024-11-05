package Vistas;

import Modelos.Juego1vs1.Ficha;
import Modelos.Juego1vs1.Jugador;
import Controladores.Controlador1vs1;
import Modelos.Tablero.Tablero1vs1;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Chrisp
 *
 */
public class FrmJuego extends javax.swing.JDialog {

    Ficha ficha;
    Controlador1vs1 controller;
    Tablero1vs1 tablero;
    Jugador jugador;
    Jugador jugador1;
    Jugador jugador2;
    private String lblTurno;

    public FrmJuego(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Crear Jugadores 
        jugador1 = new Jugador("Jugador 1", 1);
        jugador2 = new Jugador("Jugador 2", 2);

        // Crear tablero
        ficha = new Ficha();
        jugador = new Jugador();
        tablero = new Tablero1vs1(this, ficha, jugador);
        controller = new Controlador1vs1(tablero, this);

        // Crear panel contenedor con borde vacío
        JPanel contenedorTablero = new JPanel(new BorderLayout());
        contenedorTablero.setBorder(new EmptyBorder(80, 80, 80, 80));
        contenedorTablero.add(tablero, BorderLayout.CENTER);
        add(contenedorTablero, BorderLayout.CENTER);
    }

    public String getLblTurno() {
        return lblTurno;
    }

    public JLabel getLblContador1() {
        return lblContador1;
    }

    public void setLblContador1(String texto) {
        this.lblContador1.setText(texto);
    }

    public JLabel getLblContador2() {
        return lblContador2;
    }

    public void setLblContador2(String texto) {
        this.lblContador2.setText(texto);
    }

    public void setLblContTurno(String texto) {
        this.lblContTurno.setText(texto);
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public JLabel getLblContTurno() {
        return lblContTurno;
    }

    public JLabel getLblNombreJ1() {
        return lblNombreJ1;
    }

    public JLabel getLblNombreJ2() {
        return lblNombreJ2;
    }

    public void setLblNombreJ1(String texto) {
        lblNombreJ1.setText(texto);
    }

    public void setLblNombreJ2(String texto) {
        lblNombreJ2.setText(texto);
    }

    public JLabel getLblJugador1() {
        return lblJugador1;
    }

    public void setLblJugador1(JLabel lblJugador1) {
        this.lblJugador1 = lblJugador1;
    }

    public JLabel getLblJugador2() {
        return lblJugador2;
    }

    public void setLblJugador2(JLabel lblJugador2) {
        this.lblJugador2 = lblJugador2;
    }

    public JLabel getLblCirculo() {
        return lblCirculo;
    }

    public void setLblCirculo(JLabel lblCirculo) {
        this.lblCirculo = lblCirculo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreJ1 = new javax.swing.JLabel();
        lblNombreJ2 = new javax.swing.JLabel();
        lblJugador1 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        pnlTurno = new javax.swing.JPanel();
        lblContTurno = new javax.swing.JLabel();
        lblCirculo = new javax.swing.JLabel();
        lblContador1 = new javax.swing.JLabel();
        lblContador2 = new javax.swing.JLabel();
        BtnInfo = new javax.swing.JButton();
        BtnReinicia = new javax.swing.JButton();
        BtnAbandona = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("¡Bienvenido al increíble juego Othello!");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblNombreJ1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N

        lblNombreJ2.setFont(new java.awt.Font("Showcard Gothic", 1, 14)); // NOI18N

        lblJugador1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N

        lblJugador2.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N

        pnlTurno.setBackground(new java.awt.Color(9, 161, 24));
        pnlTurno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblContTurno.setFont(new java.awt.Font("Showcard Gothic", 0, 16)); // NOI18N

        javax.swing.GroupLayout pnlTurnoLayout = new javax.swing.GroupLayout(pnlTurno);
        pnlTurno.setLayout(pnlTurnoLayout);
        pnlTurnoLayout.setHorizontalGroup(
            pnlTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurnoLayout.createSequentialGroup()
                .addComponent(lblContTurno, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblCirculo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTurnoLayout.setVerticalGroup(
            pnlTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCirculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTurnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblContTurno, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblContador1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N

        lblContador2.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N

        BtnInfo.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        BtnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/infoVerde24.png"))); // NOI18N
        BtnInfo.setText("Info");
        BtnInfo.setContentAreaFilled(false);
        BtnInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnInfo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/infoVerde24.png"))); // NOI18N
        BtnInfo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/infoVerde32.png"))); // NOI18N
        BtnInfo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInfoActionPerformed(evt);
            }
        });

        BtnReinicia.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        BtnReinicia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reiniciar24.png"))); // NOI18N
        BtnReinicia.setText("Reiniciar");
        BtnReinicia.setContentAreaFilled(false);
        BtnReinicia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnReinicia.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reiniciar24.png"))); // NOI18N
        BtnReinicia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reiniciar32.png"))); // NOI18N
        BtnReinicia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnReinicia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnReinicia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReiniciaActionPerformed(evt);
            }
        });

        BtnAbandona.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        BtnAbandona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir24.png"))); // NOI18N
        BtnAbandona.setText("Abandonar");
        BtnAbandona.setContentAreaFilled(false);
        BtnAbandona.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAbandona.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir24.png"))); // NOI18N
        BtnAbandona.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir32.png"))); // NOI18N
        BtnAbandona.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnAbandona.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnAbandona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAbandonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnReinicia)
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(lblContador2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblContador1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(lblNombreJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNombreJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(BtnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(498, Short.MAX_VALUE)
                    .addComponent(BtnAbandona)
                    .addGap(7, 7, 7)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombreJ1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(lblNombreJ2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(lblJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblJugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblContador1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                            .addComponent(lblContador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(BtnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 449, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnReinicia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(516, Short.MAX_VALUE)
                    .addComponent(BtnAbandona, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(4, 4, 4)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        controller.iniciarJuego();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        int result = mostrarMensajeConfirmacion("¿Deseas cerrar el juego?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void BtnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInfoActionPerformed
        FrmAcercaDe frm = new FrmAcercaDe(null, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_BtnInfoActionPerformed

    private void BtnReiniciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReiniciaActionPerformed
        controller.reiniciarJuego();
    }//GEN-LAST:event_BtnReiniciaActionPerformed

    private void BtnAbandonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbandonaActionPerformed
        if (controller.rendirse()) {
            this.dispose();
        }
    }//GEN-LAST:event_BtnAbandonaActionPerformed

    public void mostrarMansaje(String texto, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(this, texto, titulo, tipoMensaje);
    }

    public int mostrarMensajeConfirmacion(String texto, String titulo, int tipoRespuesta, int tipoMensaje) {
        return JOptionPane.showConfirmDialog(this, texto, titulo, tipoRespuesta, tipoMensaje);
    }
    /**
     *
     * @param args args del main
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAbandona;
    private javax.swing.JButton BtnInfo;
    private javax.swing.JButton BtnReinicia;
    private javax.swing.JLabel lblCirculo;
    private javax.swing.JLabel lblContTurno;
    private javax.swing.JLabel lblContador1;
    private javax.swing.JLabel lblContador2;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblNombreJ1;
    private javax.swing.JLabel lblNombreJ2;
    private javax.swing.JPanel pnlTurno;
    // End of variables declaration//GEN-END:variables

}
