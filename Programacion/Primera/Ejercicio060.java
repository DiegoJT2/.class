/*
Implementar un método que convierta una frase en mayúsculas.
 */
package Primera;

public class Ejercicio060 {
    public static void main (String arg[]){
        char frase[]={'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        mayus(frase);
        System.out.println(frase);
    }
    public static void mayus(char f[]){
        for(int i=0; i<f.length; i++)
            f[i]=Character.toUpperCase(f[i]);
    }
}