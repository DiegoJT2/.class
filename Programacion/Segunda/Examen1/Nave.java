package Segunda.Examen1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Nave extends Rectangle{
    static final Color colores[] = {Color.ORANGE, Color.CYAN, Color.YELLOW, Color.MAGENTA};
    Color color;
    int velX;

    public Nave(int posY){
        super(150, posY, 40, 40);
        color = colores[(int)(Math.random()*colores.length)];
        velX = (int)(Math.random()*5)+1;
        switch(posY){
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
    public void update(){
        x+=velX;
        if(x<=0||x>=300-width)
            velX = -velX;
    }
}