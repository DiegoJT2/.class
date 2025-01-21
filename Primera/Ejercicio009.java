/*
Mostrar por pantalla la tabla de multiplicar de un número.
 */
package Primera;

public class Ejercicio009 {
    public static void main (String arg[]){
        int x = 5;
        for(int cont = 0; cont <= 10; cont++)
            System.out.println(x + " * " + cont + " = " + (x * cont));
    }
}