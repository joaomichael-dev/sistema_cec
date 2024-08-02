package br.com.escolacec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escolacec.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
