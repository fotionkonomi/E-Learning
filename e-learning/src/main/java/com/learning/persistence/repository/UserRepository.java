package com.learning.persistence.repository;

import org.springframework.stereotype.Repository;

import com.learning.persistence.entities.User;

@Repository
public interface UserRepository extends ELearningRepository<User, Long> {

}
