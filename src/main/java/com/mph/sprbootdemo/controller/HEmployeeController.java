package com.mph.sprbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mph.sprbootdemo.entity.Semployee;
import com.mph.sprbootdemo.service.SemployeeService;

@Controller
public class HEmployeeController {
	@Autowired
   private SemployeeService semployeeService ;

	Semployee employee;
	
	@RequestMapping(value = "/registerpage", method=RequestMethod.GET)
	public ModelAndView registerMethod() {
		return new ModelAndView("register");
	}
	@RequestMapping(value = "/loginpage", method=RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	@RequestMapping(value = "/addEmp", method=RequestMethod.POST)
	public ModelAndView signup(@RequestParam("txtename") String name,
@RequestParam("txtemail") String email,
@RequestParam("txtpass") String pass,
@RequestParam("txtgender") String gender)
 {
		System.out.println(name +" "+email+" "+pass+" "+gender);
		employee = new Semployee();
		employee.setEname(name);
		employee.setEmail(email);
		employee.setPassword(pass);
		employee.setGender(gender);
		semployeeService.createEmployee(employee);
		return new ModelAndView("login");
	}
	
//	@RequestMapping(value = "/signin", method=RequestMethod.POST)
//	public ModelAndView signin(@RequestParam("txtemail") String email
//			){
//	
//		Semployee emp=semployeeService.getEmployeeByEmail(email);
//		if(emp==null) {
//		ModelAndView mv= new ModelAndView("home");
//		mv.addObject("NOTIFICATION","Employe does not exist");
//		return mv;
//		
//		}
//		else {
//			return allEmployees();
//		}
//		
//	}
//	@RequestMapping(value = "/delete", method=RequestMethod.GET)
//	public ModelAndView deleteEmp(Semployee emp) {
//		semployeeService.deleteEmployee(emp.getEid());
//		List<Semployee> x=semployeeService.getAllEmployee();
//		ModelAndView v=new ModelAndView("home");
//		v.addObject("allemp",x);
//		return v;
//
//	}
//	@RequestMapping(value = "/edit", method=RequestMethod.GET)
//	public ModelAndView editEmp(Semployee emp) {
//		
//		ModelAndView v=new ModelAndView("edit");
//		
//		return v;
//		
//		
//	}
//	@RequestMapping(value = "/updateEmp", method=RequestMethod.POST)
//	public ModelAndView updateEmp(@ModelAttribute Semployee emp) {
//		 System.out.println("*****"+emp);
//		List<Semployee> x=(List<Semployee>) semployeeService.updateEmployee(emp);
//		ModelAndView v=new ModelAndView("home");
//		v.addObject("allemp",x);
//		return v;
//		
//		
//	}
//	public ModelAndView allEmployees(){
//		List<Semployee> list = semployeeService.getAllEmployee();
//		ModelAndView mv= new ModelAndView("home");
//		mv.addObject("allemp",list);
//		return mv;
//	}
}
