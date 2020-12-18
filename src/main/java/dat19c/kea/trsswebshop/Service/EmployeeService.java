package dat19c.kea.trsswebshop.Service;

import dat19c.kea.trsswebshop.Model.Employee;
import dat19c.kea.trsswebshop.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new RuntimeException();
        }
        return employee.get();
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
