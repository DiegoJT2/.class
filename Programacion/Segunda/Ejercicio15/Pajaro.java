package Segunda.Ejercicio15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pajaro extends Rectangle{
    public static final int GRAVEDAD = 2;
    public static final int SALTO = -25;

    public Pajaro(){
        super(10, 0, 15, 15);
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
    public void update(){
        y+=GRAVEDAD;
    }
    public void saltar(){
        y+=SALTO;
    }
    public boolean colision(Columna columna){
        return (y>=300-height || this.intersects(columna.rect1) || this.intersects(columna.rect2));
    }
}