package com.example.demo_springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo_springboot.dto.StudentRequestDTO;
import com.example.demo_springboot.dto.StudentV1ResponseDTO;
import com.example.demo_springboot.dto.StudentV2ResponseDTO;
import com.example.demo_springboot.entity.Student;
import com.example.demo_springboot.exception.InvalidAgeException;
import com.example.demo_springboot.repository.StudentRepository;

@Service
public class StudentV2Service {

	private StudentRepository studentRepository;
	private ModelMapper mapper;
	

	public StudentV2Service(StudentRepository studentRepository, ModelMapper mapper) {
		this.studentRepository = studentRepository;
		this.mapper = mapper;
	}

	public StudentV2ResponseDTO findStudentById(int id) {
		
		Student student = studentRepository.findById(id).get();
//		StudentRequestDTO studentRequestDTO = new StudentRequestDTO(student.getName(), student.getAge(), 
//												student.getEmail(), student.getPassword());
		
		StudentV2ResponseDTO studentV2ResponseDTO = mapper.map(student, StudentV2ResponseDTO.class);
		return studentV2ResponseDTO;
	}

	public StudentV2ResponseDTO saveStudent(StudentRequestDTO studentRequestDTO) {
		if(studentRequestDTO.getAge() < 18) throw new InvalidAgeException("Age is less than 18");
		
//		Student student = new Student(studentRequestDTO.name(), studentRequestDTO.age(), 
//									studentRequestDTO.email(), studentRequestDTO.password());
		
		Student student = mapper.map(studentRequestDTO, Student.class);
		Student savedStudent = studentRepository.save(student);
		
		StudentV2ResponseDTO studentV2ResponseDTO = mapper.map(savedStudent, StudentV2ResponseDTO.class);
		
		return studentV2ResponseDTO;
	}

	public List<StudentV2ResponseDTO> getAllStudents() {
//		List<StudentResponseDTO> studentDTOList =  
		return studentRepository.findAll().stream().map(s -> mapper.map(s, StudentV2ResponseDTO.class)).collect(Collectors.toList());
	}
	
	
	
}
