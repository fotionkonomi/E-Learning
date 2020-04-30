package com.learning.be.api.hateoas.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.learning.be.api.controller.UniversityRestController;
import com.learning.be.api.hateoas.assemblers.util.AssemblerUtil;
import com.learning.be.api.hateoas.model.UniversityModel;
import com.learning.be.business.dto.UniversityDto;

@Component
public class UniversityModelAssembler extends RepresentationModelAssemblerSupport<UniversityDto, UniversityModel> {

	@Autowired
	private AssemblerUtil assemblerUtil;

	public UniversityModelAssembler() {
		super(UniversityDto.class, UniversityModel.class);
	}

	@Override
	public UniversityModel toModel(UniversityDto entity) {
		UniversityModel universityModel = instantiateModel(entity);
		universityModel.add(linkTo(methodOn(UniversityRestController.class, entity.getId()).findOne(entity.getId())).withSelfRel());
		universityModel.setId(entity.getId());
		universityModel.setTimestamp(entity.getTimestamp());
		universityModel.setName(entity.getName());
		universityModel.setAddress(entity.getAddress());
		universityModel.setFaculties(new ArrayList<>(assemblerUtil.toCollectionFacultyModel(entity.getFaculties())));
		return universityModel;
	}

	@Override
	public CollectionModel<UniversityModel> toCollectionModel(Iterable<? extends UniversityDto> entities) {
		CollectionModel<UniversityModel> universityModels = super.toCollectionModel(entities);

		universityModels.add(linkTo(methodOn(UniversityRestController.class).findAll()).withRel("universities"));

		return universityModels;
	}

}
