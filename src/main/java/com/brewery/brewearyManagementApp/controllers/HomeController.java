package com.brewery.brewearyManagementApp.controllers;

import com.brewery.brewearyManagementApp.model.Brewery;
import com.brewery.brewearyManagementApp.model.Rating;
import com.brewery.brewearyManagementApp.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RatingService ratingService;
    @RequestMapping("/home")
    public String homePage(){
        return "home";
    }
    @PostMapping("/search")
    public String homePage(@RequestParam(name = "searchType") String searchType,@RequestParam(name = "searchValue") String searchValue, Model model){
        ResponseEntity<Brewery[]> reponse=null;
        if(searchType.equalsIgnoreCase("byType")){
             reponse=restTemplate.getForEntity("https://api.openbrewerydb.org/v1/breweries?by_type="+searchValue, Brewery[].class);
        }else if(searchType.equalsIgnoreCase("byCity")){
             reponse=restTemplate.getForEntity("https://api.openbrewerydb.org/v1/breweries?by_city="+searchValue, Brewery[].class);
        }else {
             reponse = restTemplate.getForEntity("https://api.openbrewerydb.org/v1/breweries?by_name="+searchValue, Brewery[].class);
        }
        model.addAttribute("isLoaded","true");
        model.addAttribute("brewers",reponse.getBody());
        return "home";
    }
    @GetMapping("/show-details/{id}")
    public String openDetails(@PathVariable(name = "id") String id, Model model){
        ResponseEntity<Brewery> response=restTemplate.getForEntity("https://api.openbrewerydb.org/v1/breweries/"+id,Brewery.class);
        List<Rating> ratings=ratingService.getRatings(id);
        model.addAttribute("brewery",response.getBody());
        model.addAttribute("ratings",ratings);
        return "details";
    }
    @PostMapping("/submit-rating")
    public String submitRating(@RequestParam String ratingVal,@RequestParam String breweryId, Authentication authentication){
        ratingService.submitRating(ratingVal,breweryId,authentication);
        return "redirect:/show-details/"+breweryId;
    }
}
