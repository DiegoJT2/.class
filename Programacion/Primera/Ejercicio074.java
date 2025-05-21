/*
Eliminar la subcadena de la frase, tantas veces como aparezca.
 */
package Primera;

public class Ejercicio074 {
    public static void main (String arg[]){
        char cadena[]={'e', 'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char subCadena[]={'e', 'n', ' '};
        
        int longitud=cadena.length;
        int i=0;
        while(i<longitud-subCadena.length){
            if(subCadena[0]==cadena[i]){
                int j=0;
                while(j<subCadena.length && cadena[i+j]==subCadena[j])
                    j++;
                if(j == subCadena.length)
                    for(int x=0; x<subCadena.length; x++){
                        for(int z=i; z<longitud-1; z++)
                            cadena[z] = cadena[z+1];
                        cadena[longitud-1]=' ';
                        longitud--;
                }
            }
            i++;
        }
        System.out.println(cadena);
    }
}