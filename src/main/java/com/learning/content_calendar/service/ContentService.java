package com.learning.content_calendar.service;

import org.springframework.stereotype.*;

import com.learning.content_calendar.entity.ContentItem;
import com.learning.content_calendar.entity.ContentStatus;
import com.learning.content_calendar.repository.ContentRepository;

import jakarta.transaction.Transactional;

import com.learning.content_calendar.entity.User;
import java.util.List;
import java.util.Optional;

@Service
public class ContentService {
    private ContentRepository contentRepository;

    public ContentService(ContentRepository contetnRepository) {
        this.contentRepository = contentRepository;
    }
    
    public ContentItem save(ContentItem contentItem) {
        return contentRepository.save(contentItem);
    }

    public List<ContentItem> getAllContents() {
        return contentRepository.findAll();
    }

    public Optional<ContentItem> findContentById(long id) {
        return contentRepository.findById(id);
    }
    
    public List<ContentItem> findByContentStatus(ContentStatus contentStatus) {
        return contentRepository.findByContentStatus(contentStatus);
    }

    public List<ContentItem> userIdContents(Long userId) {
        return contentRepository.findByUserId(userId);
    }

    public List<ContentItem> filterUserIdContensStatus(Long userId, ContentStatus contentStatus) {
        return contentRepository.findByUserIdAndContentStatus(userId, contentStatus);
    }

    @Transactional
    public ContentItem updateStatus(Long ContentId, ContentStatus contentStatus) {
        ContentItem contentItem = contentRepository.findById(ContentId).orElseThrow(
            () -> new RuntimeException("Content not found")
        );
        contentItem.setContentStatus(contentStatus);
        contentRepository.save(contentItem);
        return contentItem;
        
    }

    @Transactional
    public void deleteContentItem(Long ContentId) {
        ContentItem contentItem = contentRepository.findById(ContentId).orElseThrow(
            () -> new RuntimeException("Content not found")
        );
        contentRepository.delete(contentItem);
    }

}
