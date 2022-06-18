package com.practice.service.inf.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.dao.admin.masters.otherMasters.UserCreationRepository;
import com.practice.model.admin.masters.otherMaster.User;
import com.practice.model.common.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCreationRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        final User user = this.userRepository.findByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User not found !!");
        } else {
            return new CustomUserDetails(user);
        }


        //user database `

//        if (userName.equals("Durgesh")) {
//            return new User("Durgesh", "Durgesh123", new ArrayList<>());s
//        } else {
//            throw new UsernameNotFoundException("User not found !!");
//        }

    }
}
