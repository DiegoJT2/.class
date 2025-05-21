package Segunda.Ejercicio14;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Arkanoid extends Applet implements Runnable{
    public static final int FILAS = 5;
    public static final int COLUMNAS = 10;
    public static final int DERECHA = 0;
    public static final int IZQUIERDA = 1;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    ArrayList<Ladrillo> ladrillos;
    Raqueta raqueta;
    Pelota pelota;
    boolean continua = true;
    
    public void init(){
        Color colores[]={Color.BLUE, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.RED};
        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();
        ladrillos = new ArrayList<Ladrillo>();
        for(int i = 0; i<FILAS; i++)
            for(int j = 0; j<COLUMNAS; j++)
                ladrillos.add(new Ladrillo(((Ladrillo.ANCHURA + 2)*j)+1, ((Ladrillo.ALTURA + 2)*i)+10, colores[i]));
        raqueta = new Raqueta();
        pelota = new Pelota();
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
        for(int i=0; i<ladrillos.size(); i++)
            ladrillos.get(i).paint(noseve);
        raqueta.paint(noseve);
        pelota.paint(noseve);
        if(!continua) noseve.drawString("GAME OVER", 120, 140);
        g.drawImage(imagen, 0, 0, this);
    }
    
    @Override
    public void run() {
        do{
            continua = pelota.update(raqueta, ladrillos);
            if(!continua){
                repaint();
                animacion.stop();
            }
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }while(true);
    }
    public boolean keyDown(Event ev, int tecla){
        if(tecla == 1006)
            raqueta.setX(IZQUIERDA);
        if(tecla == 1007)
            raqueta.setX(DERECHA);
        return true;
    }
}