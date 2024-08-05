package br.com.escolacec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.escolacec.models.Professor;
import br.com.escolacec.service.ProfessorService;


@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping
	public List<Professor> getAllProfessor() {
		return professorService.getAllProfessores();
	}
	
	@GetMapping("/{id}")
	public Optional<Professor> getProfessor(@PathVariable Long id) {
		return professorService.getProfessorById(id);
	}
	
	@PostMapping("/new")
	public Professor create(@RequestBody Professor professor) {
		return professorService.createProfessor(professor);
	}
	
	@PutMapping("/update/{id}")
	public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
		return professorService.updateProfessor(id, professor);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteProfessor(@PathVariable Long id) {
		professorService.deleteProfessor(id);
	}
	
	
}
