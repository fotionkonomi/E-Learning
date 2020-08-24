package com.learning.be.persistence.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.learning.be.persistence.entities.User;

@Repository
public interface UserRepository extends ELearningRepository<User, Long> {

	Optional<User> findByUsername(final String username);
}
