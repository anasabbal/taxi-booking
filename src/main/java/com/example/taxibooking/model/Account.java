package com.example.taxibooking.model;


import com.example.taxibooking.enums.UserType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Account extends AbstractEntity{

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType role;
}
