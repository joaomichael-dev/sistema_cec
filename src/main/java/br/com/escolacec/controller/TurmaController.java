package br.com.escolacec.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.escolacec.models.Turma;
import br.com.escolacec.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	@GetMapping
	public Iterable<Turma> getAllTurmas() {
		return turmaService.getAllTurmas();
	}
	
	@GetMapping("/{id}")
	public Optional<Turma> getTurma(@PathVariable Long id) {
		return turmaService.getTurmaById(id);
	}
	
	@PostMapping("/new")
	public Turma createTurma(@RequestBody Turma turma) {
		return turmaService.createTurma(turma);
	}
	
	@PutMapping("/update/{id}")
	public Turma updateTurma(@PathVariable Long id, @RequestBody Turma turma) {
		return turmaService.updateTurma(id, turma);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTurma(@PathVariable Long id) {
		turmaService.deleteTurma(id);
	}
	
}
