package com.mph.sprbootdemo.service;

import java.util.List;
import java.util.Optional;

import com.mph.sprbootdemo.entity.Sdepartment;

public interface SdepartmentService {
	public Sdepartment createDepartment(Sdepartment department);
	public List<Sdepartment> getAllDepartments();
	public Sdepartment updateDepartment(Sdepartment department);
	public void deleteDepartment(long did);
	public Optional<Sdepartment> getDepartmentById(long did);
}
