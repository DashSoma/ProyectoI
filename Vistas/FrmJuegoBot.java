/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vistas;

import Controladores.Controlador1vsBot;
import Modelos.Juego1vs1.Jugador;
import Modelos.Tablero.Tablero1vsBot;
import Modelos.Juego1vsBot.FichaBot;
import Modelos.Juego1vsBot.JugadorBot;
import Musica.Musica;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author dashs
 */
public class FrmJuegoBot extends javax.swing.JDialog {

    /**
     * Creates new form FrmJuegoBot
     */
    FichaBot ficha;
    Controlador1vsBot controlador;
    Tablero1vsBot tablero;
    JugadorBot jugador;
    Musica musica;
    JugadorBot jugador1;
    private String lblTurno;

    public FrmJuegoBot(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        jugador1 = new JugadorBot("Jugador 1", 1);

        ficha = new FichaBot();
        jugador = new JugadorBot();
        musica = new Musica();
        tablero = new Tablero1vsBot(this, musica);
        controlador = new Controlador1vsBot(tablero, this);
        JPanel contenedorTablero = new JPanel(new BorderLayout());
        contenedorTablero.setBorder(new EmptyBorder(80, 80, 80, 80));
        contenedorTablero.add(tablero, BorderLayout.CENTER);
        add(contenedorTablero, BorderLayout.CENTER);
        iniciarFicha();
        Thread HiloBot = new Thread();
        HiloBot.start();
    }

    private void iniciarFicha() {
        ficha.start();
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

    public JLabel getLblNombreFichasActuales1() {
        return lblNombreFichasActuales1;
    }

    public void setLblNombreFichasActuales1(String texto) {
        this.lblNombreFichasActuales1.setText(texto);
    }

    public JLabel getLblNombreFichasActuales2() {
        return lblNombreFichasActuales2;
    }

    public void setLblNombreFichasActuales2(String texto) {
        this.lblNombreFichasActuales2.setText(texto);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnReiniciar = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        lblContador1 = new javax.swing.JLabel();
        lblContador2 = new javax.swing.JLabel();
        lblNombreJ1 = new javax.swing.JLabel();
        lblNombreJ2 = new javax.swing.JLabel();
        lblJugador1 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        pnlTurno = new javax.swing.JPanel();
        lblContTurno = new javax.swing.JLabel();
        lblCirculo = new javax.swing.JLabel();
        BtnInfo = new javax.swing.JButton();
        lblNombreFichasActuales1 = new javax.swing.JLabel();
        lblNombreFichasActuales2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(590, 630));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        BtnReiniciar.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        BtnReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reiniciar24.png"))); // NOI18N
        BtnReiniciar.setText("Reiniciar");
        BtnReiniciar.setContentAreaFilled(false);
        BtnReiniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnReiniciar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reiniciar24.png"))); // NOI18N
        BtnReiniciar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reiniciar32.png"))); // NOI18N
        BtnReiniciar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnReiniciar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReiniciarActionPerformed(evt);
            }
        });

        BtnSalir.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir24.png"))); // NOI18N
        BtnSalir.setText("Rendirse");
        BtnSalir.setContentAreaFilled(false);
        BtnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir24.png"))); // NOI18N
        BtnSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir32.png"))); // NOI18N
        BtnSalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        lblContador1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N

        lblContador2.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N

        lblNombreJ1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N

        lblNombreJ2.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N

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

        lblNombreFichasActuales1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N

        lblNombreFichasActuales2.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(BtnReiniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(89, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombreFichasActuales1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblContador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreFichasActuales2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContador1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnInfo))
                    .addComponent(BtnSalir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(lblJugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreJ1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContador1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreFichasActuales1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContador2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreFichasActuales2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 426, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReiniciarActionPerformed
        controlador.reiniciar();
    }//GEN-LAST:event_BtnReiniciarActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        controlador.rendirse();
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void BtnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInfoActionPerformed
        FrmAcercaDe frm = new FrmAcercaDe(null, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_BtnInfoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        controlador.iniciarJuegobot();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        int result = JOptionPane.showConfirmDialog(null, "¿Deseas cerrar el juego?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    public void mostrarMansaje(String texto, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(this, texto, titulo, tipoMensaje);
    }

    public int mostrarMensajeConfirmacion(String texto, String titulo, int tipoRespuesta, int tipoMensaje) {
        return JOptionPane.showConfirmDialog(this, texto, titulo, tipoRespuesta, tipoMensaje);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInfo;
    private javax.swing.JButton BtnReiniciar;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JLabel lblCirculo;
    private javax.swing.JLabel lblContTurno;
    private javax.swing.JLabel lblContador1;
    private javax.swing.JLabel lblContador2;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblNombreFichasActuales1;
    private javax.swing.JLabel lblNombreFichasActuales2;
    private javax.swing.JLabel lblNombreJ1;
    private javax.swing.JLabel lblNombreJ2;
    private javax.swing.JPanel pnlTurno;
    // End of variables declaration//GEN-END:variables
}
