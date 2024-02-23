package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	//localhost:8080/student
	//All Student
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		List<Student> students = repo.findAll();
		return students;
	}
	
	//localhost:8080/student/1
	// Student By Id
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		return student;
	}
	
	//localhost:8080/student/add
	//Add
	@PostMapping("/student/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student newStudent = repo.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
	}
	
	//Update
	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		student.setName("Rutvik");
		student.setPercentage(76);
		student.setBranch("ENTC");
		repo.save(student);
		return student;
	}
	
	//Delete
	@DeleteMapping("/student/delete/{id}")
	public void removeStudent(@PathVariable int id) {
		Student student = repo.findById(id).get();
		repo.delete(student);
	}
	

}
