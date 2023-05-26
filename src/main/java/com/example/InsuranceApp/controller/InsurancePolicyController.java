package com.example.InsuranceApp.controller;

import com.example.InsuranceApp.entity.InsurancePolicy;
import com.example.InsuranceApp.service.InsurancePolicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/insurancePolicies")
public class InsurancePolicyController {

	@Autowired
	private InsurancePolicyService policyService;

	@GetMapping("")
	public String getAllPolicies(Model model) {
	    List<InsurancePolicy> policies = policyService.getAllInsurancePolicies();
	    model.addAttribute("policies", policies);
	    return "insurancePolicies";
	}

	@GetMapping("/{id}")
	public String getPolicyById(@PathVariable Long id, Model model) {
	    Optional<InsurancePolicy> policy = policyService.getInsurancePolicyById(id);
	    model.addAttribute("policy", policy.orElseThrow(() -> new ResourceNotFoundException("Policy not found with id " + id)));
	    return "insurancePolicies";
	}

	// Show the new policy form
	@GetMapping("/NewInsurancePolicy")
	public String showNewInsurancePolicyForm(Model model) {
	    InsurancePolicy policy = new InsurancePolicy();
	    model.addAttribute("policy", policy);
	    return "NewInsurancePolicy";
	}

	@PostMapping("")
	public String createPolicy(InsurancePolicy policy, Model model) {
	    policyService.createInsurancePolicy(policy);
	    List<InsurancePolicy> policies = policyService.getAllInsurancePolicies();
	    model.addAttribute("policies", policies);
	    return "redirect:/insurancePolicies";
	}

	@GetMapping("/{insuranceId}/EditInsurancePolicy")
	public String showEditInsurancePolicyForm(@PathVariable Long insuranceId, Model model) {
	    InsurancePolicy insurancePolicy = policyService.getInsurancePolicyById(insuranceId)
	            .orElseThrow(() -> new ResourceNotFoundException("Insurance policy not found with id: " + insuranceId));
	    model.addAttribute("insurancePolicy", insurancePolicy);
	    return "EditInsurancePolicy";
	}

	@PutMapping("/{insuranceId}")
	public String updateInsurancePolicy(@PathVariable Long insuranceId, @ModelAttribute InsurancePolicy insurancePolicy) {
	    policyService.updateInsurancePolicy(insuranceId, insurancePolicy);
	    return "redirect:/insurancePolicies";
	}

	@DeleteMapping("/{insuranceId}")
	public String deleteInsurancePolicy(@PathVariable Long insuranceId) {
	    policyService.deleteInsurancePolicy(insuranceId);
	    return "redirect:/insurancePolicies";
	}

	@PostMapping("/{insuranceId}")
	public String confirmDelete(@PathVariable Long insuranceId) {
	    policyService.deleteInsurancePolicy(insuranceId);
	    return "redirect:/insurancePolicies";
	}
}
