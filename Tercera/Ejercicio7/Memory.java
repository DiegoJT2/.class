package Tercera.Ejercicio7;

import Tercera.Ejercicio6.Casilla;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Memory extends Applet{
    public static final int TAM = 4;
    Image imagen;
    Graphics noseve;
    Image imagenes[];
    Image reverso;
    Donut donuts[][];
    
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
                donut=new Donut(98+(j*Casilla.DIM), 98+(i*Donut.DIM),imagenes[i+j], reverso);
        this.setSize(700, 800);
    }
    public void update(Graphics g){
        paint(g);
    }    
    public void paint(Graphics g){
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, 700, 800);
        for(Donut[] donut1:donuts)
            for(Donut donut:donut1)
                donut.paint(noseve, this);
        g.drawImage(imagen, 0, 0, this);
    }
    public boolean mouseDown(Event ev, int x, int y){
        for(Donut[] donut1:donuts)
            for(Donut donut:donut1)
                if(donut.contains(x,y))
                    donut.setDestapada(true);
        repaint();
        return true;
    }
    public boolean mouseDrag(Event ev, int x, int y){
        
        repaint();
        return true;
    }
    public boolean mouseUp(Event ev, int x, int y){
        
        return true;
    }
    public boolean action(Event ev, Object obj){
        
        return false;
    }
}