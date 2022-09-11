package com.tahmid.springcrud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tahmidul Islam
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/list")
    public String listCustomers(Model theModel){
        return "list-customer";
    }
}
