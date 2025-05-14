package Segunda.Examen2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota extends Rectangle {
    Color colores[] = {Color.RED, Color.YELLOW, Color.MAGENTA, Color.PINK, Color.ORANGE};
    Color color;
    int velX, velY;
    int numero;

    public Pelota() {
        super(150, 150, 0, 0);
        int radio = (int)(Math.random()*30)+20;
        this.setSize(radio, radio);
        this.velX = (int)(Math.random()*5)-2;
        this.velY = (int)(Math.random()*5)-2;
        color = colores[(int)(Math.random()*colores.length)];
        numero = 1;
    }
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
        String num = Integer.toString(numero);
        g.setColor(Color.BLACK);
        g.drawString(num, x+15, y+15);
    }
    
    public void update() {
        x += velX;
        y += velY;
    }
}