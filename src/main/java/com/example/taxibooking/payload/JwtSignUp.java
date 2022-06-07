package com.example.taxibooking.payload;

import com.example.taxibooking.enums.Gender;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class JwtSignUp {
    private String firstName;
    private String email;
    private String password;
    private Gender gender;
}
