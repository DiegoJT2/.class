package Tercera.Examen1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Pieza extends Rectangle {
    public static final int TAM = 60;
    int numero;
    int columna, fila;
    Color color;

    public Pieza(int col, int fila, int num){
        super(col * TAM + 20, fila * TAM + 90, TAM, TAM);
        columna = col;
        this.fila = fila;
        numero = num;
        colorUpdate();
    }
    public void paint(Graphics g){
    g.setColor(color);
    g.fillRect(x, y, width, height);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, width, height);
    g.drawString("" + numero, x + TAM/2 - 5, y + TAM/2 + 5);
    }
    public int getNumero(){
        return numero;
    }
    public void setNumero(int n){
        numero = n;
    }
    public void setGridPos(int col, int fil){
        columna = col;
        fila = fil;
        x = col * TAM + 20;
        y = fil * TAM + 90;
    }
    public void setPosicion(int px, int py){
        x = px;
        y = py;
    }
    public void colorUpdate(){
        switch(numero){
            case 1:
                color=Color.red;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.BLUE;
                break;
            case 4:
                color = Color.GRAY;
                break;
            case 5:
                color = Color.yellow;
                break;
            case 6:
                color = Color.PINK;
                break;
            case 7:
                color = Color.ORANGE;
                break;
            case 8:
                color = Color.MAGENTA;
                break;
            case 9:
                color = Color.lightGray;
                break;
            case 10:
                color = Color.CYAN;
                break;
        }
    }
}