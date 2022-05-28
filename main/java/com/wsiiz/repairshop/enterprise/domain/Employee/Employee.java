package com.wsiiz.repairshop.enterprise.domain.Employee;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor

public class Employee extends BaseEntity {

Long EmployeeID;
String EmployeeName, EmployeeSurname, HireDate;
    @Enumerated(EnumType.STRING)
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)

    List<EmployeeSkills> employeeSkills = new ArrayList<>();

}
