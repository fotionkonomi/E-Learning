package com.learning.be.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.business.dto.RoleDto;

@RestController
@RequestMapping("/role")
public class RoleRestController extends CrudAbstractRestController<RoleDto, Long> {

}
