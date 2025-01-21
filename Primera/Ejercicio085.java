/*

 */
package Primera;

public class Ejercicio085 {
    public static void main (String arg[]){
        String frase1 = "Había vez circo alegraba el ";
        String frase2 = "una un que siempre corazón sin temer jamás ";
        String frase3 = "";
        
        int inicio1=0, fin1=frase1.indexOf(" ");
        int inicio2=0, fin2=frase2.indexOf(" ");
        while(fin1!=-1&&fin2!=-1){
            frase3=frase3.concat(frase1.substring(inicio1, fin1+1));
            inicio1=fin1+1;
            fin1 = frase1.indexOf(" ", inicio1);
            frase3=frase3.concat(frase2.substring(inicio2, fin2+1));
            inicio2=fin2+1;
            fin2 = frase2.indexOf(" ", inicio2);
        }
        //Pregunta cual ha terminado y la que no haya acabado que siga hasta el final
        if(fin1==-1)
            frase3=frase3.concat(frase2.substring(inicio2));
        else
            frase3=frase3.concat(frase1.substring(inicio1));
        System.out.println(frase3);
    }
}