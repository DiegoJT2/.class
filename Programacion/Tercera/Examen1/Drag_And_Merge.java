package Tercera.Examen1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Drag_And_Merge extends Applet implements Runnable{
    public static final int FILAS = 6;
    public static final int COLUMNAS = 7;
    public static final int TIEMPO = 25;
    public static final int FILAS_INICIAR = 3;
    public static final int NUM_MAX = 10;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Pieza[][] grid = new Pieza[FILAS][COLUMNAS];
    Piezas piezas;
    Pieza activa = null;
    int offsetX, offsetY;
    int origCol, origFil;
    int contador = 0;
    int maxNumero = 4;

    public void init(){
        imagen = createImage(700, 600);
        noseve = imagen.getGraphics();
        piezas = new Piezas(FILAS_INICIAR);
        for (int i =FILAS_INICIAR; i < FILAS; i++){
            for (int j = 0; j < COLUMNAS; j++){
                int num = (int)(Math.random() * 4) + 1;
                grid[i][j] = new Pieza(j, i, num);
            }
        }
        setSize(700, 600);
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    public void update(Graphics g){
        paint(g);
    }
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 700, 600);
        for(int i = 0; i < FILAS; i++)
            for(int j = 0; j < COLUMNAS; j++){
                int x = j * Pieza.TAM + 20;
                int y = i * Pieza.TAM + 90;
                noseve.setColor(Color.WHITE);
                noseve.drawRect(x, y, Pieza.TAM, Pieza.TAM);
                if(grid[i][j] != null && grid[i][j] != activa)
                    grid[i][j].paint(noseve);
            }
        if(activa != null)
            activa.paint(noseve);
        g.drawImage(imagen, 0, 0, this);
    }
    public boolean mouseDown(Event e, int x, int y){
        for(int i = 0; i < FILAS; i++) {
            for(int j = 0; j < COLUMNAS; j++) {
                Pieza p = grid[i][j];
                if(p != null && p.contains(x, y)){
                    activa = p;
                    offsetX = x - p.x;
                    offsetY = y - p.y;
                    origCol = p.columna;
                    origFil = p.fila;
                    grid[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean mouseDrag(Event e, int x, int y){
        if(activa!=null){
            activa.setPosicion(x-(Pieza.TAM/2), y-(Pieza.TAM/2));
            return true;
        }
        return false;
    }
    public boolean mouseUp(Event e, int x, int y){
        if(activa != null){
            int col = (x - 20) / Pieza.TAM;
            int fil = (y - 90) / Pieza.TAM;
            boolean puedeSoltar = false;
            if(col >= 0 && col < COLUMNAS && fil >= 0 && fil < FILAS){
                if(fil == FILAS - 1 || grid[fil + 1][col] != null){
                    if(grid[fil][col] == null){
                        puedeSoltar = true;
                    }else if(grid[fil][col].getNumero() == activa.getNumero()){
                        int nuevoNum = grid[fil][col].getNumero() + 1;
                        grid[fil][col].setNumero(nuevoNum);
                        grid[fil][col].colorUpdate();
                        activa = null;
                        piezas.recolocar(grid);
                        repaint();
                        return true;
                    }
                }
            }
            if(puedeSoltar){
                activa.setGridPos(col, fil);
                grid[fil][col] = activa;
            }else{
                activa.setGridPos(origCol, origFil);
                grid[origFil][origCol] = activa;
            }
            activa = null;
            piezas.recolocar(grid);
        }
        return true;
    }
    @Override
    public void run(){
        do{
            contador += TIEMPO;
            if (contador >= 10000){
                piezas.subirFila(grid);
                piezas.cargarFila(grid, maxNumero);
                contador = 0;
            }
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){}
        }while(true);
    }
}