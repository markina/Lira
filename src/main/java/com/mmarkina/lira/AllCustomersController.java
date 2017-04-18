package com.mmarkina.lira;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


/**
 * @author mmarkina
 */
@Controller
public class AllCustomersController {

    private CustomerRepository repository;
    private static final Logger log = LoggerFactory.getLogger(AllCustomersController.class);

    @Autowired
    public void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/allCustomers")
    @ModelAttribute("customers")
    public List<Customer> allCustomers(Model model) {
        return repository.findAll();
    }

}
