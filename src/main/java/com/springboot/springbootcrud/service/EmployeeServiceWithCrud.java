package com.springboot.springbootcrud.service;

import com.springboot.springbootcrud.dao.EmployeeRepository;
import com.springboot.springbootcrud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceWithCrud {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        List<Employee> crudGetById = new ArrayList<>();
        Iterable<Employee> iterator = employeeRepository.findAll();
        iterator.forEach(crudGetById::add);
        return crudGetById;
    }

    public Employee getById(int id) {
        Employee employee = employeeRepository.findEmployeeById(id);
        return employee;
    }


    public Employee saveWithRepo(Employee employee) {
        boolean hasError = false;
        try {
            employee = employeeRepository.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public boolean deleteById(int id){
        boolean hasError = false;
        try {
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            hasError = true;
        }
        return hasError;

    }

    public List<Employee> findByFirstNameEndsWith(String firstName){
        List<Employee> employeesNameEndsWith = new ArrayList<>();
        try {
            Iterable<Employee> iterator = employeeRepository.findByFirstNameEndsWith(firstName);
            iterator.forEach(employeesNameEndsWith::add);
        } catch (Exception e) {
            e.printStackTrace();
            employeesNameEndsWith = null;
        }
        return employeesNameEndsWith;
    }

    public List<Employee> findAllByEmail(String email){
        List<Employee> employees = new ArrayList<>();
        try{
            Pageable firstElements = PageRequest.of(0, 3, Sort.by("firstName"));
            Iterable<Employee> iterator = employeeRepository.findEmployeeByEmail(email,firstElements);
            iterator.forEach(employees::add);
        }catch (Exception e){
            e.printStackTrace();
            employees = null;
        }
        return employees;
    }

    public List<Employee> findByFirstNameAndEmailInOrderById(String email, List<String> names) {

        List<Employee> entityList = new ArrayList<Employee>();
        Pageable pagination = PageRequest.of(0, 3);
        try{
        Iterable<Employee> iterator = employeeRepository.findByEmailAndFirstNameInOrderById(email, names, pagination);

        iterator.forEach(entityList::add);
        }catch(Exception e){
            e.printStackTrace();
        }
        return entityList;
    }

}
