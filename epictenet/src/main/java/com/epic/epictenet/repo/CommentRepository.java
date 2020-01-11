package com.epic.epictenet.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epic.epictenet.model.Comment;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
   
    List<Comment> findByPostId(Long postId);
    Long countByPostId(Long postId);
}
