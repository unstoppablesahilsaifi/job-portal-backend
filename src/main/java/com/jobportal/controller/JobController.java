package com.jobportal.controller;

import com.jobportal.entity.Job;
import com.jobportal.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // Create Job (companyId required)
    @PostMapping("/{companyId}")
    public ResponseEntity<Job> createJob(@PathVariable Long companyId,
                                         @RequestBody Job job) {

        Job saved = jobService.createJob(job, companyId);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Get All Jobs
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    // Get Job By Id
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }
}
