/*

 */
package Primera;

public class Ejercicio097 {
    public static void main (String arg[]){
        String partido[]={"PP", "PSOE", "VOX", "CHA", "EXISTE"};
        final int ESCANOS=7;//final sirve para declarar un valor constante es decir no se puede modificar, el nombre de las constantes se ponen siempre en mayusculas
        int votos[]={232712, 193170, 73677, 33454, 32717};
        int divisor[]={1, 1, 1, 1, 1};
        int PosMax;
        for(int i=0; i<ESCANOS; i++){
            PosMax=0;
            for(int j=0; j<votos.length-1; j++)
                if(votos[PosMax]/divisor[PosMax]<votos[j]/divisor[j])
                    PosMax=j;
            divisor[PosMax]++;
        }
        for(int i=0; i<votos.length; i++)
            System.out.printf("El %s ha obtenido %d escaños\n", partido[i], divisor[i]-1);
    }
}