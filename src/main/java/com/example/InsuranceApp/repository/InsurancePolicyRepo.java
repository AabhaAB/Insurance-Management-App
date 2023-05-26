package com.example.InsuranceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.InsuranceApp.entity.InsurancePolicy;
@Repository
public interface InsurancePolicyRepo extends JpaRepository<InsurancePolicy, Long>{

}
