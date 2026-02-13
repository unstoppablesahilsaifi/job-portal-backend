package com.jobportal.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    private LocalDate appliedDate;

    public JobApplication() {}

    public JobApplication(User user, Job job, LocalDate appliedDate) {
        this.user = user;
        this.job = job;
        this.appliedDate = appliedDate;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Job getJob() {
        return job;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }
}
