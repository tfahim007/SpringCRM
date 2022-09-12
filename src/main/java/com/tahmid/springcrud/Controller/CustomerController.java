package com.tahmid.springcrud.Controller;

import com.tahmid.springcrud.Entity.Customer;
import com.tahmid.springcrud.dao.CustomerDAO;
import com.tahmid.springcrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
