public class Empleado {

    private final int id;
    private final String nombre;
    private String cargo;
    private double salario;

    public Empleado(int id, String nombre, String cargo, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void mostrarEmpleado() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salario: " + salario);
    }
}
