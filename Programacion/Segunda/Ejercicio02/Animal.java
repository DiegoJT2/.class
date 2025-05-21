
package Segunda.Ejercicio02;

abstract class Animal {
    int ID;
    String fnac;
    boolean vacunado;
    private String nombre;
    
    public Animal(int ID, String fnac, boolean vacunado, String nombre){
        this.ID = ID;
        this.fnac = fnac;
        this.vacunado = vacunado;
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    abstract void habla();
}
