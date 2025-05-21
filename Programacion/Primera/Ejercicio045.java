/*
Funciones o métodos.
 */
package Primera;

public class Ejercicio045 {
    public static void main (String arg[]){
        String palabras;
        escribir();
        hablar("Buenos días");
        animalHabla("Me llamo toby", "Guau, guau");
        palabras=concatenar("En un lugar", "de la Mancha");
        System.out.println(palabras);
        System.out.printf("La suma de 345 + 55 es %d\n", suma(345, 55));
    }
    public static void escribir(){
        System.out.println("hola");
    }
    public static void hablar(String frase){
        System.out.println(frase);
    }
    public static void animalHabla(String frase, String onomatopeya){
        System.out.println(frase + " : " + onomatopeya);
    }
    public static String concatenar(String frase1, String frase2){
        return frase1+frase2; //cuando se ejecuta la función return la instrucción se acaba.
    }
    public static int suma(int x,int y){
        return x+y;
    }
}