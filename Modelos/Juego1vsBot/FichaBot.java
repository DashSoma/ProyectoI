/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.Juego1vsBot;

/**
 *
 * @author munoz
 */
public class FichaBot extends Thread{
    public int negro = 1;
    public int blanco = 2;
    
    public FichaBot() {
    }

    public int getNegro() {
        return negro;
    }

    public void setNegro(int negro) {
        this.negro = negro;
    }

    public int getBlanco() {
        return blanco;
    }

    public void setBlanco(int blanco) {
        this.blanco = blanco;
    }

//
//    public void run() {
//        
//        for (int i = 0; i < 5; i++) {
//            synchronized(this) {
//                setNegro(getNegro() + 1);
//                setBlanco(getBlanco() + 1);
//                System.out.println("Hilo " + Thread.currentThread().getName() + " - Negro: " + getNegro() + ", Blanco: " + getBlanco());
//            }
//
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                System.out.println("Hilo interrumpido");
//            }
//        }
//    }
}
