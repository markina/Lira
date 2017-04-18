package com.mmarkina.lira;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author mmarkina
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>, CustomCustomerRepository {
    List<Customer> findAll();
}
