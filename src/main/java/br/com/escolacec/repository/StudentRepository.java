package br.com.escolacec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.escolacec.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
