package Tercera.Ejercicio2;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Pieza extends Rectangle{
    public static final int DIMENSION = 60;
    private boolean coloada = false;
    int posicion;
    Image imagen;
    
    public Pieza(Image img, int pos){
        super((int)(Math.random()*300+350), (int)(Math.random()*450), DIMENSION, DIMENSION);
        imagen = img;
        posicion = pos;
    }
    public void paint(Graphics g, Applet a){
       g.drawImage(imagen, x, y, a);
    }
    public void Mover(int posX, int posY){
        x=posX-(DIMENSION/2);
        y=posY-(DIMENSION/2);
    }

    public boolean isColoada() {
        return coloada;
    }

    public void setColoada(boolean coloada) {
        this.coloada = coloada;
    }
    public void ajustar(int posX, int posY){
        x=posX;
        y=posY;        
    }
}