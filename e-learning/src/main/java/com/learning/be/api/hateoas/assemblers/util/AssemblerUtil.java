package com.learning.be.api.hateoas.assemblers.util;

import java.util.Collection;

import com.learning.be.api.hateoas.model.FacultyModel;
import com.learning.be.api.hateoas.model.QuestionModel;
import com.learning.be.api.hateoas.model.UniversityModel;
import com.learning.be.api.hateoas.model.UserModel;
import com.learning.be.business.dto.FacultyDto;
import com.learning.be.business.dto.QuestionDto;
import com.learning.be.business.dto.UniversityDto;
import com.learning.be.business.dto.UserDto;

public interface AssemblerUtil {

	QuestionModel toQuestionModel(QuestionDto questionDto);
	
	Collection<UserModel> toCollectionUserModel(Collection<UserDto> userDtos);

    Collection<FacultyModel> toCollectionFacultyModel(Collection<FacultyDto> faculties);

	UniversityModel toUniversityModel(UniversityDto universityDto);

}
