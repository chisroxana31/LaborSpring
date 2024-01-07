package Domain;

public class LoggingEmployeeDecorator implements Person {

    private Employee decoratedEmployee = null;



    public LoggingEmployeeDecorator(Employee employee) {
        this.decoratedEmployee = employee;
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
