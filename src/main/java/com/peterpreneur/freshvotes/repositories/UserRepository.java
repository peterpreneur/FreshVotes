package com.peterpreneur.freshvotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peterpreneur.freshvotes.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername (String username);
}
