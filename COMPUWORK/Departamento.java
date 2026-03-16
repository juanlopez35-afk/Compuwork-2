import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Departamento {

    private final int idDepartamento;
    private String nombreDepartamento;
    private final ArrayList<Empleado> empleados;

    public Departamento(int idDepartamento, String nombreDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) {
        if (e == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        empleados.add(e);
        System.out.println("Empleado agregado al departamento.");
    }

    public boolean eliminarEmpleado(int id) {
        Iterator<Empleado> iterator = empleados.iterator();
        while (iterator.hasNext()) {
            Empleado e = iterator.next();
            if (e.getId() == id) {
                iterator.remove();
                System.out.println("Empleado eliminado.");
                return true;
            }
        }
        System.out.println("Empleado no encontrado.");
        return false;
    }

    public Empleado buscarEmpleado(int id) {
        for (Empleado e : empleados) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public void actualizarEmpleado(int id, String nuevoCargo, double nuevoSalario) {
        Empleado empleado = buscarEmpleado(id);
        if (empleado == null) {
            throw new IllegalArgumentException("No existe un empleado con el id " + id);
        }
        if (nuevoCargo == null || nuevoCargo.isBlank()) {
            throw new IllegalArgumentException("El cargo no puede estar vacio");
        }
        if (nuevoSalario <= 0) {
            throw new IllegalArgumentException("El salario debe ser mayor a 0");
        }
        empleado.setCargo(nuevoCargo);
        empleado.setSalario(nuevoSalario);
        System.out.println("Empleado actualizado.");
    }

    public void mostrarEmpleados() {

        System.out.println("Departamento: " + nombreDepartamento);

        for (Empleado e : empleados) {
            e.mostrarEmpleado();
            System.out.println("-------------");
        }
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        if (nombreDepartamento == null || nombreDepartamento.isBlank()) {
            throw new IllegalArgumentException("El nombre del departamento no puede estar vacio");
        }
        this.nombreDepartamento = nombreDepartamento;
    }

    public List<Empleado> getEmpleados() {
        return Collections.unmodifiableList(empleados);
    }
}
