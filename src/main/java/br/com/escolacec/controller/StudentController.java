package br.com.escolacec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.escolacec.models.Student;
import br.com.escolacec.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public Iterable<Student> getAllStudent() {
		return studentService.getAllProfessores();
	}
	
	@PostMapping("/new")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	
	
}
