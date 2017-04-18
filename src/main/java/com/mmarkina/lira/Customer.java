package com.mmarkina.lira;

import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author mmarkina
 */

@Entity
public class Customer {

    private static final Logger log = LoggerFactory.getLogger(Customer.class);

    @GenericGenerator(
            name = "sequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator"
    )
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "sequenceGenerator")
    private Long id;
    private String firstName;
    private String lastName;
    private String fathersName;
    private String position;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private Date birthday;


    protected Customer() {
    }

    public Customer(String firstName, String lastName, String fathersName, String position, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fathersName = fathersName;
        this.position = position;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", position='" + position + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public String getPosition() {
        return position;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

