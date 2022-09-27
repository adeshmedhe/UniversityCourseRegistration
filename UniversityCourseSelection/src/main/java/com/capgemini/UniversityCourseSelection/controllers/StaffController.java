package com.capgemini.UniversityCourseSelection.controllers;

import java.util.List;

import com.capgemini.UniversityCourseSelection.entities.Course;
import com.capgemini.UniversityCourseSelection.entities.UniversityStaffMember;
import com.capgemini.UniversityCourseSelection.services.ICourseService;
import com.capgemini.UniversityCourseSelection.services.IUniversityStaffService;

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

@RestController
@RequestMapping("/uni/staff")
public class StaffController {
	
	@Autowired
	private IUniversityStaffService staffService;
	@Autowired
	private ICourseService courseService;
	
	@PostMapping("/add")
	public ResponseEntity<UniversityStaffMember> addStaff(@RequestBody UniversityStaffMember staff) {
		UniversityStaffMember ref = staffService.addStaff(staff);
		return new ResponseEntity<>(ref,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<UniversityStaffMember> updateStaff(@RequestBody UniversityStaffMember staff) {
		UniversityStaffMember ref = staffService.updateStaff(staff);
		return new ResponseEntity<>(ref, HttpStatus.OK);
	}
	
	@GetMapping("/view/{id}")
	public ResponseEntity<UniversityStaffMember> viewStaff(@PathVariable int id) {
		UniversityStaffMember ref = staffService.viewStaff(id);
		return new ResponseEntity<>(ref, HttpStatus.OK);
	}
	
	@GetMapping("/view/all")
	public ResponseEntity<List<UniversityStaffMember>> viewAllStaffs() {
		List<UniversityStaffMember> ref = staffService.viewAllStaffs();
		return new ResponseEntity<>(ref, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeStaff(@PathVariable int id) {
		try {
			staffService.removeStaff(id);
		} catch (Exception e) {
			return new ResponseEntity<>("Staff id:"+id+" not found!", HttpStatus.OK);
		}
		return new ResponseEntity<>("Staff id:\"+id+\" deleted successfully!", HttpStatus.OK);
	}
	
	@PostMapping("/course/add")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		return new ResponseEntity<>(courseService.addCourse(course),HttpStatus.OK);
	}
	
	@PutMapping("/course/update")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
		return new ResponseEntity<>(courseService.updateCourse(course),HttpStatus.OK);
	}
	
	@DeleteMapping("/course/delete/{id}")
	public ResponseEntity<Course> deleteCourse(@PathVariable int id) {
		return new ResponseEntity<>(courseService.removeCourse(id),HttpStatus.OK);
	}
}