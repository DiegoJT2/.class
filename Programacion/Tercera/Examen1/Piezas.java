package Tercera.Examen1;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

public class Piezas{
    ArrayList<Pieza> piezas;
    private int valorI=4;
    
    public Piezas(int num){
        piezas=new ArrayList<>();
        Collections.shuffle(piezas);
    }
    public void paint(Graphics g){
        for(Pieza pieza:piezas)
            pieza.paint(g);
    }
    public void cargarFila(Pieza[][] grid, int maxNumero){
        for(int j = 0; j < Drag_And_Merge.COLUMNAS; j++){
            int num = (int)(Math.random() * maxNumero) + 1;
            grid[Drag_And_Merge.FILAS - 1][j] = new Pieza(j, Drag_And_Merge.FILAS - 1, num);
        }
    }
    public void subirFila(Pieza[][] grid){
        for(int i = 0; i < Drag_And_Merge.FILAS - 1; i++)
            for(int j = 0; j < Drag_And_Merge.COLUMNAS; j++)
                grid[i][j] = grid[i + 1][j];
        for(int j = 0; j < Drag_And_Merge.COLUMNAS; j++)
            grid[Drag_And_Merge.FILAS - 1][j] = null;
    }
    public void recolocar(Pieza[][] grid){
        for(int i = 0; i < Drag_And_Merge.FILAS; i++)
            for(int j = 0; j < Drag_And_Merge.COLUMNAS; j++)
                if(grid[i][j] != null)
                    grid[i][j].setGridPos(j, i);
    }
    public Pieza extraer(){
        return piezas.get(piezas.size()-1);
    }
    public int getValorI() {
        return valorI;
    }
    public void setValorI(int valorI) {
        this.valorI = valorI;
    }
}