package Tercera.Practica;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class JuegoRobin extends Applet implements Runnable{
    public static final int TIEMPO = 25;
    public static final int IMGS = 4;
    Thread animacion;
    Image imagenes[];
    Image imagen;
    Graphics noseve;
    ArrayList<Flecha> flechas;
    ArrayList<Globo> globos;
    Robin robin;
    int contador;
    
    public void init() {
        imagen = this.createImage(700, 500);
        noseve = imagen.getGraphics();
        imagenes = new Image[IMGS];
        flechas = new ArrayList<Flecha>();
        globos = new ArrayList<Globo>();
        for(int i = 0; i<IMGS; i++)
            imagenes[i] = getImage(getCodeBase(), "Tercera/Practica/Imagenes/"+(i+1)+".png");
        robin = new Robin(imagenes[3]);
        globos.add(new Globo(imagenes[(int)(Math.random()+0.5)]));
        this.setSize(700, 500);
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
        noseve.fillRect(0, 0, 700, 500);
        noseve.setColor(Color.white);
        robin.paint(noseve, this);
        for(Globo globo:globos)
            globo.paint(noseve, this);
        for(Flecha flecha:flechas)
            flecha.paint(noseve, this);
        g.drawImage(imagen, 0, 0, this);
    }
    public void run() {
        do {
            contador+=TIEMPO;
            if(contador == 3000){
                globos.add(new Globo(imagenes[(int)(Math.random()+0.5)]));
                contador = 0;
            }
            for(Globo globo:globos)
                globo.update();
            if(!flechas.isEmpty())
                for(Flecha flecha:flechas)
                    if(flecha.update())
                        globos.remove(0);
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        } while (true);
    }
    public boolean mouseDown(Event ev, int x, int y){
        flechas.add(new Flecha(robin.y, imagenes[2]));
        return true;
    }
    public boolean mouseMove(Event ev, int x, int y){
        robin.mover(y);
        repaint();
        return true;
    }
}