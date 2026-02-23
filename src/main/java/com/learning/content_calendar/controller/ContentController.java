package com.learning.content_calendar.controller;

import org.springframework.web.bind.annotation.*;
import com.learning.content_calendar.service.ContentService;
import com.learning.content_calendar.entity.ContentItem;
import com.learning.content_calendar.entity.ContentStatus;

import java.util.List;

@RestController
@RequestMapping("/contents")
public class ContentController {
    
    private final ContentService contentService;
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping
    public List<ContentItem> getContentItems(
        @RequestParam(required = false) ContentStatus contentStatus) {
            if(contentStatus != null) {
                return contentService.findByContentStatus(contentStatus);
            }
        return contentService.getAllContents();
    }
    @PatchMapping("/{id}/{status}")
    public ContentItem updateContentItem(
        @PathVariable Long id,
        @PathVariable ContentStatus status) {
            return contentService.updateStatus(id, status);
        }


    @PostMapping
    public ContentItem createContentItem(@RequestBody ContentItem contentItem) {
        return contentService.save(contentItem);
    }

    @DeleteMapping("/{id}")
    public String deleteContentItem(
        @PathVariable Long id
    ) {
        contentService.deleteContentItem(id);
        return "Item with id " + id + " deleted.";
    }


}
