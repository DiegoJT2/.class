package Segunda.Ejercicio01;

public class Casa {
    private String direccion;
    private double numMetros;
    private String material;
    private int numHabitaciones;
    public Casa(String direccion, double nM, String material, int nH){
        this.direccion = direccion;
        numMetros = nM;
        this.material = material;
        numHabitaciones = nH;
    }
    public Casa(String direccion, double nM, String material){
        this.direccion = direccion;
        numMetros = nM;
        this.material = material;
        numHabitaciones = 1;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String dir){
        direccion = dir;
    }
    public double getNumMetros(){
        return numMetros;
    }
    public void setNumMetros(double nM){
        numMetros = nM;
    }
    public String getMaterial(){
        return material;
    }
    public void setMaterial(String material){
        this.material = material;
    }
    public int getNumHabitaciones(){
        return numHabitaciones;
    }
    public void setNumMetros(int nH){
        numHabitaciones = nH;
    }
    public void mostrar(){
        System.out.printf("dirección: %s, número de metros: %.2f, material: %s, número de habitaciones: %d\n",direccion, numMetros, material, numHabitaciones);
    }
}