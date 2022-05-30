package com.example.taxibooking.model;


import com.example.taxibooking.command.DriverCommand;
import com.example.taxibooking.enums.DriverStatus;
import com.example.taxibooking.enums.DriverType;
import com.example.taxibooking.enums.Rating;
import com.example.taxibooking.exception.ExceptionPayload;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Driver extends AbstractEntity{

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    @Enumerated(EnumType.STRING)
    private DriverStatus status;
    @Enumerated(EnumType.STRING)
    private DriverType driverType;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;

    @OneToOne
    private Booking activeBooking = null;  // driver.active_booking_id  either be null or be a foreign key

    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings; // bookings that the driver actually drove

    @ManyToMany(mappedBy = "notifiedDrivers", cascade = CascadeType.PERSIST)
    private Set<Booking> acceptableBookings = new HashSet<>(); // bookings that the driver can currently accept

    private Boolean isAvailable;

    public static Driver createDriver(final DriverCommand driverCommand, final ExactLocation lastLocation, final ExactLocation direction){
        final Driver driver = new Driver();

        driver.status = driverCommand.getStatus();
        driver.driverType = driverCommand.getDriverType();
        /*driver.lastLocation = lastLocation;
        driver.direction = direction;*/
        driver.driverType = driverCommand.getDriverType();

        return driver;
    }

    public void setIsAvailable(Boolean available){
        if(available && !status.equals(DriverStatus.APPROVED)){
            throw new RuntimeException("Driver approved ");
        }
        isAvailable = available;
    }
}
