package com.example.demo.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize){
        Pageable pages = PageRequest.of(pageNumber, pageSize);
        return eRepository.findAll(pages).getContent();
       // return eRepository.findAll();
    }



    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = eRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new RuntimeException("Employee not found for id "+ id);

    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return eRepository.findByName(name);

    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        return eRepository.findByNameAndLocation(name, location);
    }

    @Override //Trying to implement sorting
    public List<Employee> getEmployeesByKeyword(String name) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return  eRepository.findByNameContaining(name);
    }


//    private static List<Employee> list = new ArrayList<>();
//
//    static{
//        Employee e = new Employee();
//        e.setName("absush");
//        e.setAge(25L);
//        e.setDepartment("IT");
//        e.setEmail("absus@gmail.com");
//        e.setLocation("India");
//        list.add(e);
//
//        e= new Employee();
//        e.setName("absush1710");
//        e.setAge(26L);
//        e.setDepartment("CSE");
//        e.setEmail("absus1710@gmail.com");
//        e.setLocation("India_Loc");
//        list.add(e);
//    }




}
