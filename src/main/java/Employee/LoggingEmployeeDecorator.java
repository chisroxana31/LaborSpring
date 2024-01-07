package Employee;

public class LoggingEmployeeDecorator implements Employee {

    private Employee decoratedEmployee = null;



    public LoggingEmployeeDecorator(Domain.Employee employee) {
        this.decoratedEmployee = decoratedEmployee;
    }

    @Override
    public String getName() {
        // Additional behavior (logging) before calling the decorated employee
        System.out.println("Logging: Employee name retrieval...");

        // Call the decorated employee
        String name = decoratedEmployee.getName();

        // Additional behavior (logging) after calling the decorated employee
        System.out.println("Logging: Employee name retrieved: " + name);

        return name;
    }

}
