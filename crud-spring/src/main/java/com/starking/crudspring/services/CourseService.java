package com.starking.crudspring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.starking.crudspring.model.Course;
import com.starking.crudspring.repositories.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

	private final CourseRepository courseRepository;
	
	public List<Course> findAll() {
		return this.courseRepository.findAll();
	}
	
}
