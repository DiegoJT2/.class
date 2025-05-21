package Tercera.Ejercicio8;

public class MazoSecundario extends Mazo{
    public static final int POSICIONX=110;
    public static final int POSICIONY=20;
    
    public MazoSecundario(){
        super(POSICIONX, POSICIONY, Carta.ANCHURA, Carta.ALTURA);
    }
    public boolean anadir(Carta c){
        cartas.add(c);
        return true;
    }
    public void recolocar(){
        extraer().setPosicion(POSICIONX, POSICIONY);
    }
}