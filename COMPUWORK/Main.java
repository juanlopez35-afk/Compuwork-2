
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SistemaRecursosHumanos sistema = new SistemaRecursosHumanos();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuar = true;

            while (continuar) {
                mostrarMenu();
                int opcion = leerEntero(scanner, "Seleccione una opcion: ");

                try {
                    switch (opcion) {
                        case 1 -> crearDepartamento(scanner, sistema);
                        case 2 -> modificarDepartamento(scanner, sistema);
                        case 3 -> eliminarDepartamento(scanner, sistema);
                        case 4 -> listarDepartamentos(sistema);
                        case 5 -> crearYAsignarEmpleado(scanner, sistema);
                        case 6 -> actualizarEmpleado(scanner, sistema);
                        case 7 -> eliminarEmpleado(scanner, sistema);
                        case 8 -> reasignarEmpleado(scanner, sistema);
                        case 9 -> mostrarEmpleadosDepartamento(scanner, sistema);
                        case 10 -> generarReporteIndividual(scanner, sistema);
                        case 11 -> generarReporteDepartamento(scanner, sistema);
                        case 0 -> {
                            continuar = false;
                            System.out.println("Saliendo del sistema...");
                        }
                        default -> System.out.println("Opcion no valida.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error de validacion: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error inesperado: " + e.getMessage());
                }
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n===== COMPUWORK - RRHH =====");
        System.out.println("1. Crear departamento");
        System.out.println("2. Modificar departamento");
        System.out.println("3. Eliminar departamento");
        System.out.println("4. Listar departamentos");
        System.out.println("5. Crear y asignar empleado");
        System.out.println("6. Actualizar empleado");
        System.out.println("7. Eliminar empleado");
        System.out.println("8. Reasignar empleado");
        System.out.println("9. Mostrar empleados por departamento");
        System.out.println("10. Generar reporte individual");
        System.out.println("11. Generar reporte por departamento");
        System.out.println("0. Salir");
    }

    private static void crearDepartamento(Scanner scanner, SistemaRecursosHumanos sistema) {
        int id = leerEntero(scanner, "Id departamento: ");
        String nombre = leerTexto(scanner, "Nombre departamento: ");
        sistema.crearDepartamento(new Departamento(id, nombre));
    }

    private static void modificarDepartamento(Scanner scanner, SistemaRecursosHumanos sistema) {
        int id = leerEntero(scanner, "Id departamento a modificar: ");
        String nombre = leerTexto(scanner, "Nuevo nombre: ");
        sistema.modificarDepartamento(id, nombre);
    }

    private static void eliminarDepartamento(Scanner scanner, SistemaRecursosHumanos sistema) {
        int id = leerEntero(scanner, "Id departamento a eliminar: ");
        sistema.eliminarDepartamento(id);
    }

    private static void listarDepartamentos(SistemaRecursosHumanos sistema) {
        System.out.println("\nDepartamentos registrados:");
        for (Departamento d : sistema.listarDepartamentos()) {
            System.out.println("- " + d.getIdDepartamento() + " | " + d.getNombreDepartamento());
        }
    }

    private static void crearYAsignarEmpleado(Scanner scanner, SistemaRecursosHumanos sistema) {
        int idDepartamento = leerEntero(scanner, "Id departamento destino: ");
        int tipo = leerEntero(scanner, "Tipo de empleado (1 = Permanente, 2 = Temporal): ");
        int id = leerEntero(scanner, "Id empleado: ");
        String nombre = leerTexto(scanner, "Nombre empleado: ");
        String cargo = leerTexto(scanner, "Cargo: ");
        double salario = leerDouble(scanner, "Salario: ");

        Empleado empleado = switch (tipo) {
            case 1 -> {
                double bono = leerDouble(scanner, "Bono: ");
                yield new EmpleadoPermanente(id, nombre, cargo, salario, bono);
            }
            case 2 -> {
                int meses = leerEntero(scanner, "Meses de contrato: ");
                yield new EmpleadoTemporal(id, nombre, cargo, salario, meses);
            }
            default -> throw new IllegalArgumentException("Tipo de empleado invalido");
        };

        sistema.asignarEmpleado(idDepartamento, empleado);
    }

    private static void actualizarEmpleado(Scanner scanner, SistemaRecursosHumanos sistema) {
        int idDepartamento = leerEntero(scanner, "Id departamento: ");
        int idEmpleado = leerEntero(scanner, "Id empleado: ");
        String nuevoCargo = leerTexto(scanner, "Nuevo cargo: ");
        double nuevoSalario = leerDouble(scanner, "Nuevo salario: ");
        sistema.actualizarEmpleado(idDepartamento, idEmpleado, nuevoCargo, nuevoSalario);
    }

    private static void eliminarEmpleado(Scanner scanner, SistemaRecursosHumanos sistema) {
        int idDepartamento = leerEntero(scanner, "Id departamento: ");
        int idEmpleado = leerEntero(scanner, "Id empleado a eliminar: ");
        sistema.eliminarEmpleado(idDepartamento, idEmpleado);
    }

    private static void reasignarEmpleado(Scanner scanner, SistemaRecursosHumanos sistema) {
        int idOrigen = leerEntero(scanner, "Id departamento origen: ");
        int idDestino = leerEntero(scanner, "Id departamento destino: ");
        int idEmpleado = leerEntero(scanner, "Id empleado a mover: ");
        sistema.reasignarEmpleado(idOrigen, idDestino, idEmpleado);
    }

    private static void mostrarEmpleadosDepartamento(Scanner scanner, SistemaRecursosHumanos sistema) {
        int idDepartamento = leerEntero(scanner, "Id departamento: ");
        Departamento departamento = sistema.obtenerDepartamento(idDepartamento);
        departamento.mostrarEmpleados();
    }

    private static void generarReporteIndividual(Scanner scanner, SistemaRecursosHumanos sistema) {
        int idDepartamento = leerEntero(scanner, "Id departamento: ");
        int idEmpleado = leerEntero(scanner, "Id empleado: ");
        int calificacion = leerEntero(scanner, "Calificacion (1-10): ");
        String comentarios = leerTexto(scanner, "Comentarios: ");

        Departamento departamento = sistema.obtenerDepartamento(idDepartamento);
        Empleado empleado = departamento.buscarEmpleado(idEmpleado);
        if (empleado == null) {
            throw new IllegalArgumentException("Empleado no encontrado en el departamento indicado");
        }

        ReporteDesempeno reporte = new ReporteDesempeno(empleado, calificacion, comentarios);
        reporte.generarReporte();
    }

    private static void generarReporteDepartamento(Scanner scanner, SistemaRecursosHumanos sistema) {
        int idDepartamento = leerEntero(scanner, "Id departamento: ");
        Departamento departamento = sistema.obtenerDepartamento(idDepartamento);
        ReporteDesempeno.generarReporteDepartamento(departamento);
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero.");
            }
        }
    }

    private static double leerDouble(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }

    private static String leerTexto(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("El texto no puede estar vacio.");
        }
    }
}
