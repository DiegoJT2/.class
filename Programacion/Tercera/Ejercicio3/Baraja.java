package Tercera.Ejercicio3;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    ArrayList<Carta> cartas;
    public Baraja(Image imgs[]){
        cartas = new ArrayList<Carta>();
        for(int i=0; i<BlackJack.NUMCARTAS; i++)
            cartas.add(new Carta(imgs[i], (i%BlackJack.CPP)+1));
        Collections.shuffle(cartas);//Desordena los elementos de la lista
    }
    public Carta sacarCarta(){
        Carta carta = cartas.get(0);
        cartas.remove(0);
        return carta;
    }
}