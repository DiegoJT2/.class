/*
División entera
 */
package Primera;

public class Ejercicio013 {
    public static void main (String arg[]){
        int dividendo = 9, divisor = 2, contador = 0;
        int div = dividendo;
        while(div >= divisor){
            contador++;
            div -= divisor;
        }
        System.out.printf("%d dividido para %d es %d\n", dividendo, divisor, contador);
    }
}
