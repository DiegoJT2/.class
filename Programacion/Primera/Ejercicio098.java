/*
Un número es primo si solamente es divisible por sí mismo o por el 1. Realizar una función que reciba un entero positivo y devuelva si es primo o no
 */
package Primera;

public class Ejercicio098 {
    public static void main (String arg[]){
        int numero=4;
        if(primo(numero))
            System.out.println("Es primo");
        else
            System.out.println("No es primo");
    }
    public static boolean primo(int n){
        for(int i=n-1; i>1; i--)
            if(n%i==0)
                return true;
        return true;
    }
}