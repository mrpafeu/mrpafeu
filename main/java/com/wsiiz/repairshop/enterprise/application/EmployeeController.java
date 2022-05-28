package com.wsiiz.repairshop.enterprise.application;

import com.wsiiz.repairshop.enterprise.domain.Employee.Employee;
import com.wsiiz.repairshop.enterprise.domain.Employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getMany(
            @RequestParam(value = "branchId", required = false) Long branchId) {
        if (branchId == null) {
            return ResponseEntity.ok(employeeRepository.findAll());
        } else {
            return ResponseEntity.ok(employeeRepository.findByBranchId(branchId));
        }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getOne(@PathVariable("id") Long id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addNew(@RequestBody Employee employee) {
        employee.getEmployeeSkills().forEach(r -> r.setEmployee(employee));
        return ResponseEntity.created(null).body(employeeRepository.save(employee));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> remove(@PathVariable("id") Long id) {

        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}