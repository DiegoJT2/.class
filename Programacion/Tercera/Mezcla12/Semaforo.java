package Tercera.Mezcla12;

import java.awt.Color;
import java.awt.Graphics;

class Semaforo {
    private boolean verde;
    private long ultimoCambio;
    private static final int DURACION = 5000; // ms

    public Semaforo(boolean verdeInicial) {
        verde = verdeInicial;
        ultimoCambio = System.currentTimeMillis();
    }

    public boolean estaVerde() {
        return verde;
    }

    public void update() {
        long ahora = System.currentTimeMillis();// Obtener el tiempo actual
        if (ahora - ultimoCambio > DURACION) {
            verde = !verde;
            ultimoCambio = ahora;
        }
    }

    public void paint(Graphics g, int x, int y) {
        g.setColor(Color.black);
        g.fillRect(x, y, 20, 40);
        g.setColor(verde ? Color.green : Color.red);
        g.fillOval(x + 2, y + 2, 16, 16);
        g.setColor(!verde ? Color.green : Color.red);
        g.fillOval(x + 2, y + 22, 16, 16);
    }
}