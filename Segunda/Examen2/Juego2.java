package Segunda.Examen2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Juego2 extends Applet implements Runnable {
    public static final int TIEMPO = 25;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    ArrayList<Pelota> pelotas;
    boolean continua = true;
    int contador;
    int contadorEliminados;

    public void init() {
        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();
        pelotas = new ArrayList<Pelota>();
        pelotas.add(new Pelota());
        this.setSize(300, 300);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }

    public void paint(Graphics g) {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 300, 300);
        noseve.setColor(Color.WHITE);
        noseve.drawString("PINCHADOS: " + contadorEliminados, 110, 20);
        for (int i = 0; i < pelotas.size(); i++)
            pelotas.get(i).paint(noseve);
        if (!continua)
            noseve.drawString("GAME OVER", 120, 140);
        g.drawImage(imagen, 0, 0, this);
    }

    public void run() {
        do {
            contador += TIEMPO;
            if (contador >= 2000) {
                pelotas.add(new Pelota());
                contador = 0;
            }
            if (pelotas.size() >= 10) {
                continua = false;
                repaint();
                animacion.stop();
            }
            for (int i = 0; i < pelotas.size(); i++)
                pelotas.get(i).update();
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        } while (true);
    }

    public boolean mouseDown(Event ev, int x, int y) {
        for (int i = 0; i < pelotas.size(); i++) {
            if (pelotas.get(i).contains(x, y)) {
                Pelota p = pelotas.get(i);
                p.numero++;
                if (p.numero == 5) {
                    pelotas.remove(i);
                    contadorEliminados++;
                    break;
                }
            }
        }
        return true;
    }
}