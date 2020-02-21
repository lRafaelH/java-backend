package com.example.login.controllers;
import com.example.login.model.Account;
import com.example.login.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final AccountService accountService;


    @PostMapping("/test/register")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        Optional<Account> check = accountService.findAccount(account.getUsername());

        if (!check.isPresent()) {
            accountService.addAccount(account);
            return new ResponseEntity<>("Successfully Registered", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/test/login")
    public ResponseEntity<String> findAccount(@RequestBody Account account) {
        Optional<Account> user = accountService.findAccount(account.getUsername());
        if (user.isPresent() && user.get().getPassword().equals(account.getPassword())) {
            return new ResponseEntity<>("Login Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login Failed",HttpStatus.UNAUTHORIZED);
        }
    }

}







