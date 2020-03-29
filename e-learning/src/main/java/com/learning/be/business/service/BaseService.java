package com.learning.be.business.service;

import java.util.Optional;

public interface BaseService<T, ID> {
	
	Optional<T> findById(ID id);
	
	T save(T t);
	
}
