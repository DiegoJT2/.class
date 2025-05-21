package Segunda.Ejercicio14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

 public class Raqueta extends Rectangle{
    public static final int VELX = 5;

    public Raqueta(){
        super(110, 285, 60, 8);
    }
    public void paint(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(x, y, width, height);
    }
    public void setX(int direccion){
        if(direccion==Arkanoid.DERECHA)
            x += VELX;
        else
            x -= VELX;
        if(x<0) x=0;
        if(x>240) x=240;
    }
}