package com.brewery.brewearyManagementApp.service;

import com.brewery.brewearyManagementApp.model.Users;
import com.brewery.brewearyManagementApp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    public void saveDetails(Users users){
        usersRepository.save(users);
    }
}
