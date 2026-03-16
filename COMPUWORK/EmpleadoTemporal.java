
public class EmpleadoTemporal extends Empleado {
    private final int mesesContrato;

    public EmpleadoTemporal(int id, String nombre, String cargo, double salario, int mesesContrato) {
        super(id, nombre, cargo, salario);
        this.mesesContrato = mesesContrato;
    }

    public int getMesesContrato() {
        return mesesContrato;
    }

    @Override
    public void mostrarEmpleado() {
        super.mostrarEmpleado();
        System.out.println("Meses de contrato: " + mesesContrato);
    }
}
