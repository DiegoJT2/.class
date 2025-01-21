/*

 */
package Primera;

public class Ejercicio093 {
    public static void main (String arg[]){
        System.out.println("División entera de 7/2 = " + dividir(7,2));
    }
    public static int dividir(int dividendo, int divisor){
        if(dividendo<divisor)
            return 0;
        else
            return dividir(dividendo-divisor, divisor)+1;
    }
}