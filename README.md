# Compuwork-2
## Descripcion
Aplicacion de consola en Java para gestionar empleados, departamentos y reportes de desempeno.

## Funcionalidades implementadas
- CRUD de departamentos: crear, modificar, eliminar y listar.
- Gestion de empleados: crear, actualizar, eliminar, asignar y reasignar.
- Tipos de empleado: permanente y temporal (herencia y polimorfismo).
- Reportes de desempeno: individual y por departamento.
- Manejo de excepciones en operaciones criticas.
- Menu interactivo por consola.

## Estructura del proyecto
- `Empleado.java`
- `EmpleadoPermanente.java`
- `EmpleadoTemporal.java`
- `Departamento.java`
- `ReporteDesempeno.java`
- `SistemaRecursosHumanos.java`
- `Main.java`
- `diagrama-clases.puml`

## Requisitos
- JDK 17+ (probado con JDK 23)

## Compilar y ejecutar
```bash
javac *.java
java Main
```

## Pruebas Unitarias
Se implementaron pruebas unitarias utilizando JUnit para validar el correcto funcionamiento del sistema.

## Diagrama UML
El diagrama del sistema se encuentra debajo de la carpeta Prueba.
