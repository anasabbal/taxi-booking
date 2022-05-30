package com.example.taxibooking.model;


import com.example.taxibooking.command.LocationCommand;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class ExactLocation extends AbstractEntity{
    private Double latitude;
    private Double longitude;


    public static ExactLocation createLocation(final LocationCommand locationCommand){
        final ExactLocation exactLocation = new ExactLocation();
        exactLocation.longitude = locationCommand.getLongitude();
        exactLocation.latitude = locationCommand.getLatitude();

        return exactLocation;
    }

    public double distanceKm(ExactLocation exactLocation) {
        final Double R = 6371e3; // metres
        if ((latitude.equals(exactLocation.getLatitude())) && (longitude.equals(exactLocation.getLongitude()))) {
            return 0;
        }
        double theta = longitude - exactLocation.longitude;
        double dist = Math.sin(Math.toRadians(latitude)) *
                Math.sin(Math.toRadians(exactLocation.latitude)) +
                Math.cos(Math.toRadians(latitude)) *
                        Math.cos(Math.toRadians(exactLocation.latitude)) *
                        Math.cos(Math.toRadians(theta));
        return Math.toDegrees(Math.acos(dist)) * 60 * 1.85316;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
