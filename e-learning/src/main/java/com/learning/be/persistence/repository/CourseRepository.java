package com.learning.be.persistence.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.learning.be.persistence.entities.Course;

@Repository
public interface CourseRepository extends ELearningRepository<Course, Long> {

	List<Course> findByProfessor_Id(Long professorId);
}
