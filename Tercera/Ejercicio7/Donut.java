package Tercera.Ejercicio7;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Donut extends Rectangle{
    public static final int DIM=100;
    private Image imagen;
    Image reverso;
    private boolean destapada=false;
    public Donut(int posX, int posY, Image img, Image rev){
        super(posX, posY, DIM, DIM);
        imagen=img;
        reverso=rev;
    }
    public void paint(Graphics g, Applet a){
        if(destapada)
            g.drawImage(imagen, x, y, width, height, a);
        else
            g.drawImage(reverso, x, y, width, height, a);
    }
    public Image getImagen() {
        return imagen;
    }
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    public boolean isDestapada() {
        return destapada;
    }
    public void setDestapada(boolean destapada) {
        this.destapada = destapada;
    }
}
