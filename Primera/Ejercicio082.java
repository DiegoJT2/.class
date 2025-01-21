/*
Reemplazar una subcadena por ella misma en mayúsculas
Funcion concat
 */
package Primera;

public class Ejercicio082 {
    public static void main (String arg[]){
        String frases[]={"en un lugar", " lugar en La Mancha", ", de cuyo nombre", " no quiero acordarmen"};
        String subCadena = "en";
        
        for(int i=0;i<frases.length; i++){
                frases[i]=frases[i].replace(subCadena, subCadena.toUpperCase());
                frases[0]=frases[0].concat("HOLA");
                System.out.println(frases[i]);
        }
    }
}