package com.example.apibootframework.restapidevepoment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(path = "/employees")
    public List<Employees> getEmployees(){
        return employeeService.getEmployee();
    }

    @GetMapping(path = "/employees/{id}")
    public Employees getOnetEmployee(@PathVariable int id){
        int size = employeeService.getEmployee().size();
        if(id > size ){
            System.out.println("the given ID is bigger than the total number of employyes or the ID is not available");
        }
        return  employeeService.getEmployee(id);
    }
    @GetMapping(path = "/employees/some")
    public List<Employees> getEmployeeMatchingQuery(@RequestParam(required = false) int limit){
        int size = employeeService.getEmployee().size();
        if(limit > size ){
            System.out.println("the given ID is bigger than the total number of employyes or the ID is not available");
        }
        return  employeeService.getEmployeeWithQuery(limit);
    }

    @PostMapping(path = "/employees")
    public Employees addEmployee(@RequestBody Employees employees){
        employeeService.addEmployee(employees);
        return employees;
    }

    @DeleteMapping(path = "/employees/{id}")
    public String deleteEmployee( @PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "/employees/{id}")
    public Employees updateEmployee( @RequestBody Employees employees, @PathVariable int id){
        return employeeService.updateEmployee(employees, id);
    }

}
