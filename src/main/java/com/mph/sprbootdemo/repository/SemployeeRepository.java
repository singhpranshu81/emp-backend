package com.mph.sprbootdemo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mph.sprbootdemo.entity.Semployee;

@Repository
public interface SemployeeRepository  extends JpaRepository<Semployee, Integer>{
	public Semployee findByEname(String name);
	public Semployee findByEmail(String email);
	public List<Semployee> findByEnameContaining(String name);

	//JPQL 
	@Query("select e from Semployee e where e.ename like %:name%")
	public List<Semployee> findSemployeeByEnameLike(@Param("name") String name);
	
	//Native Query
	@Query(value="select * from Semployee e where e.gender= :gender",nativeQuery=true)
	public List<Semployee> findByGenderNative(@Param("gender") String name);
	
	public List<Semployee> findByDepartmentDeptId(Long deptId);
	
	@Query("SELECT COALESCE(MAX(e.eid),0) FROM Semployee e")
	public Integer findMaxEmployeeId();
}
