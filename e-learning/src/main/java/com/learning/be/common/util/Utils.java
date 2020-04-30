package com.learning.be.common.util;

import java.net.URI;
import java.net.URISyntaxException;

import com.learning.be.business.dto.BaseClassDto;

public class Utils {
	
	private static String slash = "/";
	
	public static <T extends BaseClassDto> URI getUriAfterPost(T dto) throws URISyntaxException {
		return new URI(slash + objectNameWithoutDto(dto) + slash + dto.getId());
	}
		
	private static <T extends BaseClassDto> String objectNameWithoutDto(T dto) {
		String className = dto.getClass().getSimpleName();
		if(className.contains("Dto")) {
			return className.replace("Dto", "");
		}
		return className;
	}
	
	

}
