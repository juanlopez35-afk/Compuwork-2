public class ReporteDesempeno {

    private final Empleado empleado;
    private final int calificacion;
    private final String comentarios;

    public ReporteDesempeno(Empleado empleado, int calificacion, String comentarios) {
        this.empleado = empleado;
        this.calificacion = calificacion;
        this.comentarios = comentarios;
    }

    public void generarReporte() {
        System.out.println("----- REPORTE DE DESEMPEÑO -----");
        empleado.mostrarEmpleado();
        System.out.println("Calificación: " + calificacion);
        System.out.println("Comentarios: " + comentarios);
    }

    public static void generarReporteDepartamento(Departamento departamento) {
        if (departamento == null) {
            throw new IllegalArgumentException("El departamento no puede ser nulo");
        }

        System.out.println("----- REPORTE DEPARTAMENTO -----");
        System.out.println("Departamento: " + departamento.getNombreDepartamento());
        System.out.println("Total empleados: " + departamento.getEmpleados().size());

        for (Empleado empleado : departamento.getEmpleados()) {
            System.out.println("- " + empleado.getNombre() + " | Cargo: " + empleado.getCargo()
                    + " | Salario: " + empleado.getSalario());
        }
    }
}
