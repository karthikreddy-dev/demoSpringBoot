package com.example.demo_springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo_springboot.dto.StudentRequestDTO;
import com.example.demo_springboot.dto.StudentV1ResponseDTO;
import com.example.demo_springboot.entity.Student;
import com.example.demo_springboot.exception.InvalidAgeException;
import com.example.demo_springboot.repository.StudentRepository;

@Service
public class StudentService {

	private StudentRepository studentRepository;
	private ModelMapper mapper;
	

	public StudentService(StudentRepository studentRepository, ModelMapper mapper) {
		this.studentRepository = studentRepository;
		this.mapper = mapper;
	}


	public StudentV1ResponseDTO saveStudent(StudentRequestDTO studentRequestDTO) {
		if(studentRequestDTO.getAge() < 18) throw new InvalidAgeException("Age is less than 18");
		
//		Student student = new Student(studentRequestDTO.name(), studentRequestDTO.age(), 
//									studentRequestDTO.email(), studentRequestDTO.password());
		
		Student student = mapper.map(studentRequestDTO, Student.class);
		Student savedStudent = studentRepository.save(student);
		
		StudentV1ResponseDTO studentV1ResponseDTO = mapper.map(savedStudent, StudentV1ResponseDTO.class);
		
		return studentV1ResponseDTO;
	}

	
	
	
}
