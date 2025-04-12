package Tercera.Ejercicio6;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Ficha extends Rectangle{
    public static final int DIM=60;
    Image imagen;
    private int precio;
    private ArrayList<Integer> numerosApostados;

    public Ficha(int posX, int posY, int v, Image img ) {
        super(posX, posY, DIM, DIM);
        imagen = img;
        precio = v;
        numerosApostados=new ArrayList<Integer>();
    }
    public ArrayList<Integer> getNumerosApostados() {
        return numerosApostados;
    }
    public void setNumerosApostados(ArrayList<Integer> numerosApostados) {
        this.numerosApostados = numerosApostados;
    }
    public int getPrecio() {
        return precio;
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
    public void update(int px, int py){
        x=px-(DIM/2);
        y=py-(DIM/2);
    }
    public void cargarApostados(Casilla casillas[][]){
        numerosApostados.clear();//Vacía la lista antes de volverla a cargar.
        for (Casilla[] casilla1 : casillas)
            for (Casilla casilla : casilla1)
                if(this.intersects(casilla))
                    numerosApostados.add(casilla.getValor());
    }
}