/*
Invertir el orden de cada palabra.
Las palabras están separadas por un espacio en blanco.
 */
package Primera;

public class Ejercicio065 {
    public static void main (String arg[]){
        char frase[]={'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        int inicio, fin;
        char intercambio;
        inicio = fin = 0;
        while(fin<frase.length){
            while(fin<frase.length&&frase[fin]!=' ')
                fin++;
            for(int i=0; i<=(fin-inicio)/2; i++,inicio++){
                intercambio=frase[inicio];
                frase[inicio]=frase[fin-i-1];
                frase[fin-i-1]=intercambio;
            }
            inicio=fin=fin+1;
        }
        System.out.println(frase);
    }
}