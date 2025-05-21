/*
Tenemos un bombo con 48 bolas tienes que sacarlas de manera aleatoria y guardarlas en una tabla, que luego mostrarás.
 */
package Segunda.Ejercicio04;

public class Ejecutable {
    public static final int numBolas = 48;
    public static final int FILAS = 6;
    public static final int COLUMNAS = 8;
    public static void main (String arg[]){
    Bombo bombo=new Bombo();
    int resultados[][]=new int[FILAS][COLUMNAS];
    for(int i=0; i<resultados.length; i++)
        for(int j=0; j<resultados[i].length; j++)
            resultados[i][j]=bombo.SacarBola();
    for(int i=0; i<resultados.length; i++){
        for(int j=0; j<resultados[i].length; j++)
            System.out.printf(" %d ", resultados[i][j]);
        System.out.println();
        }
    }
}