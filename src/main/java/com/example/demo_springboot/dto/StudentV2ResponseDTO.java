package com.example.demo_springboot.dto;

public class StudentV2ResponseDTO{
	private int id;
	private String name;
	
	
	public StudentV2ResponseDTO() {
		super();
	}
	public StudentV2ResponseDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	

}
