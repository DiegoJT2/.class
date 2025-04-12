package Tercera.Practica;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Robin extends Rectangle{
    Image imagen;
    public Robin(Image img){
        super(50, 50, 50, 50);
        imagen = img;
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
    public void mover(int posY){
        y = posY;
    }
}
