package com.example.swipemangement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	private String employeeName;
	private String phone;
	private String email;
	private String projectName;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.MERGE)
	private List<Swipe> swipes;


	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public List<Swipe> getSwipes() {
		return swipes;
	}

	public void setSwipes(List<Swipe> swipes) {
		this.swipes = swipes;
	}

}
