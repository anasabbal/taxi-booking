package com.example.taxibooking.command;


import com.example.taxibooking.enums.Gender;
import com.example.taxibooking.enums.UserType;
import com.example.taxibooking.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCommand {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private UserType role;
    //private Set<Driver> driver;
    private Gender gender;
    private Location home;
    private Location work;
    private Location lastLocation;
}
