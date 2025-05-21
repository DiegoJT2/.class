/*
Clase String. 2 primeras funciones. LENGTH y CHARAT.
 */
package Primera;

public class Ejercicio077 {
    public static void main (String arg[]){
        String frase="En un lugar de La Mancha, de cuyo nombre no quiero acordarme";
        char[] cadena=new char[150];
        
        for(int i=0; i<frase.length(); i++)
            System.out.printf(" %c", frase.charAt(i));
        System.out.println();
        for(int i=0; i<frase.length(); i++)
            cadena[i]=frase.charAt(i);
        System.out.println(cadena);
    }
}