/*
Eliminar el exceso de espacios en blanco
 */
package Primera;

public class Ejercicio088 {
    public static void main (String arg[]){
        String frase1 = "Había          una            vez              un            circo      que        alegraba       siempre        el      corazón ";
        //frase1=frase1.replaceAll(" +", " ");
        //System.out.println(frase1);
        boolean primero=true;
        int i=0;
        while(i<frase1.length())
            if(frase1.charAt(i)==' ')
                if(primero){
                    i++;
                    primero=false;
                }else{
                    frase1=frase1.substring(0, i).concat(frase1.substring(i+1));
                }
            else{
                i++;
                primero=true;
            }
        System.out.println(frase1);
    }
}