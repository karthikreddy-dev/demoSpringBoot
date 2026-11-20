package com.example.demo_springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_springboot.dto.StudentV2ResponseDTO;
import com.example.demo_springboot.service.StudentService;
import com.example.demo_springboot.service.StudentV1Service;
import com.example.demo_springboot.service.StudentV2Service;

@RestController
@RequestMapping("/api/v2/students")
public class StudentV2Controller {
	
	private StudentV2Service studentV2Service;
	private StudentService studentService;
	
	public StudentV2Controller(StudentV2Service studentV2Service, StudentService studentService) {
		super();
		this.studentV2Service = studentV2Service;
		this.studentService = studentService;
	}

	@GetMapping
	public ResponseEntity<List<StudentV2ResponseDTO>> getStudents() {
		
		return new ResponseEntity<>(studentV2Service.getAllStudents(), HttpStatus.OK);
	}

	@GetMapping("/{id}") 
	public ResponseEntity<StudentV2ResponseDTO> findStudentById(@PathVariable int id) {
		
		StudentV2ResponseDTO studentResponseDTO = studentV2Service.findStudentById(id);
		return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
	}
	
	
}
