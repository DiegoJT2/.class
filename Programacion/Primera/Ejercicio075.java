/*
Tenemos una cadena caracteres cargada con palabras , cada palabra está separada por un espacio en blanco.
Modificar la cadena de manera que cada palabra que con su primer y último caracter en mayúsculas.
 */
package Primera;

public class Ejercicio075 {
    public static void main (String arg[]){
        char cadena[]={'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'l', 'a', ' ', 'm', 'a', 'n', 'c', 'h', 'a'};
        int inicio, fin;
        inicio = fin = 0;
        while(fin<cadena.length){
            while(fin<cadena.length&&cadena[fin]!=' ')
                fin++;
            cadena[inicio]=Character.toUpperCase(cadena[inicio]);
            cadena[fin-1]=Character.toUpperCase(cadena[fin-1]);//toLowerCase convierte a minusculas
            inicio=fin=fin+1;
        }
        System.out.println(cadena);
    }
}