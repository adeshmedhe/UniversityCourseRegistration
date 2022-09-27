package com.capgemini.UniversityCourseSelection.controllers;

import com.capgemini.UniversityCourseSelection.entities.AdmissionStatus;
import com.capgemini.UniversityCourseSelection.entities.Applicant;
import com.capgemini.UniversityCourseSelection.services.IApplicantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

	@Autowired
	private IApplicantService service;

	@PostMapping("/apply")
	public ResponseEntity<Applicant> applyForCourse(@RequestBody Applicant applicant) {

		Applicant temp = service.addApplicant(applicant);

		return new ResponseEntity<>(temp, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<Applicant> updateApplication(@RequestBody Applicant applicant) {

		Applicant temp = service.updateApplicant(applicant);

		return new ResponseEntity<>(temp, HttpStatus.OK);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<Applicant> deleteApplication(@RequestBody Applicant applicant) {
		Applicant temp = service.deleteApplicant(applicant);
		return new ResponseEntity<>(temp, HttpStatus.OK);

	}

	
	@GetMapping("/get/{id}")
	public ResponseEntity<Applicant> getById(@PathVariable("id") Integer id){
		Applicant temp= service.viewApplicant(id);
		
		return new ResponseEntity<>(temp,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Applicant>> getAllApplicants(@RequestBody AdmissionStatus status){
		
		List<Applicant> res= service.viewAllApplicantsByStatus(status);
		return new ResponseEntity<>(res,HttpStatus.OK);
		
	}
}