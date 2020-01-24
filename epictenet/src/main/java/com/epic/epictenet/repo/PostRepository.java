package com.epic.epictenet.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.epic.epictenet.model.Lyke;
import com.epic.epictenet.model.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	 @Query(
			   value = "SELECT * FROM POST l WHERE l.id = ?1", 
			   nativeQuery = true)
	   Post getUndoData(int id);
	

}
