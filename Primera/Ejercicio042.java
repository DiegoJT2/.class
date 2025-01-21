//Método burbuja.
package Primera;

public class Ejercicio042 {
    public static void main (String arg[]){
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        for(int i = 0; i < vector.length; i++)
            for(int j = vector.length-1; j > i; j--)
                if(vector[j] < vector[j-1]){
                   int inter = vector[j];
                   vector[j] = vector[j-1];
                   vector[j-1] = inter;
                }
        for(int i = 0; i < vector.length; i++)
            System.out.print(vector[i] + "  ");
    }
}