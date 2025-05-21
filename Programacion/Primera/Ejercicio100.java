/*

 */
package Primera;

public class Ejercicio100 {
    public static void main (String arg[]){
        String valores[][]={{"", "y uno", "y dos", "y tres", "y cuatro", "y cinco", "y seis", "y siete", "y ocho", "y nueve"},
                            {"","diez ", "veinti ", "treinta ", "cuarenta ", "cincuenta ","sesenta ", "setenta ", "ochenta ", "noventa "},
                            {"","ciento ", "dosciento ", "trescientos ", "cuatrocientos ", "quinientos "}};
        int numero=599;
        enLetras(valores, numero, 0);
    }
    public static void enLetras(String valores[][], int num, int i){
        if(num>0){ 
            enLetras(valores, num/10, i+1);
            System.out.print(valores[i][num%10] );
        }
    }
}