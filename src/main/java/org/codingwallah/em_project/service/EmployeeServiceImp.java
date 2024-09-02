package org.codingwallah.em_project.service;

import java.util.ArrayList;
import java.util.List;

import org.codingwallah.em_project.entity.Employee;
import org.codingwallah.em_project.entity.EmployeeEntity;
import org.codingwallah.em_project.repositery.EmployeeRepositery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepositery employeeRepositery;

    // List<Employee> employees = new ArrayList<>();
    // @Autowired

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepositery.save(employeeEntity);
        // employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public Employee readEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepositery.findById(id).get();

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);

        return employee;
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeesList = employeeRepositery.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeesList) {
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp = employeeRepositery.findById(id).get();
        employeeRepositery.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee = employeeRepositery.findById(id).get();

        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());

        employeeRepositery.save(existingEmployee);
        return "Update Succesfully";
    }

}