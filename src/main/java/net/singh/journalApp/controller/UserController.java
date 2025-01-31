package net.singh.journalApp.controller;


import net.singh.journalApp.entity.User;
import net.singh.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveEntry(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String username) {
        User uesrInDB = userService.findByUsername(username);
        if (uesrInDB != null) {
            uesrInDB.setUsername(user.getUsername());
            uesrInDB.setPassword(user.getPassword());
            userService.saveEntry(uesrInDB);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}