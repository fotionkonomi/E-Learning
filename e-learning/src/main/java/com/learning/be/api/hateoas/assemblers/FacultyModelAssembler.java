package com.learning.be.api.hateoas.assemblers;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.learning.be.api.controller.FacultyRestController;
import com.learning.be.api.hateoas.assemblers.util.AssemblerUtil;
import com.learning.be.api.hateoas.model.FacultyModel;
import com.learning.be.business.dto.FacultyDto;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class FacultyModelAssembler extends RepresentationModelAssemblerSupport<FacultyDto, FacultyModel> {

	@Autowired
	private AssemblerUtil assemblerUtil;

	public FacultyModelAssembler() {
		super(FacultyRestController.class, FacultyModel.class);
	}

	@Override
	public FacultyModel toModel(FacultyDto entity) {
		FacultyModel facultyModel = instantiateModel(entity);

		facultyModel.add(linkTo(methodOn(FacultyRestController.class).findOne(entity.getId())).withSelfRel());

		facultyModel.setId(entity.getId());
		facultyModel.setTimestamp(entity.getTimestamp());
		facultyModel.setName(entity.getName());
		facultyModel.setUniversity(assemblerUtil.toUniversityModel(entity.getUniversity()));
		facultyModel.setStudentsAndProfessors(
				new ArrayList<>(assemblerUtil.toCollectionUserModel(entity.getStudentsAndProfessors())));
		return facultyModel;
	}

	@Override
	public CollectionModel<FacultyModel> toCollectionModel(Iterable<? extends FacultyDto> entities) {
		CollectionModel<FacultyModel> facultyModels = super.toCollectionModel(entities);

		facultyModels.add(linkTo(methodOn(FacultyRestController.class).findAll()).withSelfRel());

		return facultyModels;
	}

}
