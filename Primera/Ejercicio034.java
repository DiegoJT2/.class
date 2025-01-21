/*
Mostrar por pantalla el título de la película y el día de la semana de mayor taquillaje.
 */
package Primera;

public class Ejercicio034 {
    public static void main (String arg[]){
        int salas[][]={ {10, 20, 30, 40, 50, 200, 180},
                        {50, 60, 70, 80, 80, 300, 198},
                        {90, 100, 110, 120, 130, 150, 120},
                        {9, 199, 150, 180, 13, 100, 190}};
        String peliculas[]={"Joker", "Soy Neveka", "Buffalo kids", "Los destellos"};
        String []dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int posMax=0,posMin=0,posSalaMax=0,posSalaMin=0;
        for(int i=0; i<salas.length; i++)
            for(int j=0; j<salas[i].length; j++){
                if(salas[i][j]>salas[posMax][posSalaMax]){
                    posMax=i;
                    posSalaMax=j;}
                if(salas[i][j]<salas[posMin][posSalaMin]){
                    posMin=i;
                    posSalaMin=j;}
        }
        System.out.printf("La sesión más vista fue %s con %s con %d espectadores.\n", dias[posSalaMax], peliculas[posMax], salas[posMax][posSalaMax]);
        System.out.printf("La sesión menos vista fue %s con %s con %d espectadores.\n", dias[posSalaMin], peliculas[posMin], salas[posMin][posSalaMin]);
    }
}