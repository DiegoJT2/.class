/*

 */
package Primera;

public class Ejercicio099 {
    public static void main (String arg[]){
        String modulos[]={"Programacion", "Marcas", "Entornos", "Bases de datos"};
        String Alumnos[]={"Alumno1", "Alumno2", "Alumno3", "Alumno4", "Alumno5"};
        int notas[][]={{3,4,8,9},{4,5,7,10},{2,7,10,8},{5,3,6,7},{4,2,5,8}};
        int cont;
        for(int i=0; i<notas.length-1; i++){
            cont=0;
            for(int j=0; j<notas[i].length+1; j++)
                if(notas[j][i]<5)
                    cont++;
        System.out.printf("Han suspendido %d alumnos en %s\n",cont, modulos[i]);
        }
        //Realizar la media de las calificaciones menores a 5
        double acum=0;
        cont=0;
        for(int i=0; i<notas.length-1; i++){
            for(int j=0; j<notas[i].length+1; j++)
                if(notas[j][i]<5){
                    acum+= notas[j][i];
                    cont++;
                }
        System.out.printf("La nota media de las calificaciones suspendidas es de %.2f\n", acum/cont);
        }
        for(int i=0; i<notas.length; i++){
            acum=0;
            for(int j=0; j<notas[i].length; j++)
                acum+=notas[i][j];
            if(acum/modulos.length>=5)
                System.out.println(Alumnos[i]);
        }
    }
}