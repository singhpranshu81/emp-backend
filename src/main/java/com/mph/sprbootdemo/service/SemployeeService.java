package com.mph.sprbootdemo.service;

import java.util.List;
import java.util.Optional;

import com.mph.sprbootdemo.entity.Semployee;

public interface SemployeeService {
	public void createEmployee(Semployee employee);
	public List<Semployee> getAllEmployees();
	public List<Semployee> updateEmployee(Semployee employee);
	public List<Semployee> deleteEmployee(int eid);
	public Optional<Semployee> getEmployeeById(int eid);
	public Semployee getEmpByEname(String name);
	//public Semployee getEmployeeByEmail(String email);
	public List<Semployee> getEnameContaining(String name);
	//public List<Semployee> getEnameOrderByEid();
	public List<Semployee> getEmpByEnameLike(String name);
	public List<Semployee> getEmpByGender(String gender);
	public Semployee  getEmployeesByEmail(String param); 

	public List<Semployee> getByDepartmentDeptId(Long deptId);
	public Semployee getByEmail(String email);
	
	public Integer getNextEmployeeId();
}
