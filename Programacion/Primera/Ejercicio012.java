/*
Cálculo de variaciones matemáticas
 */
package Primera;

public class Ejercicio012 {
    public static void main (String arg[]){
        int tomadas = 4, numero = 6, acum = 1;
        for(int valor = numero; valor > tomadas; valor--)
            acum *= valor;
        System.out.printf("Variaciones de %d elementos tomados de %d en %d son %d\n", numero, tomadas, tomadas, acum);//%d numero decimal %s string
    }
}