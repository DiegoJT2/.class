package Tercera.Practica;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Flecha{
    public static final int ANCHURA = 30;
    public static final int ALTURA = 30;
    public static final int velX = 2;
    int x=50;
    int y;
    Image imagen;
    public Flecha(int posY, Image img){
        y = posY;
        imagen = img;
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, ALTURA, ANCHURA, a);
    }
    public boolean update(){
        x+=velX;
        return x>=500;
    }
}
