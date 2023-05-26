package com.example.InsuranceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.InsuranceApp.entity.Claim;

@Repository
public interface ClaimRepo extends JpaRepository<Claim, Long>  {

}
