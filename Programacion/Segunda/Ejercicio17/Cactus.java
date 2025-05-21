package Segunda.Ejercicio17;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Cactus extends Rectangle{
    static final int VELX = 2;
    static final Color colores[] = {Color.BLUE, Color.CYAN, Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED};
    Color color;

    public Cactus(int altura) {
        super(300, 300-altura, (int)(Math.random()*10)+20, altura);//(int): parsear, convierte el double de random a int
        color = colores[(int)(Math.random()*colores.length)];
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    public boolean update(){
        x-=VELX;
        return(x<-width);
    }
}