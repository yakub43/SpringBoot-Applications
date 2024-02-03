package com.yakub.employee.Controller;

import com.yakub.employee.Exceptions.NoDataToShowException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.yakub.employee.Entity.Employee;
import com.yakub.employee.service.EmployeeServiceIntrf;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceIntrf employeeServiceIntrf;

    Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAll() {
        log.info("Inside get All method...");
        List<Employee> e = employeeServiceIntrf.getAll();
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Employee> findById(@PathVariable int id) {
        log.info("Inside findById Method...");
        Employee e = employeeServiceIntrf.getById(id);

        if (e == null) {
            log.error("No Content associated with the given iD...");
        }

        return new ResponseEntity<>(e, HttpStatus.ACCEPTED);
    }

    @PostMapping("/")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee e) {
        log.info("Inside saveEmployee Method...");
        log.warn("Saving Employee into database...");
        Employee emp = employeeServiceIntrf.saveEmployee(e);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee e) {
        log.info("Inside Update Employee Method...");
        Employee ue = employeeServiceIntrf.updateById(id, e);
        log.warn("Update Employee with id: " + id);
        return new ResponseEntity<>(ue, HttpStatus.OK);
    }

    @DeleteMapping("/delete/id")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        log.info("Inside delete employee method...");
        Employee e = employeeServiceIntrf.deleteById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

}
