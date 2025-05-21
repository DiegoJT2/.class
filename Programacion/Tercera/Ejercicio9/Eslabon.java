package Tercera.Ejercicio9;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Eslabon extends Rectangle{
    public static final int TAM = 15;
    private int direccion;
    Image reverso;
    
    public Eslabon(Image img, int posX, int posY, int direccion){
        super(posX, posY, TAM, TAM);
            reverso = img;
            this.direccion = direccion;
    }
    public int getDireccion(){
        return direccion;
    }
    public void setDireccion(int direccion){
        this.direccion = direccion;
    }
    public void paint(Graphics g, Applet s){
        g.drawImage(reverso, x, y, width, height, s);
    }
    public void update(){
        switch(direccion){
            case Event.RIGHT:
                x += TAM;
                break;
            case Event.LEFT:
                x -= TAM;
                break;
            case Event.DOWN:
                y += TAM;
                break;
            case Event.UP:
                y -= TAM;
                break;
        }
    }
}