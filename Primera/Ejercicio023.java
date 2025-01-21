/*
Ir mostrando el contenido del vector, 
 */
package Primera;

public class Ejercicio023 {
    public static void main (String arg[]){
        int datos[]={10,20,30,40,50};
        for(int j= 0; j<datos.length; j++){
            int guarda = datos[datos.length-1];
            for(int i = datos.length-1; i > 0; i--)
                datos[i] = datos[i-1];
            datos[0] = guarda;
            for(int i = 0; i<datos.length; i++)
                System.out.print(datos[i] + "  ");
            System.out.println();
        }
    }
}