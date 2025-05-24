package Tercera.Examen24;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Granada extends Rectangle{
    public static final int VELY = 3;
    Image imagen;
    
    public Granada(int posX, int posY, Image img){
        super(posX, posY, 10, 15);
        this.imagen = img;
    }
    public void paint(Graphics g){
        g.drawImage(imagen, x, y, width, height, null);
    }
    public void update(){
        y+=VELY;
    }
    
}