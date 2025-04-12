package Tercera.Ejercicio5;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    public static final int TAM = 17;
    private Image mina;
    Image reverso;
    private int alrededor;
    private boolean tapa;
    public Casilla(int posX, int posY, Image rev){
        super(posX, posY, TAM, TAM);
        reverso = rev;
        tapa = true;
        alrededor = 0;
    }
    public Image getMina() {
        return mina;
    }
    public void setMina(Image mina) {
        this.mina = mina;
    }
    public int getAlrededor() {
        return alrededor;
    }
    public void setAlrededor(int alrededor) {
        this.alrededor = alrededor;
    }
    public boolean isTapa() {
        return tapa;
    }
    public void setTapa(boolean tapa) {
        this.tapa = tapa;
    }
    public void paint(Graphics g, Applet a){
        g.setColor(Color.GREEN);
        g.drawRect(x, y, width, height);
        if(tapa)
            g.drawImage(reverso, x, y, a);
        else if(mina!=null)
            g.drawImage(mina, x, y, a);
            else
                g.drawString(""+alrededor, x+4, y+13);
    }
}