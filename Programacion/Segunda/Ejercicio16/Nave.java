package Segunda.Ejercicio16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Nave extends Rectangle{
    static final Color colores[] = {Color.BLUE, Color.CYAN, Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED};
    Color color;
    int velX;

    public Nave(){
        super((int)(Math.random()*250), (int)(Math.random()*100), 40, 15);
        color = colores[(int)(Math.random()*colores.length)];
        velX = (int)(Math.random()*5)+1;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    public void update(){
        x+=velX;
        if(x<=0||x>=300-width)
            velX = -velX;
    }
}