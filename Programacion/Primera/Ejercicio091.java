/*
Factorial con recursividad
 */
package Primera;

public class Ejercicio091 {
    public static void main (String arg[]){
        int num = 5;
        int resultado=factorial(num);
        System.out.println("El resultado es "+resultado);
    }
    public static int factorial(int a){
        if(a==1)
            return a;
        else
            return factorial(a-1)* a;
    }
}