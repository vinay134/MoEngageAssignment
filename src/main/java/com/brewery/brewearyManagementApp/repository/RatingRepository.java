package com.brewery.brewearyManagementApp.repository;

import com.brewery.brewearyManagementApp.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {
   public List<Rating> findBybreweryId(String id);
}
