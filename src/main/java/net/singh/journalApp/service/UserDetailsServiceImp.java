//package net.singh.journalApp.service;
//
//import net.singh.journalApp.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//@Component
//public class UserDetailsServiceImp implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user != null) {
//            User.builder()
//                    .username(username)
//                    .password(user.getPassword())
//                    .roles(user.getRoles().toArray(new String[0]))
//                    .build();
//        }
//    }
//}