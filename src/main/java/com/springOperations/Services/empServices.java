package com.springOperations.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springOperations.Entities.empEntity;

@Service
public class empServices {

    private List<empEntity> employees;

    public empServices() {
        employees = new ArrayList<empEntity>();
        employees.addAll(
                List.of(
                        new empEntity(1, "John Doe", "johndoe@example.com", 123456789),
                        new empEntity(2, "Jane Smith", "janesmith@example.com", 987654321),
                        new empEntity(3, "Alice Johnson", "alice@example.com", 555111223)
                )
        );
    }
    
    public List<empEntity> findAllEmployees(){
    	return employees;
    }
    
    public empEntity findEmployeeById(int id) {
    	for(int i=0; i<employees.size(); i++) {
    		if(employees.get(i).getId() == id) {
    			return employees.get(i);
    		}
    	}
    	return null;
    }
    
    public empEntity addEmployee(empEntity temp) {
        int newEmployeeId = temp.getId();
        for (empEntity existingEmployee : employees) {
            if (existingEmployee.getId() == newEmployeeId) {
            	// Employee with the same ID already exists
                return null; 
            }
        }
        // If no employee with the same ID is found, add the new employee
        empEntity newEmployee = new empEntity();
        newEmployee.setId(newEmployeeId);
        newEmployee.setName(temp.getName());
        newEmployee.setEmail(temp.getEmail());
        newEmployee.setPhone(temp.getPhone());
        employees.add(newEmployee);
        return newEmployee;
    }

    
    public empEntity updateEmployee(empEntity temp) {
        int updatedId = -1;
        int currentId = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == temp.getId()){
                updatedId = temp.getId();
                currentId = i;
                break;
            }
        }
        if(currentId != -1) {
        	empEntity updatedEmployee = new empEntity();
            updatedEmployee.setId(updatedId);
            updatedEmployee.setName(temp.getName());
            updatedEmployee.setEmail(temp.getEmail());
            updatedEmployee.setPhone(temp.getPhone());
            employees.set(currentId, temp);
            return updatedEmployee;
        }
        return null;
    }
    
    public String deleteEmployee(int id) {
    	employees.removeIf(x -> x.getId() == id);
    	if(findEmployeeById(id) == null) {
    		return "Deleted";
    	}
		return null;
    	
    }
    
}
