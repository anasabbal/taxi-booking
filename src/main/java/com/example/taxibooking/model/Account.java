package com.example.taxibooking.model;



import com.example.taxibooking.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account extends AbstractEntity{

    private String email;
    private String password;
    private UserType userType;
}
