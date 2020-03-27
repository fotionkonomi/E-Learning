package com.learning.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.learning.persistence.entities.BaseClass;

@NoRepositoryBean
public interface ELearningRepository<T extends BaseClass, ID> extends JpaRepository<T, ID> {

}
