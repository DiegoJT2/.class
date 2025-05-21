/*
Mostrar por pantalla el nombre del empleado que más cobra y su media mensual. Y el que menos cobra y su media mensual.
Mostrar por pantalla el mes que más se cobra y su media por empleado. Y el mes en que menos se cobra y su media por empleado.
 */
package Primera;

public class Ejercicio037 {
    public static void main (String arg[]){
        int salarios[][] = { {700, 900, 1300, 800, 790, 850}, { 1000, 950, 1080, 1070, 1200, 1100}, {1300, 930, 1200, 1170, 1000, 1000}, {1500, 1950, 1880, 1978, 2200, 2100} };
        String empleados[] = {"Javier Marías", "Antonio Muñoz", "Isabel Allende", "José Antonio", "Gabriel"};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
        double empleadosAcum[]={0, 0, 0, 0};
        double mesesAcum[]={0, 0, 0, 0, 0, 0};
        for(int i=0; i<salarios.length; i++)
            for(int j=0; j<salarios[i].length; j++){
                empleadosAcum[i]+=salarios[i][j];
                mesesAcum[j]+=salarios[i][j];
            }
        int posMasCobra=0;
        int posMenosCobra=0;
        for(int i=0; i<empleadosAcum.length; i++){
            if(empleadosAcum[i]>empleadosAcum[posMasCobra])
                    posMasCobra=i;
            if(empleadosAcum[i]<empleadosAcum[posMenosCobra])
                    posMenosCobra=i;
            }
        System.out.printf("%s es el empleado que más cobra y su media es %.2f\n", empleados[posMasCobra], empleadosAcum[posMasCobra]/salarios.length);
        System.out.printf("%s es el empleado que peor cobra y su media es %.2f\n", empleados[posMenosCobra], empleadosAcum[posMenosCobra]/salarios.length);
        int posMasMes=0;
        int posMenosMes=0;
        for(int i=0; i<mesesAcum.length; i++){
            if(mesesAcum[i]>mesesAcum[posMasMes])
                    posMasMes=i;
            if(mesesAcum[i]<mesesAcum[posMenosMes])
                    posMenosMes=i;
            }
        System.out.printf("%s es el mes que más se cobra y su media es %.2f\n", meses[posMasMes], mesesAcum[posMasMes]/salarios.length);
        System.out.printf("%s es el empleado que peor se cobra y su media es %.2f\n", empleados[posMenosMes], mesesAcum[posMenosMes]/salarios.length);
    }
}
