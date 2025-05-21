package Segunda.Ejercicio13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota extends Rectangle{
    int velX, velY;
    Color color;
    Color colores[]={Color.RED, Color.YELLOW, Color.MAGENTA, Color.PINK, Color.ORANGE};

    public Pelota() {
        super((int)(Math.random()*250), (int)(Math.random()*250), 0, 0);//(int): parsear, convierte el double de random a int
        int radio = (int)(Math.random()*30)+20;
        //this.height = this.width = radio;
        this.setSize(radio, radio);
        this.velX=(int)(Math.random()*11)-5;
        velY=(int)(Math.random()*11)-5;
        color = colores[(int)(Math.random()*colores.length)];
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    public void update(){
        x += velX;
        y += velY;
        if(x<=0 || x>=300-height)
            velX = -velX;
        if(y<=0 || y>=300-height)
            velY = -velY;
    }
}