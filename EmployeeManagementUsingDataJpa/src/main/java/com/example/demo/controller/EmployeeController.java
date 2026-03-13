package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

//collection of all endpoints is know as API
@RestController  //@Controller+@ResponseBody
@RequestMapping("/employee") // http://locahost:1234/employees
@AllArgsConstructor
public class EmployeeController {

	//@Autowired   no need to write field injection but use constructor and above write @Autowired(but no need to write autowire)
	
	EmployeeService service;
	
//	public EmployeeController(EmployeeService service) {
//		super();
//		this.service = service;
//	}
	@GetMapping("/message") // http://locahost:1234/employees/message//end point
	// 
	public String getMessage() {
		return "Hellooo";

	}
	@PostMapping("/save")    //http://localhost:2021/employees/save
	public String createEmployee(@RequestBody  @Validated Employee employee) {    //@RequestBody = Take JSON from body → convert to object.
		return service.saveEmployee(employee);
	}
	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	@DeleteMapping("/delete/{id}")    //http://localhost:2021/employees/delete/123
	public String removeEmployee( @PathVariable("id") int  empId) {  //map url varible with path name
		return service.deleteEmployee(empId);
	}
	@GetMapping("/fetch/{id}")
	public Employee getEmployee( @PathVariable("id") int  empId) throws EmployeeNotFound {  
		return service.getEmployee(empId);
	}
	@GetMapping("/fetchAll")
	public List<Employee> getAllEmployees() {  
		return service.getAllEmployees();
	}
	@GetMapping("/fetchAllByDesg/{empDesg}")
	public List<Employee> getAllEmployees(@PathVariable("empDesg") String empDesg) {  
		return service.getEmployeesByDesg(empDesg);
	}
	@GetMapping("/fetchAllBetweenJpa")   //http://localhost:2021/employees/fetchAllBetween?sal1=10000&sal2=18000
	public List<Employee> getAllEmployees(@RequestParam("sal1") int initialSal,@RequestParam("sal2") int finalSal) {  //map url varible with path name
		return service.getEmployeesBetweenSal(initialSal,finalSal);
	}

}
