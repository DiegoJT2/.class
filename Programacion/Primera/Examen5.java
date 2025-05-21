/*
Implementar un método recursivo que reciba un número entero y devuelva la suma de sus dígitos.
 */
package Primera;

public class Examen5 {
    public static void main (String arg[]){
        int numero=765;
        System.out.println(suma(numero));
    }
    public static int suma(int num){
        if(num == 0)
            return 0;
        return suma(num/10)+num%10;
    }
}