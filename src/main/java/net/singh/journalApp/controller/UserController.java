package net.singh.journalApp.controller;


import lombok.extern.slf4j.Slf4j;
import net.singh.journalApp.entity.User;
import net.singh.journalApp.service.JournalEntryService;
import net.singh.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            userService.saveEntry(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("e: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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

    // Fix the comment line
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteUser(@RequestBody User user, @PathVariable ObjectId id){
//        userService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}