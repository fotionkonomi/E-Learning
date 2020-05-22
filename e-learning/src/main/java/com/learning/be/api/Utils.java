package com.learning.be.api;

import java.net.URI;
import java.net.URISyntaxException;

import com.learning.be.business.dto.BaseClassDto;
import com.learning.be.common.constants.MessageConstants;

public class Utils {

	public static <T extends BaseClassDto> URI getUriAfterPost(T dto) throws URISyntaxException {
		return new URI(MessageConstants.SLASH + objectNameWithoutDto(dto) + MessageConstants.SLASH + dto.getId());
	}
		
	private static <T extends BaseClassDto> String objectNameWithoutDto(T dto) {
		String className = dto.getClass().getSimpleName();
		if(className.contains("Dto")) {
			return className.replace("Dto", "");
		}
		return className;
	}

}
