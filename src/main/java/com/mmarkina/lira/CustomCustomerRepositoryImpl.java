package com.mmarkina.lira;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * @author mmarkina
 */
public class CustomCustomerRepositoryImpl implements CustomCustomerRepository {
    private static final Logger log = LoggerFactory.getLogger(CustomCustomerRepository.class);

    public List<Customer> searchFilter(Customer customer) {
        log.info(">>>>>>>>>>>>>>>>>>>>");
        String query = "SELECT * FROM customer WHERE ";
        query += addPartOfQuery(customer.getFirstName(), "firstName");
        query += addPartOfQuery(customer.getLastName(), "lastName");
        query += addPartOfQuery(customer.getFathersName(), "fathersName");
        query += addPartOfQuery(customer.getPosition(), "position");
        if(customer.getBirthday() != null) {
            query += " birthday = '" + new SimpleDateFormat("yyyy-MM-dd").format(customer.getBirthday()) + "'";
        } else {
            query += "0 = 0";
        }
        log.info(query);
        return new ArrayList<>();

    }

    private String addPartOfQuery(String value, String paramName) {
        if (value == null || "".equals(value)) {
            return "";
        }

        return paramName + " LIKE '%" + value + "%' AND ";

    }

}
