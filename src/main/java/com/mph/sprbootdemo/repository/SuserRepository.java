package com.mph.sprbootdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mph.sprbootdemo.entity.Suser;

public interface SuserRepository extends JpaRepository<Suser, Long> {
	@Query("SELECT s FROM Suser s WHERE s.username like %:uname%")
	Optional<Suser> findByUsername(@Param("uname") String username);   
}