/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Musica.Metodos;

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
    private boolean musicaSonando = false;

    public void musicaInicio(boolean estado) {
        try {
            if (musicaSonando) {
                // Si la música está sonando, deténla
                if (clip != null && clip.isRunning()) {
                    clip.stop();
                    clip.close();
                    clip = null;
                    musicaSonando = false; // Actualiza el estado

                }
            } else {
                // Si la música no está sonando, iníciala
                java.net.URL resource = getClass().getResource("/musica/Inicio.wav");
                if (resource == null) {
                    System.err.println("No se encontró el archivo de audio en la ruta especificada.");
                    return;
                }
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(resource);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                musicaSonando = true; // Actualiza el estado
                FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volumeControl.setValue(-10.0f); // Ajusta este valor para cambiar el volumen

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void musicaJuego(boolean estado) {
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
