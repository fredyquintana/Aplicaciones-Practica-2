// Step 1: Creating the Employee Abstract Class
abstract class Empleado {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    // Paso 5: Uso del Polimorfismo
    public abstract double calcularSalario();
}

// Step 2: Creation of the HourlyEmployee and SalariedEmployee Classes
class EmpleadoPorHora extends Empleado {
    private int horasTrabajadas;
    private double valorHora;

    public EmpleadoPorHora(String nombre, double salario, int horasTrabajadas, double valorHora) {
        super(nombre, salario);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
        validarSalario();
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * valorHora;
    }
    //Step 6: Exception Handling
    private void validarSalario() {
        if (salario <= 0) {

            throw new SalarioInvalidoException("Invalid wage for hourly employee");
        }
    }
}

class EmpleadoAsalariado extends Empleado implements Bonificable {
    private int diasTrabajados;

    public EmpleadoAsalariado(String nombre, double salario, int diasTrabajados) {
        super(nombre, salario);
        this.diasTrabajados = diasTrabajados;
        validarSalario();
    }

    @Override
    public double calcularSalario() {
        return salario / 30 * diasTrabajados;
    }

    @Override
    public double calcularBonificacion() {
        // Implement bonus logic here
        return 0;
    }
//Step 6: Exception Handling
    private void validarSalario() {
        if (salario <= 0) {
            throw new SalarioInvalidoException("Invalid salary for salaried employee");
        }
    }
}

// Step 3: Implementation of the Bonus Interface
interface Bonificable {
    double calcularBonificacion();
}

// Step 4: Using Exceptions
class SalarioInvalidoException extends RuntimeException {
    public SalarioInvalidoException(String mensaje) {
        super(mensaje);
    }
}



