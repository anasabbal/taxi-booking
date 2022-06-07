package com.example.taxibooking.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface AssertValidation {

    // digit + lowercase char + uppercase char + punctuation + symbol
    public static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    static boolean isMobile(String value){
        // The number should be of 10 digits.
        // Creating a Pattern class object
        Pattern p = Pattern.compile("^\\d{10}$");
        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression for which
        // object of Matcher class is created
        Matcher m = p.matcher(value);

        // Returning boolean value
        if(m.matches()){
            return true;
        }else {
            throw new RuntimeException("");
        }
    }
    static boolean isEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if(matcher.matches()){
            return true;
        }else{
            throw new RuntimeException("");
        }
    }
    static boolean isEmpty(String firstName){
        if(firstName == null){
            throw new RuntimeException();
        }
        return true;
    }
    static boolean isPassword(String password){
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        if(matcher.matches()){
            return true;
        }else{
            throw new RuntimeException();
        }
    }
}
