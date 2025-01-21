package Segunda.Ejercicio01;

public class Ejecutable {
    public static void main (String arg[]){
        Casa casa1, casa2;
        Chalet Chalet1;
        casa1 = new Casa("C/. María Auxiliadora nº 59", 1200, "Ladrillo", 200);
        casa2 = new Casa("Plaza del Pilar Nº1", 2000, "Piedra");
        System.out.println(casa2.getDireccion());
        casa1.mostrar();
        
        Chalet1=new Chalet("evd. de la Ilustración Nº3", 2000, "Ladrillo", 5, 80, true);
        Chalet1.mostrar();
    }
}