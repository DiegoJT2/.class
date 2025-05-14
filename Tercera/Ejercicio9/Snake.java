package Tercera.Ejercicio9;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Snake extends Applet implements Runnable{
    public static final int TIEMPO = 300;
    Thread animacion;
    Serpiente serpiente;
    Image imagen;
    Graphics noseve;
    Image imgCasilla;
    ArrayList<Eslabon> manzanas;
    Image imgManzana;
    int contador;
    
    public void init(){
        imagen = this.createImage(700, 800);
        noseve = imagen.getGraphics();
        imgCasilla = getImage(getCodeBase(), "Tercera/Ejercicio9/casilla.png");
        serpiente = new Serpiente(imgCasilla);
        
        imgManzana = getImage(getCodeBase(), "Tercera/Ejercicio9/manzana.png");
        manzanas = new ArrayList<Eslabon>();
        
        this.setSize(700, 800);
    }
    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }
    public void update(Graphics g){
        paint(g);
    }
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 700, 800);
        serpiente.paint(noseve, this);
        for(Eslabon manzana:manzanas)
            manzana.paint(noseve, this);
        
        g.drawImage(imagen, 0, 0, this);
    }
    public void run(){
        do {
            serpiente.update();
            contador+=TIEMPO;
            if(contador>5000){
                manzanas.add(new Eslabon(imgManzana, (int)(Math.random()*600), (int)(Math.random()*600), 0));
                contador=0;
            }
            for(Eslabon manzana:manzanas)
                if(serpiente.getPrimero().intersects(manzana)){
                    manzanas.remove(manzana);
                    serpiente.anadir(imgCasilla);
                    break;
                }
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch(InterruptedException e) {}
        } while (true);
    }
    public boolean keyDown(Event ev, int tecla){
        serpiente.cambiarDireccion(tecla);
        return true;
    }
}