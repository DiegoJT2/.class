package Segunda.Ejercicio05;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ovalo {
    int posX, posY, anchura, altura;
    Color color;
    Random r;
    
    public Ovalo() {
        r = new Random();
        inicializar();
    }

    public void inicializar() {
        posX = r.nextInt(200);
        posY = r.nextInt(200);
        anchura = r.nextInt(100);
        altura = r.nextInt(100);
        color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillOval(posX, posY, anchura, altura);
    }
}