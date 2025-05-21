package Tercera.Ejercicio5;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class BuscaMinas extends Applet{
    public static final int DIM = 10;
    Image imagen;
    Graphics noseve;
    Image mina;
    Image reverso;
    Casilla casillas[][];
    
    public void init() {
        imagen = this.createImage(400, 500);
        noseve = imagen.getGraphics();
        
        mina = getImage(getCodeBase(), "Tercera/Ejercicio5/Imagenes/mina.png");
        reverso = getImage(getCodeBase(), "Tercera/Ejercicio5/Imagenes/casilla.png");//carga la imagen
        casillas=new Casilla[DIM][DIM];
        for(int i=0; i<DIM; i++)
            for(int j=0; j<DIM; j++)
                casillas[i][j] = new Casilla(100+(j*Casilla.TAM),100+(i*Casilla.TAM),reverso);
        int aleatorios[]=obtenerAleatorio();
        for(int aleatorio:aleatorios)
            casillas[aleatorio/DIM][aleatorio%DIM].setMina(mina);//mete una mina aleatoria
        cercania();
        this.setSize(400, 500);
    }

    private void cercania() {
        for(int fila=0; fila<DIM; fila++)
            for(int columna=0; columna<DIM; columna++){
                int inicioX=(fila==0)?0:fila-1;
                int finX=(fila==DIM-1)?DIM-1:fila+1;
                int inicioY=(columna==0)?0:columna-1;
                int finY=(columna == DIM-1)?DIM-1:columna+1;
                int contador=0;
                for(int i=inicioX; i<=finX; i++)
                    for(int j=inicioY; j<=finY; j++)
                        if(casillas[i][j].getMina()!=null)
                            contador++;
                casillas[fila][columna].setAlrededor(contador);
            }
    }

    private int[] obtenerAleatorio() {
        int resultados[] = new int[DIM];
        int vector[] = new int[DIM*DIM];
        for(int i=0; i<(DIM*DIM); i++)
            vector[i] = i;
        for(int i=0; i<DIM; i++){
            int aleatorio = (int)(Math.random()*((DIM*DIM)-i));
            resultados[i]=vector[aleatorio];
            vector[aleatorio]=vector[(DIM*DIM)-i-1];
        }
        return resultados;
    }

    public void update(Graphics g) {
        paint(g);
    }
    
    public void paint(Graphics g) {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 400, 500);
        for(int i=0; i<DIM; i++)
            for(int j=0; j<DIM; j++)
                casillas[i][j].paint(noseve, this);
        
        g.drawImage(imagen, 0, 0, this);
    }
    public boolean mouseDown(Event ev, int x, int y){
        for(int i=0; i<DIM; i++)
            for(int j=0; j<DIM; j++)
                if(casillas[i][j].contains(x, y)){
                    casillas[i][j].setTapa(false);
                }
        repaint();
        return true;
    }
}