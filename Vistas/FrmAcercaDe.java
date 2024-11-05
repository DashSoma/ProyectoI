/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vistas;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author dashs
 */
public class FrmAcercaDe extends javax.swing.JDialog {

    /**
     * Creates new form FrmAcercaDe
     */
    public FrmAcercaDe(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/Iconos/Reglas.png"));
        DeskAcerca = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(icon.getImage(),0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Objetivo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tener más fichas de tu color en el tablero al final del juego. ");

        jLabel7.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Instrucciones");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cada jugador comienza con dos fichas en el centro del tablero, dispuestas en diagonal.");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Un jugador coloca una ficha en una casilla vacía, \"enclavando\" fichas del oponente.");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("El juego termina cuando no hay más movimientos posibles.");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Gana el jugador con más fichas.");

        jLabel12.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Creadores");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Christian Paniagua, Dashly Obando, Daniel Delgado y Felipe Muñoz");

        DeskAcerca.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DeskAcerca.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DeskAcerca.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DeskAcerca.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DeskAcerca.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DeskAcerca.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DeskAcerca.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DeskAcerca.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DeskAcerca.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DeskAcercaLayout = new javax.swing.GroupLayout(DeskAcerca);
        DeskAcerca.setLayout(DeskAcercaLayout);
        DeskAcercaLayout.setHorizontalGroup(
            DeskAcercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeskAcercaLayout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(DeskAcercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeskAcercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DeskAcercaLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel9))
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeskAcercaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(81, 81, 81))
                    .addGroup(DeskAcercaLayout.createSequentialGroup()
                        .addGroup(DeskAcercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DeskAcercaLayout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DeskAcercaLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jLabel10))
                            .addGroup(DeskAcercaLayout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DeskAcercaLayout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(DeskAcercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DeskAcercaLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11))))
                        .addGap(88, 88, 88)))
                .addGap(96, 96, 96))
            .addGroup(DeskAcercaLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DeskAcercaLayout.setVerticalGroup(
            DeskAcercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeskAcercaLayout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeskAcerca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DeskAcerca)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DeskAcerca;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}