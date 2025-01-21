/*
Modificar frase, de manera que sus palabras (se separan por un espacio en blanco) queden ordenadas alfabéticamente.
 */
package Primera;

public class Ejercicio084 {
    public static void main (String arg[]){
        String frase="5Cinco 6Seis 2Dos 4Cuatro 1Uno 3Tres";
        String vector[];
        
        //Instanciamos el vector
        int cont=0;
        int pos = frase.indexOf(" ");
        while(pos != -1){
            cont++;
            pos = frase.indexOf(" ", pos+1);
        }
        vector = new String[cont];
        
        //Cargamos el vector con las palabras
        int x=0;
        int inicio=0, fin=frase.indexOf(" ");
        while(fin!=-1){
            vector[x++]=frase.substring(inicio, fin+1);
            inicio=fin+1;
            fin = frase.indexOf(" ", inicio);
            }
        
        //Ordenar los elementos del vector
        String inter;
        
        for(int i=0; i<vector.length-1; i++)
            for(int j=vector.length-1; j>i; j--)
                if(vector[j].compareTo(vector[j-1])<0){
                    inter=vector[j];
                    vector[j]=vector[j-1];
                    vector[j-1]=inter;
                }
        
        //Cargar frase con los elementos del vector
        frase="";
        for(int i=0; i<vector.length; i++)
            frase=frase.concat(vector[i]);
        
        System.out.println(frase);
    }
}