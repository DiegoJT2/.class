/*
Meter en cadena2 el contenido de frase, sustituyendo la subcadena1 por la subcadena2.
 */
package Primera;

public class Ejercicio071 {
    public static void main (String arg[]){
        char frase[]={'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char subCad1[]={'e', 'n', ' '};
        char subCad2[]={'X', 'X', 'X', 'X', 'X'};
        char cadena2[]=new char[150];
        
        
        for(int i=0, x=0; i<frase.length; i++)
            if(subCad1[0]==frase[i]){
                int j=1;
                while(j<subCad1.length && frase[i+j]==subCad1[j])
                    j++;
                if(j == subCad1.length){
                    for(int z=0; z<subCad2.length; z++)
                        cadena2[x++] = subCad2[z];
                    i+=subCad1.length-1;
                }else
                    cadena2[x++]=frase[i];
            }else{
                cadena2[x++]=frase[i];
            }
        System.out.println(cadena2);
    }
}