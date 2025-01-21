/*
Implementar un método al que se le pase una matriz de 3*3 de enteros y devuelva otra matriz de 3*3 con los valores de la matriz original rotados 90º.
Tal y como veis en el ejemplo. El contenido de la matriz rotada debe mostrarse por pantalla.
 */
package Primera;

public class Examen3 {
    public static void main (String arg[]){
        int original[][]={{1,2,3},{4,5,6},{7,8,9}};
        int rotada[][]=rotacion(original);
        for(int i=0; i<original.length; i++){
            for(int j=0; j<original[i].length; j++)
                System.out.print(rotada[i][j]+"  ");
        System.out.println();
        }
    }
        public static int[][] rotacion(int[][] original){
            int[][] rotada = new int[original.length][original.length];
            for(int i=0; i<original.length; i++)
                for(int j=0; j<original[i].length; j++)
                    rotada[j][original.length-1-i]=original[i][j];
        return rotada;
    }
}