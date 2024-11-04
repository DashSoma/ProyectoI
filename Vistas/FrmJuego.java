package Vistas;

import Bots.Bot;
import Modelos.Ficha;
import Modelos.Jugador;
import Modelos.Tablero.Tablero;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Chrisp
 *
 */
public class FrmJuego extends javax.swing.JDialog {

    FrmJuego view;
    Ficha ficha = new Ficha();
    private Tablero tablero;
    private Bot bot;
    Jugador jugador = new Jugador();
    Jugador jugador1;
    Jugador jugador2;
    int jugadorActual = jugador.getJugadorActual();
    private String lblTurno;

    
    public FrmJuego(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        jugador1 = new Jugador("Jugador 1", 1);
        jugador2 = new Jugador("Jugador 2", 2);
        tablero = new Tablero(this);

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
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuBarOpc = new javax.swing.JMenu();
        mnuItemReiniciar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("¡Bienvenido al increíble juego Othello!");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblNombreJ1.setFont(new java.awt.Font("Showcard Gothic", 1, 16)); // NOI18N

        lblNombreJ2.setFont(new java.awt.Font("Showcard Gothic", 1, 16)); // NOI18N

        lblJugador1.setFont(new java.awt.Font("Showcard Gothic", 0, 16)); // NOI18N

        lblJugador2.setFont(new java.awt.Font("Showcard Gothic", 0, 16)); // NOI18N

        pnlTurno.setBackground(new java.awt.Color(9, 161, 24));
        pnlTurno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblContTurno.setFont(new java.awt.Font("Showcard Gothic", 1, 16)); // NOI18N

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

        lblContador1.setFont(new java.awt.Font("Showcard Gothic", 0, 16)); // NOI18N

        lblContador2.setFont(new java.awt.Font("Lucida Fax", 0, 16)); // NOI18N

        mnuBarOpc.setText("Opciones");

        mnuItemReiniciar.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        mnuItemReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reiniciar32.png"))); // NOI18N
        mnuItemReiniciar.setText(" Reiniciar");
        mnuItemReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemReiniciarActionPerformed(evt);
            }
        });
        mnuBarOpc.add(mnuItemReiniciar);

        jMenuItem1.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir32.png"))); // NOI18N
        jMenuItem1.setText(" Rendirse");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuBarOpc.add(jMenuItem1);

        jMenuBar1.add(mnuBarOpc);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(lblJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(pnlTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lblContador1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(lblContador2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombreJ1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(lblNombreJ2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(lblJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblJugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContador1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(lblContador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(469, 469, 469)
                .addComponent(pnlTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuItemReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemReiniciarActionPerformed
        tablero.reiniciarJuego();
    }//GEN-LAST:event_mnuItemReiniciarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         if (tablero.rendirse()) {
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    
        
    }//GEN-LAST:event_formWindowOpened

    /**
     *
     * @param args args del main
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblCirculo;
    private javax.swing.JLabel lblContTurno;
    private javax.swing.JLabel lblContador1;
    private javax.swing.JLabel lblContador2;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblNombreJ1;
    private javax.swing.JLabel lblNombreJ2;
    private javax.swing.JMenu mnuBarOpc;
    private javax.swing.JMenuItem mnuItemReiniciar;
    private javax.swing.JPanel pnlTurno;
    // End of variables declaration//GEN-END:variables

}
