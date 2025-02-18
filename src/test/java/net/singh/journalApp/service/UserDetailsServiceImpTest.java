package net.singh.journalApp.service;

import net.singh.journalApp.entity.User;
import net.singh.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UserDetailsServiceImpTest {

    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;

    @Mock
    private UserRepository userRepository;

    @Test
    void loadUserNameTest() {
        when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("ram").password("xyz").role(new ArrayList<>()).build());
        UserDetails userDetails = userDetailsServiceImp.loadUserByUsername("Ram");
        Assertions.assertNotNull(userDetails);
    }
}
