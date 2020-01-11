package com.epic.epictenet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epic.epictenet.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	 Boolean existsByUsername(String username);
}
