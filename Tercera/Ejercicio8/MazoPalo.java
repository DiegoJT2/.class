package Tercera.Ejercicio8;

public class MazoPalo extends Mazo{
    public static final int POSICIONY = 20;
    int palo;
    public MazoPalo(int posX){
        super(posX, POSICIONY, Carta.ANCHURA, Carta.ALTURA);
    }
    public boolean anadir(Carta carta){
        if(cartas.isEmpty()&&carta.getValor()==1){
            cartas.add(carta);
            palo=carta.getPalo();
            recolocar();
            return true;
        }else{
            if(palo==carta.getPalo()&&carta.getValor()-1==extraer().getValor()){
                cartas.add(carta);
                recolocar();
                return true;
            }
        }
        return false;
    }
    public void recolocar(){
        extraer().setPosicion(x, POSICIONY);
    }
}