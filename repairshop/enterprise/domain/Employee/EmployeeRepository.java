package com.wsiiz.repairshop.enterprise.domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByBranchId(Long branchId);
}
