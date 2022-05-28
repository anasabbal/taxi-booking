package com.example.taxibooking.model;


import com.example.taxibooking.command.DriverCommand;
import com.example.taxibooking.enums.DriverStatus;
import com.example.taxibooking.enums.DriverType;
import com.example.taxibooking.enums.Rating;
import com.google.maps.FindPlaceFromTextRequest;
import com.google.maps.model.AddressComponent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.remoting.support.DefaultRemoteInvocationExecutor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends AbstractEntity{

    private LocalDateTime startDriveWithClient;
    private LocalDateTime endTimeWithClient;
    @Enumerated(EnumType.STRING)
    private DriverStatus status;

    @Enumerated(EnumType.STRING)
    private DriverType driverType;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @OneToOne
    private Location lastLocation;

    @OneToOne
    private Location direction;

    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings; // bookings that the driver actually drove

    @ManyToMany(mappedBy = "notifiedDrivers", cascade = CascadeType.PERSIST)
    private Set<Booking> acceptableBookings = new HashSet<>(); // bookings that the driver can currently accept

    private Boolean isAvailable;

    public static Driver createDriver(final DriverCommand driverCommand){
        final Driver driver = new Driver();

        driver.startDriveWithClient = driverCommand.getStartDriveWithClient();
        driver.endTimeWithClient = driverCommand.getEndTimeWithClient();
        driver.status = driverCommand.getStatus();
        driver.driverType = driverCommand.getDriverType();
        driver.lastLocation = driverCommand.getLastLocation();
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
