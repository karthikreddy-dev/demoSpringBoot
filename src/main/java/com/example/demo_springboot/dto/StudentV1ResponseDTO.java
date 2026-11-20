package com.example.demo_springboot.dto;

public class StudentV1ResponseDTO{
	private int id;
	private String name;
	private String email;
	
	
	public StudentV1ResponseDTO() {
		super();
	}
	public StudentV1ResponseDTO(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
