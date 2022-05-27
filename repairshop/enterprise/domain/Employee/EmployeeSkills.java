package com.wsiiz.repairshop.enterprise.domain.Employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)

public class EmployeeSkills extends BaseEntity {
    String skills;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="employee_id")
    @JsonIgnore
    Employee employee;
}
