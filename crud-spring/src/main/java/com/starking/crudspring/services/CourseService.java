package com.starking.crudspring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
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
	
	@Transactional
	public Course save(Course course) {
		return this.courseRepository.save(course);
	}
	
	public Course update(Long id, Course course) {
		Course courseUpdate = this.courseRepository.getById(id);
		BeanUtils.copyProperties(course, courseUpdate, "id");
		return this.courseRepository.save(courseUpdate);
	}
	
	public void getById(Long id) {
		this.courseRepository.getById(id);
	}
	
	public void delete(Long id) {
		this.courseRepository.getById(id);
	}
}
