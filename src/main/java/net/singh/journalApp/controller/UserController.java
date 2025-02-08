package net.singh.journalApp.controller;


import net.singh.journalApp.entity.User;
import net.singh.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userInDB = userService.findByUsername(username);
        userInDB.setUsername(user.getUsername());
        userInDB.setPassword(user.getPassword());
        userService.saveEntry(userInDB);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Fix the comment line
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteUser(@RequestBody User user, @PathVariable ObjectId id){
//        userService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    //    @DeleteMapping
//    public ResponseEntity<?> deleteUserById() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        userRepository.deleteByUserName(authentication.getName());
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//    @DeleteMapping
//    public ResponseEntity<?> deleteByUserName() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        userService.deleteByUserName(authentication.getName());
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteByUserName2(@PathVariable String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userService.deleteByUserName(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}