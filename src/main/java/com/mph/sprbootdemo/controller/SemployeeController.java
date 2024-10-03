package com.mph.sprbootdemo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mph.sprbootdemo.entity.Sdepartment;
import com.mph.sprbootdemo.entity.Semployee;
import com.mph.sprbootdemo.entity.Suser;
import com.mph.sprbootdemo.service.SemployeeService;
import com.mph.sprbootdemo.service.SuserService;

import ch.qos.logback.core.model.Model;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/sprbootdemo/semployee")
@CrossOrigin(allowCredentials = "false" , allowedHeaders = "*" , origins = "*" ,
methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SemployeeController {
	@Autowired
	private SemployeeService semployeeService;
  @Autowired
	private SuserService suserService;
	
	Semployee employee;

	@RequestMapping(value = "/registerpage", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public ModelAndView signup(@RequestParam("txteid") int eid,@RequestParam("txtename") String name, @RequestParam("txtemail") String email,
			@RequestParam("txtpass") String pass, @RequestParam("txtgender") String gender,
			@RequestParam("txtdob") LocalDate dob, @RequestParam("txtdeptid") String deptid) {
		System.out.println(name + " " + email + " " + pass + " " + gender +dob + deptid);
		employee = new Semployee();
		employee.setEid(eid);
		employee.setEname(name);
		employee.setEmail(email);
		employee.setPassword(pass);
		employee.setGender(gender);
		employee.setDob(dob);
		Sdepartment dept = new Sdepartment();
		dept.setDeptId(Long.parseLong(deptid));
		employee.setDepartment(dept);
		semployeeService.createEmployee(employee);
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signin(@RequestParam("txtemail") String email, @RequestParam("txtpass") String pass) {
		// employee = new Semployee();
		// employee.setEmail(email);
		Semployee emp = semployeeService.getByEmail(email);
		
		
		System.out.println("&&&&&&& " + emp + " &&&&&&");
		if (emp == null) {
			ModelAndView mv = new ModelAndView("home");
			mv.addObject("NOTIFICATION", "Employee Does not exist");
			return mv;
		} else {
			return allEmployees();
		}

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmp(Semployee emp) {
		ModelAndView mv = new ModelAndView("edit");
		return mv;
	}

	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	public ModelAndView updateEmp(@ModelAttribute(name = "Semployee") Semployee emp, Model model) {

		if (emp.getEid() == 0) {
			System.out.println("Employee ID is missing. Update failed.");
			ModelAndView mv = new ModelAndView("edit");
			mv.addObject("NOTIFICATION", "Employee ID is missing. Cannot update.");
			return mv;
		}
		System.out.println("**********" + emp);
		List<Semployee> li = semployeeService.updateEmployee(emp);
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("allemp", li);
		return mv;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmp(Semployee emp) {
		List<Semployee> li = semployeeService.deleteEmployee(emp.getEid());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("allemp", li);
		return mv;
	}

	public ModelAndView allEmployees() {
		List<Semployee> li = semployeeService.getAllEmployees();
		System.out.println("-----------" +li);
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("allemp", li);
		return mv;

	}

//@Operation(summary = "Find User by username", description = "Retrieves an employee by their Email")
////	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User found"),
////			@ApiResponse(responseCode = "401", description = "User not Authorized") })
//	@GetMapping("/login/{username}/{pwd}/{role}")
//	public ResponseEntity<?> login(@PathVariable String username, @PathVariable String pwd, @PathVariable String role) {
//		Suser susr = new Suser();
//		susr.setUsername(username);
//		susr.setPassword(pwd);
//		susr.setRole(role);
//		System.out.println("********* " + susr);
//
//		// Use findByUsername to retrieve the user wrapped in Optional
//		Optional<Suser> foundUser = suserService.findByUsername(username);
//
//		// Check if the user is present in Optional
//		if (foundUser.isPresent()) {
//			Suser actualUser = foundUser.get();
//			System.out.println("Actual user " + actualUser);
//			// Check if the password and role match
//			if (actualUser.getPassword().equals(pwd) && actualUser.getRole().equals(role)) {
//
//				return ResponseEntity.ok(actualUser); // Return the found user if credentials are valid
//			} else {
//				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentialssss");
//			}
//		} else {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.d.d.d");
//		}
//	}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
