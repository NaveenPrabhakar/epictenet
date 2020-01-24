package com.epic.epictenet.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.epic.epictenet.model.Lyke;


@Repository
public interface LikeRepository extends JpaRepository<Lyke, Long> {
	
   List<Lyke> findByPostId(Long postId);
   
   Optional<Lyke> findById(int id);
   
   Long countByPostId(Long postId);
   
   @Query(
		   value = "SELECT * FROM LYKE l WHERE l.id = ?1", 
		   nativeQuery = true)
   Lyke getUndoData(int id);
   

}
