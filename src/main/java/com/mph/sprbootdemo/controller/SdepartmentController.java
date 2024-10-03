package com.mph.sprbootdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.sprbootdemo.entity.Sdepartment;
import com.mph.sprbootdemo.service.SdepartmentService;

@RestController
@RequestMapping("/sprbootdemo/sdepartment")
@CrossOrigin(allowCredentials = "false", allowedHeaders = "*", origins = "*",
methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SdepartmentController {
	@Autowired
	private SdepartmentService sdepartmentService;
	@PostMapping("/addDept")
	public ResponseEntity<Sdepartment> addDepartment(@RequestBody Sdepartment sdepartment){
		System.out.println("#################" + sdepartment);
		sdepartmentService.createDepartment(sdepartment);
		return new ResponseEntity(sdepartment, HttpStatus.CREATED);
	}
	@GetMapping("/listalldepts")
	public ResponseEntity<List<Sdepartment>> listAllDepts(){
		List<Sdepartment> deptlist = sdepartmentService.getAllDepartments();
		return ResponseEntity.ok(deptlist);
	}
	@GetMapping("/finddept/{did}")
	public ResponseEntity<Optional<Sdepartment>> getDepartmentById(@PathVariable int did){
		Optional<Sdepartment> emp = sdepartmentService.getDepartmentById(did);
		return ResponseEntity.ok(emp);	
	}
}