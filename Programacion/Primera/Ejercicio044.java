/*
Ordenar con while
 */
package Primera;

public class Ejercicio044 {
    public static void main (String arg[]){
        int vector[] = {25, 2, 73, 81, 16, 4, 33}, inter;
        for(int i=1; i<vector.length; i++){
            int j=i;
            while((j>0) && (vector[j]<vector[j-1])){
                inter=vector[j];
                vector[j]=vector[j-1];
                vector[j-1]=inter;
                j--;
            }
        }
        for(int i=0; i<vector.length; i++)
            System.out.println(vector[i]);
    }
}