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
        this.velX = (int)(Math.random()*11)-5;
        this.velY = (int)(Math.random()*11)-5;
        color = colores[(int)(Math.random()*colores.length)];
        numero = 1;
    }
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
        String num = Integer.toString(numero);
        g.setColor(Color.BLACK);
        int fontSize = width / 2;
        int textWidth =num.length()*fontSize / 2;
        int posX = x + (width - textWidth) / 2;
        int posY = y + (height + fontSize / 2) / 2;
        g.drawString(num, posX, posY);
    }
    
    public void update() {
        x += velX;
        y += velY;
        if (x <= 0 || x >= 300 - height)
            velX = -velX;
        if (y <= 0 || y >= 300 - height)
            velY = -velY;
    }
}