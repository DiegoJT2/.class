package Tercera.Mezcla12;

import java.awt.Color;
import java.awt.Graphics;

class Coche {
    private static final int VELOCIDAD = 2;
    private int x, y;
    private boolean horizontal;

    public Coche(int x, int y, boolean horizontal) {
        this.x = x;
        this.y = y;
        this.horizontal = horizontal;
    }

    public void mover(Semaforo semaforo){
        if (horizontal){
            if (x < 170 || x > 230 || semaforo.estaVerde()) x += VELOCIDAD;
            if (x > 400) x = 0;
        } else {
            if (y < 170 || y > 230 || semaforo.estaVerde()) y += VELOCIDAD;
            if (y > 400) y = 0;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        if (horizontal) g.fillRect(x, y, 30, 15);
        else g.fillRect(x, y, 15, 30);
    }
}