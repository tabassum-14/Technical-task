package com.SocialNetworkPost.service;

import com.SocialNetworkPost.entity.SocialNetworkPost;

import java.util.List;

public interface SocialNetworkPostService {
    List<SocialNetworkPost> getTop10PostsByCategory(String category);
    List<SocialNetworkPost> searchPostsByAuthor(String author);
}
