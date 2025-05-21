/*
Dado un String, eliminar de él los espacios en blanco, sin utilizar la función replace.
Utilizando indexOf, subString, concat
 */
package Primera;

public class Ejercicio083 {
    public static void main (String arg[]){
        String frase = "Había una vez, un circo, que alegraba siempre el corazón";
        
        int pos= frase.indexOf(" ");
        while(pos != -1){
            frase=frase.substring(0, pos).concat(frase.substring(pos+1));
            pos = frase.indexOf(" ", pos);
            }
        System.out.println(frase);
    }
}