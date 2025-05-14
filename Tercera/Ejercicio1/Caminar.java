package Tercera.Ejercicio1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Caminar extends Applet implements Runnable {
    public static final int TIEMPO = 100;
    public static final int GUERRILLERO = 0;
    public static final int HAMPON = 1;
    public static final int VAQUERO = 2;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Image fotogramas[][];
    String lugares[] = {"Guerrillero/g", "Hampon/h", "Vaquero/v"};
    DibujoAnimado da;
    
    public void init() {
        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();
        fotogramas = new Image[3][4];
        for(int i=0; i<fotogramas.length; i++)
            for(int j=0; j<fotogramas[i].length; j++)
                fotogramas[i][j] = getImage(getCodeBase(), "Tercera/Ejercicio1/Sprites/"+lugares[i]+(j+1)+".gif");
        da = new DibujoAnimado(fotogramas[GUERRILLERO]);
        this.setSize(300, 300);
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
        noseve.fillRect(0, 0, 300, 300);
        da.paint(noseve, this);
        g.drawImage(imagen, 0, 0, this);
    }
    public void run() {
        do {
            da.update();
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        } while (true);
    }
    public boolean keyDown(Event ev, int tecla){
        switch(tecla){
            case 103:
            case 71:
                da.setImagenes(fotogramas[GUERRILLERO]);
                break;
            case 104:
            case 72:
                da.setImagenes(fotogramas[HAMPON]);
                break;
            case 118:
            case 86:
                da.setImagenes(fotogramas[VAQUERO]);
        }
        return true;
    }
}