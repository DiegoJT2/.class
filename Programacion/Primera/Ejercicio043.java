
//Método de ordenación de un vector por selección directa.

package Primera;

public class Ejercicio043 {
    public static void main (String arg[]){
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        for(int i=0; i<vector.length-1; i++){
            int posMin=i;
            for(int j=i+1; j < vector.length; j++)
                if(vector[j]>vector[posMin])
                    posMin=j;
            int inter=vector[posMin];
            vector[posMin]=vector[i];
            vector[i]=inter;
            }
        for(int i=0; i<vector.length; i++)
            System.out.println(vector[i]);
    }
}