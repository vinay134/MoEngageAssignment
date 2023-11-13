package com.brewery.brewearyManagementApp.config;

import com.brewery.brewearyManagementApp.model.Users;
import com.brewery.brewearyManagementApp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName=authentication.getName();
        String password=authentication.getCredentials().toString();
        System.out.println("User Name : "+userName+" Password : "+password);
        Optional<Users> user=usersRepository.findByuserName(userName);
        List<GrantedAuthority> roles=null;
        if(user.isPresent()) {
            Users users = user.get();
            if (users.getPassword().equals(password)) {
                roles = new ArrayList<>();
                roles.add(new SimpleGrantedAuthority("user"));

                return new UsernamePasswordAuthenticationToken(userName, password, roles);
            } else {
                throw new BadCredentialsException("Invalid Password");
            }
        }else
            throw new BadCredentialsException("We didn't find your credintials");
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
