package com.example.taxibooking.command;


import com.example.taxibooking.enums.Gender;
import com.example.taxibooking.enums.UserType;
import com.example.taxibooking.util.AssertValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCommand {
    private String firstName;
    private String email;
    private String phone;
    // private String password;
    private UserType role;
    private Gender gender;
    private String home;
    private String work;
    private String lastLocation;
    private String driverCommand;

    public void validate(){
        AssertValidation.isEmpty(firstName);
        AssertValidation.isEmpty(String.valueOf(gender));
        AssertValidation.isEmail(email);
        AssertValidation.isMobile(phone);
    }
}
