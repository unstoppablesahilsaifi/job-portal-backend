package com.jobportal.controller;

import com.jobportal.entity.Company;
import com.jobportal.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    // Create Company
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company saved = companyService.createCompany(company);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    // Get All Companies
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    // Get Company By Id
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompanyById(id));
    }



}
