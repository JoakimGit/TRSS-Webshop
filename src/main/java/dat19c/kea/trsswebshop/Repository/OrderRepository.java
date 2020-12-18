package dat19c.kea.trsswebshop.Repository;

import dat19c.kea.trsswebshop.Model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
