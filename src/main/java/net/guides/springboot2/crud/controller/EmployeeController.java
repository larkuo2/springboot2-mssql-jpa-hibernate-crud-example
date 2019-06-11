package net.guides.springboot2.crud.controller;

import net.guides.springboot2.crud.domain.Employee;
import net.guides.springboot2.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //GET
    @GetMapping(value = "/employees")
    public Page<Employee> getAllEmployees(@RequestParam(value="page", defaultValue = "0") Integer page,
                                          @RequestParam(value="limit", defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return employeeService.findAll(pageable);
    }

    @GetMapping(value = "/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    //PUT - All
    @PutMapping(value = "/address/{id}")
    public void editEmployeeDetails(@PathVariable("id") Long id,
                                    @RequestParam(value ="name", defaultValue = "Unavailable") String name,
                                    @RequestParam(value ="email", defaultValue = "Unavailable") String email,
                                    @RequestParam(value ="role", defaultValue = "Unavailable") String role){
        employeeService.editEmployee(id, name, email, role);

    }

    //POST
    @PostMapping(value = "/address/{id}")
    public void addNewEmployee(@PathVariable("id") Long id,
                               @RequestParam(value = "name", defaultValue = "Unavailable") String name,
                               @RequestParam(value = "email", defaultValue = "Unavailable") String email,
                               @RequestParam(value = "role", defaultValue = "Unavailable") String role,
                               @RequestParam(value = "employedOn", defaultValue = "01-01-2010") Date employedOn){
        Employee tempEmployee = new Employee(name, email, role, employedOn);
        employeeService.createEmployee(tempEmployee);
    }

    //DELETE
    @DeleteMapping(value = "/employee/{id}")
    public void deleteEmployee(@PathVariable("id")Long id){
        Employee tempEmployee = employeeService.getEmployeeById(id);
        employeeService.deleteEmployee(tempEmployee);
    }


}
