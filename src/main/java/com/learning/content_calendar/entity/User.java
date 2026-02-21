package com.learning.content_calendar.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long id;

    private String name;
    
}