package dat19c.kea.trsswebshop.Controller;

import dat19c.kea.trsswebshop.Model.*;
import dat19c.kea.trsswebshop.Service.CustomerService;
import dat19c.kea.trsswebshop.Service.OrderService;
import dat19c.kea.trsswebshop.Utils.HelperMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/ordre/opret")
    public String createOrder() {
        String username = HelperMethods.getLoggedUsername();
        Customer customer = customerService.findByUsername(username);

        Order order = new Order();
        order.setDateTime(HelperMethods.getCurrentDate());
        order.setTotalPrice(cart.getTotalPrice());
        order.setStatus("Afventer");
        order.setCustomer(customer);

        for (Product p : cart.getProducts()) {
            OrderLineItem oli = new OrderLineItem(p.getName(), p.getPrice());
            order.addOrderLineItem(oli);
        }
        
        orderService.save(order);
        cart.clearCart();
        return "redirect:/ordre";
    }


}
