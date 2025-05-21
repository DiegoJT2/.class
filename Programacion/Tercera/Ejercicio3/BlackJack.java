package Tercera.Ejercicio3;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextField;

public class BlackJack extends Applet{
    public static final int NUMCARTAS = 52;
    public static final int CPP = 13;
    Image imagenes[];
    Image imagen;
    Graphics noseve;
    Rectangle tablero[][];
    String palos[] = {"clubs", "diamonds", "hearts", "spades"};
    Baraja baraja;
    Mano jugador;
    Mano crouppier;
    TextField apuesta;
    Button boton1, boton2;
    public void init() {
        imagen = this.createImage(700, 500);
        noseve = imagen.getGraphics();
        imagenes = new Image[NUMCARTAS];
        for(int i = 0; i<NUMCARTAS; i++)
            imagenes[i] = getImage(getCodeBase(), "Tercera/Ejercicio3/Cartas/"+((i%CPP)+1)+ "_of_" + palos[i/CPP] +".png");
        baraja = new Baraja(imagenes);
        jugador = new Mano(300);
        crouppier = new Mano(20);
        configPaneles();
        this.setSize(700, 500);
    }

    private void configPaneles() {
        this.setLayout(new BorderLayout());
        Panel primerPanel = new Panel();
        Label etiqueta = new Label("Introduce tu apuesta : ", Label.RIGHT);
        apuesta = new TextField("", 10);
        primerPanel.add(etiqueta);
        primerPanel.add(apuesta);
        this.add("North", primerPanel);
        
        Panel segundoPanel = new Panel();
        boton1 = new Button("Carta!");
        boton2 = new Button("Me planto!");
        segundoPanel.add(boton1);
        segundoPanel.add(boton2);
        segundoPanel.setBackground(Color.black);
        this.add("South", segundoPanel);
    }

    public void update(Graphics g) {
        paint(g);
    }
    
    public void paint(Graphics g) {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 700, 500);
        jugador.paint(noseve, this);
        crouppier.paint(noseve, this);
        g.drawImage(imagen, 0, 0, this);
    }
    public boolean action(Event ev, Object obj){
        if(ev.target instanceof TextField){
            apuesta.setEnabled(false);
            crouppier.anadirCarta(baraja.sacarCarta());
            jugador.anadirCarta(baraja.sacarCarta());
            jugador.anadirCarta(baraja.sacarCarta());
        }else if(ev.target instanceof Button)
                if(ev.arg.equals("Carta!")){//if(boton1.isFocusOwner())
                    jugador.anadirCarta(baraja.sacarCarta());
                    jugador.puntuacion();
                    if(jugador.seHaPasado())
                        juegaElCrouppier();
                }
        repaint();
        return true;
    }
    public void juegaElCrouppier(){
        while(crouppier.menor17())
            crouppier.anadirCarta(baraja.sacarCarta());
    }
}