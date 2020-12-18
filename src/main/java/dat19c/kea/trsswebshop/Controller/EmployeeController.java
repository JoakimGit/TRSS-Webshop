package dat19c.kea.trsswebshop.Controller;

import dat19c.kea.trsswebshop.Model.Customer;
import dat19c.kea.trsswebshop.Model.Employee;
import dat19c.kea.trsswebshop.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/medarbejdere")
    public String showEmployee(Model model) {
        model.addAttribute("employees", employeeService.findEmployees());
        return "/employee/employee_overview";
    }

    @GetMapping("/medarbejder")
    public String createEmployee() {
        return "/employee/employee_create";
    }

    @PostMapping("/medarbejder")
    public String createEmployee(@ModelAttribute Employee employee) {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String today = currentDate.format(formatter);
        employee.setHireDate(today);
        employeeService.save(employee);
        return "redirect:/medarbejdere";
    }

    @GetMapping("/rediger/medarbejder/{id}")
    public String editCustomerEmployee(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/employee_edit";
    }

    @PostMapping("/rediger/medarbejder")
    public String editEmployee(@ModelAttribute Employee employee) {
        Employee employee1 = employeeService.findById(employee.getEmployee_id());
        employee.setHireDate(employee1.getHireDate());
        employeeService.save(employee);
        return "redirect:/medarbejdere";
    }

    @GetMapping("/slet/medarbejder/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delete(id);
        return "redirect:/medarbejdere";
    }
}
