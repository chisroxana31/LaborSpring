package Service;

import Domain.Customer;
import Repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public void addCustomer(Customer customer) {
        // You can add business logic here before saving if needed
        customerRepository.save(customer);
    }

    // Add additional methods if needed
}