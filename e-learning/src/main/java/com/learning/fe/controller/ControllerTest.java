package com.learning.fe.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping
public class ControllerTest {

	@RequestMapping
	public String page() {
		return "index";
	}
}
