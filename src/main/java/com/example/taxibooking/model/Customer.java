package com.example.taxibooking.model;


import com.example.taxibooking.command.CustomerCommand;
import com.example.taxibooking.enums.Gender;
import com.example.taxibooking.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AbstractEntity{
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
    private Location home;
    @OneToOne
    private Location work;
    @OneToOne
    private Location lastLocation;

    public static Customer createUser(final CustomerCommand customerCommand){
        final Customer customer = new Customer();
        customer.firstName = customerCommand.getFirstName();
        customer.lastName = customerCommand.getLastName();
        customer.email = customerCommand.getEmail();
        customer.phone = customerCommand.getPhone();
        customer.password = customerCommand.getPassword();
        customer.role = customerCommand.getRole();
        customer.gender = customerCommand.getGender();
        customer.home = customerCommand.getHome();
        customer.work = customerCommand.getWork();
        customer.lastLocation = customerCommand.getLastLocation();

        return customer;
    }
}
