package com.example.userservice.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

    @Id
    @Column(name = "userId")
    private String userId;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "about")
    private String about;
    //other user properties that you want

    @Transient
    private List<Rating> ratings;
}
