/*
Implementar un método que devuelva un vector en el que se hayan acumulado kilos de cada producto.
Desde el programa principal mostrad de cada producto, su nombre y el número de kilos que se han vendido.
 */
package Primera;

public class Ejercicio056 {
    public static void main (String arg[]){
        int kilos[][] = {{5, 6, 9, 23, 7, 14, 0}, {16, 8, 4, 33, 15, 21, 2}};
        String productos[]={"Peras", "Manzanas"};
        int acumkil[]=suma(kilos);
        for(int i=0; i<acumkil.length; i++){
           System.out.printf("De %s se han vendigo %d Kg.\n", productos[i], acumkil[i]);
        }
    }
    public static int[] suma(int k[][]){
        int acum[]=new int[2];
        for(int i=0; i<k.length; i++)
            for(int j=0; j<k[i].length; j++)
                acum[i]+=k[i][j];
        return acum;
    }
}