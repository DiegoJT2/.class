package Segunda.Ejercicio10;

import java.awt.Canvas;
import java.awt.Event;
import java.awt.Graphics;

public class MiCanvas extends Canvas{
    DosPuntos actual;
    private int tipo;
    public MiCanvas(int tipo) {
        super();
        this.tipo = tipo;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public void paint(Graphics g){
        if(actual != null)
            actual.dibujar(g);
    }
    public boolean mouseDown(Event ev, int x, int y){
        actual = new DosPuntos(x, y, tipo);
        return true;
    }
    public boolean mouseDrag(Event ev, int x, int y){
        actual.finX=x;
        actual.finY=y;
        repaint();
        return true;
    }
}
