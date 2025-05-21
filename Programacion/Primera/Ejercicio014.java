/*
a)Declaración y manipulación de vectores
b) modificar el contenido de cada elemento del vector multiplicandolo por 2 y mostrar como queda el vector.
 */
package Primera;

public class Ejercicio014 {
    public static void main (String arg[]){
        int datos[] = {17, 33, 4, 95, 170};
        for(int i=0; i<datos.length; i++)
        System.out.printf("datos[%d] = %d\n", i, datos[i]);
        
        System.out.println();
        for(int i=0; i<datos.length; i++){
            datos[i] *= 2;
            System.out.printf("datos[%d] = %d\n", i, datos[i]);
        }
    }
}