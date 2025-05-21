/*
Mostrar por pantalla, de cada producto, cuántos € he recaudado y al final mostrar el total de € recaudados.
 */
package Primera;

public class Ejercicio031 {
    public static void main (String arg[]){
        int kilos[][]={ {10, 20, 30, 40, 50},
                        {50, 60, 70, 80, 80},
                        {90, 100, 110, 120, 30}};
        String []productos = {"Naranjas", "Manzanas", "Peras"}; //String productos[]
        double precios[] = {1.5, 2, 0.83};
        double acum;
        double total=0;
        for(int i = 0; i<kilos.length; i++){
            acum=0;
            for(int j = 0; j<kilos[i].length; j++)
                acum+=kilos[i][j]*precios[i];
            total+=acum;
            System.out.printf("He vendido %.2f € de %s\n", acum, productos[i]); //%."nºdecimales"f
        }
        System.out.printf("He vendido %.2f € en total\n", total);
    }
}