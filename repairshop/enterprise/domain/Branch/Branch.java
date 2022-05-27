package com.wsiiz.repairshop.enterprise.domain.Branch;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor

public class Branch extends BaseEntity {
    Long branchId;
    String branchName;
    @Embedded
    Address address;

    @Enumerated(EnumType.STRING)
    BranchType branchType;

}