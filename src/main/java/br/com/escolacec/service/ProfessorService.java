package br.com.escolacec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.escolacec.models.Professor;
import br.com.escolacec.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getProfessorById(Long id) {
        return professorRepository.findById(id);
    }

    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(Long id, Professor professorDetails) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Professor not found with id " + id));
        
        // Necessário rever e adicionar todos os atributos
        professor.setNome(professorDetails.getNome());
        professor.setTurmas(professorDetails.getTurmas());
        return professorRepository.save(professor);
    }

    public void deleteProfessor(Long id) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Professor not found with id " + id));
        professorRepository.delete(professor);
    }
	
	
	
}
