package com.wsiiz.repairshop.enterprise.application;

import com.wsiiz.repairshop.enterprise.domain.Branch.Branch;
import com.wsiiz.repairshop.enterprise.domain.Branch.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BranchController {
    @Autowired
    BranchRepository branchRepository;
    //finding by branch ID
    @GetMapping("/branches")
    public ResponseEntity<List<Branch>> getMany(
            @RequestParam(value = "branchId", required = false) Long branchId) {
        if (branchId == null) {
            return ResponseEntity.ok(branchRepository.findAll());
        } else {
            return ResponseEntity.ok(branchRepository.findByBranchId(branchId));
        }
    }

    @GetMapping("/branches/{id}")
    public ResponseEntity<Branch> getOne(@PathVariable("id") Long id) {

        Optional<Branch> branch = branchRepository.findById(id);
        return branch.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/branches")
    public ResponseEntity<Branch> addNew(@RequestBody Branch branch) {
        ResponseEntity<Branch> responseEntity = ResponseEntity.created(null).body(branchRepository.save(branch));
        return responseEntity;
    }

    @DeleteMapping("/branches/{id}")
    public ResponseEntity<Branch> remove(@PathVariable("id") Long id) {

        Optional<Branch> branch = branchRepository.findById(id);

        if (branch.isPresent()) {
            branchRepository.deleteById(id);
            return ResponseEntity.ok(branch.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}