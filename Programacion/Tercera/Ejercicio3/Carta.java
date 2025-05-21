package Tercera.Ejercicio3;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Carta {
    public static final int ANCHURA = 100;
    public static final int ALTURA = 200;
    private int posX, posY;
    Image img;
    int valor;
    public Carta(Image imagen, int val){
    img = imagen;
    /*valor = val;
    if(val>10) valor = 10;*/
    valor = (val>10)?10:val;//si inmediato iif siInm
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(img, posX, posY, ANCHURA, ALTURA, a);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}