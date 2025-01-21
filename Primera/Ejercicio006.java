/*
Mostrar en pantalla si un numero termina en 5 o no
 */
package Primera;

public class Ejercicio006 {
    public static void main (String arg[]){
        int x;
        x = 305;
        if((x % 10) == 5)
            System.out.println(x + " termina en 5");
        else
            System.out.println(x + " no termina en 5");
    }
}
