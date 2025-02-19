package net.singh.journalApp.service;

import net.singh.journalApp.entity.User;
import net.singh.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

//@SpringBootTest  -> This will commented because we don;t want to load other controls and all. Avoid Any type of connection
public class UserDetailsServiceImpTest {

//    @Autowired -> We making a component/Bean that's why we use @MockBean
//    private UserDetailsServiceImp userDetailsServiceImp;

//    @MockBean
//    private UserRepository userRepository;


    @InjectMocks
    private UserDetailsServiceImp userDetailsServiceImp;

    @Mock
    private UserRepository userRepository;

//    Initializing the mocks
//    UserRepository initialized and inject into UserDetailsServiceImp
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserNameTest() {
        when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("hey").password("xyz").role(new ArrayList<>()).build());
        UserDetails userDetails = userDetailsServiceImp.loadUserByUsername("loadCheckRam");
        Assertions.assertNotNull(userDetails);
    }
}