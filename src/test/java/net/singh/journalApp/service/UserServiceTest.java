package net.singh.journalApp.service;

import net.singh.journalApp.entity.User;
import net.singh.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

//    @Test
//    public  void testFindUsername(){
//        assertEquals(4,2+2);
//        assertNotNull(userRepository.findByUsername("Ram"));
//    }

    @Test
    public void findUsername2(){
        User user = userRepository.findByUsername("Ram2");
        assertNotNull(user, "User should not be null");
        assertFalse(user.getJournalEntries().isEmpty(), "Journal entries should not be empty");
    }
}