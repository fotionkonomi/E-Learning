package com.learning.be.business.service;

import java.util.Optional;

public interface BaseService<DTO, ID> {
	
	Optional<DTO> findById(ID id);
	
	DTO save(DTO dto);
	
}
