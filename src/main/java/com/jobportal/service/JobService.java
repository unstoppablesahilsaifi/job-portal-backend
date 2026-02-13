package com.jobportal.service;

import com.jobportal.entity.Company;
import com.jobportal.entity.Job;
import com.jobportal.repository.CompanyRepository;
import com.jobportal.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    public JobService(JobRepository jobRepository,
                      CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }
    // Create Job
    public Job createJob(Job job, Long companyId) {

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        job.setCompany(company);

        return jobRepository.save(job);
    }
    // Get All Jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get Job By Id
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }
}
