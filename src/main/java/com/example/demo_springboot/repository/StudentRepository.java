package com.example.demo_springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_springboot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByName(String name);
}
