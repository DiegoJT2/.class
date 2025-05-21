/*
Cadena de caracteres.
Implementar una función que devuelva el número de espacios en blanco que contiene una cadena.
 */
package Primera;

public class Ejercicio058 {
    public static void main (String arg[]){
        char frase[]={'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        System.out.printf("La frase tiene %d palabras\n",espacios(frase)+1);
    }
    public static int espacios(char f[]){
        int e=0;
        for(int i=0; i<f.length; i++)
            if(f[i]==' ')
                e++;
        return e;
    }
}