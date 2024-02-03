package com.yakub.employee.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yakub.employee.Entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
