package org.codingwallah.em_project.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.codingwallah.em_project.entity.Employee;
import org.codingwallah.em_project.service.EmployeeService;
import org.codingwallah.em_project.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin("http://localhost:3000/")
public class EmpController {

    // Dependency Injection
    @Autowired
    EmployeeService employeeService = new EmployeeServiceImp();
    // EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.readEmployee(id);
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);

    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id))
            return "Delete Successfully";
        return "Not Found";
    }

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);
    }

}
