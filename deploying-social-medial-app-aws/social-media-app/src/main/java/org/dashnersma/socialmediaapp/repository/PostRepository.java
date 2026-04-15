package org.umaxcodesma.socialmediaapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.umaxcodesma.socialmediaapp.domain.entity.Post;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findAllByAuthor(String author);
}
