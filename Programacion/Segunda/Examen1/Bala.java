package Segunda.Examen1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bala extends Rectangle{
    static final Color colores[] = {Color.ORANGE, Color.CYAN, Color.YELLOW, Color.MAGENTA};
    Color color;
    public static final int VELY = -5;
    
    public Bala(int posX, Color color){
        super(posX, 460, 5, 10);
        this.color = color;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    public boolean update(){
        y+=VELY;
        return y < -(5+width);
    }
    
}