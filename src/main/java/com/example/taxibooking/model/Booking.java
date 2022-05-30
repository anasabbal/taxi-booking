package com.example.taxibooking.model;


import com.example.taxibooking.enums.DriverApproveStatus;
import com.example.taxibooking.exception.InvalidActionForBookingStateException;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Booking extends AbstractEntity{

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Driver driver;

    private DriverApproveStatus status;

    private Date startTime; // actual start time

    private Date endTime; // actual end time
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Driver> notifiedDrivers = new HashSet<>(); // store which drivers can potentially accept this booking


    public void startRide(){
        startTime = new Date();
        customer.setActiveBooking(null);
        driver.setActiveBooking(null);

        status = DriverApproveStatus.IN_RIDE;
    }
    public void endRide(){
        if(status.equals(DriverApproveStatus.IN_RIDE)){
            throw new RuntimeException("The ride hasn't started yet");
        }
        driver.setActiveBooking(null);
        endTime = new Date();
        customer.setActiveBooking(null);
        status = DriverApproveStatus.COMPLETED;
    }
    public boolean needsDriver() {
        return status.equals(DriverApproveStatus.ASSIGNING_DRIVER);
    }
    public void cancel() {
        if (!(status.equals(DriverApproveStatus.REACHING_PICKUP_LOCATION)
                || status.equals(DriverApproveStatus.ASSIGNING_DRIVER)
                || status.equals(DriverApproveStatus.SCHEDULED)
                || status.equals(DriverApproveStatus.CAB_ARRIVED))) {
            throw new InvalidActionForBookingStateException("Cannot cancel the booking now.");
        }
        status = DriverApproveStatus.CANCELLED;
        driver = null;
        notifiedDrivers.clear();
    }
}
