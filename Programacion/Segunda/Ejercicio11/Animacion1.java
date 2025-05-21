/*
Primera animación
 */
package Segunda.Ejercicio11;

import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;

public class Animacion1 extends Frame implements Runnable{
    Thread animacion; //Proceso
    String frames[]={"*", "**", "***", "****", "*****", "******", "*****", "****", "***", "**", "*"};
    int actual;
    public static void main (String arg[]){
        Animacion1 app = new Animacion1();
    }
    public Animacion1(){
        super("Animacion sencilla");
        
        this.pack();
        this.setSize(200, 200);
        this.setVisible(true);
        animacion = new Thread(this);
        animacion.start();
    }
    public void paint(Graphics g){
        g.drawString(frames[actual], 80, 100);
    }
    public boolean handleEvent(Event ev){
        if(ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        do{
            actual = (actual + 1) % frames.length;
            repaint();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {}
        }while(true);
    }
}