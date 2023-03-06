package org.corsojava.foto.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public String home() {
		return "redirect:index";
	}

	@GetMapping("/TLStest")
	public String TLStest(Authentication auth) {
		System.out.println("Login OK -- nome = " + auth.getName());
		return "TLStest";
	}

}