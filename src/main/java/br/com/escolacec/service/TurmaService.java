package br.com.escolacec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.escolacec.models.Turma;
import br.com.escolacec.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public Iterable<Turma> getAllTurmas() {
		return turmaRepository.findAll();
	}
	
	public Optional<Turma> getTurmaById(Long id) {
		return turmaRepository.findById(id);
	}
	
	public Turma createTurma(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public Turma updateTurma(Long id, Turma turma) {
		Turma turmaUpdated = turmaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Turma not found with id: " + id));
		
		turmaUpdated.setNome(turma.getNome());
		turmaUpdated.setProfessor(turma.getProfessor());
		
		return turmaRepository.save(turmaUpdated);
	}
	
	public void deleteTurma(Long id) {
		Turma turma = turmaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Turma not found with id: " + id));
		turmaRepository.delete(turma);
	}
	
}
