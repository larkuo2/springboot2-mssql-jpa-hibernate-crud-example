package net.guides.springboot2.crud.service;

import net.guides.springboot2.crud.domain.Employee;
import net.guides.springboot2.crud.model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    //GET ALL
    public Page<Employee> findAll(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }
    //GET BY ID
    public Employee getEmployeeById(Long id){
        return  employeeRepository.findById(id).get();
    }
    //POST
    public void createEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    //PUT
    public void editEmployee(Long id, String name, String email, String role){
        Employee tempEmployee = employeeRepository.findById(id).get();
        tempEmployee.setName(name);
        tempEmployee.setEmail(email);
        tempEmployee.setRole(role);
    }
    //DELETE
    public void deleteEmployee(Employee employee){
        employeeRepository.delete(employee);
    }
}
