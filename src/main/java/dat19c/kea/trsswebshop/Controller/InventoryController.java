package dat19c.kea.trsswebshop.Controller;

import dat19c.kea.trsswebshop.Model.Inventory;
import dat19c.kea.trsswebshop.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/lager")
    public String showInventory(Model model) {
        model.addAttribute("inventory", inventoryService.findInventory());
        return "/inventory/inventory_overview";
    }

    @PostMapping("/lager/tilfoej")
    public String addExtraInventory(WebRequest request) {
        Long productID = Long.valueOf(request.getParameter("product_id"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        Inventory productInventory = inventoryService.findById(productID);
        productInventory.setQuantity(productInventory.getQuantity() + amount);
        productInventory.calculateStatus();
        inventoryService.save(productInventory);
        return "redirect:/lager";
    }
}
