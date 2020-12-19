package dat19c.kea.trsswebshop.Controller;

import dat19c.kea.trsswebshop.Model.Customer;
import dat19c.kea.trsswebshop.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/kunder")
    public String showCustomer(Model model) {
        model.addAttribute("customers", customerService.findCustomers());
        return "/customer/customer_overview";
    }

    @GetMapping("/kunde/opret")
    public String createCustomer() {
        return "/customer/customer_create";
    }

    @PostMapping("/kunde/opret")
    public String createCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/kunder";
    }

    @GetMapping("/rediger/kunde/{id}")
    public String editCustomer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/customer_edit";
    }

    @PostMapping("/rediger/kunde")
    public String editCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/kunder";
    }

    @GetMapping("/slet/kunde/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.delete(id);
        return "redirect:/kunder";
    }
}
