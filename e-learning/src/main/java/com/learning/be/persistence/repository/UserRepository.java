package com.learning.be.persistence.repository;

import org.springframework.stereotype.Repository;

import com.learning.be.persistence.entities.User;

@Repository
public interface UserRepository extends ELearningRepository<User, Long> {

}
