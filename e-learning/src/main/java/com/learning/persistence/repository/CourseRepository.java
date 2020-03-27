package com.learning.persistence.repository;

import org.springframework.stereotype.Repository;

import com.learning.persistence.entities.Course;

@Repository
public interface CourseRepository extends ELearningRepository<Course, Long> {

}
