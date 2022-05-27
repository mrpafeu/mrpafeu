package com.wsiiz.repairshop.enterprise.domain.Branch;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    List<Branch> findByBranchId(Long branchId);

}