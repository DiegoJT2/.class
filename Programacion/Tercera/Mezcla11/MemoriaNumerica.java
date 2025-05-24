package Tercera.Mezcla11;

import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class MemoriaNumerica extends Applet {
    private CasillaMemoria[] casillas = new CasillaMemoria[16];
    private int siguiente = 1;
    private boolean bloqueado = false;

    public void init() {
        setLayout(new GridLayout(4, 4));
        // Crear y mezclar números
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 16; i++) numeros.add(i);
        Collections.shuffle(numeros);

        // Crear casillas
        for (int i = 0; i < 16; i++) {
            casillas[i] = new CasillaMemoria(numeros.get(i), this);
            add(casillas[i].getButton());
        }
    }

    // Método llamado por CasillaMemoria al hacer clic
    public void casillaSeleccionada(CasillaMemoria casilla) {
        if (bloqueado || !casilla.estaActiva()) return;
        casilla.mostrarNumero();
        bloqueado = true;
        new Thread(() -> {
            try { Thread.sleep(1000); } catch (InterruptedException ex) {}
            if (casilla.getNumero() == siguiente) {
                casilla.deshabilitar();
                siguiente++;
                if (siguiente > 16) {
                    showStatus("¡Felicidades! Has completado el juego.");
                }
            } else {
                for (CasillaMemoria c : casillas) {
                    c.ocultarNumero();
                    c.habilitar();
                }
                siguiente = 1;
                showStatus("¡Te has equivocado! Intenta de nuevo.");
            }
            bloqueado = false;
        }).start();
    }
}