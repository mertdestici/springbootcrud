package com.springboot.springbootcrud.dao;

import com.springboot.springbootcrud.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends GenericRepository<Employee,String> {
    Employee findEmployeeById(int id);
    List<Employee> findAll();
    void deleteById(int id);
    List<Employee> findByFirstNameEndsWith(String firstName);
    List<Employee> findEmployeeByEmail(String email, Pageable pageable);
    Page<Employee> findByEmailAndFirstNameInOrderById(String email, List<String> firstName, Pageable pagination);
}
