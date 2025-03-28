package net.singh.journalApp.service;

import net.singh.journalApp.entity.User;
import net.singh.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public static final Logger logger = LoggerFactory.getLogger(UserService.class);


    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean saveNewEntry(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            logger.info("HEHHAHAHAHAHAH");
            return false;
        }
    }

        public void saveAdminUser (User user){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER", "ADMIN"));
            userRepository.save(user);
        }

        public void saveUser (User user){
            userRepository.save(user);
        }


        public List<User> getAll () {
            return userRepository.findAll();
        }

        public Optional<User> findById (ObjectId id){
            return userRepository.findById(id);
        }

        public void deleteById (ObjectId id){
            userRepository.deleteById(id);
        }

        public void deleteByUserName (String username){
            userRepository.deleteByUsername(username);
        }

        public User findByUsername (String username){
            return userRepository.findByUsername(username);
        }
    }