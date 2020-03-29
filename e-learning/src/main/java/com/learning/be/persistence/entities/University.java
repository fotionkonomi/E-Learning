package com.learning.be.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "university")
@Data
@ToString( exclude = { "faculties" } ) 
@EqualsAndHashCode(callSuper = true, exclude = { "faculties" })
@NoArgsConstructor
@AllArgsConstructor
public class University extends BaseClass {

	@Column(name = "name_university", nullable = false, length = 100)
	private String name;
	
	@Column(name = "name", nullable = false, columnDefinition = "TEXT", length = 65535)
	private String address;
	
	@OneToMany(mappedBy = "university")
	private List<Faculty> faculties = new ArrayList<>(); 
}
