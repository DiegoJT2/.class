package Tercera.Ejercicio3;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;

public class Mano {
    ArrayList<Carta> cartas;
    int posY;
    public Mano(int pY){
        cartas = new ArrayList<Carta>();
        posY = pY;
    }
    public void paint(Graphics g, Applet a){
        for(int i=0; i<cartas.size(); i++){
            cartas.get(i).setPosX(100 + (i*30));
            cartas.get(i).setPosY(posY);
            cartas.get(i).paint(g, a);
        }
    }
    public void anadirCarta(Carta carta){
        cartas.add(carta);
    }
    public int puntuacion(){
        int acum=0;
        boolean as = false;
        for(Carta carta:cartas){
            acum+=carta.valor;
            if(carta.valor==1) as = true;
        }
        if(as && acum<=11)acum+=10;
        return acum;
    }
    public boolean seHaPasado(){
        return puntuacion()>21;
    }
    public boolean menor17(){
        return puntuacion()<17;
    }
}
