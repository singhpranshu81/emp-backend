package com.mph.sprbootdemo.entity;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Semployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "The user's Id is required.")
	@Positive(message = "The user's Id must be greater than 0")
	private int eid;

	@Size(min = 5, max = 20, message = "Name must be between 5 and 20 character")
	@Pattern(regexp = "[^0-9]*", message = "Name must not contain numbers")
	@NotBlank(message = "Name is mandatory field")
	private String ename;

	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is a mandatory field")
	private String email;

	@Size(min = 8, message = "Password must be at least 8 characters")
	@NotBlank(message = "Password is a mandatory field")
	private String password;

	@NotBlank(message = "Gender is a mandatory field")
	@Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")

	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "Date should be in past")
	private LocalDate dob;

	@ManyToOne
	private Sdepartment department;
	
	@Pattern(regexp = "Admin|Employee", message = "Role must be Admin or Employee")
	@NotBlank(message = "Role is a mandatory field")
	private String role;

	public Semployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Semployee(
			@NotNull(message = "The user's Id is required.") @Positive(message = "The user's Id must be greater than 0") int eid,
			@Size(min = 5, max = 20, message = "Name must be between 5 and 20 character") @Pattern(regexp = "[^0-9]*", message = "Name must not contain numbers") @NotBlank(message = "Name is mandatory field") String ename,
			@Email(message = "Email should be valid") @NotBlank(message = "Email is a mandatory field") String email,
			@Size(min = 8, message = "Password must be at least 8 characters") @NotBlank(message = "Password is a mandatory field") String password,
			@NotBlank(message = "Gender is a mandatory field") @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other") String gender,
			@Past(message = "Date should be in past") LocalDate dob, Sdepartment department,
			@Pattern(regexp = "Admin|Employee", message = "Role must be Admin or Employee") @NotBlank(message = "Role is a mandatory field") String role) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.department = department;
		this.role = role;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Sdepartment getDepartment() {
		return department;
	}

	public void setDepartment(Sdepartment department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Semployee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", dob=" + dob + ", department=" + department + ", role=" + role + "]";
	}

	
}
