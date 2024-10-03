package com.mph.sprbootdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mph.sprbootdemo.entity.Sdepartment;
import com.mph.sprbootdemo.entity.Semployee;
import com.mph.sprbootdemo.entity.Suser;
import com.mph.sprbootdemo.exception.DepartmentNotFoundException;
import com.mph.sprbootdemo.service.SdepartmentService;
import com.mph.sprbootdemo.service.SemployeeService;
import com.mph.sprbootdemo.service.SuserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sprbootdemo/semployee")
@CrossOrigin(allowCredentials = "false" , allowedHeaders = "*" , origins = "*" ,
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SemployeeRestController {

	@Autowired
	private SemployeeService semployeeService;
	@Autowired
	private SdepartmentService sdepartmentService;

	  @Autowired
		private SuserService suserService;

	@PostMapping("/addempl")	
	public @ResponseBody
	ResponseEntity<?> addEmployee(@Valid @RequestBody Semployee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {

			Map<String, String> errors = new HashMap<>();
			bindingResult.getFieldErrors().forEach(error -> {
				errors.put(error.getField(), error.getDefaultMessage());
			});

			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		Sdepartment department = sdepartmentService.getDepartmentById(employee.getDepartment().getDeptId())
				.orElseThrow(() -> new DepartmentNotFoundException(
						"Department not found with ID: " + employee.getDepartment().getDeptId()));
		// employee.setDepartment(department);
		semployeeService.createEmployee(employee);
		return new ResponseEntity(employee, HttpStatus.CREATED);
	}

	// http://localhost:8082/sprbootdemo/semployee/listallemp
	@GetMapping("/listallemp")
	public ResponseEntity<List<Semployee>> listAllEmployees() {
		List<Semployee> emplist = semployeeService.getAllEmployees();
		return ResponseEntity.ok(emplist);

	}

	// http://localhost:8082/sprbootdemo/semployee/updateemp
	@PutMapping("/updateemp")
	public ResponseEntity<List<Semployee>> updateEmployee(@RequestBody Semployee employee) {
		List<Semployee> updatedEmp = semployeeService.updateEmployee(employee);
		return ResponseEntity.ok(updatedEmp);
	}

	// http://localhost:8082/sprbootdemo/semployee/deleteemp/3
	@DeleteMapping("/deleteemp/{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int eid) {
		semployeeService.deleteEmployee(eid);
		return ResponseEntity.ok("Employee " + eid + " Deleted ...");

	}

	// http://localhost:8082/sprbootdemo/semployee/findemp/2
	@GetMapping("/findemp/{eid}")
	public ResponseEntity<Optional<Semployee>> findEmployeeById(@PathVariable int eid) {
		Optional<Semployee> emp = semployeeService.getEmployeeById(eid);
		return ResponseEntity.ok(emp);
	}

	// localhost:8082/sprbootdemo/semployee/findempbyname/Anu
	@GetMapping("/findempbyname/{name}")
	public ResponseEntity<Semployee> getEmpByEname(@PathVariable String name) {
		Semployee emp = semployeeService.getEmpByEname(name);
		return ResponseEntity.ok(emp);
	}

	// http://localhost:8082/sprbootdemo/semployee/findempwithSri/Sri
	@GetMapping("/findempwithSri/{pattern}")
	public ResponseEntity<List<Semployee>> getEnameContaining(@PathVariable String pattern) {
		List<Semployee> emplist = semployeeService.getEnameContaining(pattern);
		return ResponseEntity.ok(emplist);
	}

	/*
	 * @GetMapping("/findename") public ResponseEntity<List<Semployee>>
	 * getEnameOrderByEid(){ List<Semployee>
	 * emplist=semployeeService.getEnameOrderByEid(); return
	 * ResponseEntity.ok(emplist); }
	 */
	// http://localhost:8082/sprbootdemo/semployee/findemplike/A
	@GetMapping("/findemplike/{pattern}")
	public ResponseEntity<List<Semployee>> getEmpByEnameLike(@PathVariable String pattern) {
		List<Semployee> emplist = semployeeService.getEmpByEnameLike(pattern);
		return ResponseEntity.ok(emplist);
	}

	// http://localhost:8082/sprbootdemo/semployee/findempbygender/Male
	@GetMapping("/findempbygender/{gender}")
	public ResponseEntity<List<Semployee>> getEmpByGender(@PathVariable String gender) {
		List<Semployee> emplist = semployeeService.getEmpByGender(gender);
		return ResponseEntity.ok(emplist);
	}

	// http://localhost:8082/sprbootdemo/semployee/findempbygenderqp?gender=Male
	@GetMapping("/findempbygenderqp")
	public ResponseEntity<List<Semployee>> getEmpByGenderQp(@RequestParam String gender) {
		List<Semployee> emplist = semployeeService.getEmpByGender(gender);
		return ResponseEntity.ok(emplist);
	}

	// http://localhost:8082/sprbootdemo/semployee/findempbyemail/srikanth@gmail.com
	@GetMapping("/findempbyemail/{email}")
	public ResponseEntity<Semployee> getEmployeesByEmail(@PathVariable String email) {
		Semployee emplist = semployeeService.getEmployeesByEmail(email);
		return ResponseEntity.ok(emplist);
	}

	@GetMapping("/findempbydeptid/{did}")
	public ResponseEntity<List<Semployee>> getEmployeeListUsingDeptId(@PathVariable Long did) {

		List<Semployee> emplist = semployeeService.getByDepartmentDeptId(did);
		return ResponseEntity.ok(emplist);
	}

@Operation(summary = "Find User by username", description = "Retrieves an employee by their Email")
//	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User found"),
//			@ApiResponse(responseCode = "401", description = "User not Authorized") })
	@GetMapping("/login/{username}/{pwd}/{role}")
	public ResponseEntity<?> login(@PathVariable String username, @PathVariable String pwd, @PathVariable String role) {
		Suser susr = new Suser();
		susr.setUsername(username);
		susr.setPassword(pwd);
		susr.setRole(role);
		System.out.println("********* " + susr);

		// Use findByUsername to retrieve the user wrapped in Optional
		Optional<Suser> foundUser = suserService.findByUsername(username);

		// Check if the user is present in Optional
		if (foundUser.isPresent()) {
			Suser actualUser = foundUser.get();
			System.out.println("Actual user " + actualUser);
			// Check if the password and role match
			if (actualUser.getPassword().equals(pwd) && actualUser.getRole().equals(role)) {

				return ResponseEntity.ok(actualUser); // Return the found user if credentials are valid
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentialssss");
			}
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.d.d.d");
		}
	}
  
       @GetMapping("/next-eid")
       public ResponseEntity<Integer> getNextEmployeeId(){
    	   Integer nextId = semployeeService.getNextEmployeeId();
    	   return ResponseEntity.ok(nextId);
       }





















}