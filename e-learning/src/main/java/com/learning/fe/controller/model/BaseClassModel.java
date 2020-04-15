package com.learning.fe.controller.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseClassModel {

	private Long id;
	private Date timestamp;
}
