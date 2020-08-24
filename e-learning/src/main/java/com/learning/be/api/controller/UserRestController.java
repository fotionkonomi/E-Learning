package com.learning.be.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.business.dto.UserDto;

@RestController
@RequestMapping("/user")
public class UserRestController extends CrudAbstractRestController<UserDto, Long> {


}
