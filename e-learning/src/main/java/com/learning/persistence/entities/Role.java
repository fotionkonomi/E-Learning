package com.learning.persistence.entities;

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
@Table(name = "role")
@Data
@ToString( exclude = { "users" } )
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = { "users" })
public class Role extends BaseClass {

	@Column(name = "name_role", nullable = false, length = 50)
	private String name;
	
	@Column(name = "description", nullable = false, columnDefinition = "TEXT", length = 65535)
	private String description;
	
	@OneToMany(mappedBy = "role")
	private List<User> users = new ArrayList<>();
}
