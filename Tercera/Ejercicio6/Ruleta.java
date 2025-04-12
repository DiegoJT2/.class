package Tercera.Ejercicio6;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.util.ArrayList;

public class Ruleta extends Applet{
    public static final int FILAS = 12;
    public static final int COLUMNAS = 3;
    public static final int NUMJUGADAS = 10;
    Image imagen;
    Graphics noseve;
    Casilla casillas[][];
    public int rojos[]={1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    ArrayList<Ficha> fichas[];
    Ficha activa;
    Image imagenes[];
    int valores[]={1,5,10,25,50,100,500,1000,5000,10000};
    Button boton;
    int numeroSuerte;
    int jugadas[];
    java.util.ArrayList<Integer> lRojos;
    int dinero=1000000;
    int dineroApostado;
    int dineroGanado;
    
    public void init() {
        imagen = this.createImage(700, 800);
        noseve = imagen.getGraphics();
        casillas = new Casilla[FILAS][COLUMNAS];
        
        setup();
        
        lRojos = new java.util.ArrayList<Integer>();
        for(int i=0; i<rojos.length; i++)
            lRojos.add(new Integer(rojos[i]));
        
        for(int i=0; i<FILAS; i++)
            for(int j=0; j<COLUMNAS; j++)
                if(lRojos.contains(new Integer((i*COLUMNAS)+j+1)))
                    casillas[i][j]=new Casilla((j*Casilla.DIM)+30, (i*Casilla.DIM)+50, (i*COLUMNAS)+j+1, Color.red);
                else
                    casillas[i][j]=new Casilla((j*Casilla.DIM)+30, (i*Casilla.DIM)+50, (i*COLUMNAS)+j+1, Color.black);
        imagenes=new Image[NUMJUGADAS];
        fichas=new ArrayList[NUMJUGADAS];
        for(int i=0; i<NUMJUGADAS; i++){
            imagenes[i] = getImage(getCodeBase(), "Tercera/Ejercicio6/Fichas/ficha"+(i+1)+".png");
            fichas[i]=new ArrayList<Ficha>();
            fichas[i].add(new Ficha(525, 50+(i*Ficha.DIM), valores[i], imagenes[i]));
        }
        jugadas=new int[NUMJUGADAS];
            
        this.setSize(700, 800);
    }

    private void setup(){
        Panel panel = new Panel();
        boton = new Button("Jugar");
        panel.add(boton);
        this.setLayout(new BorderLayout());
        this.add("North", panel);
    }

    public void update(Graphics g) {
        paint(g);
    }
    
    public void paint(Graphics g) {
        noseve.setColor(Color.GREEN);
        noseve.fillRect(0, 0, 700, 800);
        
        mostrarCasillas();
        
        mostrarFichas();
        
        mostrarJugadas();
        
        noseve.drawString("En esta jugada estás apostando : "+dineroApostado, 270, 600);
        noseve.drawString("En esta jugada has ganado : "+dineroGanado, 270, 650);
        
        noseve.setColor(Color.BLACK);
        noseve.drawString("Dinero = "+dinero, 270, 700);
        
        g.drawImage(imagen, 0, 0, this);
    }

    private void mostrarCasillas() {
        for(int i=0; i<FILAS; i++)
            for(int j=0; j<COLUMNAS; j++)
                casillas[i][j].paint(noseve);
    }

    private void mostrarFichas() {
        for(int i=0; i<NUMJUGADAS; i++)
            for(Ficha ficha:fichas[i])
                ficha.paint(noseve, this);
    }

    private void mostrarJugadas() {
        Color color=Color.BLACK;
        noseve.setColor(Color.BLUE);
        noseve.drawString(""+numeroSuerte, 400, 80);
        for(int i=0; i<NUMJUGADAS; i++){
            color=(lRojos.contains(new Integer(jugadas[i])))?Color.RED:Color.BLACK;
            noseve.setColor(color);
            noseve.drawString(""+jugadas[i], 600, (30*i)+80);
        }
        if(color == Color.RED)
            noseve.drawString("ROJO", 400, 120);
        else
            noseve.drawString("NEGRO", 400, 120);
        if(numeroSuerte % 2 == 0)
            noseve.drawString("PAR", 400, 150);
        else
            noseve.drawString("IMPAR", 400, 150);
        if(numeroSuerte <= 18)
            noseve.drawString("FALTA", 400, 190);
        else
            noseve.drawString("PASA", 400, 190);
    }
    public boolean mouseDown(Event ev, int x, int y){
        for(int i=0; i<NUMJUGADAS; i++)
            for(Ficha ficha:fichas[i])
                if(ficha.contains(x,y)){
                    activa=ficha;
                    fichas[i].add(new Ficha(525, 50+(i*Ficha.DIM), valores[i], imagenes[i]));
                    break;
                }
        return true;
    }
    public boolean mouseDrag(Event ev, int x, int y){
        if(activa!=null)
            activa.update(x, y);
        repaint();
        return true;
    }
    public boolean mouseUp(Event ev, int x, int y){
        if(activa!=null){
            activa.cargarApostados(casillas);
            dineroApostado=0;
            for(int i=0; i<NUMJUGADAS; i++)
                for(Ficha ficha:fichas[i])
                    if(!ficha.getNumerosApostados().isEmpty())
                        dineroApostado += ficha.getPrecio();
            activa=null;
            repaint();
        }
        return true;
    }
    public boolean action(Event ev, Object obj){
        if(ev.target instanceof Button){
            numeroSuerte = (int)(Math.random()*37);
            for(int i=0; i<NUMJUGADAS-1; i++)
                jugadas[i]=jugadas[i+1];
            jugadas[NUMJUGADAS-1]=numeroSuerte;
            
            dineroGanado=0;
            for(int i=0; i<NUMJUGADAS; i++)
                for(Ficha ficha:fichas[i])
                    if(ficha.getNumerosApostados().contains(numeroSuerte))
                        dineroGanado+=(ficha.getPrecio()*36) / ficha.getNumerosApostados().size();
            dinero+=(dineroGanado-dineroApostado);
            repaint();
        }
        return false;
    }
}