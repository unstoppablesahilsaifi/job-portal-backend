package com.jobportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 500)
    private String description;

    private Double salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Job() {}

    public Job(String title, String description, Double salary, Company company) {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Double getSalary() {
        return salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
