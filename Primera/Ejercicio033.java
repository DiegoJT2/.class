/*
Mostrar por pantalla la película más taquillera y el número de entradas que ha vendido.
Mostrar por pantalla la èlícula menos taquillera y el número de entradas que ha vendido.
 */
package Primera;

public class Ejercicio033 {
    public static void main (String arg[]){
        int salas[][]={ {10, 20, 30, 40, 50, 200, 180},
                        {50, 60, 70, 80, 80, 300, 198},
                        {90, 100, 110, 120, 130, 150, 120},
                        {9, 199, 150, 180, 13, 100, 190}};
        String peliculas[]={"Joker", "Soy Neveka", "Buffalo kids", "Los destellos"};
        int vacum[]={0,0,0,0};
        for(int i = 0; i<salas.length; i++)
            for(int j=0; j < salas[i].length; j++)
                vacum[i]+=salas[i][j];
        int posMax=0,posMin=0;
        for(int i=0; i<vacum.length;i++){
            if(vacum[i]<vacum[posMax])
                posMax=i;
            if(vacum[i]>vacum[posMin])
                posMin=i;
        }
        System.out.printf("La película más taquillera fue %s con %d entradas.\n", peliculas[posMax], vacum[posMax]);
        System.out.printf("La película menos taquillera fue %s con %d entradas.\n", peliculas[posMin], vacum[posMin]);
    }
}