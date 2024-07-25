package com.SocialNetworkPost.controller;

import com.SocialNetworkPost.entity.SocialNetworkPost;
import com.SocialNetworkPost.service.SocialNetworkPostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(SocialNetworkPostController.class)
class SocialNetworkPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SocialNetworkPostService service;

    @Test
    void getTop10PostsByCategory() throws Exception {
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

        when(service.getTop10PostsByCategory("Music")).thenReturn(posts);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/posts/top/Music"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].author").value("Alice"))
                .andExpect(jsonPath("$[1].author").value("Bob"));
    }

    @Test
    void searchPostsByAuthor() throws Exception {
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

        when(service.searchPostsByAuthor("Alice")).thenReturn(posts);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/posts/author/Alice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].author").value("Alice"))
                .andExpect(jsonPath("$[1].author").value("Alice"));
    }
}
