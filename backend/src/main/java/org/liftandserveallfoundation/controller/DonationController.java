package org.liftandserveallfoundation.controller;

import org.liftandserveallfoundation.model.Donation;
import org.liftandserveallfoundation.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/donations")
@CrossOrigin(origins = "*")
public class DonationController {
    
    @Autowired
    private DonationService donationService;
    
    @PostMapping
    public ResponseEntity<Map<String, Object>> createDonation(@Valid @RequestBody Donation donation) {
        try {
            Donation savedDonation = donationService.saveDonation(donation);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Donation submitted successfully");
            response.put("donationId", savedDonation.getId());
            response.put("amount", savedDonation.getAmount());
            response.put("status", savedDonation.getStatus());
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Failed to process donation: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getDonationStats() {
        try {
            Map<String, Object> stats = new HashMap<>();
            stats.put("totalDonations", donationService.getTotalDonations());
            stats.put("totalCount", donationService.getTotalDonationCount());
            stats.put("monthlyDonations", donationService.getMonthlyDonations());
            stats.put("yearlyDonations", donationService.getYearlyDonations());
            
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Failed to retrieve stats: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/recent")
    public ResponseEntity<List<Donation>> getRecentDonations(@RequestParam(defaultValue = "10") int limit) {
        try {
            List<Donation> recentDonations = donationService.getRecentDonations(limit);
            return ResponseEntity.ok(recentDonations);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Donation> getDonation(@PathVariable Long id) {
        return donationService.findById(id)
                .map(donation -> ResponseEntity.ok().body(donation))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<List<Donation>> getDonationsByEmail(@PathVariable String email) {
        try {
            List<Donation> donations = donationService.findByEmail(email);
            return ResponseEntity.ok(donations);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<Map<String, Object>> updateDonationStatus(
            @PathVariable Long id, 
            @RequestParam Donation.DonationStatus status) {
        try {
            Donation updatedDonation = donationService.updateDonationStatus(id, status);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Donation status updated successfully");
            response.put("donationId", updatedDonation.getId());
            response.put("status", updatedDonation.getStatus());
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Failed to update donation status: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
