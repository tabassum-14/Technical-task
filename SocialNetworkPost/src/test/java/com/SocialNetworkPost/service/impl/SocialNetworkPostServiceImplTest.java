package com.SocialNetworkPost.service.impl;

import com.SocialNetworkPost.entity.SocialNetworkPost;
import com.SocialNetworkPost.repository.SocialNetworkPostRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class SocialNetworkPostServiceImplTest {
    @Mock
    private SocialNetworkPostRepository repository;

    @InjectMocks
    private SocialNetworkPostServiceImpl service;

    @Test
    void getTop10PostsByCategory() {
        SocialNetworkPost post1 = new SocialNetworkPost();
        post1.setId(1L);
        post1.setPostCategory("Music");
        post1.setAuthor("Alice");
        post1.setContent("Check out my new song!");
        post1.setViewCount(1570);

        SocialNetworkPost post2 = new SocialNetworkPost();
        post2.setId(2L);
        post2.setPostCategory("Music");
        post2.setAuthor("Bob");
        post2.setContent("New album out now!");
        post2.setViewCount(2200);

        List<SocialNetworkPost> posts = Arrays.asList(post1, post2);

        when(repository.findTop10ByPostCategoryOrderByViewCountDesc("Music")).thenReturn(posts);

        List<SocialNetworkPost> topPosts = service.getTop10PostsByCategory("Music");

        assertThat(topPosts).isNotEmpty();
        assertThat(topPosts.size()).isEqualTo(2);
        assertThat(topPosts.get(0).getAuthor()).isEqualTo("Alice");
    }

    @Test
    void searchPostsByAuthor() {
        SocialNetworkPost post1 = new SocialNetworkPost();
        post1.setId(1L);
        post1.setPostCategory("Gaming");
        post1.setAuthor("Alice");
        post1.setContent("Just finished an epic gaming session!");
        post1.setViewCount(2215);

        SocialNetworkPost post2 = new SocialNetworkPost();
        post2.setId(2L);
        post2.setPostCategory("Music");
        post2.setAuthor("Alice");
        post2.setContent("New song released!");
        post2.setViewCount(1800);

        List<SocialNetworkPost> posts = Arrays.asList(post1, post2);

        when(repository.findByAuthor("Alice")).thenReturn(posts);

        List<SocialNetworkPost> foundPosts = service.searchPostsByAuthor("Alice");

        assertThat(foundPosts).isNotEmpty();
        assertThat(foundPosts.size()).isEqualTo(2);
        assertThat(foundPosts.get(0).getAuthor()).isEqualTo("Alice");
    }
}