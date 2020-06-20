package com.learning.be.business.service.impl;

import org.springframework.stereotype.Service;

import com.learning.be.business.dto.BranchDto;
import com.learning.be.persistence.entities.Branch;

@Service
public class BranchServiceImpl extends AbstractJpaService<BranchDto, Branch, Long> {

	public BranchServiceImpl() {
		super(Branch.class, BranchDto.class);
	}
}
