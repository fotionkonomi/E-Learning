package com.learning.be.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.be.business.dto.BranchDto;

@RestController
@RequestMapping("/branch")
public class BranchRestController extends CrudAbstractRestController<BranchDto, Long> {

}
