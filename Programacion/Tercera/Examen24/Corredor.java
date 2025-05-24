package Tercera.Examen24;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Corredor extends Rectangle{
    Image[] sprites;
    int frame = 0;
    int direccion = 0; // -1: izquierda, 1: derecha, 0: parado
    boolean muerto=false;
    Image dead;

    public Corredor(Image[] sprites, Image dead) {
        super(130, 420, 40, 60); // posición inicial y tamaño
        this.sprites = sprites;
        this.dead = dead;
    }

    public void mover(int dir){
        if(muerto)return;
        direccion = dir;
        x += dir * 10;
        if (x < 0) x = 0;
        if (x > 560) x = 560; // 600 - ancho corredor
        if (dir != 0) frame = (frame + 1) % sprites.length;
    }
    public void morir(){
        muerto = true;
    }
    public void caer(){
        if (y < 540) // 600 - alto corredor
            y += 5;
    }
    public void paint(Graphics g){
        if(muerto)
            g.drawImage(dead, x, y, width, height, null);
        else
            g.drawImage(sprites[frame], x, y, width, height, null);
    }
}