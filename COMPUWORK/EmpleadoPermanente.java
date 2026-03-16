
public class EmpleadoPermanente extends Empleado {
    private final double bono;

    public EmpleadoPermanente(int id, String nombre, String cargo, double salario, double bono) {
        super(id, nombre, cargo, salario);
        this.bono = bono;
    }

    public double getBono() {
        return bono;
    }

    @Override
    public void mostrarEmpleado() {
        super.mostrarEmpleado();
        System.out.println("Bono: " + bono);
    }
}
