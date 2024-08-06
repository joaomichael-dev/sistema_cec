package br.com.escolacec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escolacec.models.Turma;
import br.com.escolacec.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public Optional<Turma> getTumaById(Long id) {
		return turmaRepository.findById(id);
	}
	
	public Iterable<Turma> getAllTurma() {
		return turmaRepository.findAll();
	}
	
}
