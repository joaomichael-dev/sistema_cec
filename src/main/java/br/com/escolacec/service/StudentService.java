package br.com.escolacec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.escolacec.models.Student;
import br.com.escolacec.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Iterable<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Long id, Student student) {
		Student studentUpdate = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
		
		studentUpdate.setNome(student.getNome());
		studentUpdate.setCpf(student.getCpf());
		
		return studentRepository.save(studentUpdate);
	}
	
	public void deleteStudent(Long id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        studentRepository.delete(student);
	}
	
}
