package com.learning.content_calendar.entity;

import jakarta.persistence.*;

@Entity
@Table(name="content_items")
public class ContentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private ContentStatus contentStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {return this.id;}

    public void setTitle(String title) {this.title = title;}
    public String getTitle() {return this.title;}
    
    public void setDescription(String description) {this.description = description;}
    public String getDescription() {return this.description;}

    public void setContentStatus(ContentStatus contentStatus) {this.contentStatus = contentStatus;}
    public ContentStatus getContentStatus() {return this.contentStatus;}

    public User getUser() {return this.user;}

}
