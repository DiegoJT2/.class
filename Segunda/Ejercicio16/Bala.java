package Segunda.Ejercicio16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Bala extends Rectangle{
    public static final int VELY = -5;
    
    public Bala(int posX){
        super(posX, 260, 5, 10);
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
    public boolean update(){
        y+=VELY;
        return y < 0;
    }
}