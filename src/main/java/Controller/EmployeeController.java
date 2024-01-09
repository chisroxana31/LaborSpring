package Controller;

import Domain.Employee;
import Domain.LoggingEmployeeDecorator;
import Repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

//    private final Employee employee;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("getAll")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }
//
    @PutMapping("/{employeeId}")
    public void updateEmployee(@PathVariable int employeeId, @RequestBody Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setName(updatedEmployee.getName());
            employeeRepository.save(existingEmployee);
        }
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeRepository.deleteById(employeeId);
    }


    @GetMapping("/getEmployeeName/{employeeId}")
    public String getEmployeeName(@PathVariable int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        // Use the logging decorator for the employee
        if (employee != null) {
            LoggingEmployeeDecorator loggingEmployee = new LoggingEmployeeDecorator(employee);

            // Access the employee's name (this will print log messages)
            String employeeName = loggingEmployee.getName();
            return "Employee's name: " + employeeName;
        }
        return null;
    }
}
