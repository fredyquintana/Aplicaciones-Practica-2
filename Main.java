import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Create an hourly employee
            System.out.println("Enter the name of the hourly employee:");
            String nombrePorHora = scanner.nextLine();
            System.out.println("Enter hourly wage:");
            double salarioPorHora = scanner.nextDouble();
            System.out.println("Enter hours worked:");
            int horasTrabajadas = scanner.nextInt();
            System.out.println("Enter the value per hour:");
            double valorHora = scanner.nextDouble();
            

            Empleado empleadoPorHora = new EmpleadoPorHora(nombrePorHora, salarioPorHora, horasTrabajadas, valorHora);
            System.out.println("The employee's hourly wage is: " + empleadoPorHora.calcularSalario());
        } catch (SalarioInvalidoException e) {
            System.out.println("Mistake: " + e.getMessage());
        }

        // Create a salaried employee
        System.out.println("--------------------------------------------");
        System.out.println("Enter the name of the salaried employee:");
        String nombreAsalariado = scanner.next();
        System.out.println("Enter monthly salary:");
        double salarioAsalariado = scanner.nextDouble();
        System.out.println("Enter the days worked in the month:");
        int diasTrabajados = scanner.nextInt();

        Empleado empleadoAsalariado = new EmpleadoAsalariado(nombreAsalariado, salarioAsalariado, diasTrabajados);
        System.out.println("The salary of the salaried employee is: " + empleadoAsalariado.calcularSalario());

        // Step 5: If the employee is of type SalariedEmployee, calculate the bonus if it implements the Bonusable interface
        if (empleadoAsalariado instanceof Bonificable) {
            Bonificable bonificable = (Bonificable) empleadoAsalariado;
            double bonificacion = bonificable.calcularBonificacion();
            System.out.println("The salaried employee's bonus is: " + bonificacion);
        }

        scanner.close();
    }
}
