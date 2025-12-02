package org.liftandserveallfoundation.service;

import org.liftandserveallfoundation.model.Donation;
import org.liftandserveallfoundation.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DonationService {
    
    @Autowired
    private DonationRepository donationRepository;
    
    public Donation saveDonation(Donation donation) {
        return donationRepository.save(donation);
    }
    
    public Optional<Donation> findById(Long id) {
        return donationRepository.findById(id);
    }
    
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }
    
    public List<Donation> findByEmail(String email) {
        return donationRepository.findByEmail(email);
    }
    
    public List<Donation> findByStatus(Donation.DonationStatus status) {
        return donationRepository.findByStatus(status);
    }
    
    public BigDecimal getTotalDonations() {
        BigDecimal total = donationRepository.getTotalDonations();
        return total != null ? total : BigDecimal.ZERO;
    }
    
    public BigDecimal getTotalDonationsSince(LocalDateTime startDate) {
        BigDecimal total = donationRepository.getTotalDonationsSince(startDate);
        return total != null ? total : BigDecimal.ZERO;
    }
    
    public Long getTotalDonationCount() {
        return donationRepository.getTotalDonationCount();
    }
    
    public Long getDonationCountSince(LocalDateTime startDate) {
        return donationRepository.getDonationCountSince(startDate);
    }
    
    public Donation updateDonationStatus(Long id, Donation.DonationStatus status) {
        Optional<Donation> donationOpt = donationRepository.findById(id);
        if (donationOpt.isPresent()) {
            Donation donation = donationOpt.get();
            donation.setStatus(status);
            return donationRepository.save(donation);
        }
        throw new RuntimeException("Donation not found with id: " + id);
    }
    
    public List<Donation> getRecentDonations(int limit) {
        return donationRepository.findAll().stream()
                .filter(d -> d.getStatus() == Donation.DonationStatus.COMPLETED)
                .sorted((d1, d2) -> d2.getCreatedAt().compareTo(d1.getCreatedAt()))
                .limit(limit)
                .toList();
    }
    
    public BigDecimal getMonthlyDonations() {
        LocalDateTime startOfMonth = LocalDateTime.now().withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        return getTotalDonationsSince(startOfMonth);
    }
    
    public BigDecimal getYearlyDonations() {
        LocalDateTime startOfYear = LocalDateTime.now().withDayOfYear(1).withHour(0).withMinute(0).withSecond(0);
        return getTotalDonationsSince(startOfYear);
    }
}
