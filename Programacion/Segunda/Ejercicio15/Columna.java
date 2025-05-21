package Segunda.Ejercicio15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Columna{
    public static final int HUECO = 80;
    public static final int ANCHURA = 30;
    public static final int POSINICIAL = 300;
    public static final int VELX = -1;
    Rectangle rect1, rect2;

    public Columna() {
        int altura = (int)(Math.random()*130)+20;//(int): parsear, convierte el double de random a int
        rect1 = new Rectangle(POSINICIAL, 0, ANCHURA, altura);
        rect2 = new Rectangle(POSINICIAL, altura+HUECO, ANCHURA, 300-altura+HUECO);
    }
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillRect(rect1.x, rect1.y, rect1.width, rect1.height);
        g.fillRect(rect2.x, rect2.y, rect2.width, rect2.height);
    }
    public void update(){
        rect1.x+=VELX;
        rect2.x+=VELX;
    }
}