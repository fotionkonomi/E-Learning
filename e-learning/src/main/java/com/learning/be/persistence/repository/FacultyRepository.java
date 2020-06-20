package com.learning.be.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.learning.be.persistence.entities.Faculty;

@Repository
public interface FacultyRepository extends ELearningRepository<Faculty, Long> {

	List<Faculty> findByUniversityId(Long universityId);
}
