/*
Método de ordenación.
 */
package Primera;

public class Ejercicio049 {
    public static void main (String arg[]){
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        ordenar(vector);
        
        for(int i = 0; i < vector.length; i++)
            System.out.print(vector[i] + "  ");
    }
    public static void ordenar(int v[]){
        //ordenación por método burbuja.
        for(int i = 0; i < v.length; i++)
            for(int j = v.length-1; j > i; j--)
                if(v[j] < v[j-1]){
                   int inter = v[j];
                   v[j] = v[j-1];
                   v[j-1] = inter;
                }
    }
}