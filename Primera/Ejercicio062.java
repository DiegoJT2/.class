/*
Implementar un método que reciba una cadena de caracteres y sustituya en ella un caracter por otra cadena de caracteres.
Lo haremos sobre una cadena de caracteres auxiliar.
 */
package Primera;

public class Ejercicio062 {
    public static void main (String arg[]){
        char frase[]={'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char sustituir='u';
        char sustituto[]={'X', 'X', 'V'};
        char frase2[]=susti(frase, sustituir, sustituto);
        System.out.println(frase2);
    }
    public static char[] susti(char f[], char s1, char s2[]){
        char fr[]=new char[50];
        for(int i=0, j=0; i<f.length; i++,j++)
            if(f[i]==s1)
                for(int x=0; x<s2.length; x++,j++)
                    fr[j]=s2[x];
            else
                fr[j]=f[i];
        return fr;
    }
}