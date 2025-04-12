package Tercera.Practica;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Globo extends Rectangle{
    public static final int velY = 3;
    Image imagen;
    public Globo(Image img){
        super(550, 520, 50, 50);
        imagen = img;
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
    public void update(){
        y-=velY;
    }
}
