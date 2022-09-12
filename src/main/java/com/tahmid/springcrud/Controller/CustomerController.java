package com.tahmid.springcrud.Controller;

import com.tahmid.springcrud.Entity.Customer;
import com.tahmid.springcrud.dao.CustomerDAO;
import com.tahmid.springcrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tahmidul Islam
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel){
        List<Customer> theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers",theCustomers);
        return "list-customer";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Customer customer = new Customer();
        theModel.addAttribute("customer",customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel){
        System.out.println("===========BREAK==========");
        Customer theCustomer = customerService.getCustomer(theId);
        System.out.println(theCustomer.toString());
        theModel.addAttribute("customer",theCustomer);

        return "customer-form";
    }


}
