package com.example.InsuranceApp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Claim {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 private int claimNumber;
	 private String description;
	 private LocalDate claimDate;
	 private String claimStatus;
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "insurance_policy_id")
	 private InsurancePolicy insurancePolicy;
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public InsurancePolicy getInsurancePolicy() {
		return insurancePolicy;
	}
	public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}
}
