package Service;

import Domain.Employee;
import Domain.LoggingEmployeeDecorator;
import Repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Employee getEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }


    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    public void updateEmployee(int employeeId, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setName(updatedEmployee.getName());
            employeeRepository.save(existingEmployee);
        }
    }


    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }


    public String getEmployeeName(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            LoggingEmployeeDecorator loggingEmployee = new LoggingEmployeeDecorator(employee);

            // Access the employee's name (this will print log messages)
            String employeeName = loggingEmployee.getName();
            return "Employee's name: " + employeeName;
        }
        return null;
    }

}
