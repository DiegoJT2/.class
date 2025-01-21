/*
Obtener el valor mayor y el menor de un vector de enteros
 */
package Primera;

public class Ejercicio016 {
    public static void main (String arg[]){
        int datos[] = {17, 33, 4, 95, 170}, mayor=datos[0], menor=datos[0];
        for(int i = 1; i < datos.length; i++){
            if(mayor<datos[i])
                mayor=datos[i];
            if(menor>datos[i])
                menor=datos[i];
        }
        System.out.printf("El mayor es %d y el menor es %d\n", mayor, menor);
        int posMayor=0, posMenor=0;
        for(int i = 1; i < datos.length; i++)
            if(mayor<datos[i])
                mayor=datos[i];
        for(int i = 1; i < datos.length; i++){
            if(datos[i]>datos[posMayor])
                posMayor=i;
            if(datos[i]<datos[posMenor])
                posMenor=i;
        }
        System.out.printf("El mayor es %d y está en la posición %d, el menor es %d y está en la posición %d\n", mayor, posMayor, menor, posMenor);
    }
}