package com.example.demo.Controller;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@Controller // instead of this we can use @RestController
@RestController // @Controller + @ResponseBody
//@RequestMapping("/api/v1")
public class EmployeeController {


    @Autowired
    private EmployeeService eService;

//    @Value("${app.name}")
//    private String appName;
//
//    @Value("${app.version}")
//    private String appVersion;
//
//    @GetMapping("/version")
//    public  String getAppDetails(){
//        return appName + "-" + appVersion;
//
//    }

//    //we have created first rest end point called employees
//    @GetMapping( "/employees") // mapping uri to the handler mtd getEmployees
//   // @ResponseBody // to get response from this mtd //one of the handler mtd //It is matched to a uri (/employees) //localhost:8080/employees
//    public String getEmployees(){
//        return "displaying the list of employees";
//    }
    @GetMapping("/employees")
    public List<Employee>getEmployees(){

        return eService.getEmployees();
    }

//    @GetMapping("/employees/{id}")
//    public String getEmployee(@PathVariable Long id){
//        return "Fetching employee details id " + id;
//    }


    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return eService.getSingleEmployee(id);
    }
//    @PostMapping("/employees")
//    public String saveEmployee(@RequestBody Employee employee){
//        return "saving the employee details to the database" + employee;
//    }

    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        return eService.saveEmployee(employee);
    }

//    @PutMapping("/employees/{id}")
//    public Employee updateEmployee (@PathVariable Long id, @RequestBody Employee employee){
//        System.out.println("updating the values for employee data for id " + id);
//        return employee;
//
//    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee (@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return eService.updateEmployee(employee);
    }

    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam Long id){
        eService.deleteEmployee(id);
    }



}
