package Vistas;

import Musica.Musica;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author munoz
 */
public class FrmVistaMenu extends javax.swing.JFrame {

    Musica musica;

    /**
     * Creates new form VistaMenu
     */
    public FrmVistaMenu() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(this);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ajustarPosiciones();
            }
        });

        musica = new Musica();
    }

    private void ajustarPosiciones() {
        int frameWidth = getWidth();
        int frameHeight = getHeight();

        int x1 = (int) (frameWidth * 0.35);
        int y1 = (int) (frameHeight * 0.70);

        int x2 = (int) (frameWidth * 0.55);
        int y2 = (int) (frameHeight * 0.70);

        int xInfo = (int) (frameWidth * 0.87);
        int yInfo = (int) (frameHeight * 0.08);

        btnInformacion.setLocation(xInfo, yInfo);
        btnInciar1vsBot.setLocation(x1, y1);
        btnInciar1vsv1.setLocation(x2, y2);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource(
                        "Iconos/icon.png"));

        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/Iconos/MenuOthello.png"));
        Desk = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(icon.getImage(),0,0,getWidth(),getHeight(),this);
            }
        };
        btnInciar1vsv1 = new javax.swing.JButton();
        btnInciar1vsBot = new javax.swing.JButton();
        btnInformacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        btnInciar1vsv1.setFont(new java.awt.Font("Showcard Gothic", 0, 22)); // NOI18N
        btnInciar1vsv1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PlayV64.png"))); // NOI18N
        btnInciar1vsv1.setText("1vrs1");
        btnInciar1vsv1.setContentAreaFilled(false);
        btnInciar1vsv1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInciar1vsv1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PlayV64.png"))); // NOI18N
        btnInciar1vsv1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PlayV128.png"))); // NOI18N
        btnInciar1vsv1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInciar1vsv1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInciar1vsv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInciar1vsv1ActionPerformed(evt);
            }
        });

        btnInciar1vsBot.setFont(new java.awt.Font("Showcard Gothic", 0, 22)); // NOI18N
        btnInciar1vsBot.setForeground(new java.awt.Color(255, 255, 255));
        btnInciar1vsBot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PlayV64.png"))); // NOI18N
        btnInciar1vsBot.setText("1vrsBot");
        btnInciar1vsBot.setContentAreaFilled(false);
        btnInciar1vsBot.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInciar1vsBot.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PlayV64.png"))); // NOI18N
        btnInciar1vsBot.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PlayV128.png"))); // NOI18N
        btnInciar1vsBot.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInciar1vsBot.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInciar1vsBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInciar1vsBotActionPerformed(evt);
            }
        });

        btnInformacion.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        btnInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/infoVerde32.png"))); // NOI18N
        btnInformacion.setText("Información");
        btnInformacion.setContentAreaFilled(false);
        btnInformacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInformacion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/infoVerde32.png"))); // NOI18N
        btnInformacion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/infoVerde64.png"))); // NOI18N
        btnInformacion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInformacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformacionActionPerformed(evt);
            }
        });

        Desk.setLayer(btnInciar1vsv1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desk.setLayer(btnInciar1vsBot, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Desk.setLayer(btnInformacion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DeskLayout = new javax.swing.GroupLayout(Desk);
        Desk.setLayout(DeskLayout);
        DeskLayout.setHorizontalGroup(
            DeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeskLayout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addGroup(DeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeskLayout.createSequentialGroup()
                        .addComponent(btnInciar1vsBot, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnInciar1vsv1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeskLayout.createSequentialGroup()
                        .addComponent(btnInformacion)
                        .addContainerGap())))
        );
        DeskLayout.setVerticalGroup(
            DeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeskLayout.createSequentialGroup()
                .addComponent(btnInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(DeskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInciar1vsBot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInciar1vsv1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desk)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desk)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInciar1vsv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInciar1vsv1ActionPerformed
        FrmJuego view = new FrmJuego(this, true);
        musica.musicaInicio(false);
        view.setVisible(true);
    }//GEN-LAST:event_btnInciar1vsv1ActionPerformed
    private void btnInciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInciarActionPerformed
        FrmJuego view = new FrmJuego(this, true);
        view.setVisible(true);
        musica.musicaInicio(false);
    }//GEN-LAST:event_btnInciarActionPerformed

    private void btnInciar1vsBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInciar1vsBotActionPerformed
        FrmJuegoBot view = new FrmJuegoBot(this, true);
        musica.musicaInicio(false);
        view.setVisible(true);
    }//GEN-LAST:event_btnInciar1vsBotActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        musica.musicaInicio(true);
    }//GEN-LAST:event_formWindowActivated

    private void btnInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformacionActionPerformed
        FrmAcercaDe frm = new FrmAcercaDe(null, true);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_btnInformacionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmVistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVistaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desk;
    private javax.swing.JButton btnInciar1vsBot;
    private javax.swing.JButton btnInciar1vsv1;
    private javax.swing.JButton btnInformacion;
    // End of variables declaration//GEN-END:variables
}
