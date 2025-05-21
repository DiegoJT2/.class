/*
Implementar una función que reciba la frase y sustituya el caracter a sustituir por el caracter sustituto.
 */
package Primera;

public class Ejercicio061 {
    public static void main (String arg[]){
        char frase[]={'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char sustituir='a';
        char sustituto='X';
        susti(frase, sustituir, sustituto);
        System.out.println(frase);
        
    }
    public static void susti(char f[], char s1, char s2){
        for(int i=0; i<f.length; i++)
            if(f[i]==s1)
                f[i]=s2;
    }
}