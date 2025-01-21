/*

 */
package Primera;

public class Ejercicio094 {
    public static void main (String arg[]){
        System.out.printf("Número de campanadas que ha dado a lo largo del día %d %d\n", campanadas1(24), campanadas2(14));
    }
    public static int campanadas1(int hora){
        int acum=0;
        for(int i=1; i<=hora; i++)
            if(i>12)
                acum+=i-12;
        else
                acum+=i;
        return acum;
    }
    public static int campanadas2(int hora){
        if(hora==1)
            return 1;
        if(hora>12)
            return campanadas2(hora-1)+(hora-12);
        else
            return campanadas2(hora-1)+hora;
    }
}