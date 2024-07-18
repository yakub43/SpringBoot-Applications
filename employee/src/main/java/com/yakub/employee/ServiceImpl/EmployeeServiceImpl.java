package com.yakub.employee.ServiceImpl;

import java.util.List;

import com.yakub.employee.Exceptions.NoDataToShowException;
import com.yakub.employee.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.yakub.employee.Entity.Employee;
import com.yakub.employee.Repo.EmployeeRepo;
import com.yakub.employee.service.EmployeeServiceIntrf;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeServiceIntrf {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee saveEmployee(Employee e) {
        return employeeRepo.save(e);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> e = employeeRepo.findAll();
        if (e.isEmpty()) {
            throw new NoDataToShowException("The Database is Empty...");
        }
        return e;
    }

    @Override
    public Employee getById(int Id) {
        return employeeRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("There is No Resource Associated with the Given Id: " + Id));
    }

    @Override
    public Employee updateById(int id, Employee e) {
        Employee ue = getById(id);
        ue.setName(e.getName());
        ue.setYOE(e.getYOE());
        ue.setSalary(e.getSalary());
        ue.setAddress(e.getAddress());
        ue.setJoining_year(e.getJoining_year());
        return employeeRepo.saveAndFlush(ue);
    }

    @Override
    public Employee deleteById(int Id) {
        Employee e = getById(Id);
        employeeRepo.deleteById(Id);
        return e;
    }

}
