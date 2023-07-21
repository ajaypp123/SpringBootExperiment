package com.example.rating.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user_ratings")
public class Rating {
    @Id
    @Column(name = "ratingId")
    private String ratingId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "hotelId")
    private String hotelId;

    @Column(name = "rating")
    private int rating;

    @Column(name = "feedback")
    private String feedback;
}
