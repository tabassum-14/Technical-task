package com.SocialNetworkPost.service.impl;

import com.SocialNetworkPost.entity.SocialNetworkPost;
import com.SocialNetworkPost.repository.SocialNetworkPostRepository;
import com.SocialNetworkPost.service.SocialNetworkPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SocialNetworkPostServiceImpl implements SocialNetworkPostService {
    @Autowired
    private SocialNetworkPostRepository repository;
    @Override
    public List<SocialNetworkPost> getTop10PostsByCategory(String category) {
        return repository.findTop10ByPostCategoryOrderByViewCountDesc(category);
    }

    @Override
    public List<SocialNetworkPost> searchPostsByAuthor(String author) {
        return repository.findByAuthor(author);
    }
}
