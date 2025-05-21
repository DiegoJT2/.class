
package Segunda.Ejercicio03;

public class Ejecutable {
    public static void main (String arg[]) throws Exception{
        NIF persona1, persona2;
        persona1=new NIF(26282131);
        persona2=new NIF(26282131,'T');
        try{
            System.out.println("Hola " + (20/0));
        }catch(ArithmeticException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
        persona1.mostrar();
        persona2.mostrar();
    }
}