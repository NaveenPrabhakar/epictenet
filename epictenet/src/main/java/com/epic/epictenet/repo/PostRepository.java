package com.epic.epictenet.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epic.epictenet.model.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	

	

}
