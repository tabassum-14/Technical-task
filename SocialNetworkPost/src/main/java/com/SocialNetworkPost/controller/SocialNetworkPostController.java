package com.SocialNetworkPost.controller;

import com.SocialNetworkPost.entity.SocialNetworkPost;
import com.SocialNetworkPost.service.SocialNetworkPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class SocialNetworkPostController {
    @Autowired
    private SocialNetworkPostService service;

    @GetMapping("/top/{category}")
    public List<SocialNetworkPost> getTop10PostsByCategory(@PathVariable String category) {
        return service.getTop10PostsByCategory(category);
    }

    @GetMapping("/author/{author}")
    public List<SocialNetworkPost> searchPostsByAuthor(@PathVariable String author) {
        return service.searchPostsByAuthor(author);
    }
}

