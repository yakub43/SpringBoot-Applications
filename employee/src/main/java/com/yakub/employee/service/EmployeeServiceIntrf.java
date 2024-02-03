package com.yakub.employee.service;

import java.util.*;

import com.yakub.employee.Entity.Employee;

public interface EmployeeServiceIntrf {

    public Employee saveEmployee(Employee e);

    public List<Employee> getAll();

    public Employee getById(int Id);

    public Employee updateById(int id, Employee e);

    public Employee deleteById(int Id);

}
