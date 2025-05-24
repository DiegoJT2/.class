package Tercera.Examen24;

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
    Corredor corredor;
    Image[] imgsCorredor;
    Image dead;
    ArrayList<Granada> granadas;
    ArrayList<Nave> naves;
    Image imgNave;
    Image imgGranada;
    int contador;
    
    public void init(){
        imagen = this.createImage(600, 600);
        noseve = imagen.getGraphics();
        imgGranada = getImage(getCodeBase(), "Tercera/Examen24/granada.jpg");
        granadas = new ArrayList<Granada>();
        imgsCorredor = new Image[4];
        for(int i=0; i<4; i++)
            imgsCorredor[i] = getImage(getCodeBase(), "Tercera/Ejercicio1/Sprites/Hampon/h"+i+".gif");
        dead = getImage(getCodeBase(), "Tercera/Ejercicio1/Sprites/Hampon/dead.png");
        corredor = new Corredor(imgsCorredor, dead);
        imgNave = getImage(getCodeBase(), "Tercera/Examen24/nave.png");
        naves = new ArrayList<Nave>();
        for(int i=0; i<10; i++){
            int posY = 10 + i * 45; // Espaciado vertical para 10 naves
            naves.add(new Nave(posY, imgNave));
        }
        this.setSize(600, 600);
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
        noseve.fillRect(0, 0, 600, 600);
        corredor.paint(noseve);
        for(Granada granada : granadas)
            granada.paint(noseve);
        for(Nave nave : naves)
            nave.paint(noseve, this);
        g.drawImage(imagen, 0, 0, this);
    }
    
    @Override
    public void run() {
        do{
            contador += TIEMPO;
            for(Nave nave:naves){
                nave.update();
                if(Math.random() < 0.01) {
                    granadas.add(new Granada(nave.x + nave.width/2, nave.y + nave.height, imgGranada));
                }
            }
            for(Granada granada:granadas){
                granada.update();
            }
            // Colisión granada-corredor
            if (!corredor.muerto) {
                for (Granada granada : granadas) {
                    if (granada.intersects(corredor)) {
                        corredor.morir();
                        break;
                    }
                }
            }
            // Si está muerto, que caiga poco a poco
            if (corredor.muerto) {
                corredor.caer();
            }
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        }while(true);
    }
    public boolean keyDown(Event e, int key){
    if(key == Event.LEFT)
        corredor.mover(-1);
    else if(key == Event.RIGHT)
        corredor.mover(1);
    return true;
    }
}