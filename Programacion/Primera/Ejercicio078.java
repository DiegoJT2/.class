/*
Ordenar el vector en orden alfabético.
Método burguja.
 */
package Primera;

public class Ejercicio078 {
    public static void main (String arg[]){
        String nombres[]={"Pepe", "Juan", "María", "Antonio", "Luisa", "Pepe"};
        String inter;
        for(int i=0; i<nombres.length-1; i++)
            for(int j=nombres.length-1; j>i; j--)
                if(nombres[j].compareTo(nombres[j-1])<0){
                    inter=nombres[j];
                    nombres[j]=nombres[j-1];
                    nombres[j-1]=inter;
                }
        for(int i=0; i<nombres.length-1; i++)
            System.out.println(nombres[i]);
    }
}