package Controller;

import Domain.Customer;
import Repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Assuming you have a CustomerService injected for business logic

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        // You can add business logic in the service layer if needed
        customerRepository.save(customer);
    }

    @GetMapping("/findByName/{name}")
    public List<Customer> getCustomersByName(@PathVariable String name) {
        return customerRepository.findByNameIgnoreCase(name);
    }

}
