package com.springboot.demo.controller;

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

import com.springboot.demo.model.Student;
import com.springboot.demo.service.StudentService;

@RestController
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;;
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentService.getAll();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@PostMapping("/student")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		String status = studentService.InsertUpdate(student);
		return new ResponseEntity<>(status, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/student")
	public ResponseEntity<String> updateStudent(@RequestBody Student student){
		String status = studentService.InsertUpdate(student);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		String status = studentService.deleteById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	

}
