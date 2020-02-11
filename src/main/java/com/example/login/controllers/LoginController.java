package com.example.login.controllers;

import com.example.login.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
public class LoginController {


    @PostMapping("/test/login")
    public ResponseEntity<String> login(@RequestBody Account account) {
        if(!account.getUsername().equals("admin")) {
            return new ResponseEntity<>("Incorrect Username",HttpStatus.UNAUTHORIZED);
        }
        if (!account.getPassword().equals("password")) {
            return new ResponseEntity<>("Incorrect password",HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

}
