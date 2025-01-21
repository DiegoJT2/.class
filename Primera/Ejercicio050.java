/*
Ordenar todos los vectores de la tabla.
 */
package Primera;

public class Ejercicio050 {
    public static void main (String arg[]){
        int salarios[][] = { {700, 900, 1300, 800, 790, 850}, { 1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1200, 1170, 1000, 1000}, {1500, 1950, 1880, 1978, 2200, 2100} };
        for(int i = 0; i < salarios.length; i++)
            ordenar(salarios[i]);
        
        for(int i = 0; i < salarios.length; i++){
            for(int j = 0; j < salarios[i].length; j++)
                System.out.print(salarios[i][j] + "  ");
            System.out.println();
        }
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
