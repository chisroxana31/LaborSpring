package Controller;

import Domain.Customer;
import Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable int customerId, @RequestBody Customer updatedCustomer) {
        customerService.updateCustomer(customerId, updatedCustomer);
    }

}
