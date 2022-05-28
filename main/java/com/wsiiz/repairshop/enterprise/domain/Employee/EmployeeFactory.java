package com.wsiiz.repairshop.enterprise.domain.Employee;

import org.springframework.stereotype.Component;
import com.wsiiz.repairshop.foundation.domain.AbstractFactory;

@Component
public class EmployeeFactory implements AbstractFactory{
    @Override
    public Employee create() {
        return new Employee();
    }
}
