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

    public Long getId() {return this.id;}

    public void setName(String name) {this.name = name;}
    public String getName() {return this.name;}

    public void setEmail(String email) {this.email = email;}
    public String getEmail() {return this.email;}

    public List<ContentItem> getContentItem() {return this.contentItems;}
}