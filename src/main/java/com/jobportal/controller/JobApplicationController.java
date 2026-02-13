package com.jobportal.controller;

import com.jobportal.entity.JobApplication;
import com.jobportal.service.JobApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    // Apply Job
    @PostMapping("/apply")
    public ResponseEntity<JobApplication> applyJob(@RequestParam Long userId,
                                                   @RequestParam Long jobId) {

        JobApplication application =
                jobApplicationService.applyJob(userId, jobId);

        return new ResponseEntity<>(application, HttpStatus.CREATED);
    }
}
