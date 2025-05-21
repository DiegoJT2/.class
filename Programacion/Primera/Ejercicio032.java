/*
Mostrar por pantalla el dia en que se vendieron más entradas y cuántas se vendieron.
Y el día que se vendieron menos entradas y cuántas se vendieron.
 */
package Primera;

public class Ejercicio032 {
    public static void main (String arg[]){
        int salas[][]={ {10, 20, 30, 40, 50, 200, 180},
                        {50, 60, 70, 80, 80, 300, 198},
                        {90, 100, 110, 120, 130, 150, 120}};
        String []días = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int vacum[]={0, 0, 0, 0, 0, 0, 0};
        for(int i=0; i<salas.length; i++)
            for(int j=0; j<salas[i].length; j++)
                vacum[j]+=salas[i][j];
        int posMax=0, posMin=0;
        for(int i=0; i<vacum.length; i++){
            if(vacum[i]>vacum[posMax])
                posMax=i;
            if(vacum[i]<vacum[posMin])
                posMin=i;
        }
        System.out.printf("El mejor día fue el %s con %d espectadores.\n", días[posMax], vacum[posMax]);
        System.out.printf("El peor día fue el %s con %d espectadores.\n", días[posMin], vacum[posMin]);
    }
}