package com.learning.content_calendar.entity;

import jakarta.persistence.*;
import com.learning.content_calendar.entity.ContentStatus;
import com.learning.content_calendar.entity.User;

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

}
