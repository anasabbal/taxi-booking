package com.example.taxibooking.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location extends AbstractEntity{
    private Double latitude;
    private Double longitude;

    public double distanceKm(Location location) {
        final Double R = 6371e3; // metres
        if ((latitude.equals(location.getLatitude())) && (longitude.equals(location.getLongitude()))) {
            return 0;
        }
        double theta = longitude - location.longitude;
        double dist = Math.sin(Math.toRadians(latitude)) *
                Math.sin(Math.toRadians(location.latitude)) +
                Math.cos(Math.toRadians(latitude)) *
                        Math.cos(Math.toRadians(location.latitude)) *
                        Math.cos(Math.toRadians(theta));
        return Math.toDegrees(Math.acos(dist)) * 60 * 1.85316;
    }
}
