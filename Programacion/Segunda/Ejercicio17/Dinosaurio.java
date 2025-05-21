package Segunda.Ejercicio17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Dinosaurio extends Rectangle{
    public static final int TOPE = 170;
    public int velY = -2;
    private boolean salto = false;

    public Dinosaurio(){
        super(20, 250, 20, 50);
    }

    public boolean isSalto() {
        return salto;
    }

    public void setSalto(boolean salto) {
        this.salto = salto;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
    public boolean update(Cactus cac){
        if(salto){
            y+=velY;
            if(y <= TOPE)
                velY = -velY;
            if(y >= 250){
                velY = -velY;
                setSalto(false);
            }
        }
        return this.intersects(cac);
    }
}