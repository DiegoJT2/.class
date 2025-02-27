package Segunda.Ejercicio15;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Floppy_Bird extends Applet implements Runnable{
    public static final int TIEMPO = 35;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Pajaro pajaro;
    ArrayList<Columna> columnas;
    boolean continua = true;
    int contador;

    public void init(){
        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();
        pajaro = new Pajaro();
        columnas = new ArrayList<Columna>();
        columnas.add(new Columna());
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
        pajaro.paint(noseve);
        for(Columna columna : columnas)
            columna.paint(noseve);
        if(!continua) noseve.drawString("GAME OVER", 120, 140);
        g.drawImage(imagen, 0, 0, this);
    }
    @Override
    public void run() {
        do{
            contador+= TIEMPO;
            if(contador > 3000){
                columnas.add(new Columna());
                contador = 0;
            }
            pajaro.update();
            for(Columna columna:columnas)
                columna.update();
            
            if(!columnas.isEmpty())//si está o no vacia
                if(columnas.get(0).rect1.x < -Columna.ANCHURA)
                    columnas.remove(0);
            
            continua = !pajaro.colision(columnas.get(0));
            
            if(!continua){
                repaint();
                animacion.stop();
            }
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        }while(true);
    }
    public boolean keyDown(Event ev, int tecla){
        if(tecla == 32)
            pajaro.saltar();
        return true;
    }
}