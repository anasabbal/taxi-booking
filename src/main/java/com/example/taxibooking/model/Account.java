package com.example.taxibooking.model;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account extends AbstractEntity{

    private String email;
    private String password;
}
