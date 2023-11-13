package com.brewery.brewearyManagementApp.service;

import com.brewery.brewearyManagementApp.model.Rating;
import com.brewery.brewearyManagementApp.model.Users;
import com.brewery.brewearyManagementApp.repository.RatingRepository;
import com.brewery.brewearyManagementApp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private UsersRepository usersRepository;
    public void submitRating(String ratingValue, String breweryId, Authentication authentication){
        Rating rating=new Rating();
        Optional<Users> users=usersRepository.findByuserName(authentication.getName());
        if(users.isPresent()){
            Users user=users.get();
            rating.setBreweryId(breweryId);
            rating.setUser(user);
            rating.setRatingValue(ratingValue);
            ratingRepository.save(rating);
        }
    }
    public List<Rating> getRatings(String breweryId){
        return ratingRepository.findBybreweryId(breweryId);
    }
}
