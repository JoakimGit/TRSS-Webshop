package dat19c.kea.trsswebshop.Controller;

import dat19c.kea.trsswebshop.Model.Cart;
import dat19c.kea.trsswebshop.Model.Inventory;
import dat19c.kea.trsswebshop.Model.Product;
import dat19c.kea.trsswebshop.Service.InventoryService;
import dat19c.kea.trsswebshop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("request")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    Cart cart;

    @GetMapping("/produkter/oversigt")
    public String showProduct(Model model) {
        model.addAttribute("products", productService.findProducts());
        return "/product/product_overview";
    }

    @GetMapping("/produkter")
    public String showProductByCategory(@RequestParam String category, Model model) {
        model.addAttribute("products", productService.findByCategory(category));
        return "/product/product_overview_category";
    }

    @GetMapping("/produkt/opret")
    public String createProduct() {
        return "/product/product_create";
    }

    @PostMapping("/produkt/opret")
    public String createProduct(@ModelAttribute Product product, @ModelAttribute Inventory inventory) {
        inventory.calculateStatus();
        inventory.setProduct(product);
        inventoryService.save(inventory);
        return "redirect:/produkter";
    }

    @GetMapping("/rediger/produkt/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/product/product_edit";
    }

    @PostMapping("/rediger/produkt")
    public String editProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/produkter";
    }

    @GetMapping("/slet/produkt/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/produkter";
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        cart.calculateTotal();
        model.addAttribute("cart", cart);
        return "/cart";
    }

    @GetMapping("/addToCart/{id}/{category}")
    public String addToCart(@PathVariable ("id") Long id, @PathVariable("category") String category) {
        Product product = productService.findById(id);
        cart.addToCard(product);
        return "redirect:/cart";
    }

    @GetMapping("/removeFromCart/{id}")
    public String removeFromCart(@PathVariable ("id") Long id) {
        Product product = productService.findById(id);
        cart.removeFromCart(product);
        return "redirect:/cart";
    }
}
