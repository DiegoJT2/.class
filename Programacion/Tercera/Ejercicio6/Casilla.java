package Tercera.Ejercicio6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    public static final int DIM=60;
    private int valor;
    Color color;

    public Casilla(int posX, int posY, int v, Color color) {
        super(posX, posY, DIM, DIM);
        valor = v;
        this.color = color;
    }
    public void paint(Graphics g){
        g.setColor(color.black);
        g.drawRect(x, y, width, height);
        g.setFont(new Font("TimesRoman", Font.BOLD, 24));
        g.setColor(color);
        g.drawString(""+valor, x+20, y+40);
    }
    public int getValor() {
        return valor;
    }
}
