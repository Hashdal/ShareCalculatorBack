package com.learning.content_calendar.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ContentItem> contentItems;
}