package com.example.demo_springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo_springboot.dto.StudentRequestDTO;
import com.example.demo_springboot.dto.StudentV1ResponseDTO;
import com.example.demo_springboot.entity.Student;
import com.example.demo_springboot.exception.InvalidAgeException;
import com.example.demo_springboot.repository.StudentRepository;

@Service
public class StudentV1Service {

	private StudentRepository studentRepository;
	private ModelMapper mapper;
	

	public StudentV1Service(StudentRepository studentRepository, ModelMapper mapper) {
		this.studentRepository = studentRepository;
		this.mapper = mapper;
	}

	public StudentV1ResponseDTO findStudentById(int id) {
		
		Student student = studentRepository.findById(id).get();
//		StudentRequestDTO studentRequestDTO = new StudentRequestDTO(student.getName(), student.getAge(), 
//												student.getEmail(), student.getPassword());
		
		StudentV1ResponseDTO studentV1ResponseDTO = mapper.map(student, StudentV1ResponseDTO.class);
		return studentV1ResponseDTO;
	}


	public List<StudentV1ResponseDTO> getAllStudents() {
//		List<StudentResponseDTO> studentDTOList =  
		return studentRepository.findAll().stream().map(s -> mapper.map(s, StudentV1ResponseDTO.class)).collect(Collectors.toList());
	}
	
	public List<StudentV1ResponseDTO> getAllStudentsByName(String name) {
//		List<StudentResponseDTO> studentDTOList =  
		return studentRepository.findByName(name).stream().map(s -> mapper.map(s, StudentV1ResponseDTO.class)).collect(Collectors.toList());
	}
	
	public List<StudentV1ResponseDTO> getAllStudentsByPage(Pageable pageable) {
//		List<StudentResponseDTO> studentDTOList =  
		Page<Student> page = studentRepository.findAll(pageable);
		
		List<Student> list = page.getContent();
		List<StudentV1ResponseDTO> rs = new ArrayList<StudentV1ResponseDTO>();
		for (Student student : list) {
			rs.add(mapper.map(student, StudentV1ResponseDTO.class));
		}
		
		return rs;
	}
	
}
