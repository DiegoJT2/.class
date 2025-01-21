/*
Acumular los valores de una tabla.
 */
package Primera;

public class Ejercicio029 {
    public static void main (String arg[]){
        int tabla[][]={ {10,20,30,40},
                        {50,60,70,80},
                        {90,100,110,120}};
        int acumFilas[] = {0, 0, 0}, acumColumnas[] = {0, 0, 0, 0};
        for(int i = 0; i < tabla.length; i++)
            for(int j = 0; j < tabla[i].length; j++){
                acumFilas[i]+=tabla[i][j];
                acumColumnas[j]+=tabla[i][j];
            }
        for(int i = 0; i < acumFilas.length; i++)
            System.out.printf("%d  ", acumFilas[i]);
        System.out.println();
        for(int i = 0; i < acumColumnas.length; i++)
            System.out.printf("%d  ", acumColumnas[i]);
        System.out.println();
    }
}