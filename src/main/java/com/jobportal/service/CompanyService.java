package com.jobportal.service;

import com.jobportal.entity.Company;
import com.jobportal.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    // Create company
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }
    //Get All the companies
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }
    // Get company by id
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }
}
