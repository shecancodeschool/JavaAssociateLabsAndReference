package org.eddydashcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.eddydashcode.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
