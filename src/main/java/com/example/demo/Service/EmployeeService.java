package com.example.demo.Service;

import com.example.demo.Model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees(int pageNumber, int pageSize);

    Employee saveEmployee(Employee employee); // to save records to db we use this mtd this takes employee object.

    Employee getSingleEmployee(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesByNameAndLocation(String name, String location);

    List<Employee> getEmployeesByKeyword(String name);
}
