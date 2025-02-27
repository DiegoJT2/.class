package Segunda.Ejercicio10;

import java.awt.Canvas;
import java.awt.Event;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class MiCanvas extends Canvas{
    private List<DosPuntos> lista;
    DosPuntos actual;
    private int tipo;
    public MiCanvas(int tipo) {
        super();
        this.tipo = tipo;
        lista = new ArrayList<DosPuntos>();
    }
    public List<DosPuntos> getLista() {
        return lista;
    }
    public void setLista(List<DosPuntos> lista) {
        this.lista = lista;
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
        for(int i=0; i<lista.size(); i++)
            lista.get(i).dibujar(g);
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
    }public boolean mouseUp(Event ev, int x, int y){
        lista.add(actual);
        return true;
    }
}