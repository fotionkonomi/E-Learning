package com.learning.persistence.entities;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Table(name = "university")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class University extends BaseClass {

	private String name;
	
	private String address;
	
	@OneToMany(mappedBy = "university")
	private List<Faculty> faculties; 
}
