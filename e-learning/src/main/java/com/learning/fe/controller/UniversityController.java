package com.learning.fe.controller;

import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestOperations;

import com.learning.fe.controller.model.UniversityModel;

@Controller
@RequestMapping("/university")
public class UniversityController {

	@Autowired
	private RestOperations rest;
	
	@ModelAttribute(name = "university")
	public UniversityModel university() {
		return new UniversityModel();
	}
	
	@GetMapping("/add")
	public String addPage(Model model) {
		return "add";
	}
	
	@PostMapping("/add")
	public String add(@Valid @ModelAttribute("university") UniversityModel universityModel, Errors errors) {
		if(errors.hasErrors()) {
			return "add";
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		String string = rest.postForObject("http://localhost:9090/api/university/add", universityModel, String.class);
		System.out.println(string);
		return "redirect:/";
		
	}
}
