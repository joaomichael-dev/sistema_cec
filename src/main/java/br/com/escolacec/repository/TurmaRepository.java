package br.com.escolacec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escolacec.models.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
