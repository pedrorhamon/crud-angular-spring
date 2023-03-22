package com.starking.crudspring.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starking.crudspring.model.Course;
import com.starking.crudspring.services.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
	
	private final CourseService service;

	@GetMapping
	public List<Course> list() {
		return this.service.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Course> save() {
		return ResponseEntity.accepted().build();
	}
}
