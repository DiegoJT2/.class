/*
Sacar el listado de DIECES.
 */
package Primera;

public class Ejercicio036 {
    public static void main (String arg[]){
        int notas[][] = { {7, 9, 3, 8}, { 10, 9, 9, 8}, {9, 10, 7, 1}, {3, 10, 5, 6}, {8, 5, 4, 5} };
        String alumnos[] = {"Javier Marías", "Antonio Muñoz", "Isabel Allende", "José Antonio", "Gabriel"};
        String asignaturas[] = {"Programación", "Leng.Marcas", "Sistemas", "Bases de datos"};
        System.out.println("Listado de dieces: ");
        for(int i=0; i<notas.length; i++)
            for(int j=0; j<notas[i].length; j++)
                if(notas[i][j]==10)
                    System.out.printf("%s en %s\n", alumnos[i],asignaturas[j]);
    }
}