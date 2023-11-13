package com.brewery.brewearyManagementApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity@Table(name = "rating")
public class Rating {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "brewery_id")
    private String breweryId;
    @Column(name = "rating_value")
    private String ratingValue;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId",referencedColumnName = "id")
    private Users user;
}
