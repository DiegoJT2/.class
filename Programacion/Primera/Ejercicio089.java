/*
Repartir las palabras frase1 alternativamente en fraseA y fraseB
 */
package Primera;

public class Ejercicio089 {
    public static void main (String arg[]){
        String frase1 = "Había una vez un circo ";
        String fraseA = "";
        String fraseB = "";
        
        boolean enFA=true;
        int inicio=0, fin=frase1.indexOf(" ");
        while(fin!=-1){
            if(enFA){
                fraseA=fraseA.concat(frase1.substring(inicio, fin+1));
                enFA=false;
            }else{
                fraseB=fraseB.concat(frase1.substring(inicio, fin+1));
                enFA=true;
            }
        inicio=fin+1;
        fin = frase1.indexOf(" ", inicio);
        }
        System.out.println(fraseA);
        System.out.println(fraseB);
    }
}