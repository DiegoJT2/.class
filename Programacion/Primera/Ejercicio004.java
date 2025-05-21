/*
 Cual es la mayor variable de las 3
 */
package Primera;

public class Ejercicio004 {
    public static void main (String arg[]){
        int x, y, z;
        x = 10;
        y = 50;
        z = 33;
        if(x > y)
            if(x > z)
                System.out.println("El mayor es: " + x);
            else
              System.out.println("El mayor es: " + z);
        else
            if (y > z)   
                System.out.println("El mayor es: " + y);
            else
                System.out.println("El mayor es: " + z);
    }
}