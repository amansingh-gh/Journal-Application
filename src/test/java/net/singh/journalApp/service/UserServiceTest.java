package net.singh.journalApp.service;

import net.singh.journalApp.entity.User;
import net.singh.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

/*
    @Test
    public  void testFindUsername(){
        assertEquals(4,2+2);
        assertNotNull(userRepository.findByUsername("Ram"));
    }
*/

    @Disabled
    @Test
    public void findUsername2() {
        User user = userRepository.findByUsername("Vipul");
//        assertNotNull(user, "User should not be null");
        assertTrue(!user.getJournalEntries().isEmpty(), "Journal entries should not be empty");
    }

/*
    //    Parameterized Testing
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "3,4,9"
    })
    public void paraTest(int a, int b, int expected) {
        assertEquals(expected, a + b, "Failed for: " + expected);
    }
*/

    //    ArgumentSource Test
    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    public void testSaveNewUser(User user) {
        assertTrue(userService.saveNewEntry(user));
    }


    /*  Some More Annotation's */

    @BeforeEach
    void someTask1() {
        // This will execute before running next test.
    }

    @BeforeAll
    static void showTask2() {
        // THis will execute first then other all test executed
    }

    @AfterEach
    void showTask3() {
        // After testing this will execute
    }

    @AfterAll
    static void showTask4() {
        // After ending all test's this will execute
    }
}