package com.mph.sprbootdemo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sdepartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;

	private String name;

	//@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OneToMany
	private List<Semployee> employees;

	// Getters and setters
	

	public String getName() {
		return name;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Semployee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Semployee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Sdepartment [deptId=" + deptId + ", name=" + name + ", employees=" + employees + "]";
	}

}