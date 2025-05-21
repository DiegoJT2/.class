package Tercera.Ejercicio7;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Memory extends Applet implements Runnable{
    public static final int TIEMPO = 1000;
    public static final int TAM = 4;
    Image imagen;
    Graphics noseve;
    Image imagenes[];
    Image reverso;
    Donut donuts[][];
    Donut duno;
    Donut ddos;
    int contador;
    int temporal;
    Thread animacion;
    
    public void init(){
        imagen = this.createImage(700, 800);
        noseve = imagen.getGraphics();
        imagenes=new Image[8];
        reverso = getImage(getCodeBase(), "Tercera/Ejercicio7/donutsMatch/reverso.png");
        for(int i=0; i<imagenes.length; i++)
            imagenes[i] = getImage(getCodeBase(), "Tercera/Ejercicio7/donutsMatch/img"+(i+1)+".png");
        donuts=new Donut[TAM][TAM];
        for(int i=0; i<TAM; i++)
            for(int j=0; j<TAM; j++)
                donuts[i][j]=new Donut(98+(j*Donut.DIM), 98+(i*Donut.DIM),imagenes[((i*TAM)+j)%(TAM*2)], reverso);
        
        desordenar();
        this.setSize(700, 800);
    }
    private void desordenar() {
        for(int i=0;i<25;i++){
            int aleatorio1 = (int)(Math.random()*(TAM*TAM));
            int aleatorio2 = (int)(Math.random()*(TAM*TAM));
            Image auxiliar = donuts[aleatorio1/TAM][aleatorio1%TAM].getImagen();
            donuts[aleatorio1/TAM][aleatorio1%TAM].setImagen(donuts[aleatorio2/TAM][aleatorio2%TAM].getImagen());
            donuts[aleatorio2/TAM][aleatorio2%TAM].setImagen(auxiliar);
        }
    }
    public void update(Graphics g){
        paint(g);
    }
    public void start() {
        animacion = new Thread(this);
        animacion.start();
    }
    public void paint(Graphics g){
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, 700, 800);
        for(Donut[] donut1:donuts)
            for(Donut donut:donut1)
                donut.paint(noseve, this);
        g.drawImage(imagen, 0, 0, this);
    }
    public int cuantas(){
        int num=0;
        if(duno!=null) num++;
        if(ddos!=null) num++;
        return num;
    }
    public boolean mouseDown(Event ev, int x, int y){
        for(Donut[] donut1:donuts)
            for(Donut donut:donut1)
                if(donut.contains(x,y)){
                    donut.setDestapada(true);
                    switch(cuantas()){
                        case 0:
                            duno = donut;
                            break;
                        case 1:
                            ddos = donut;
                            if(duno.getImagen()==ddos.getImagen())
                                duno = ddos = null;
                            else{
                                temporal = contador;
                            }
                    }
                    repaint();
                }
        return true;
    }
    @Override
    public void run() {
        do{
            contador++;
            if(temporal!=0 && contador-temporal==3){
                duno.setDestapada(false);
                ddos.setDestapada(false);
                duno = ddos = null;
                repaint();
            }
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){}
        } while(true);
    }
}