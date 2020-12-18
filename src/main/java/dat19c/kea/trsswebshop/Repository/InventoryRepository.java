package dat19c.kea.trsswebshop.Repository;

import dat19c.kea.trsswebshop.Model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
}
