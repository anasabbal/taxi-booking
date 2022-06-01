package com.example.taxibooking.model;


import com.example.taxibooking.command.DriverCommand;
import com.example.taxibooking.enums.DriverStatus;
import com.example.taxibooking.enums.DriverType;
import com.example.taxibooking.enums.Rating;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Driver extends AbstractEntity{

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    @Enumerated(EnumType.STRING)
    private DriverStatus status = DriverStatus.DENIED;
    @Enumerated(EnumType.STRING)
    private DriverType driverType = DriverType.TAXI;

    @Enumerated(EnumType.STRING)
    private Rating rating;
    @OneToOne
    private ExactLocation lastKnownLocation;
    @OneToOne
    private ExactLocation home;
    private Boolean isAvailable;

    @ManyToOne
    private NotificationDriver notificationDriver;

    public Driver(){

    }
    public static Driver createDriver(final DriverCommand driverCommand, final ExactLocation lastLocation, final ExactLocation home){
        final Driver driver = new Driver();

        driver.status = driverCommand.getStatus();
        driver.driverType = driverCommand.getDriverType();
        driver.lastKnownLocation = lastLocation;
        driver.home = home;
        driver.driverType = driverCommand.getDriverType();

        return driver;
    }
    public void setIsAvailable(Boolean available){
        if(available && !status.equals(DriverStatus.APPROVED)){
            throw new RuntimeException("Driver approved");
        }
        isAvailable = available;
        //return isAvailable;
    }
    public void acceptRequest(Customer customer){
        this.status = DriverStatus.APPROVED;
        this.notificationDriver.linkToCustomer(customer);
    }
    public void cancelRequest(Customer customer){
        this.status = DriverStatus.DENIED;
        this.notificationDriver.getCustomers().remove(customer);
    }
    public void linkToLastLocation(ExactLocation lastKnownLocation){
        this.lastKnownLocation = lastKnownLocation;
    }
    public void linkToHomeLocation(ExactLocation home){
        this.home = home;
    }
    public void linkToNotificationDriver(NotificationDriver notificationDriver){
        this.notificationDriver = notificationDriver;
    }
}
