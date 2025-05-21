/*
Contar las palabras que contengan al menos 1 vocal
 */
package Primera;

public class Ejercicio101 {
    public static void main (String arg[]){
        int cont=0;
        char vocales[]={'a','e','i','o','u'};
        char frase[]={'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        for(int i=0; i<frase.length; i++)
            for(int j=0; j<vocales.length; j++)
                if(frase[i]!=' '&&frase[i]==vocales[j])
                    cont++;
        System.out.println(cont);
    }
}