/*
1. Implementa un método que cargue en fraseMod el contenido de frase sustituyendo los espacios en blanco por una 'X'.
 */
package Primera;

public class Ejercicio059 {
    public static void main (String arg[]){
        char frase[]={'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char fraseMod[]=new char[50];
        mod(frase,fraseMod);
            System.out.println(fraseMod);
        char fraseMod1[]=mod(frase);
            System.out.println(fraseMod1);
    }
    public static void mod(char f[], char fm[]){
        for(int i=0; i<f.length; i++)
            if(f[i]==' ')
                fm[i]='X';
            else
                fm[i]=f[i];
    }
    public static char[] mod(char f[]){
        char fm[]=new char[50];
        for(int i=0; i<f.length; i++){
            fm[i]=f[i];
            if(f[i]==' ')
                fm[i]='X';
        }
        return fm;
    }
}