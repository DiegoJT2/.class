/*
Meter frase en cadena2, pero sus caracteres se alojarán en orden inverso.
 */
package Primera;

public class Ejercicio069 {
    public static void main (String arg[]){
        char frase[]={'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char cadena2[]=new char[150];
        for(int i=0,j=frase.length-1; j>=0; i++,j--)
            cadena2[i]=frase[j];
        System.out.println(cadena2);
    }
}