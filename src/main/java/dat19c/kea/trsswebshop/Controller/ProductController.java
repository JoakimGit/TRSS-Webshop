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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Scope("request")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    Cart cart;

    @GetMapping("/produkter")
    public String showProduct(Model model) {
        model.addAttribute("products", productService.findProducts());
        return "/product/product_overview";
    }

    @GetMapping("/produkt")
    public String createProduct() {
        return "/product/product_create";
    }

    @PostMapping("/produkt")
    public String createProduct(@ModelAttribute Product product, @ModelAttribute Inventory inventory) {
        inventory.calculateStatus();
        inventory.setProduct(product);
        inventoryService.save(inventory);
        //productService.save(product);
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

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable ("id") Long id) {
        Product product = productService.findById(id);
        cart.addToCard(product);
        return "redirect:/produkter";
    }

    @GetMapping("/removeFromCart/{id}")
    public String removeFromCart(@PathVariable ("id") Long id) {
        Product product = productService.findById(id);
        cart.removeFromCart(product);
        return "redirect:/cart";
    }
}
