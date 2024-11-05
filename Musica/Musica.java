/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoI.Musica;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author Crisp
 */
public class Musica {

    Clip clip;
    boolean musicaEstado = false;

    public void MusicaInicio(boolean estado) {
        try {
            if (musicaEstado) {
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                    clip.close();
                    clip = null;
                    musicaEstado = false;

                }
            } else {
                java.net.URL resource = getClass().getResource("/musica/Inicio.wav");
                if (resource == null) {
                    System.err.println("No se encontró el archivo de audio en la ruta especificada.");
                    return;
                }
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(resource);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                musicaEstado = true;
                FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volumeControl.setValue(-10.0f);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
