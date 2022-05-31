package com.example.taxibooking.payload;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String email;
    private List<String> roles;
}
