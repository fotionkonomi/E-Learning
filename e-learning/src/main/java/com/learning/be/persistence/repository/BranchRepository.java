package com.learning.be.persistence.repository;

import org.springframework.stereotype.Repository;

import com.learning.be.persistence.entities.Branch;

@Repository
public interface BranchRepository extends ELearningRepository<Branch, Long> {

}
