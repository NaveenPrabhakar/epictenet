package com.epic.epictenet.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.epic.epictenet.model.Comment;
import com.epic.epictenet.model.Lyke;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
   
    List<Comment> findByPostId(Long postId);
    Long countByPostId(Long postId);
    @Query(
 		   value = "SELECT * FROM COMMENT c WHERE c.id = ?1", 
 		   nativeQuery = true)
    Comment getUndoData(int id);
}
