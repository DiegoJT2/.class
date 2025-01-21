/*
Desplazar todos los elementos de un vector 1 posición hacia la izquierda. El 1º que pasara al final del vector.
 */
package Primera;

public class Ejercicio020 {
    public static void main (String arg[]){
        int datos[]={10,20,30,40,50}, guarda=datos[0];
        for(int i = 1; i < datos.length; i++)
            datos[i-1]=datos[i];
        datos[datos.length-1] = guarda;
        for(int i = 0; i < datos.length; i++)
            System.out.println(datos[i]);
    }
}