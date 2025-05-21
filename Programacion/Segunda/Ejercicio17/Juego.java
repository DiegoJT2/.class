package Segunda.Ejercicio17;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Juego extends Applet implements Runnable{
    public static final int TIEMPO = 20;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Dinosaurio dino;
    ArrayList<Cactus> cactus;
    boolean continua = true;
    int contador;
    int randomTime;

    public void init(){
        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();
        dino = new Dinosaurio();
        cactus = new ArrayList<Cactus>();
        cactus.add(new Cactus((int)(Math.random()*5)+10));
        randomTime = (int)(Math.random()*2000)+2000;
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
        dino.paint(noseve);
        for(Cactus cactus : cactus)
            cactus.paint(noseve);
        if(!continua) noseve.drawString("GAME OVER", 120, 140);
        g.drawImage(imagen, 0, 0, this);
    }
    @Override
    public void run() {
        do{
            contador+= TIEMPO;
            if(contador >= randomTime){
                cactus.add(new Cactus((int)(Math.random()*5)+10));
                contador = 0;
                randomTime = (int)(Math.random()*1800)+1800;
            }
            if(dino.update(cactus.get(0))){
                continua = false;
                repaint();
                animacion.stop(); 
            }
            for(Cactus cac:cactus)
                if(cac.update()){
                    cactus.remove(cac);
                    break;
                }
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        }while(true);
    }
    public boolean keyDown(Event ev, int tecla){
        if(tecla == 32)
            dino.setSalto(true);
        return true;
    }
}