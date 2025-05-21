/*
Función charAt
Mostrar por pantalla cuántas 'a' hay en una frase
 */
package Primera;

public class Ejercicio081 {
    public static void main (String arg[]){
        String frases[]={"En un lugar", "lugar de La Mancha", ",de cuyo nombre", "no quiero acordarme"};
        int cont=0;
        for(int i=0;i<frases.length; i++)
            for(int j=0;j<frases[i].length(); j++)
                if(frases[i].charAt(j)=='a')
                    cont++;
        System.out.printf("Hay %d aes\n", cont);
    }
}