package com.learning.be.business.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<DTO, ID> {
	
	Optional<DTO> findById(ID id);
	
	DTO save(DTO dto);
	
	List<DTO> findAll();
	
}
