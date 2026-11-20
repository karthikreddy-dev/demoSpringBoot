package com.example.demo_springboot.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_springboot.dto.StudentRequestDTO;
import com.example.demo_springboot.dto.StudentV1ResponseDTO;
import com.example.demo_springboot.service.StudentService;
import com.example.demo_springboot.service.StudentV1Service;

@RestController
@RequestMapping("/api/v1/students")
public class StudentV1Controller {
	
	private StudentV1Service studentV1Service;
	private StudentService studentService;
	

	public StudentV1Controller(StudentV1Service studentV1Service, StudentService studentService) {
		this.studentV1Service = studentV1Service;
		this.studentService = studentService;
	}

	@GetMapping
	public ResponseEntity<List<StudentV1ResponseDTO>> getStudents() {
		
		return new ResponseEntity<>(studentV1Service.getAllStudents(), HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentV1ResponseDTO>> getStudentsByPage(Pageable pageable) {
		
		return new ResponseEntity<>(studentV1Service.getAllStudentsByPage(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<List<StudentV1ResponseDTO>> getAllStudentsByName(@PathVariable String name) {
		
		return new ResponseEntity<>(studentV1Service.getAllStudentsByName(name), HttpStatus.OK);
	}

//	@GetMapping("/{id}") 
//	public ResponseEntity<StudentV1ResponseDTO> findStudentById(@PathVariable int id) {
//		
//		StudentV1ResponseDTO studentResponseDTO = studentV1Service.findStudentById(id);
//		return new ResponseEntity<>(studentResponseDTO, HttpStatus.OK);
//	}
	
	@PostMapping
	public ResponseEntity<String> saveStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
		StudentV1ResponseDTO studentResponseDTO = studentService.saveStudent(studentRequestDTO);
			
			return new ResponseEntity<>("Student saved" + studentResponseDTO, HttpStatus.CREATED);
	}
}
