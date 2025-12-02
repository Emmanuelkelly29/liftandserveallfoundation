package org.liftandserveallfoundation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "donations")
public class Donation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Email(message = "Valid email is required")
    @NotBlank(message = "Email is required")
    @Column(nullable = false)
    private String email;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "address")
    private String address;
    
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "donation_type", nullable = false)
    private DonationType donationType;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;
    
    @Column(name = "payment_id")
    private String paymentId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private DonationStatus status = DonationStatus.PENDING;
    
    @Column(name = "dedication")
    private String dedication;
    
    @Column(name = "newsletter_subscription")
    private Boolean newsletterSubscription = false;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Constructors
    public Donation() {}
    
    public Donation(String firstName, String lastName, String email, BigDecimal amount, 
                   DonationType donationType, PaymentMethod paymentMethod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.amount = amount;
        this.donationType = donationType;
        this.paymentMethod = paymentMethod;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public DonationType getDonationType() {
        return donationType;
    }
    
    public void setDonationType(DonationType donationType) {
        this.donationType = donationType;
    }
    
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
    
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public String getPaymentId() {
        return paymentId;
    }
    
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    
    public DonationStatus getStatus() {
        return status;
    }
    
    public void setStatus(DonationStatus status) {
        this.status = status;
    }
    
    public String getDedication() {
        return dedication;
    }
    
    public void setDedication(String dedication) {
        this.dedication = dedication;
    }
    
    public Boolean getNewsletterSubscription() {
        return newsletterSubscription;
    }
    
    public void setNewsletterSubscription(Boolean newsletterSubscription) {
        this.newsletterSubscription = newsletterSubscription;
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
    public enum DonationType {
        ONE_TIME, MONTHLY
    }
    
    public enum PaymentMethod {
        PAYPAL, STRIPE, FLUTTERWAVE, BANK_TRANSFER, MOBILE_MONEY
    }
    
    public enum DonationStatus {
        PENDING, COMPLETED, FAILED, CANCELLED, REFUNDED
    }
}
