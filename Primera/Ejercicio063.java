/*
Sustituir un caracter por una cadena de caracteres, sin utilizar una cadena auxiliar.
 */
package Primera;

public class Ejercicio063 {
    public static void main (String arg[]){
        char frase[]={'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char sustituir='n';
        char sustituto[]={'X', 'Y', 'Z'};
        char frase2[]=new char[100];
        
        for(int i=0; i<frase.length; i++)
            frase2[i]=frase[i];
        int longitud=frase.length;
        int i=0;
        while(i < longitud){
            if(frase2[i]==sustituir){
                frase2[i]=sustituto[0];
                for(int j=1; j<sustituto.length; j++, longitud++){
                    for(int x=longitud-1; x>i; x--)
                        frase2[x+1]=frase2[x];
                    frase2[i+j]=sustituto[j];
                }
            }
            i++;
        }
        System.out.println(frase2);
    }
}