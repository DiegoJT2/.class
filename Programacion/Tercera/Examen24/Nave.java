package Tercera.Examen24;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Nave extends Rectangle{
    Image imagen;
    int velX;

    public Nave(int posY, Image img){
        super(150, posY, 40, 40);
        velX = 2;
        imagen = img;
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
    public void update(){
        x+=velX;
        if(x<=0||x>=600-width)
            velX = -velX;
    }
}