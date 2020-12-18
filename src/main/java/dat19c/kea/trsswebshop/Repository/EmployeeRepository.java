package dat19c.kea.trsswebshop.Repository;

import dat19c.kea.trsswebshop.Model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
