package Segunda.Examen1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Juego1 extends Applet implements Runnable{
    public static final int TIEMPO = 35;
    
    Thread animacion;
    Image imagen;
    Graphics noseve;
    ArrayList<Gun> armas;
    ArrayList<Bala> balas;
    ArrayList<Nave> naves;
    int contador;
    
    public void init(){
        imagen = this.createImage(300, 500);
        noseve = imagen.getGraphics();
        balas = new ArrayList<Bala>();
        armas = new ArrayList<Gun>();
        int posX = 25;
        for(int i=0; i<4; i++){
            armas.add(new Gun(posX));
            posX+=70;
        }
        naves = new ArrayList<Nave>();
        int posY = 25;
        for(int i=0; i<4; i++){
            naves.add(new Nave(posY));
            posY+=70;
        }
        this.setSize(300, 500);
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
        noseve.fillRect(0, 0, 300, 500);
        for(Gun arma : armas)
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
            for(Nave nave:naves)
                nave.update();
            for(Bala bala:balas){
                if(bala.update()){
                    balas.remove(bala);
                    break;
                }
            }
            boolean salir=false;
            for (Bala bala : balas){
                for (Nave nave : naves){
                    if(bala.intersects(nave) && bala.color.equals(nave.color)) {
                        nave.width += 1;
                        nave.height +=1;
                        balas.remove(bala);
                        salir = true;
                        break;
                    }
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
    public boolean mouseDown(Event e, int x, int y){
    for(Gun arma : armas)
        if(arma.contains(x, y)){
            balas.add(new Bala(arma.x + arma.width / 2, arma.color));
            break;
        }
    return true;
    }
}