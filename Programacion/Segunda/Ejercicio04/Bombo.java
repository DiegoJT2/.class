
package Segunda.Ejercicio04;

import java.util.Random;

public class Bombo {
    int bolas[];
    Random aleatorio;
    int numBolas = Ejecutable.numBolas;

    public Bombo() {
        bolas=new int [numBolas];
        for(int i=0; i<numBolas; i++)
            bolas[i]=i+1;
        aleatorio=new Random();
    }
    public int SacarBola(){
        int numAleatorio=aleatorio.nextInt(numBolas);
        int bola = bolas[numAleatorio];
        bolas[numAleatorio]=bolas[numBolas-1];
        numBolas--;
        return bola;
    }
}