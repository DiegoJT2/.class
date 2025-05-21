/*
Convertir un numero a binario
 */
package Primera;

public class Ejercicio096 {
    public static void main (String arg[]){
        int decimal = 29;
        binario(decimal);
    }
    public static void binario(int x){
        if(x != 0){
            binario(x/2);
            System.out.print(x%2);
        }
    }
}