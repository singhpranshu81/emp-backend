package com.mph.sprbootdemo.controller;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import com.mph.sprbootdemo.entity.Sdepartment;
import com.mph.sprbootdemo.service.SdepartmentService;
 
@RestController
@RequestMapping("/sprbootdemo/sdepartments")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*",
origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE} )
 
public class SdepartmentRestController {
 
    @Autowired
    private SdepartmentService sdepartmentService;
 
    // Get all departments
    @GetMapping("/listalldepts")
    public ResponseEntity<List<Sdepartment>> getAllDepartments() {
    	List<Sdepartment> deptlist= sdepartmentService.getAllDepartments();
        return ResponseEntity.ok(deptlist);
    }
 
    // Get a department by ID
    @GetMapping("/{id}")
    public ResponseEntity<Sdepartment> getDepartmentById(@PathVariable Long id) {
        Optional<Sdepartment> department = sdepartmentService.getDepartmentById(id);
        if (department.isPresent()) {
            return ResponseEntity.ok(department.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    // Create a new department
    @PostMapping("/addDept")
    public Sdepartment createDepartment(@RequestBody Sdepartment sdepartment) {
        return sdepartmentService.createDepartment(sdepartment);
    }
 
    // Update an existing department
    @PutMapping("/{id}")
    public ResponseEntity<Sdepartment> updateDepartment(
            @PathVariable Long id, @RequestBody Sdepartment sdepartmentDetails) {
        Optional<Sdepartment> department = sdepartmentService.getDepartmentById(id);
        if (department.isPresent()) {
            Sdepartment existingDepartment = department.get();
            existingDepartment.setName(sdepartmentDetails.getName());
            existingDepartment.setEmployees(sdepartmentDetails.getEmployees());
            Sdepartment updatedDepartment = sdepartmentService.createDepartment(existingDepartment);
            return ResponseEntity.ok(updatedDepartment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    // Delete a department
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        Optional<Sdepartment> department = sdepartmentService.getDepartmentById(id);
        if (department.isPresent()) {
            sdepartmentService.deleteDepartment(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}