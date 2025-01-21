/*
Mostrar por pantalla el valor mayor del vector
 */
package Primera;

public class Ejercicio015 {
    public static void main (String arg[]){
        int datos[]={17, 33, 4, 95, 170}, mayor = 0;
        for(int i = 0; i < datos.length; i++)
            if(datos[i] > mayor)
                mayor = datos[i];
        System.out.println("El mayor es " + mayor);
        mayor = datos[0];
        //corregido para negativos:
        for(int i = 1; i < datos.length; i++)
            if(datos[i] > mayor)
                mayor = datos[i];
        System.out.println("El mayor es " + mayor);
        
        int posmayor = 0;
        for(int i = 1; i < datos.length; i++)
            if(datos[i]>datos[posmayor])
                posmayor=i;
        System.out.printf("El mayor es %d y está en la posición %d\n", datos[posmayor], posmayor);
    }
}