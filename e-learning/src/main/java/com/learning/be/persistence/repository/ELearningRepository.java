package com.learning.be.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.learning.be.persistence.entities.BaseClass;

@NoRepositoryBean
public interface ELearningRepository<ENTITY extends BaseClass, ID> extends JpaRepository<ENTITY, ID> {

}
