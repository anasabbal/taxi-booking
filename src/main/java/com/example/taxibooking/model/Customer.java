package com.example.taxibooking.model;


import com.example.taxibooking.command.CustomerCommand;
import com.example.taxibooking.command.DriverCommand;
import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.enums.Gender;
import com.example.taxibooking.enums.UserType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer extends AbstractEntity{

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    private String firstName;
    private String email;
    private String phone;
    @ManyToOne(cascade = CascadeType.ALL)
    private Driver driver;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne
    private ExactLocation home;
    @OneToOne
    private ExactLocation work;
    @OneToOne
    private ExactLocation lastKnownLocation;

    @ManyToOne
    private NotificationCustomer notificationCustomer;

    public static Customer createUser(final CustomerCommand customerCommand,
                                      final ExactLocation home,
                                      final ExactLocation work ,
                                      final ExactLocation lastKnownLocation, final Driver driver){
        final Customer customer = new Customer();
        customer.firstName = customerCommand.getFirstName();
        customer.email = customerCommand.getEmail();
        customer.phone = customerCommand.getPhone();
        customer.gender = customerCommand.getGender();
        customer.work = work;
        customer.home = home;
        customer.lastKnownLocation = lastKnownLocation;
        customer.driver = driver;

        return customer;
    }
    public void linkToNotification(NotificationCustomer notificationCustomer){
        this.notificationCustomer  = notificationCustomer;
    }
    public void linkToDriver(Driver driver){
        this.driver = driver;
    }
    public void linkToHomeLocation(ExactLocation home){
        this.home = home;
    }
    public void linkToWorkLocation(ExactLocation work){
        this.work = work;
    }
    public void linkToLastLocation(ExactLocation lastKnownLocation){
        this.lastKnownLocation = lastKnownLocation;
    }
    public void update(final CustomerCommand customerCommand){
        this.firstName = customerCommand.getFirstName();
        this.email = customerCommand.getEmail();
    }
}
