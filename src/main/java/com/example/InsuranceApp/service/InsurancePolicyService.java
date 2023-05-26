package com.example.InsuranceApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.InsuranceApp.entity.InsurancePolicy;
import com.example.InsuranceApp.repository.InsurancePolicyRepo;

@Service
public class InsurancePolicyService {
	@Autowired
    private InsurancePolicyRepo insurancePolicyRepository;

    public List<InsurancePolicy> getAllInsurancePolicies() {
        return insurancePolicyRepository.findAll();
    }

    public Optional<InsurancePolicy> getInsurancePolicyById(Long id) {
        return insurancePolicyRepository.findById(id);
    }

    public InsurancePolicy createInsurancePolicy(InsurancePolicy insurancePolicy) {
        return insurancePolicyRepository.save(insurancePolicy);
    }

    public InsurancePolicy updateInsurancePolicy(Long id, InsurancePolicy insurancePolicy) {
        Optional<InsurancePolicy> existingPolicy = insurancePolicyRepository.findById(id);
        if (existingPolicy.isPresent()) {
            InsurancePolicy updatedPolicy = existingPolicy.get();
            updatedPolicy.setPolicyNumber(insurancePolicy.getPolicyNumber());
            updatedPolicy.setType(insurancePolicy.getType());
            updatedPolicy.setCoverageAmount(insurancePolicy.getCoverageAmount());
            updatedPolicy.setPremium(insurancePolicy.getPremium());
            updatedPolicy.setStartDate(insurancePolicy.getStartDate());
            updatedPolicy.setEndDate(insurancePolicy.getEndDate());
            updatedPolicy.setClient(insurancePolicy.getClient());
            return insurancePolicyRepository.save(updatedPolicy);
        } else {
            throw new ResourceNotFoundException("Insurance policy not found with id: " + id);
        }
    }

    public void deleteInsurancePolicy(Long policy) {
        Optional<InsurancePolicy> insurancePolicy = insurancePolicyRepository.findById(policy);
        if (insurancePolicy.isPresent()) {
            insurancePolicyRepository.deleteById(policy);
        } else {
            throw new ResourceNotFoundException("Insurance policy not found with id: " + policy);
        }
    }
}
