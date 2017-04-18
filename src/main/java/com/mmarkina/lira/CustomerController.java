package com.mmarkina.lira;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @PostMapping("/customer")
    public String submitCustomer(@ModelAttribute Customer customer) {
        repository.save(customer);
        return "result";
    }

    @GetMapping("/findCustomers")
    public String findCustomers(Model model) {
        return "findCustomers";
    }

    @PostMapping("/findCustomers")
    public String resultFind(Model model, @RequestParam Customer customer) {
        log.info("findCustomer");
        log.info("birthday = " + customer.getBirthday());
//        model.addAttribute("customers", repository.searchFilter(customer));
        model.addAttribute("customers", repository.findAll());
        return "findCustomers";
    }
}
