package Segunda.Ejercicio18;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class JuegoRana extends Applet implements Runnable{
    public static final int TIEMPO = 35;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Rana rana;
    ArrayList<Coche> coches;
    
    public static boolean continua = true;
    int contador = 0;
    int tiempoAleatorio;
    public void init(){
        imagen = this.createImage(500, 300);
        noseve = imagen.getGraphics();
        rana = new Rana();
        coches = new ArrayList<Coche>();
        coches.add(crearCoche());
        tiempoAleatorio = (int)(Math.random()*2000)+2000;
        this.setSize(500, 300);
    }

    private Coche crearCoche(){
        int vel = (int)(Math.random()*3)+3;
        if(Math.random() < 0.5)
            return new Coche(-40, (int)(Math.random()*80)+150, vel);
        else
            return new Coche(500, (int)(Math.random()*80)+50, -vel);
    }
    public void update(Graphics g){
        paint(g);
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    public void paint(Graphics g){
        noseve.setColor(Color.PINK);//evita que deje rastro el rectangulo gris
        noseve.fillRect(0, 0, 500, 300);
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 50, 500, 200);//(x, y, altura, anchura)
        noseve.setColor(Color.WHITE);
        noseve.drawLine(0, 149, 500, 149);
        rana.paint(noseve);
        for(Coche coche : coches)
            coche.paint(noseve);
        if(!continua) noseve.drawString("GAME OVER", 120, 140);
        g.drawImage(imagen, 0, 0, this);
    }
    @Override
    public void run(){
        do{
            contador += TIEMPO;
            if(contador >= tiempoAleatorio){
                contador = 0;
                tiempoAleatorio = (int)(Math.random()*500)+500;
                coches.add(crearCoche());
            }
            for(Coche coche : coches)
                if(coche.update()){
                    coches.remove(coche);
                    break;
                }
            rana.isColision(coches);
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
    public boolean keyDown(Event e, int tecla){
        rana.update(tecla);
        return true;
    }
}