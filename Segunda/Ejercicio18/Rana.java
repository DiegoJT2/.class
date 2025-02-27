package Segunda.Ejercicio18;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Rana extends Rectangle{
    public static final int VEL = 3;
    public static final int ARRIBA = 1004;
    public static final int ABAJO = 1005;
    public static final int IZQUIERDA = 1006;
    public static final int DERECHA = 1007;
    public Rana(){
        super(245, 260, 30, 40);
    }
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }
    public void update(int direccion){
        switch(direccion){
            case ARRIBA:
                y-=VEL;
                break;
            case ABAJO:
                y+=VEL;
                break;
            case IZQUIERDA:
                x-=VEL;
                break;
            case DERECHA:
                x+=VEL;
        }
    }
    public void isColision(ArrayList<Coche> coches){
        for(Coche coche : coches)
            if(coche.intersects(this))
                JuegoRana.continua = false;
    }
}