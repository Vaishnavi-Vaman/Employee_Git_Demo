package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service     //to create employee obj 
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService{
   //we want to use methods of repo ,so telling obj to get
    //used to get obj of repo
	EmployeeRepository repository;
	@Override
	public String saveEmployee(Employee employee) {
		repository.save(employee);
		return "Employee saved Successfully";
	}

	@Override
	public String updateEmployee(Employee employee) {
		
		repository.save(employee);
		return "Employee Updated Successfully";
	}

	@Override
	public String deleteEmployee(int empId) {
		repository.deleteById(empId);
		return "Employee Deleted";
		//return repository.deleteEmployee(empId);
	}

	@Override
	public Employee getEmployee(int empId) throws EmployeeNotFound {
		Optional<Employee>optional = repository.findById(empId);
		
		if(optional.isEmpty()) {
			throw new EmployeeNotFound("No Employee Found with given Id");
		}
		else {
			return  optional.get();
		}
		
		//return repository.getEmployee(empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return repository.findAll();
	}

	@Override
	public List<Employee> getEmployeesByDesg(String empDesg) {
		
		return repository.getEmployeesByDesg(empDesg);
	}

	@Override
	public List<Employee> getEmployeesBetweenSal(int initialSal, int finalSal) {
		
		return repository.getEmployeesBetweenSal(initialSal, finalSal);
	}

}
