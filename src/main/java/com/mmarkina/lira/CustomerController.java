package com.mmarkina.lira;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author mmarkina
 */
@Controller
public class CustomerController {

    CustomerRepository repository;
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);


    @Autowired
    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customer")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }
}
