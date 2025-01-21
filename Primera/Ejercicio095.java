/*
Separar un número por unidades
 */
package Primera;

public class Ejercicio095 {
    public static String medidas[]= {"Unidades", "Decenas", "Centenas", "Unidadesde millar", "Decenas de millar", "Centenas de millar"};
    public static void main (String arg[]){
        
        int numero=256809;
        mostrar(numero, 0);
    }
    public static void mostrar(int numero, int i){
        if(numero>0){
            System.out.println(numero%10 + " " + medidas[i]);
            mostrar(numero/10, i+1);
        }
    }
}