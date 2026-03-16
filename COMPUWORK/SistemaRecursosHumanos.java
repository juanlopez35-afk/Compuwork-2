import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class SistemaRecursosHumanos {

    private final Map<Integer, Departamento> departamentos;

    public SistemaRecursosHumanos() {
        this.departamentos = new HashMap<>();
    }

    public void crearDepartamento(Departamento departamento) {
        if (departamento == null) {
            throw new IllegalArgumentException("El departamento no puede ser nulo");
        }
        if (departamentos.containsKey(departamento.getIdDepartamento())) {
            throw new IllegalArgumentException("Ya existe un departamento con ese id");
        }
        departamentos.put(departamento.getIdDepartamento(), departamento);
        System.out.println("Departamento creado: " + departamento.getNombreDepartamento());
    }

    public void eliminarDepartamento(int idDepartamento) {
        if (departamentos.remove(idDepartamento) == null) {
            throw new IllegalArgumentException("No existe el departamento con id " + idDepartamento);
        }
        System.out.println("Departamento eliminado.");
    }

    public void modificarDepartamento(int idDepartamento, String nuevoNombre) {
        Departamento departamento = obtenerDepartamento(idDepartamento);
        departamento.setNombreDepartamento(nuevoNombre);
        System.out.println("Departamento modificado.");
    }

    public Departamento obtenerDepartamento(int idDepartamento) {
        Departamento departamento = departamentos.get(idDepartamento);
        if (departamento == null) {
            throw new IllegalArgumentException("No existe el departamento con id " + idDepartamento);
        }
        return departamento;
    }

    public void asignarEmpleado(int idDepartamento, Empleado empleado) {
        Departamento departamento = obtenerDepartamento(idDepartamento);
        departamento.agregarEmpleado(empleado);
    }

    public void actualizarEmpleado(int idDepartamento, int idEmpleado, String nuevoCargo, double nuevoSalario) {
        Departamento departamento = obtenerDepartamento(idDepartamento);
        departamento.actualizarEmpleado(idEmpleado, nuevoCargo, nuevoSalario);
    }

    public void eliminarEmpleado(int idDepartamento, int idEmpleado) {
        Departamento departamento = obtenerDepartamento(idDepartamento);
        boolean eliminado = departamento.eliminarEmpleado(idEmpleado);
        if (!eliminado) {
            throw new IllegalArgumentException(
                    "No existe un empleado con el id " + idEmpleado + " en ese departamento");
        }
    }

    public void reasignarEmpleado(int idOrigen, int idDestino, int idEmpleado) {
        Departamento origen = obtenerDepartamento(idOrigen);
        Departamento destino = obtenerDepartamento(idDestino);

        Empleado empleado = origen.buscarEmpleado(idEmpleado);
        if (empleado == null) {
            throw new IllegalArgumentException(
                    "No existe un empleado con el id " + idEmpleado + " en el departamento origen");
        }

        origen.eliminarEmpleado(idEmpleado);
        destino.agregarEmpleado(empleado);
        System.out.println("Empleado reasignado correctamente.");
    }

    public List<Departamento> listarDepartamentos() {
        return new ArrayList<>(departamentos.values());
    }
}
