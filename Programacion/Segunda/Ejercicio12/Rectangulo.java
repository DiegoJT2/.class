package Segunda.Ejercicio12;

import com.sun.javafx.font.directwrite.RECT;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo extends RECT{
    public static final int ARRIBA = 0;
    public static final int ABAJO = 1;
    public static final int IZQUIERDA = 2;
    public static final int DERECHA = 3;
    int posX, posY, anchura, altura;
    int posXinicial, posYinicial;
    Color color;
    int direccion;

    public Rectangulo(int altura, int anchura, int posX, int posY, Color color) {
        this.altura = altura;
        this.anchura = anchura;
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        direccion = DERECHA;
        this.posXinicial = posX;
        this.posYinicial = posY;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(posX, posY, altura, anchura);
    }
    public void update(){
        switch(direccion){
                case ARRIBA:
                    posY--;
                    if(posY <= posYinicial)
                        direccion = DERECHA;
                    break;
                case ABAJO:
                    posY++;
                    if(posY >= posYinicial+20)
                        direccion = IZQUIERDA;
                    break;
                case IZQUIERDA:
                    posX--;
                    if(posX <= posXinicial)
                        direccion = ARRIBA;
                    break;
                case DERECHA:
                    posX++;
                    if(posX>=posXinicial+20)
                        direccion = ABAJO;
                    break;
        }
    }
}