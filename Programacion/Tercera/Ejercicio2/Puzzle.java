package Tercera.Ejercicio2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Puzzle extends Applet{
    public static final int PIEZAS = 25;
    public static final int FILAS = 5;
    Image imagenes[];
    Image imagen;
    Graphics noseve;
    Pieza piezas[];
    Pieza pieza;
    Rectangle tablero[][];
    
    public void init() {
        imagen = this.createImage(700, 500);
        noseve = imagen.getGraphics();
        imagenes = new Image[PIEZAS];
        piezas = new Pieza[PIEZAS];
        for(int i = 0; i<PIEZAS; i++){
            imagenes[i] = getImage(getCodeBase(), "Tercera/Ejercicio2/directorioImagenes/"+(i+1)+".png");
            piezas[i] = new Pieza(imagenes[i], i);
        }
        tablero = new Rectangle[FILAS][FILAS];
        for(int i = 0; i< FILAS; i++)
            for(int j = 0; j< FILAS; j++)
                tablero[i][j] = new Rectangle(j * Pieza.DIMENSION + 20, i * Pieza.DIMENSION + 90, Pieza.DIMENSION, Pieza.DIMENSION);
        this.setSize(700, 500);
    }

    public void update(Graphics g) {
        paint(g);
    }
    
    public void paint(Graphics g) {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 700, 500);
        noseve.setColor(Color.white);
        for(int i = 0; i< FILAS; i++)
            for(int j = 0; j< FILAS; j++)
                noseve.drawRect(tablero[i][j].x, tablero[i][j].y, tablero[i][j].width, tablero[i][j].height);
        for(Pieza pieza:piezas)
            pieza.paint(noseve, this);
        g.drawImage(imagen, 0, 0, this);
    }
    public boolean mouseDown(Event ev, int x, int y){
        for(Pieza pieza:piezas)
            if(pieza.contains(x, y) && !pieza.isColoada())
                this.pieza = pieza;
        return true;
    }
    public boolean mouseDrag(Event ev, int x, int y){
        if(pieza != null){
            pieza.Mover(x, y);
            repaint();
        }
        return true;
    }
    public boolean mouseUp(Event ev, int x, int y){
        if(pieza != null)
            for(int i = 0; i< FILAS; i++){
                for(int j = 0; j< FILAS; j++)
                    if(tablero[i][j].intersects(pieza))
                        if(pieza.posicion == (i*FILAS) + j){
                            pieza.setColoada(true);
                            pieza.ajustar(tablero[i][j].x, tablero[i][j].y);
                            repaint();
                        }
            }
        pieza = null;
        return true;
    }
}