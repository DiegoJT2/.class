package Segunda.Examen1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Gun extends Rectangle{
    public static final int VELX = 5;
    static final Color colores[] = {Color.ORANGE, Color.CYAN, Color.YELLOW, Color.MAGENTA};
    Color color;
    public Gun(int posX){
        super(posX, 460, 40, 40);
        switch(posX){
            case 25:
                color = colores[0];
                break;
            case 95:
                color = colores[1];
                break;
            case 165:
                color = colores[2];
                break;
            case 235:
                color = colores[3];
        }
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}