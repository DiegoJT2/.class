package Tercera.Ejercicio1;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class DibujoAnimado {
    private Image[] imagenes;
    public int indice;
    
    public DibujoAnimado(Image imgs[]){
        imagenes = imgs;
    }

    public Image[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(Image[] imagenes) {
        this.imagenes = imagenes;
    }
    public void paint(Graphics g, Applet ap){
        g.drawImage(imagenes[indice], 0, 0, 200, 250, ap);
    }
    public void update(){
        indice = (indice+1)%imagenes.length;
    }
}
