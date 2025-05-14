package Tercera.Ejercicio8;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

public class Baraja{
    private ArrayList<Carta> cartas;
    public Baraja(Image imagenes[]){
        cartas=new ArrayList<Carta>();
        for(int i=0;i<imagenes.length;i++)
            cartas.add(new Carta(imagenes[i], (i%Solitario.CPP)+1, (i/Solitario.CPP==0||i/Solitario.CPP==3)?Carta.NEGRO:Carta.ROJO, i/Solitario.CPP));
        Collections.shuffle(cartas);
    }
    public Carta sacarCarta(){
        return cartas.remove(0);
    }
    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
}