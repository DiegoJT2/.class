/*
Implementar una función que devuelva el valor máximo de un vector.
 */
package Primera;

public class Ejercicio046 {
    public static void main (String arg[]){
        int vector[]={24, 45, 65, 12, 7 ,123, 16, 50};
        int vector2[]={4, 49, 165, 12, 17 ,123, 16, 50};
        int numMax=maximo(vector);
        System.out.println("El máximo del primer vector es:" + vector[numMax]);
        int numMax2=maximo(vector2);
        System.out.println("El máximo del segundo vector es:" + vector2[numMax2]);
    }
    public static int maximo(int v1[]){
        int max=0;
        for(int i=0; i<v1.length; i++)
            if(v1[i]>v1[max])
                max=i;
        return max;
    }
}