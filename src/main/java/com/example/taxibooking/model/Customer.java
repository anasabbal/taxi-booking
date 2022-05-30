package com.example.taxibooking.model;


import com.example.taxibooking.command.CustomerCommand;
import com.example.taxibooking.enums.Gender;
import com.example.taxibooking.enums.UserType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class Customer{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType role;

    @ManyToOne
    private Driver driver;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne
    private ExactLocation home;
    @OneToOne
    private ExactLocation work;
    @OneToOne
    private ExactLocation lastKnownLocation;

    /*@OneToOne
    private ExactLocation home;
    @OneToOne
    private ExactLocation work;*/
    public static Customer createUser(final CustomerCommand customerCommand){
        final Customer customer = new Customer();
        customer.firstName = customerCommand.getFirstName();
        customer.lastName = customerCommand.getLastName();
        customer.email = customerCommand.getEmail();
        customer.phone = customerCommand.getPhone();
        customer.password = customerCommand.getPassword();
        customer.role = customerCommand.getRole();
        customer.gender = customerCommand.getGender();
        //customer.home = customerCommand.getHome();
        //customer.work = customerCommand.getWork();

        return customer;
    }
    public void update(final CustomerCommand customerCommand){
        this.firstName = customerCommand.getFirstName();
        this.lastName = customerCommand.getLastName();
        this.email = customerCommand.getEmail();
        this.phone = customerCommand.getPhone();
    }
}
