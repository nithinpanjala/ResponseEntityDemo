package com.stg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Employee;

@RestController
@RequestMapping(value = "api")
public class EmployeeController {

	@PostMapping(value = "/createEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		System.out.println("Employee created");
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@GetMapping (value = "/readEmployee/{empId}")
	public  ResponseEntity<Employee> readEmployee(@PathVariable("empId") int empId) {
		Employee temp = null;
		if (empId == 10) {
			temp = new Employee(10, "asd");
		} else if (empId == 20) {
			temp = new Employee(20, "zccx");
		}
		return new ResponseEntity<Employee>(temp, HttpStatus.FOUND);
	}

	@PutMapping(value = "/update/{newEmpName}")
	public  ResponseEntity<Employee>  updateEmployeeByEmpName(@RequestBody Employee employee , String newEmpName) {
		employee.setEmpName(newEmpName);
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}


}
