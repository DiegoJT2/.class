/*
Implementar una función que modifique todos los elementos de la tabla al multiplicarlos por el multiplicador.
 */
package Primera;

public class Ejercicio053 {
    public static void main (String arg[]){
        int tabla[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int multiplicador=4;
            mult(tabla,multiplicador);
        for(int i=0; i<tabla.length; i++){
            for(int j=0; j< tabla[i].length; j++)
                System.out.print(tabla[i][j]+"  ");
            System.out.println();
        }
    }
    public static void mult(int v[][], int m){
        for(int i=0; i<v.length; i++)
            for(int j=0; j<v[i].length; j++)
                v[i][j]*=m;
    }
}