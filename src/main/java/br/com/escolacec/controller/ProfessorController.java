package br.com.escolacec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/professor")
public class ProfessorController {
	
	@GetMapping()
	public String index() {
		return "professores/index";
	}
	
	
}
