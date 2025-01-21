/*
1. Implementa un método que reciba el array de salarios y nos devuelva un vector unidimensional de 6 enteros con los salarios acumulados por mes.
 */
package Primera;

public class Ejercicio048 {
    public static void main (String arg[]){
        int salarios[][] = { {700, 900, 1300, 800, 790, 850}, { 1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1200, 1170, 1000, 1000}, {1500, 1950, 1880, 1978, 2200, 2100} };
        String empleados[] = {"Javier Marías", "Antonio Muñoz", "Isabel Allende", "José Antonio"};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
        int numMes[]=salariosSemestre(salarios);
        for(int i=0; i<numMes.length; i++)
            System.out.printf("En %s se ha pagado %d\n", meses[i],numMes[i]);
        System.out.println();
        int vPorMes[]=new int[6];
        salariosSemestre(salarios, vPorMes);
        for(int i=0; i<numMes.length; i++)
            System.out.printf("En %s se ha pagado %d\n", meses[i],vPorMes[i]);
        System.out.println();
        //cuanto ha cobrado cada empleado.
        int cobra[]=SalarioEmpleados(salarios);
        for(int i=0; i<empleados.length; i++)
            System.out.printf("El empleado %s ha cobrado %d en el mes %s\n", empleados[i],cobra[i],meses[i]);
        System.out.println();
        int vCobra[]=new int[4];
        SalarioEmpleados(salarios, vCobra);
        for(int i=0; i<empleados.length; i++)
            System.out.printf("El empleado %s ha cobrado %d en el mes %s\n", empleados[i],vCobra[i],meses[i]);
    }
    public static int[] salariosSemestre(int v1[][]){
        int aux[]=new int[6];
        for(int j=0; j<aux.length; j++)
            for(int i=0; i<v1.length; i++)
                aux[j]+=v1[i][j];
        return aux;
    }
    public static void salariosSemestre(int v1[][],int vPM[]){
        for(int j=0; j<vPM.length; j++)
            for(int i=0; i<v1.length; i++)
                vPM[j]+=v1[i][j];
    }
    public static int[] SalarioEmpleados(int sals[][]){
        int cobra[]=new int[4];
        for(int i=0; i<sals.length; i++)
            for(int j=0; j<sals[i].length; j++)
                cobra[i]+=sals[i][j];
        return cobra;
    }
    public static void SalarioEmpleados(int sals[][],int v2[]){
        for(int i=0; i<sals.length; i++)
            for(int j=0; j<sals[i].length; j++)
                v2[i]+=sals[i][j];
    }
}