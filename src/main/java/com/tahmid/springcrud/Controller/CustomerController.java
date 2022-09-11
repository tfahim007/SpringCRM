package com.tahmid.springcrud.Controller;

import com.tahmid.springcrud.Entity.Customer;
import com.tahmid.springcrud.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Tahmidul Islam
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO;
    @RequestMapping("/list")
    public String listCustomers(Model theModel){
        List<Customer> theCustomers = customerDAO.getCustomers();
        theModel.addAttribute("customers",theCustomers);
        return "list-customer";
    }
}
