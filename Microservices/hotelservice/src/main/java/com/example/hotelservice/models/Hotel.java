package com.example.hotelservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    private  String id;
    private  String name;
    private  String location;
    private  String about;
}
