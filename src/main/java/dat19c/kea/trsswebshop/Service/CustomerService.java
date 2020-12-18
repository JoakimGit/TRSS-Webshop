package dat19c.kea.trsswebshop.Service;

import dat19c.kea.trsswebshop.Model.Customer;
import dat19c.kea.trsswebshop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new RuntimeException();
        }
        return customer.get();
    }

    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
