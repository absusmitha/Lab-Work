package com.example.demo.Repository;


import com.example.demo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, Long>{

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    List<Employee> findByName(String name);

    List<Employee> findByNameAndLocation(String name, String location);

    List<Employee> findByNameContaining(String Keyword);

    //List<Employee> findByNameLike(String "%"+Keyword+"%");
}
