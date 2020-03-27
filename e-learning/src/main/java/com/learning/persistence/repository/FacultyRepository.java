package com.learning.persistence.repository;

import org.springframework.stereotype.Repository;

import com.learning.persistence.entities.Faculty;

@Repository
public interface FacultyRepository extends ELearningRepository<Faculty, Long> {

}
