package com.jobportal.service;

import com.jobportal.entity.Job;
import com.jobportal.entity.JobApplication;
import com.jobportal.entity.User;
import com.jobportal.repository.JobApplicationRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository,
                                 UserRepository userRepository,
                                 JobRepository jobRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    // Apply for job
    public JobApplication applyJob(Long userId, Long jobId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        JobApplication application = new JobApplication();
        application.setUser(user);
        application.setJob(job);
        application.setAppliedDate(LocalDate.now());

        return jobApplicationRepository.save(application);
    }
}
