package com.example.InsuranceApp.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String name;
    private LocalDate dateOfBirth;
    private String address;
    private int contact;
    @OneToMany(mappedBy = "client")
    private List<InsurancePolicy> insurancePolicies = new ArrayList<>();
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public List<InsurancePolicy> getInsurancePolicies() {
		return insurancePolicies;
	}
	public void setInsurancePolicies(List<InsurancePolicy> insurancePolicies) {
		this.insurancePolicies = insurancePolicies;
	}
}
