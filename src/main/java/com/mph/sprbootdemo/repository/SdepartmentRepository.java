package com.mph.sprbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mph.sprbootdemo.entity.Sdepartment;

@Repository
public interface SdepartmentRepository extends JpaRepository<Sdepartment, Long>{

}