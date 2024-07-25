package com.SocialNetworkPost.repository;

import com.SocialNetworkPost.entity.SocialNetworkPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SocialNetworkPostRepository extends JpaRepository<SocialNetworkPost,Long> {


    List<SocialNetworkPost> findTop10ByPostCategoryOrderByViewCountDesc(String postCategory);

    List<SocialNetworkPost> findByAuthor(String author);
}
