package com.codecool.countryguidebook.security;

import com.codecool.countryguidebook.model.CountryGuideUser;
import com.codecool.countryguidebook.repository.CountryGuideUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private CountryGuideUserRepository userRepository;

    public CustomUserDetailsService(CountryGuideUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CountryGuideUser user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));

        return new User(user.getUserName(), user.getPassword(), user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}
