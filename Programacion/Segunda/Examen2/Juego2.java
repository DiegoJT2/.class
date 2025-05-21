package Segunda.Examen2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
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
    int pinchados;
    public static Font fuente;

    public void init() {
        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();
        pelotas = new ArrayList<Pelota>();
        pelotas.add(new Pelota());
        fuente = new Font("TimesRoman", Font.BOLD, 20);
        noseve.setFont(fuente);
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
        noseve.drawString("PINCHADOS: " + pinchados, 110, 20);
        for (int i = 0; i < pelotas.size(); i++)
            pelotas.get(i).paint(noseve);
        noseve.drawString("PINCHADOS" +pinchados, 20, 40);
        if(!continua) noseve.drawString("GAME OVER", 120, 140);
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
        for (Pelota pelota:pelotas) {
            if (pelota.contains(x, y)) {
                pelota.numero++;
                if(pelota.numero == 6){
                    pelotas.remove(pelota);
                    pinchados++;
                    break;
                }
            }
        }
        return true;
    }
}