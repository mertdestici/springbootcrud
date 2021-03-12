package com.springboot.springbootcrud.controller;

import com.springboot.springbootcrud.model.Employee;
import com.springboot.springbootcrud.service.EmployeeServiceWithCrud;
import com.springboot.springbootcrud.utils.EmployeeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceWithCrud employeeServiceWithCrud;

    @PostMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Map<String, Object> findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, Object> map = new HashMap<>();

        List<Employee> employees = employeeServiceWithCrud.getAll();

        if (employees == null) {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.E);
            map.put(EmployeeConstants.ERROR, EmployeeConstants.MESSAGE);
        } else {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.SUCCESS);
            map.put(EmployeeConstants.EMPLOYEE_LIST, employees);
        }
        return map;
    }

    @PostMapping(value = "/findById", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Map<String, Object> findById(@RequestParam int id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, Object> map = new HashMap<>();

        Employee employee = employeeServiceWithCrud.getById(id);

        if (employee == null) {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.E);
            map.put(EmployeeConstants.ERROR, EmployeeConstants.MESSAGE);
        } else {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.SUCCESS);
            map.put(EmployeeConstants.EMPLOYEE, employee);
        }
        return map;
    }

    @PostMapping(value = "/saveWithRepo", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Object> saveWithRepo(@ModelAttribute Employee employee, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, Object> map = new HashMap<>();

        Employee e = employeeServiceWithCrud.saveWithRepo(employee);

        if (e == null) {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.E);
            map.put(EmployeeConstants.ERROR, EmployeeConstants.MESSAGE);
        } else {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.SUCCESS);
            map.put(EmployeeConstants.EMPLOYEE, e);
        }
        return map;
    }

    @PostMapping(value = "/deleteById", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Object> deleteById(@RequestParam int id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, Object> map = new HashMap<>();

        boolean e = employeeServiceWithCrud.deleteById(id);

        if (e == true) {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.E);
            map.put(EmployeeConstants.ERROR, EmployeeConstants.MESSAGE);
        } else {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.SUCCESS);
            map.put(EmployeeConstants.EMPLOYEE, "silindi");
        }
        return map;
    }

    @PostMapping(value = "/endsWith", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Object> endsWith(@RequestParam String ends, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, Object> map = new HashMap<>();

        List<Employee> employees = employeeServiceWithCrud.findByFirstNameEndsWith(ends);

        if (employees == null) {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.E);
            map.put(EmployeeConstants.ERROR, EmployeeConstants.MESSAGE);
        } else {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.SUCCESS);
            map.put(EmployeeConstants.EMPLOYEE, employees);
        }
        return map;
    }

    @PostMapping(value = "/findAllByEmail", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Object> findAllByEmail(@RequestParam String email, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, Object> map = new HashMap<>();

        List<Employee> employees = employeeServiceWithCrud.findAllByEmail(email);

        if (employees == null) {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.E);
            map.put(EmployeeConstants.ERROR, EmployeeConstants.MESSAGE);
        } else {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.SUCCESS);
            map.put(EmployeeConstants.EMPLOYEE, employees);
        }
        return map;
    }

    @PostMapping(value = "/findByFirstNameInOrderById", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, Object> findByFirstNameInOrderById(@RequestParam String email, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, Object> map = new HashMap<>();

        List<String> firstName = new ArrayList<>();
        firstName.add("deneme1");
        firstName.add("deneme2");
        firstName.add("deneme3");

        List<Employee> employees = employeeServiceWithCrud.findByFirstNameAndEmailInOrderById(email,firstName);

        if (employees == null) {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.E);
            map.put(EmployeeConstants.ERROR, EmployeeConstants.MESSAGE);
        } else {
            map.put(EmployeeConstants.STATUS, EmployeeConstants.SUCCESS);
            map.put(EmployeeConstants.EMPLOYEE, employees);
        }
        return map;
    }


    //|-------------------------Repository--------------------------|
    //|                                                             |
    //|                                                             |
    //|                                                             |
    //|-------------------------------------------------------------|


}
