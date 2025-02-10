package net.singh.journalApp.controller;

import lombok.extern.slf4j.Slf4j;
import net.singh.journalApp.entity.User;
import net.singh.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Health is OK";
    }


    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            userService.saveNewEntry(user);
            return new ResponseEntity<>("User Created Successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error while creating user: ", e);
            return new ResponseEntity<>("Failed to Create User", HttpStatus.BAD_REQUEST);
        }
    }
}