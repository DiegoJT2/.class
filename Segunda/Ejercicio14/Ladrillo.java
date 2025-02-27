package Segunda.Ejercicio14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ladrillo extends Rectangle{
    public static final int ANCHURA = 28;
    public static final int ALTURA = 10;
    public Color color;

    public Ladrillo(int posX, int posY, Color color) {
        super(posX, posY, ANCHURA, ALTURA);
        this.color = color;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
