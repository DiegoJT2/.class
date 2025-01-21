/*
Tenemos 2 productos y guardados en la tabla kilos están lo que se ha vendido de cada producto, cada día de la semana.
El vector de precios nos indica cuánto vale el kilo de cada producto.
Implementar un método que modifique la tabla, multiplicando sus elementos por el elemento del vector de precios correspondiente.
 */
package Primera;

public class Ejercicio054 {
    public static void main (String arg[]){
        int kilos[][] = {{5, 6, 9, 23, 7, 14, 0}, {16, 8, 4, 33, 15, 21, 2}};
        int precios[]={6, 7};
        mult(kilos, precios);
        for(int i=0; i<kilos.length; i++){
            for(int j=0; j< kilos[i].length; j++)
                System.out.print(kilos[i][j]+"  ");
            System.out.println();
        }
    }
    public static void mult(int k[][], int p[]){
        for(int i=0; i<k.length; i++)
            for(int j=0; j<k[i].length; j++)
                k[i][j]*=p[i];
    }
}