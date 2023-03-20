package com.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.model.Student;
import com.springboot.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student getById(Integer id) {
		Optional<Student> findById = studentRepository.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
	
	public List<Student> getAll(){
		return studentRepository.findAll();
	}
	
	public String InsertUpdate(Student student) {
		studentRepository.save(student);//Insert or Update based on PK
		return "success";
	}
	
	public String deleteById(Integer id) {
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return "Delete Success";
		} else {
			return "No record found";
		}
	}

}
