package Segunda.Ejercicio05;

import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

public class OvalApp extends Frame{
    Ovalo ovalo;
    public static void main (String arg[]){
        OvalApp app = new OvalApp();
    }

    public OvalApp() {
        super("Dibujando óvalos");
        
        ovalo = new Ovalo();
        
        Button boton1 = new Button("Siguiente");
        Button boton2 = new Button("Salir");
        Panel panel = new Panel();
        
        panel.add(boton1);
        panel.add(boton2);
        this.add("South", panel);
        
        this.pack();
        this.resize(300, 300);
        this.show();
    }
    public void paint(Graphics g){
        ovalo.dibujar(g);
    }
    public boolean handleEvent(Event ev){
        if(ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }else if(ev.id == Event.ACTION_EVENT)
            if(ev.target instanceof Button)
                if(ev.arg.equals("Salir")){
                    System.exit(0);
                    return true;
                }else if(ev.arg.equals("Siguiente")){
                    ovalo.inicializar();
                    repaint();
                    return true;
                }
        return false;
    }
}