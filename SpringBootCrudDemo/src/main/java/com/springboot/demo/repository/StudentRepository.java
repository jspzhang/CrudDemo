package com.springboot.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Serializable>{

}
