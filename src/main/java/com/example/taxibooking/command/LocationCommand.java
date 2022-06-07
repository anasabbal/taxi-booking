package com.example.taxibooking.command;


import com.example.taxibooking.util.AssertValidation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationCommand{
    private Double latitude;
    private Double longitude;


    public void validate(){
        AssertValidation.isEmpty(String.valueOf(latitude));
        AssertValidation.isEmpty(String.valueOf(latitude));
    }
}
