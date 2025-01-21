/*
En la tabla de goles se guardan los que han metido los 5 futbolistas en las últimas 4 temporadas.
Mostrar por pantalla la media de goles de cada jugador.
No utilizar un vector auxiliar.
 */
package Primera;

public class Ejercicio041 {
    public static void main (String arg[]){
        int goles[][] = {{18, 20, 13, 14, 23}, {15, 26, 7, 18, 13}, {19, 10, 11, 22, 30}, {13, 19, 15, 26, 9}};
        String futbolistas[]={"Halland", "Mbappé", "Grizzman", "Yamal", "William"};
        double acum;
        for(int j=0; j < futbolistas.length; j++){
            acum=0;
            for(int i=0; i < goles.length; i++)
                acum+=goles[i][j];
        System.out.printf("%s ha obtenido %.1f de media\n", futbolistas[j], acum/goles.length);
        }
    }
}