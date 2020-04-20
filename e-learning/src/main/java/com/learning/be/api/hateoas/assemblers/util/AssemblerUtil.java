package com.learning.be.api.hateoas.assemblers.util;

import java.util.Collection;

import com.learning.be.api.hateoas.model.AnswerModel;
import com.learning.be.api.hateoas.model.CourseModel;
import com.learning.be.api.hateoas.model.FacultyModel;
import com.learning.be.api.hateoas.model.QuestionModel;
import com.learning.be.api.hateoas.model.TestModel;
import com.learning.be.api.hateoas.model.UniversityModel;
import com.learning.be.api.hateoas.model.UserModel;
import com.learning.be.business.dto.AnswerDto;
import com.learning.be.business.dto.CourseDto;
import com.learning.be.business.dto.FacultyDto;
import com.learning.be.business.dto.QuestionDto;
import com.learning.be.business.dto.TestDto;
import com.learning.be.business.dto.UniversityDto;
import com.learning.be.business.dto.UserDto;

public interface AssemblerUtil {

	QuestionModel toQuestionModel(QuestionDto questionDto);
	
	Collection<QuestionModel> toCollectionQuestionModels(Collection<QuestionDto> questionDtos);
	
	Collection<UserModel> toCollectionUserModel(Collection<UserDto> userDtos);

    Collection<FacultyModel> toCollectionFacultyModel(Collection<FacultyDto> faculties);

	UniversityModel toUniversityModel(UniversityDto universityDto);
	
	UserModel toUserModel(UserDto userDto);
	
	Collection<TestModel> toCollectionTestModel(Collection<TestDto> tests);
	
	Collection<AnswerModel> toCollectionAnswerModel(Collection<AnswerDto> answers);
	
	CourseModel toCourseModel(CourseDto courseDto);
	
	Collection<CourseModel> toCollectionCourseModels(Collection<CourseDto> courseDtos);
	
	FacultyModel toFacultyModel(FacultyDto facultyDto);
	
}
