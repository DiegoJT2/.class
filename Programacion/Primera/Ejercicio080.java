/*
Función replace
Función indexOf
 */
package Primera;

public class Ejercicio080 {
    public static void main (String arg[]){
        String frase="En un lugar lugar de La Mancha, de cuyo nombre no quiero acordarme";
        
        frase=frase.replace('a', 'X');
        System.out.println(frase);
        
        frase=frase.replace("lugXr", "sitio");
        System.out.println(frase);
        int cont=0;
        int posicion = frase.indexOf("sitio");
        while(posicion != -1){
            cont++;
            System.out.println("Encontrado en la posición: " + posicion);
            posicion = frase.indexOf("sitio", posicion+1);
            System.out.println("Ha aparecido: " + cont);
        }
    }
}