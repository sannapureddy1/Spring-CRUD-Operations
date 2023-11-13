package com.springOperations.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springOperations.Entities.empEntity;
import com.springOperations.Services.empServices;

@RestController
@RequestMapping("/api")
public class empController {
	@Autowired
	private empServices service;
	
	@GetMapping("/employees")
	public List<empEntity> findAllEmployees(){
		return service.findAllEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public empEntity findEmployeeById(@PathVariable int id) {
		return service.findEmployeeById(id);
	}
	
	@PostMapping("/add")
	public empEntity addEmployee(@RequestBody empEntity temp) {
		return service.addEmployee(temp);
	}
	
	@PutMapping("/update")
	public empEntity updateEmployee(@RequestBody empEntity temp) {
		return service.updateEmployee(temp);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
}
