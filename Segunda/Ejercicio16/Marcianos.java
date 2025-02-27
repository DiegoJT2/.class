package Segunda.Ejercicio16;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Marcianos extends Applet implements Runnable{
    public static final int TIEMPO = 35;
    
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Gun arma;
    ArrayList<Bala> balas;
    ArrayList<Nave> naves;
    int contador;
    
    public void init(){
        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();
        arma = new Gun();
        balas = new ArrayList<Bala>();
        naves = new ArrayList<Nave>();
        for(int i=0; i<10; i++)
            naves.add(new Nave());
        this.setSize(300, 300);
    }
    
    public void update(Graphics g){
        paint(g);
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 300, 300);
        arma.paint(noseve);
        for(Bala bala : balas)
            bala.paint(noseve);
        for(Nave nave : naves)
            nave.paint(noseve);
        g.drawImage(imagen, 0, 0, this);
    }
    
    @Override
    public void run() {
        do{
            contador += TIEMPO;
            if(contador >= 3000){
                naves.add(new Nave());
                contador = 0;
            }
            for(Nave nave:naves)
                nave.update();
            for(Bala bala:balas){
                if(bala.update()){
                    balas.remove(bala);
                    break;
                }
            }
            boolean salir=false;
            for(Bala bala:balas){
                for(Nave nave:naves)
                    if(bala.intersects(nave)){
                        naves.remove(nave);
                        balas.remove(bala);
                        salir=true;
                        break;
                    }
                if(salir)
                    break;
            }
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        }while(true);
    }
    
    public boolean mouseMove(Event e, int x, int y){
        arma.actualizar(x);
        return true;
    }
    public boolean mouseDown(Event e, int x, int y){
        balas.add(new Bala(x));
        return true;
    }
}