package com.mmarkina.lira;

import java.util.List;


/**
 * @author mmarkina
 */
public interface CustomCustomerRepository {
    List<Customer> searchFilter(Customer customer);
}
