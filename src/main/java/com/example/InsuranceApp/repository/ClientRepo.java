package com.example.InsuranceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.InsuranceApp.entity.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long>{

}
