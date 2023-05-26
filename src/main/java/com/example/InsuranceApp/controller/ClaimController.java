package com.example.InsuranceApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.InsuranceApp.entity.Claim;
import com.example.InsuranceApp.service.ClaimService;

@Controller
@RequestMapping("claims")
public class ClaimController {
    @Autowired
    private ClaimService claimService;

    // Get all claims
    @GetMapping("")
    public String getAllClaim(Model model) {
        List<Claim> claims = claimService.getAllClaim();
        model.addAttribute("claims", claims);
        return "claims";
    }

    // Get claim by ID
    @GetMapping("/{claimId}")
    public String getClaimById(@PathVariable Long claimId, Model model) {
        Claim claim = claimService.getClaimById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id " + claimId));
        model.addAttribute("claim", claim);
        return "claims";
    }

    // Show the new claim form
    @GetMapping("/NewClaim")
    public String showNewClaimForm(Model model) {
        Claim claim = new Claim();
        model.addAttribute("claim", claim);
        return "NewClaim";
    }
    
    @GetMapping("/{claimId}/EditClaim")
    public String showEditClaimForm(@PathVariable Long claimId, Model model) {
        Claim claim = claimService.getClaimById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id: " + claimId));
        model.addAttribute("claim", claim);
        return "EditClaim";
    }

    @PutMapping("/{claimId}")
    public String updateClaim(@PathVariable Long claimId, @ModelAttribute Claim claim) {
        claimService.updateClaim(claimId, claim);
        return "redirect:/claims";
    }

    @PostMapping("")
    public String createClaim(Claim claim, Model model) {
        claimService.createClaim(claim);
        List<Claim> claims = claimService.getAllClaim();
        model.addAttribute("claims", claims);
        return "redirect:/claims";
    }
    
    @DeleteMapping("/{claimId}")
    public String deleteClaim(@PathVariable Long claimId) {
        claimService.deleteClaim(claimId);
        return "redirect:/claims";
    }

    @PostMapping("/{claimId}")
    public String confirmDelete(@PathVariable Long claimId) {
        claimService.deleteClaim(claimId);
        return "redirect:/claims";
    }
}