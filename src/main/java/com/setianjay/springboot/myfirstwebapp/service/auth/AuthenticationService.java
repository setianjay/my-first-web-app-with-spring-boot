package com.setianjay.springboot.myfirstwebapp.service.auth;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


    public boolean auth(String username, String password){
        return username.equals("setianjay") && password.equals("12345");
    }
}
