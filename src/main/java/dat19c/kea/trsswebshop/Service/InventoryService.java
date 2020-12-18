package dat19c.kea.trsswebshop.Service;

import dat19c.kea.trsswebshop.Model.Inventory;
import dat19c.kea.trsswebshop.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public void save(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    public List<Inventory> findInventory() {
        return (List<Inventory>) inventoryRepository.findAll();
    }

    public Inventory findById(Long id) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);
        if (inventory.isEmpty()) {
            throw new RuntimeException();
        }
        return inventory.get();
    }
}
