/*
Las palabras de frase están separadas por un espacio en blanco.
Meter en frase2 las mismas palabras que hay en frase, pero en orden inverso.
 */
package Primera;

public class Ejercicio072 {
    public static void main (String arg[]){
        char frase[]={' ', 'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char frase2[]=new char[150];
        
        int inicio, fin;
        inicio = fin=frase.length-1;
        int pos=0;
        while(inicio>0){
            while(frase[inicio]!=' ')
                inicio--;
            for(int i=inicio; i<=fin; i++)
                frase2[pos++]=frase[i];
            fin = inicio=inicio-1;
        }
        System.out.println(frase2);
    }
}