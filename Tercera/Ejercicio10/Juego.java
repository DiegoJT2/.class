package Tercera.Ejercicio10;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Juego extends Applet implements Runnable {
    public static final int TIEMPO = 100;
    public static final int GUERRILLERO = 0;
    public static final int HAMPON = 1;
    public static final int RUEDA = 5;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Fondo fondo;
    Rueda rueda;
    Image imagenes[][];
    String lugares[] = {"fondo.jpg", "lightBeam.png", "mercedes.png", "pedal.png", "pedal2.png", "rueda1.gif", "rueda2.gif", "rueda3.gif", "rueda4.gif", "rueda5.gif"};
    
    public void init() {
        imagen = this.createImage(700, 800);
        noseve = imagen.getGraphics();
        imagenes = new Image[3][4];
        for(int i=0; i<imagenes.length; i++)
            for(int j=0; j<imagenes[i].length; j++)
                imagenes[i][j] = getImage(getCodeBase(), "Tercera/Ejercicio10/imgCoche/"+lugares[i]+(j+1));
        rueda = new Rueda(imagenes[RUEDA]);
        this.setSize(700, 800);
    }
    public void update(Graphics g) {
        paint(g);
    }
    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }
    public void paint(Graphics g) {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 700, 800);
        
        g.drawImage(imagen, 0, 0, this);
    }
    public void run() {
        do {
            
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        } while (true);
    }
    public boolean mouseDown(Event ev, int x, int y){
        
        return true;
    }
}