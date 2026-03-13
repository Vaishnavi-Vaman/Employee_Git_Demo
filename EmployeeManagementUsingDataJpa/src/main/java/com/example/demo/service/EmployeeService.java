package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.model.Employee;

public interface EmployeeService {
	public abstract String saveEmployee(Employee employee); // persist() //parameter is employee obj retrun type is
	// string

public abstract String updateEmployee(Employee employee);// merge()

public abstract String deleteEmployee(int empId); // remove()//no need entire emp info so use needed one

public abstract Employee getEmployee(int empId) throws EmployeeNotFound; // find()

public abstract List<Employee> getAllEmployees(); // createQuery("query")

public abstract List<Employee> getEmployeesByDesg(String empDesg); // we need to take many emp desg so we will get
				// many emp so use list of emp

public abstract List<Employee> getEmployeesBetweenSal(int initialSal, int finalSal);
}
