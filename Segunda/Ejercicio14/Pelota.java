package Segunda.Ejercicio14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Pelota extends Rectangle{
    int velX, velY;

    public Pelota(){
        super(150, 200, 9, 9);
        velX = -3;
        velY = -2;
    }
    public void paint(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, width, height);
    }
    public boolean update(Raqueta raq, ArrayList<Ladrillo> ladrillos){
        x += velX;
        y += velY;
        if(x<=0 || x>=300-height)
            velX = -velX;
        if(y<=0)
            velY = -velY;
        if(y>=300-height)
            return false;
        
        if(intersects(raq))
            velY = -velY;
        
        for(Ladrillo ladrillo : ladrillos)//for(elemento de lista : Lista) otros lenguajes foreach()
            if(this.intersects(ladrillo)){
                ladrillos.remove(ladrillo);
                velY = -velY;
                break;
            }
        return true;
    }
}