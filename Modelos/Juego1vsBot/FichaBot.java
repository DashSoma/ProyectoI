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

}
