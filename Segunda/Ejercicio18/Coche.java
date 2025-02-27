package Segunda.Ejercicio18;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Coche extends Rectangle{
    static final Color colores[] = {Color.BLUE, Color.CYAN, Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED};
    Color color;
    int velX;
    public Coche(int posX, int posY, int velX){
        super(posX, posY, 40, 20);
        color = colores[(int)(Math.random()*colores.length)];
        this.velX = velX;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    public boolean update(){
        x+=velX;
        return x<-width || x>500;
    }
}