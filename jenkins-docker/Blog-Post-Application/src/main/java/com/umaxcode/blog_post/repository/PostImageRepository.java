package com.umaxcode.blog_post.repository;

import com.umaxcode.blog_post.domain.entity.PostImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostImageRepository extends CrudRepository<PostImage, Long> {

    Optional<PostImage> findByImageName(String name);
}
