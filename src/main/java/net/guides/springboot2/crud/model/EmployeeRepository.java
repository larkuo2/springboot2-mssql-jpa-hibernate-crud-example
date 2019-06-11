package net.guides.springboot2.crud.model;

import net.guides.springboot2.crud.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Page<Employee> findAll(Pageable pageable);
}
