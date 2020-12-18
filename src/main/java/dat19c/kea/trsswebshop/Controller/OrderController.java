package dat19c.kea.trsswebshop.Controller;

import dat19c.kea.trsswebshop.Model.*;
import dat19c.kea.trsswebshop.Service.CustomerService;
import dat19c.kea.trsswebshop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Scope("request")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerService customerService;

    @Autowired
    Cart cart;

    @GetMapping("/ordre")
    public String showOrders(Model model) {
        model.addAttribute("orders", orderService.findOrders());
        return "/order/order_overview";
    }

    @GetMapping("/opretOrdre")
    public String createOrder() {
        Order order = new Order();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        Customer customer = customerService.findByUsername(username);

        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String today = currentDate.format(formatter);

        order.setDateTime(today);
        order.setTotalPrice(cart.getTotalPrice());
        order.setStatus("Afventer");
        order.setCustomer(customer);

        for (Product p : cart.getProducts()) {
            OrderLineItem oli = new OrderLineItem(p.getName(), p.getPrice());
            order.addOrderLineItem(oli);
        }
        
        orderService.save(order);
        return "redirect:/ordre";
    }
}
