/*
Implementa una función que reciba un vector de 10 enteros y un número entero ‘n’ y 
devuelva un nuevo vector que contenga sólo los elementos del primer vector que sean mayores que ‘n’.
 */
package Primera;

public class Examen1 {
    public static void main (String arg[]){
        int vector[]={23, 300,48,6,3,90,35,89,123,12};
        int n=30;
        int vector2[]=mayor(vector,n);
        for(int i=0; i<vector2.length; i++)
            System.out.print(vector2[i] + " - ");
    }
    public static int[] mayor(int v[], int n){
        int j=0;
        int v2[]=new int[v.length];
        for(int i=0; i<v.length; i++)
            if(v[i]>n){
                v2[j]=v[i];
                j++;
            }
        return v2;
    }
}