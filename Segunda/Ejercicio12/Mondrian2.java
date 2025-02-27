package Segunda.Ejercicio12;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Mondrian2 extends Applet implements Runnable{
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Rectangulo rectangulos[];
    int posicionesX[]={0,250,80,80,100,80,200,0,200};
    int posicionesY[]={0,0,160,220,10,100,0,110,55};
    int anchuras[]={90,40,100,220,90,110,45,70,60};
    int alturas[]={90,190,120,90,80,90,45,200,135};
    Color colores[]={Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.BLUE, Color.BLUE, Color.LIGHT_GRAY, Color.RED, Color.RED, Color.MAGENTA};

    public void init() {
        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();
        rectangulos = new Rectangulo[9];
        for(int i = 0;i<rectangulos.length; i++)
            rectangulos[i]=new Rectangulo(posicionesX[i], posicionesY[i], anchuras[i], alturas[i], colores[i]);
    }
    public void update(Graphics g){
        paint(g);
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    public void paint(Graphics g){
        noseve.setColor(Color.white);//evita que deje rastro el rectangulo gris
        noseve.fillRect(0, 0, 300, 300);
        for(int i = 0;i<rectangulos.length; i++)
            rectangulos[i].paint(noseve);
        g.drawImage(imagen, 0, 0, this);
    }
    public void run() {
        do{
            for(int i=0; i<rectangulos.length; i++)
                rectangulos[i].update();
        repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }while(true);
    }
    
}