package Tercera.Ejercicio4;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;

public class Tablero extends Applet{
    public static final int TAM = 5;
    Image imagenes[][];
    Image imagen;
    Graphics noseve;
    Lugar lugares[][];
    Point blanco;
    AudioClip error, acierto, exito;
    Button remover;
    Panel panel;
    
    public void init() {
        imagen = this.createImage(400, 500);
        noseve = imagen.getGraphics();
        error = getAudioClip(getCodeBase(), "Tercera/Ejercicio4/Sonidos/error.wav");
        acierto = getAudioClip(getCodeBase(), "Tercera/Ejercicio4/Sonidos/correct.wav");
        exito = getAudioClip(getCodeBase(), "Tercera/Ejercicio4/Sonidos/exito.wav");
        imagenes = new Image[TAM][TAM];
        for(int i = 0; i<TAM; i++)
            for(int j = 0; j < TAM; j++)
                imagenes[i][j] = getImage(getCodeBase(), "Tercera/Ejercicio4/Botones/"+((i*TAM)+j+1)+".gif");
        lugares = new Lugar[TAM][TAM];
        for(int i=0; i<TAM; i++)
            for(int j=0; j<TAM; j++)
                lugares[i][j] = new Lugar(imagenes[i][j], (i*TAM)+j);
        
        blanco = new Point(TAM-1, TAM-1);
        remover = new Button("Remover");
        panel = new Panel();
        panel.add(remover);
        this.add("South",panel);
        this.setSize(400, 500);
    }

    public void update(Graphics g) {
        paint(g);
    }
    
    public void paint(Graphics g) {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 400, 500);
        for(int i=0; i<TAM; i++)
            for(int j=0; j<TAM; j++)
                lugares[i][j].paint(noseve, this, j, i);
        
        
        g.drawImage(imagen, 0, 0, this);
    }
    public boolean mover(Point click){
        Point desplazamiento, hasta;
        desplazamiento = new Point(delta(click.x, blanco.x), delta(click.y, blanco.y));
        if(desplazamiento.x == 0 && desplazamiento.y == 0)
            return false;
        if(desplazamiento.x!=0&&desplazamiento.y!=0)
            return false;
        hasta = new Point(click.x+desplazamiento.x, click.y+desplazamiento.y);
        if(!(hasta.x==blanco.x && hasta.y==blanco.y))
            mover(hasta);
        lugares[blanco.x][blanco.y].setImagen(lugares[click.x][click.y].getImagen());
        lugares[blanco.x][blanco.y].valor = lugares[click.x][click.y].valor;
        lugares[click.x][click.y].setImagen(null);
        lugares[click.x][click.y].valor = 24;
        blanco = click;
        return true;
    }
    public int delta(int a, int b){
        if(a==b)return 0;
        else return ((b-a)/Math.abs(b-a));
    }
    public boolean mouseDown(Event ev, int x, int y){
        Point click;
        click = new Point(y/Lugar.DIM, x/Lugar.DIM);
        if(mover(click))
            acierto.play();
        else
            error.play();
        repaint();
        return true;
    }
    public boolean action(Event ev, Object obj){
        if(ev.target == remover){
            int x = (int) (Math.random() * TAM);
            int y = (int) (Math.random() * TAM);
            mover(new Point(x, y));
        }
        repaint();
        return true;
    }
}