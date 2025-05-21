package Segunda.Ejercicio10;

import java.awt.Graphics;

public class DosPuntos {
    public static final int LINEA = 0;
    public static final int OVALO = 1;
    public static final int RECTANGULO = 2;
    int inicioX, inicioY, finX, finY;
    int tipo;
    public DosPuntos(int inicioX, int inicioY, int finX, int finY, int tipo){
        this.inicioX = inicioX;
        this.inicioY = inicioY;
        this.finX = finX;
        this.finY = finY;
        this.tipo = tipo;
    }

    public DosPuntos(int inicioX, int inicioY, int tipo){
        this(inicioX, inicioY, inicioX, inicioY, tipo);
    }
    public DosPuntos(){
        this(0, 0, LINEA);
    }
    public void dibujar(Graphics g){
        int anchura, altura;
        anchura=Math.abs(finX-inicioX);
        altura=Math.abs(finX-inicioX);
        switch(tipo){
            case LINEA:
                g.drawLine(inicioX, inicioY, finX, finY);
            break;
            case OVALO:
                g.drawOval(inicioX, inicioY, anchura, altura);
            break;
            case RECTANGULO:
                g.drawRect(inicioX, inicioY, anchura, altura);
            break;
        }
    }
}