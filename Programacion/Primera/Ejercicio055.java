/*
Lo mismo que el anterior, pero el resultado de las multiplicaciones se guarda en una nueva tabla .
 */
package Primera;

public class Ejercicio055 {
    public static void main (String arg[]){
        int kilos[][] = {{5, 6, 9, 23, 7, 14, 0}, {16, 8, 4, 33, 15, 21, 2}};
        int precios[]={6, 7};
        int ventas[][]=mult(kilos, precios);
        for(int i=0; i<ventas.length; i++){
            for(int j=0; j< ventas[i].length; j++)
                System.out.print(ventas[i][j]+"  ");
            System.out.println();
        }
        int €[][]=new int[2][7];
        mult(kilos,precios,€);
        for(int i=0; i<€.length; i++){
            for(int j=0; j< €[i].length; j++)
                System.out.print(€[i][j]+"  ");
            System.out.println();
        }
    }
    public static int[][] mult(int k[][], int p[]){
        int €[][]=new int [2][7];
        for(int i=0; i<k.length; i++)
            for(int j=0; j<k[i].length; j++)
                €[i][j]=k[i][j]*p[i];
        return €;
    }
    public static void mult(int k[][], int p[], int €[][]){
        for(int i=0; i<k.length; i++)
            for(int j=0; j<k[i].length; j++)
                €[i][j]=k[i][j]*p[i];
    }
}