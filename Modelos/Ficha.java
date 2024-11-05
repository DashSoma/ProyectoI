/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author dashs
 */
//public class Ficha {
//    
//    public int negro = 1;
//    public int blanco = 2;
//    
//    public Ficha() {
//    }
//
//    public int getNegro() {
//        return negro;
//    }
//
//    public void setNegro(int negro) {
//        this.negro = negro;
//    }
//
//    public int getBlanco() {
//        return blanco;
//    }
//
//    public void setBlanco(int blanco) {
//        this.blanco = blanco;
//    }

//}
public class Ficha extends Thread {
    
    private int negro = 1;
    private int blanco = 2;

    public Ficha() {
    }

    public synchronized int getNegro() {
        return negro;
    }

    public synchronized void setNegro(int negro) {
        this.negro = negro;
    }

    public synchronized int getBlanco() {
        return blanco;
    }

    public synchronized void setBlanco(int blanco) {
        this.blanco = blanco;
    }

    @Override
    public void run() {
        
        for (int i = 0; i < 5; i++) {
            synchronized(this) {
                setNegro(getNegro() + 1);
                setBlanco(getBlanco() + 1);
                System.out.println("Hilo " + Thread.currentThread().getName() + " - Negro: " + getNegro() + ", Blanco: " + getBlanco());
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        }
    }
}