package com.learning.be.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.learning.be.business.dto.BaseClassDto;
import com.learning.be.business.service.BaseService;
import com.learning.be.common.exception.ConstraintException;
import com.learning.be.persistence.entities.BaseClass;
import com.learning.be.persistence.repository.ELearningRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
public abstract class AbstractJpaService<DTO extends BaseClassDto, ENTITY extends BaseClass, ID>
		implements BaseService<DTO, ID> {

	@Autowired
	protected ELearningRepository<ENTITY, ID> repo;

	@Autowired
	protected ModelMapper modelMapper;

	protected Class<ENTITY> classOfEntity;
	protected Class<DTO> classOfDto;

	public AbstractJpaService(Class<ENTITY> classOfEntity, Class<DTO> classOfDto) {
		this.classOfEntity = classOfEntity;
		this.classOfDto = classOfDto;
	}

	public Optional<DTO> findById(ID id) {
		Optional<ENTITY> optionalEntity = repo.findById(id);

		return mapOptionalEntityToDTO(optionalEntity);
	}

	@Override
	public DTO save(DTO dto) {
		try {
			ENTITY mappedEntity = mapFromDTO(dto);
			mappedEntity = repo.save(mappedEntity);
			log.info(classOfEntity.getName() + " object saved successfully: " + mappedEntity);
			return mapFromEntity(mappedEntity);
		} catch (DataIntegrityViolationException e) {
			log.info(classOfEntity.getName() + " object could not be saved, exception thrown: " + e);
			throw new ConstraintException(e.getMessage(), e);
		}
	}
	
	@Override
	public List<DTO> findAll() {
		return mapEntityListToDTO(repo.findAll());
	}

	public ENTITY mapFromDTO(DTO dto) {
		return modelMapper.map(dto, classOfEntity);
	}

	public DTO mapFromEntity(ENTITY entity) {
		return modelMapper.map(entity, classOfDto);
	}
	
	

	private Optional<DTO> mapOptionalEntityToDTO(Optional<ENTITY> optionalEntity) {
		return Optional.ofNullable(optionalEntity.isPresent() ? mapFromEntity(optionalEntity.get()) : null);
	}

	protected List<DTO> mapEntityListToDTO(List<ENTITY> entityList) {
		List<DTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(mapFromEntity(entity)));
		return dtoList;
		
	}
}
