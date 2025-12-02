package org.liftandserveallfoundation.repository;

import org.liftandserveallfoundation.model.Donation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    
    List<Donation> findByEmail(String email);
    
    List<Donation> findByStatus(Donation.DonationStatus status);
    
    List<Donation> findByDonationType(Donation.DonationType donationType);
    
    List<Donation> findByPaymentMethod(Donation.PaymentMethod paymentMethod);
    
    @Query("SELECT SUM(d.amount) FROM Donation d WHERE d.status = 'COMPLETED'")
    BigDecimal getTotalDonations();
    
    @Query("SELECT SUM(d.amount) FROM Donation d WHERE d.status = 'COMPLETED' AND d.createdAt >= :startDate")
    BigDecimal getTotalDonationsSince(@Param("startDate") LocalDateTime startDate);
    
    @Query("SELECT COUNT(d) FROM Donation d WHERE d.status = 'COMPLETED'")
    Long getTotalDonationCount();
    
    @Query("SELECT COUNT(d) FROM Donation d WHERE d.status = 'COMPLETED' AND d.createdAt >= :startDate")
    Long getDonationCountSince(@Param("startDate") LocalDateTime startDate);
    
    @Query("SELECT d FROM Donation d WHERE d.status = 'COMPLETED' ORDER BY d.createdAt DESC")
    Page<Donation> findCompletedDonations(Pageable pageable);
    
    @Query("SELECT d FROM Donation d WHERE d.createdAt >= :startDate AND d.createdAt <= :endDate")
    List<Donation> findDonationsBetween(@Param("startDate") LocalDateTime startDate, 
                                      @Param("endDate") LocalDateTime endDate);
    
    @Query("SELECT d.paymentMethod, SUM(d.amount) FROM Donation d WHERE d.status = 'COMPLETED' GROUP BY d.paymentMethod")
    List<Object[]> getDonationsByPaymentMethod();
    
    @Query("SELECT MONTH(d.createdAt), SUM(d.amount) FROM Donation d WHERE d.status = 'COMPLETED' AND YEAR(d.createdAt) = :year GROUP BY MONTH(d.createdAt)")
    List<Object[]> getMonthlyDonations(@Param("year") int year);
}
