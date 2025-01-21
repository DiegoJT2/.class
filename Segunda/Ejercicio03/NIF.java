
package Segunda.Ejercicio03;

public class NIF {
    public int dni;
    public char letra;
    public final char tabla[]={'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};//no puede modificarse porque está definida como "final"

    public NIF(int dni, char letra) throws Exception{
        this.dni = dni;
        if(letra!=tabla[dni%23])
            throw new Exception("Has calculado mal la letra");//throw lanzar una excepcion
        this.letra = letra;
    }
    public NIF(int dni) {
        this.dni = dni;
        letra = tabla[dni%23];
    }
    public void mostrar(){
        System.out.printf("El NIF es: %d - %c\n", dni, letra);
    }
}