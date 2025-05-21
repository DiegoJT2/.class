package Tercera.Ejercicio10;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Fondo{
    public static final int VELX = 2;
    Image imagen;
    int posX;
    
    public Fondo(){
        
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, 0, 0, a);
    }
    public void update(){
        posX+=VELX;
    }
}