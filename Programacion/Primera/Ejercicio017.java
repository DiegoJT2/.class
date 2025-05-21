/*
Invertir el contenido de los vectores.
 */
package Primera;

public class Ejercicio017 {
    public static void main (String arg[]){
        int datos[]={10,20,30,40,50}, aux;
        for(int i=0; i < (datos.length/2); i++){
            aux = datos[i];
            datos[i] = datos[datos.length-i-1];
            datos[datos.length -i -1]=aux;
        }
        for(int i = 0; i <datos.length; i++)
            System.out.println(datos[i]);
    }
}