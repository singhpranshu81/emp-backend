package com.mph.sprbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.sprbootdemo.entity.Semployee;
import com.mph.sprbootdemo.repository.SemployeeRepository;

@Service
@Transactional
public class SemployeeServiceImpl implements SemployeeService {

	@Autowired
	private SemployeeRepository semployeeRepository;

	@Override
	public void createEmployee(Semployee employee) {
		semployeeRepository.save(employee);
	}

	@Override
	public List<Semployee> getAllEmployees() {
		return semployeeRepository.findAll();
	}

	@Override
	public List<Semployee> updateEmployee(Semployee employee) {
		semployeeRepository.save(employee);
		return getAllEmployees();
	}

	@Override
	public List<Semployee> deleteEmployee(int eid) {
		semployeeRepository.deleteById(eid);
		return getAllEmployees();
	}

	@Override
	public Optional<Semployee> getEmployeeById(int eid) {
		return semployeeRepository.findById(eid);
	}

	@Override
	public Semployee getEmpByEname(String name) {
		return semployeeRepository.findByEname(name);
	}

	@Override
	public List<Semployee> getEnameContaining(String name) {
		return semployeeRepository.findByEnameContaining(name);
	}

	@Override
	public List<Semployee> getEmpByEnameLike(String name) {
		return semployeeRepository.findSemployeeByEnameLike(name);

	}

	@Override
	public List<Semployee> getEmpByGender(String gender) {

		return semployeeRepository.findByGenderNative(gender);
	}

	@Override
	public Semployee getEmployeesByEmail(String param) {
//		List<Semployee> emplist = semployeeRepository.findEmployeesByLogic(param);
//		System.out.println("emplist" + emplist);
//		return emplist;
		Semployee emp = semployeeRepository.findByEmail(param);
		System.out.println("emplist" + emp);
		return emp;
	}

	@Override
	public List<Semployee> getByDepartmentDeptId(Long deptId) {
		
		return semployeeRepository.findByDepartmentDeptId(deptId);
	}

	@Override
	public Semployee getByEmail(String email) {
		System.out.println("getb y email......." +email);
		Semployee emp = semployeeRepository.findByEmail(email);
		System.out.println("emplist" + emp);
		return emp;
		
	}

	@Override
	public Integer getNextEmployeeId() {
		Integer maxId= semployeeRepository.findMaxEmployeeId();
		return maxId+1;
	}

//	@Override
//	public List<Semployee> getEnameOrderByEid() {
//		
//		return semployeeRepository.findByEnameOrderByEid();
//	}
}
