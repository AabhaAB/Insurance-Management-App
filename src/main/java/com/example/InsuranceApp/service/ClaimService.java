package com.example.InsuranceApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.InsuranceApp.entity.Claim;
import com.example.InsuranceApp.repository.ClaimRepo;

@Service
public class ClaimService {
	@Autowired
	private ClaimRepo claimRepository;

	public List<Claim> getAllClaim() {
		return claimRepository.findAll();
	}

	public Optional<Claim> getClaimById(Long id) {
		return claimRepository.findById(id);
	}

	public Claim createClaim(Claim claim) {
		return claimRepository.save(claim);
	}
	public Claim updateClaim(Long id, Claim claim) {
		Optional<Claim> existingClaim = claimRepository.findById(id);
		if (existingClaim.isPresent()) {
			Claim updatedClaim = existingClaim.get();
			updatedClaim.setClaimNumber(claim.getClaimNumber());
			updatedClaim.setDescription(claim.getDescription());
			updatedClaim.setClaimDate(claim.getClaimDate());
			updatedClaim.setClaimStatus(claim.getClaimStatus());
			updatedClaim.setInsurancePolicy(claim.getInsurancePolicy());
			return claimRepository.save(updatedClaim);
		} else {
			throw new ResourceNotFoundException("Claim not found with id: " + id);
		}
	}

	public void deleteClaim(Long id) {
		Optional<Claim> claim = claimRepository.findById(id);
		if (claim.isPresent()) {
			claimRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Claim not found with id: " + id);
		}
	}
}
