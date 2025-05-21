/*
Multiplicación mediante sumas
5*7 5+5+5+5+5+5+5
 */
package Primera;

public class Ejercicio011 {
    public static void main (String arg[]){
        int multiplicador = 5, multiplicando = 7, acum = 0;
        for(int cont = 1;cont <= multiplicando; cont++)
            acum += multiplicador;
        System.out.println("El resultado es: " + acum);
    }
}