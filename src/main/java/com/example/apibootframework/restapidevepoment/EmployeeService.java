package com.example.apibootframework.restapidevepoment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employees> getEmployee(){
        var employeeList= Arrays.asList(
                new Employees(1,"larry,","chuks","larry.com"),
                new Employees(2,"Ebu,","chuk","ebu.com")
        );
        employeeRepository.saveAll(employeeList);
        return employeeRepository.findAll();
    }
    public Employees getEmployee(int id){
        if(employeeRepository.findById(id).isEmpty()){
            throw new IllegalArgumentException("Employee with given ID is not available");
        }
        return employeeRepository.getReferenceById(id);
    }

    public Employees addEmployee(Employees employees) {
        int id = employees.getId();
        if(employeeRepository.existsById(id)){
            throw  new IllegalArgumentException("ID already exist");
        }
        employeeRepository.save(employees);
        return employees;
    }

    public Employees updateEmployee(Employees employee, int id) {
        if (employeeRepository.existsById(id)){
            //employeeRepository.deleteById(id);
            deleteEmployee(id);
            employeeRepository.save(employee);
        }else {
            throw new IllegalArgumentException("Employee with ID does not exist");
        }
        return employee;

    }

    public String deleteEmployee(int id) {
        if(!employeeRepository.existsById(id)){
            throw  new IllegalArgumentException("ID Does not exist");
        }
        employeeRepository.deleteById(id);
        return "Deletion successful";
    }

    public List<Employees> getEmployeeWithQuery(int limit) {
       return employeeRepository.findAll().stream().limit(limit).collect(Collectors.toList());
    }
}
