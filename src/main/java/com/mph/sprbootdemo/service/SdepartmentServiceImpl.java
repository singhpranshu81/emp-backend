package com.mph.sprbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mph.sprbootdemo.entity.Sdepartment;
import com.mph.sprbootdemo.repository.SdepartmentRepository;

@Service
public class SdepartmentServiceImpl implements SdepartmentService{

	@Autowired
	private SdepartmentRepository sdepartmentRepository;

	@Override
	public Sdepartment createDepartment(Sdepartment department) {
		return sdepartmentRepository.save(department);
		
	}

	@Override
	public List<Sdepartment> getAllDepartments() {
		return sdepartmentRepository.findAll();
	}

	@Override
	public Sdepartment updateDepartment(Sdepartment department) {
		return sdepartmentRepository.save(department);
	}

	@Override
	public void deleteDepartment(long did) {
		sdepartmentRepository.deleteById(did);
		
	}

	@Override
	public Optional<Sdepartment> getDepartmentById(long did) {
		return sdepartmentRepository.findById(did);
	}
	

}
