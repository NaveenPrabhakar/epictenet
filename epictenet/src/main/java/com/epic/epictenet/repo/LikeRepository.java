package com.epic.epictenet.repo;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.epic.epictenet.model.Lyke;


@Repository
public interface LikeRepository extends JpaRepository<Lyke, Long> {
	
   List<Lyke> findByPostId(Long postId);
   Long countByPostId(Long postId);
   
   

}
