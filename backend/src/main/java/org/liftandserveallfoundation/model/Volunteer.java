package org.liftandserveallfoundation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "volunteers")
public class Volunteer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;
    
    @Email(message = "Valid email is required")
    @NotBlank(message = "Email is required")
    @Column(nullable = false)
    private String email;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "age")
    private Integer age;
    
    @Column(name = "skills_experience", columnDefinition = "TEXT")
    private String skillsExperience;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "availability")
    private Availability availability;
    
    @Column(name = "areas_of_interest", columnDefinition = "TEXT")
    private String areasOfInterest;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private VolunteerStatus status = VolunteerStatus.PENDING;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Constructors
    public Volunteer() {}
    
    public Volunteer(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getSkillsExperience() {
        return skillsExperience;
    }
    
    public void setSkillsExperience(String skillsExperience) {
        this.skillsExperience = skillsExperience;
    }
    
    public Availability getAvailability() {
        return availability;
    }
    
    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
    
    public String getAreasOfInterest() {
        return areasOfInterest;
    }
    
    public void setAreasOfInterest(String areasOfInterest) {
        this.areasOfInterest = areasOfInterest;
    }
    
    public VolunteerStatus getStatus() {
        return status;
    }
    
    public void setStatus(VolunteerStatus status) {
        this.status = status;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // Enums
    public enum Availability {
        WEEKDAYS, WEEKENDS, EVENINGS, FLEXIBLE
    }
    
    public enum VolunteerStatus {
        PENDING, APPROVED, REJECTED, ACTIVE, INACTIVE
    }
}
