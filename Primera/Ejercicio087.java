/*
Meter una 'a' después de cada palabra.
 */
package Primera;

public class Ejercicio087 {
    public static void main (String arg[]){
        String frase1 = "Había una vez un circo que alegraba siempre el corazón ";
        
        //frase1=frase1.replace(" ", "a ");
        //System.out.println(frase1);
        int pos=frase1.indexOf(" ");
        while(pos!=-1){
            frase1=frase1.substring(0, pos).concat("a").concat(frase1.substring(pos));
            pos = frase1.indexOf(" ", pos+2);
            }
        System.out.println(frase1);
    }
}