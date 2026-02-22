package com.learning.content_calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learning.content_calendar.entity.ContentItem;
import com.learning.content_calendar.entity.ContentStatus;

import java.util.List;

public interface ContentRepository extends JpaRepository<ContentItem, Long> {

    // By user ID (better than User object)
    List<ContentItem> findByUserId(Long userId);

    // By content status
    List<ContentItem> findByContentStatus(ContentStatus contentStatus);

    // By user ID + content status
    List<ContentItem> findByUserIdAndContentStatus(Long userId, ContentStatus contentStatus);

}