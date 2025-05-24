package Tercera.Mezcla12;

import java.applet.Applet;
import java.awt.*;
import java.util.*;

public class SimulacionTrafico extends Applet implements Runnable {
    private final Semaforo semaforoH = new Semaforo(true);
    private final Semaforo semaforoV = new Semaforo(false);
    private final ArrayList<Coche> cochesH = new ArrayList<>();
    private final ArrayList<Coche> cochesV = new ArrayList<>();
    Image imagen;
    Graphics noseve;
    private Thread animacion;

    public void init() {
        imagen = this.createImage(400, 400);
        noseve = imagen.getGraphics();
        cochesH.add(new Coche(0, 180, true));
        cochesV.add(new Coche(180, 0, false));
        animacion = new Thread(this);
        animacion.start();
        this.setSize(400, 400);
    }
    public void update(Graphics g) {
        paint(g);
    }

    public void run() {
        while(true) {
            semaforoH.update();
            semaforoV.update();
            for (Coche c : cochesH) c.mover(semaforoH);
            for (Coche c : cochesV) c.mover(semaforoV);
            repaint();
            try { Thread.sleep(30); } catch (InterruptedException e) {}
        }
    }

    public void paint(Graphics g) {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 400, 400);
        // Dibujar calles
        noseve.setColor(Color.gray);
        noseve.fillRect(0, 170, 400, 60);
        noseve.fillRect(170, 0, 60, 400);
        // Dibujar semáforos
        semaforoH.paint(noseve, 230, 160);
        semaforoV.paint(noseve, 160, 230);
        // Dibujar coches
        for(Coche c : cochesH) c.paint(noseve);
        for(Coche c : cochesV) c.paint(noseve);
        g.drawImage(imagen, 0, 0, this);
    }
    public boolean mouseDown(Event e, int x, int y){
        if (x < 200) cochesH.add(new Coche(0, 180, true));
        else cochesV.add(new Coche(180, 0, false));
        return true;
    }
}